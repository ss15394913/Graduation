package command;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

import bean.MemberBean;
import dao.OraMemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className AbstractCommand
 *@author Kohichi Tujihashi
 *@date 2017/03/03
 *@description
 */
public class AddTempUserCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{

		RequestContext reqc = getRequestContext();

		/*メンバー情報を取得*/
		MemberBean memberbean = (MemberBean)reqc.getSessionAttribute("tempuser");
		/*受け取ったセッションを重複しないよう消す*/
		reqc.removeSessionAttribute("tempuser");

		/*セッションで持っているemailAddressを取得*/
		String memberEmail=memberbean.getMemberEmail();

		//認証用のランダムコードの生成(半角小文字の英数字のみ8桁)
		String random=RandomStringUtils.random(8,"abcdefghijklmnopqrstuvwxyz");
		random=random.toString();

		try {

            Properties property = new Properties();

            // 各種設定
            property.put("mail.smtp.host", "smtp.gmail.com");
            //property.put("mail.smtp.host", "smtp.mail.yahoo.co.jp");
            property.put("mail.smtp.auth", "true");
            property.put("mail.smtp.starttls.enable", "true");
            property.put("mail.smtp.host", "smtp.gmail.com");
            property.put("mail.smtp.port", "587");
            property.put("mail.smtp.debug", "true");

            Session session = Session.getInstance(property,
                new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    //"Gメールアカウント", "パスワード");
                    "kt15304014@ga.tera-house.ac.jp", "Br7dHHgW");
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);

            InternetAddress toAddress = new InternetAddress(
                    /*"宛先メールアドレス", "宛先名");*/
                    memberEmail, "宛先名を指定します");

            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

            InternetAddress fromAddress = new InternetAddress(
                //"送信","管理者");
                "kt15304014@ga.tera-house.ac.jp","辻橋");

            mimeMessage.setFrom(fromAddress);

            String image= " http://localhost:8080/watercress/front/entrycode ←本登録してください！";

            mimeMessage.setSubject("テストメール", "ISO-2022-JP");
            mimeMessage.setText("認証コードは" + random +"です"+ image, "ISO-2022-JP");

            Transport.send(mimeMessage);

            System.out.println("送信完了");
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("エラー");
        }






		memberbean.setMemberEntryCode(random);
		reqc.setSessionAttribute("tempuser", memberbean);



		OraMemberDao memberdao = new OraMemberDao();
		//member情報を登録させるdaoのインスタンスを生成
		try{
			memberdao.registMember(memberbean);
			//Member表の全データを取得
			List memberlist= memberdao.getMembers();

			//↑の中から、認証コードがrandomと同じかつステータスIDが未入会の会員データをBeanに取得
			MemberBean memberData = new MemberBean();

			for(int i=0;i<memberlist.size();i++){
				memberData=(MemberBean)memberlist.get(i);
				if(memberData.getMemberStatusId() == 0 && memberData.getMemberEntryCode().equals(random)){
					break;
				}
			}

			//BeanからIdを取得
			int memberid =memberData.getMemberId();

			//Idをmemberbeanにsetして、セッションに登録
			memberbean.setMemberId(memberid);
			reqc.setSessionAttribute("tempuser", memberbean);
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}


		//登録確認ページに移動
		responseContext.setTarget( "entrytemp" );

		responseContext.setResult(memberbean);
		//AppricationControllerのsetAttributeに
		//登録するためにsetResultメソッドを使ってbeanを登録
		return responseContext;
	}
}
