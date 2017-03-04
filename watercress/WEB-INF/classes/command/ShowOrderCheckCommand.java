/*
  @className ShowOrderChechCommand
  @author 窪田
  @date 2017/03/02
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
import java.util.HashMap;
import java.util.Map;


/*確認画面に移行する*/
public class ShowOrderCheckCommand extends AbstractCommand {
	
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException {
		
		RequestContext requestContext = getRequestContext();
		
		/*formのnameを格納*/
		/*String[] singleValueKeyNames = {"firstname","name","kanafirstname","kananame",
		"zipcode","prefectures","city","blocknumber","bildingname","phonenumber",
		"delivery_request_day","delivery_request_time","orderprice","totalprice"};
		*/
		
		String payment_method = requestContext.getParameter("payment_method")[0];
		HashMap<String,String> parameters = new HashMap<String,String>();
		
		if(payment_method.equals("creditCard")){
			/*クレジットカードの番号16桁を取得*/
			String cardNum = requestContext.getParameter("creditcardnumber")[0];
			
			/*カード番号最初４桁のみ表示し、残り12桁を「*」にする*/
			String asteristCardNum = cardNum.substring(0,4) + " **** **** ****";
			
			String expirationdate_year = requestContext.getParameter("expirationdate_year")[0];
			
			String expirationdate_month = requestContext.getParameter("expirationdate_month")[0];
			
			/*jspに渡すためにhtml形式で成形する*/
			String str = "カード番号&nbsp;" + asteristCardNum + "<br>"+
				     "有効期限" + expirationdate_year + "年/" + 
				     expirationdate_month + "月";
			parameters.put("payment_information",str);
			
			String totalprice = "&yen;" + requestContext.getParameter("totalprice")[0];
			String orderprice = "&yen;" + requestContext.getParameter("orderprice")[0];
			
			parameters.put("orderprice",orderprice);
			parameters.put("comission","&yen;0");
			parameters.put("totalprice",totalprice);
			
		}else if(payment_method.equals("cashOnDelivery")){
			String str = "商品代引き&nbsp;:手数料324円";
			parameters.put("payment_information",str);
			parameters.put("comission","&yen;324");
			
			String orderprice = requestContext.getParameter("orderprice")[0];
			
			String totalprice = 
			String.valueOf(Integer.parseInt(orderprice) + new Integer(324));
			
			orderprice = "&yen;" + orderprice;
			totalprice = "&yen;" + totalprice;
			
			parameters.put("orderprice",orderprice);
			parameters.put("totalprice",totalprice);
		}
			parameters.put("name",requestContext.getParameter("name")[0]);
		/*
			リクエストスコープのparameterを確認画面にの表示するためのmapに格納
		*/
		
		String firstname = requestContext.getParameter("firstname")[0];
		String name = requestContext.getParameter("name")[0];
		String kanafirstname = requestContext.getParameter("kanafirstname")[0];
		String kananame = requestContext.getParameter("kananame")[0];
		String zipcode = requestContext.getParameter("zipcode")[0];
		String prefectures = requestContext.getParameter("prefectures")[0];
		String city = requestContext.getParameter("city")[0];
		String blocknumber = requestContext.getParameter("blocknumber")[0];
		String bildingname = requestContext.getParameter("bildingname")[0];
		String phonenumber = requestContext.getParameter("phonenumber")[0];
		String delivery_request_day = requestContext.getParameter("delivery_request_day")[0] + "営業日後";
		String delivery_request_time = requestContext.getParameter("delivery_request_time")[0];
		
		
		
		parameters.put("firstname",firstname);
		parameters.put("name",name);
		parameters.put("kanafirstname",kanafirstname);
		parameters.put("kananame",kananame);
		parameters.put("zipcode",zipcode);
		parameters.put("prefectures",prefectures);
		parameters.put("city",city);
		parameters.put("blocknumber",blocknumber);
		parameters.put("bildingname",bildingname);
		parameters.put("phonenumber",phonenumber);
		parameters.put("delivery_request_day",delivery_request_day);
		parameters.put("delivery_request_time",delivery_request_time);
		
		
				
		responseContext.setResult(parameters);
		
		responseContext.setTarget("ordercheck"); 

		return responseContext;
	}
}

