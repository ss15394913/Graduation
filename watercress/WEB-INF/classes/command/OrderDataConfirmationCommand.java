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

/*入力された注文情報を確認する画面を表示するコマンドのクラス*/
public class OrderDataConfirmationCommand extends AbstractCommand {
	/*入力された注文情報をセッションスコープに保存し、
	注文する商品の情報をレスポンスに含めて返すメソッド*/
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException {
		/*initメソッドによって準備されていたRequestContextを取得する*/
		RequestContext requestContext = getRequestContext();
		
		/*リクエストスコープから取り出し、セッションスコープに登録したい値の
		キーを定義する。ここでは、入力値が必ず一つであるキーを定義する。*/
		String[] singleValueKeyNames = {"familyname","name","zipcode",
			"prefectures","city","blocknumber","buildingname","phonenumber",
			"requesteddate","requestedtime","paymentmethod","creditcardnumber",
			"securitycode","expirationdate","orderprice","commission",
			"totalprice"
		};
		
		/*リクエストスコープにある上記配列内の名前のキーの値を、
		セッションスコープに追加する*/
		for(String keyName : singleValueKeyNames){
			requestContext.setSessionAttribute(
				keyName,requestContext.getParameter(keyName)[0]);
		}
		
		/*リクエストスコープから取り出し、セッションスコープに登録したい値の
		キーを定義する。ここでは、入力値が複数になるキーを定義する。*/
		String[] multipleValueKeyNames = {"ordercounts","orderproducts"};
		
		/*リクエストスコープにある上記配列内の名前のキーの値を、
		セッションスコープに追加する*/
		for(String keyName : multipleValueKeyNames){
			requestContext.setSessionAttribute(
				keyName,requestContext.getParameter(keyName));
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

/*
スコープに保存するデータのキーが何を表すかを列挙する。
"familyname"		名字
"name"				名前
"zipcode"			郵便番号
"prefectures"		都道府県
"city"				市区町村
"blocknumber"		番地
"buildingname"		建物名
"phonenumber"		電話番号
"requesteddate"		配達希望日
"requestedtime"		配達希望時間
"paymentmethod"		支払い方法（代引きかクレジットカード）
"creditcardnumber"	クレジットカード番号
"securitycode"		クレジットカードのセキュリティコード
"expirationdate"	クレジットカードの有効期限
"orderprice"		注文する商品の金額
"commission"		手数料（代引きの際の追加料金）
"totalprice"		注文する商品の金額と手数料の合計

"ordercount"		注文する個数の配列
					１番目の商品の個数は[0]、２番目の商品は[1]・・・
"orderproducts"		注文する商品のIDの配列
*/
