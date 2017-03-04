/*
  @author 窪田
  @date 2017/03/03
*/

package command;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import ex.LogicException;

import bean.MemberBean;

import dao.MemberDao;
import dao.AbstractDaoFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ShowMemberOrderCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		
		RequestContext requestContext = getRequestContext();
		
		String memberId = (String) requestContext.getSessionAttribute("member_id");
		/*会員情報をリクエストから取得*/
		
		ArrayList cart = (ArrayList)requestContext.getSessionAttribute("cart");
		/*cartを取得*/
		
		MemberBean memberBean = new MemberBean();
		
		/*jspに渡すためのmap*/
		Map<String,String> memberInformation = new HashMap<String,String>();
		
		try{
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
				
			/*MemberDaoを利用*/
			MemberDao memberDao = factory.getMemberDao();
			
			/*全ての会員の会員情報を取得*/
			List allMemberList = memberDao.getMembers();
			
			/*allMemberListをiterate*/
			Iterator allMemberListItelator = allMemberList.iterator();
			
			/*
				合致する会員idを持つ会員の情報をmapに追加
			*/
			while( allMemberListItelator.hasNext() ){
				
				memberBean = (MemberBean)allMemberListItelator.next();
				String tempMemberId = String.valueOf(memberBean.getMemberId());
				
				if(memberId.equals(tempMemberId)){
					String[] name = spritFullName(memberBean.getMemberName());
					memberInformation.put("firstname",name[0]);
					memberInformation.put("name",name[1]);
					
					String[] kananame = spritFullName(memberBean.getMemberKana());
					memberInformation.put("kanafirstname",kananame[0]);
					memberInformation.put("kananame",kananame[1]);
					
					memberInformation.put("addr0",memberBean.getMemberZipCode());
					
					memberInformation.put("phonenumber",memberBean.getMemberPhoneNumber());
					
					int orderprice = getOrdertotal(cart);
					
					String[] fullAddress = (memberBean.getMemberAddress()).split(" ",0);
					
					memberInformation.put("addr1",fullAddress[0]);
					memberInformation.put("addr2",fullAddress[1]);
					memberInformation.put("addr3",fullAddress[2]);
					memberInformation.put("addr4",fullAddress[3]);
					
					memberInformation.put("orderprice",String.valueOf(orderprice));
					memberInformation.put("totalprice",String.valueOf(orderprice));
					
					requestContext.setSessionAttribute("memberInformation",memberInformation);
					break;
				}
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		/*会員情報を入力するページをせっと*/
		responseContext.setTarget("memberorder");
		
		return responseContext;
	}
	
	/*
		DBの形式「山田 太郎」を分割してString[]に格納する
		@return String[]	//[0]:山田,[1]:太郎
	*/
	private String[] spritFullName(String fullName){
		
		String[] name = fullName.split(" ",0);
		return name;
	}
	
	/*
		@return cartに登録されている商品の合計金額を返す
	*/
	private int getOrdertotal(ArrayList cart){
	
		HashMap productInformation;
		//1種類の商品を表す
		
		int totalprice = 0;
		//商品の金額、注文数をかけたものの合計金額を表す
		
		int productprice = 0;
		//1商品の単価を表す
		
		int ordercount = 1;
		//1商品の注文数を表す
		
		for(int i = 0;i<cart.size();i++){
			productInformation = (HashMap<String,String>)cart.get(i);
			
			productprice = Integer.parseInt((String)productInformation.get("productPrice"));
			
			ordercount = Integer.parseInt((String)productInformation.get("count"));
			
			totalprice += productprice * ordercount;
			
			System.out.println(i+"回目の合計金額は"+totalprice);
		}
		
		return totalprice;
	}
}