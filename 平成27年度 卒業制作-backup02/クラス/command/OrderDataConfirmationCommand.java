/*
  @className OrderDataConfirmationCommand
  @author 池田大和
  @date 2017/01/31
*/
package command;

import ex.LogicException;
import ex.IntegrationException;
import logic.RequestContext;
import logic.ResponseContext;

import bean.ProductBean;
import dao.AbstractDaoFactory;
import dao.ProductDao;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

/*入力された注文情報を確認する画面を表示するコマンドのクラス*/
public class OrderDataConfirmationCommand extends AbstractCommand {
	/*入力された注文情報をセッションスコープに保存し、
	注文する商品の情報をレスポンスに含めて返すメソッド*/
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException {
		/*initメソッドによって準備されていたRequestContextを取得する*/
		RequestContext requestContext = getRequestContext();
		
		/*注文情報を保存するためのセッションを取得する*/
		HttpSession session = (HttpSession)requestContext.getSession();
		
		/*リクエストスコープから取り出し、セッションスコープに登録したい値の
		全てのキーを定義する*/
		String[] keyNames = {"familyname","name","zipcode","prefectures",
			"city","blocknumber","buildingname","phonenumber","requesteddate",
			"requestedtime","paymentmethod","creditcardnumber","securitycode",
			"expirationdate","orderprice","commission","totalprice"
		};
		
		/*リクエストスコープにある上記配列内の名前のキーの値を、
		セッションスコープに追加する*/
		for(String key : keyNames){
			session.setAttribute(key,requestContext.getParameter(key)[0]);
		}
		
		/*リクエストスコープから注文する商品のIDを取得する*/
		String[] orderProductsId
		= requestContext.getParameter("orderproducts");
		
		/*Arrays.AsListメソッドを利用し、注文する商品のIDのString配列を
		ArrayListに変換する*/
		ArrayList<String> orderProductsIdList
		= new ArrayList<String>(Arrays.asList(orderProductsId));
		
		/*全ての商品のデータを格納する変数の宣言*/
		List<ProductBean> products = new ArrayList<ProductBean>();
		
		/*注文する商品のデータを格納する変数の宣言*/
		/*これを戻り値のResponseContextに加える*/
		List<ProductBean> orderProducts = new ArrayList<ProductBean>();
		
		try{
			/*商品の表からデータを取得するためのDAOを取得する*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductDao productDao = factory.getProductDao();
			
			/*全ての商品のデータを取得する*/
			products = productDao.getProducts();
			
			/*イテレータを使い、取得した表の各行を確認して処理を行う*/
			Iterator iterator = products.iterator();
			while(iterator.hasNext()){
				/*取得したBean内の商品IDが、ユーザーが選択した商品のID
				  と同じであるなら、レスポンスのListにそのBeanを追加する*/
				ProductBean product = (ProductBean)iterator.next();
				if(orderProductsIdList.contains(product.getProductId())){
					orderProducts.add(product);
				}
			}
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*レスポンスに、注文する商品詳細のリストを加える*/
		responseContext.setResult(orderProducts);
		
		/*転送先のViewの名前をレスポンスに加える*/
		responseContext.setTarget("ordercheck"); 
		
		/*必要な情報を入れ終わったレスポンスを返す*/
		return responseContext;
	}
}