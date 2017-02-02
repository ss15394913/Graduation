/*
  @author 池田大和
  @date 2017/01/26
*/

package command;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import bean.ProductInformationBean;
import dao.AbstractDaoFactory;
import dao.ProductInformationDao;

import logic.RequestContext;
import logic.ResponseContext;
import ex.IntegrationException;
import ex.LogicException;

/*クリックされた商品の詳細を表示するコマンドのクラス*/
public class ShowProductDetailCommand extends AbstractCommand{
	/*クリックされた商品の詳細を返すメソッド*/
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		/*initメソッドによって準備されていたRequestContextを取得する*/
		RequestContext requestContext = getRequestContext();
		
		/*「DAOから受け取る商品詳細のリスト」の変数を宣言*/
		List allProductInformations = null;
		
		/*「目的の名前を持つ商品の、商品詳細のリスト」の変数を宣言*/
		/*これを戻り値のResponseContextに加える*/
		List returnProductInformations = null;
		
		/*ユーザーが選択した商品の名前を取得*/
		String selectedProductName
		= requestContext.getParameter("product_name")[0];
		
		try{
			/*商品詳細の表からデータを取得するためのDAOを取得する*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductInformationDao productInformationDao
			= factory.getProductInformationDao();
			
			/*DAOから商品詳細表のデータを取得する*/
			allProductInformations
			= productInformationDao.getProductInformations();
			
			/*イテレータを使い、取得した表の各行を確認して処理を行う*/
			Iterator iterator = allProductInformations.iterator();
			while(iterator.hasNext()){
				/*一件の商品詳細であるBeanを取得*/
				ProductInformationBean productInfo
				= (ProductInformationBean)iterator.next();
				/*取得したBean内の商品名の変数が、ユーザーが選択した商品の名前
				  と同じであるなら、レスポンスのListにそのBeanを追加する*/
				/*選ばれた名前の商品なら、レスポンスの内容に追加される*/
				if(productInfo.getProductName().equals(selectedProductName)){
					returnProductInformations.add(productInfo);
				}
			}
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*レスポンスに、目的の名前を持つ商品の商品詳細のリストを加える*/
		responseContext.setResult(returnProductInformations);
		
		/*転送先のViewの名前をレスポンスに加える*/
		responseContext.setTarget("productdetail");
		
		/*必要な情報を入れ終わったレスポンスを返す*/
		return responseContext;
	}
}