package command;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import bean.MemberBean;
import bean.ProductBean;
import bean.FavoriteBean;

import dao.AbstractDaoFactory;
import dao.MemberDao;
import dao.ProductDao;
import dao.FavoriteDao;


import logic.ResponseContext;
import logic.RequestContext;
import logic.WebRequestContext;
import ex.IntegrationException;
import ex.LogicException;

/**
 *@className UserStatusCommand
 *@author 河野,宇津野
 *@date 2017/01/31
 *@description 
 */

public class UserStatusCommand extends AbstractCommand{
	
	/*クライアントからのリクエスト*/
	private RequestContext requestContext;
	/*Daoからお気に入り表全件入れるList*/
	private List favoriteList;
	/*会員のお気に入り商品IDのみ入れるList*/
	private ArrayList<String> memberFavoriteList =
		new ArrayList<String>();
	/*商品全件を入れるList*/
	private List productList;
	/*会員のお気に入り商品を入れるList*/
	private ArrayList<ProductBean> memberProductList =
		new ArrayList<ProductBean>();
	
	public ResponseContext execute(ResponseContext responseContext) throws LogicException{
		/*RequestContextのインスタンスを取得*/
		RequestContext requestContext = new WebRequestContext();
		
		MemberBean member = new MemberBean();
	
		/*入力されたパラメータを受け取る*/
		int memberId = Integer.parseInt(requestContext.getSessionAttribute("login").toString()) ;
		
		/*メンバーリストを全件取得のためのリスト*/
		List allMemberList = null;
		/*returnで返すためのリスト*/
		List myPageList = null;
		
		try{
		/*プロフィールの取得処理ーーーーーーーーーーーーーーーーーーーー*/
			
			/*AbstractDaoFactoryのインスタンスを取得*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			
			/*MemberDaoのインスタンスを取得*/
			MemberDao memberDao = factory.getMemberDao();
			
			/*メンバーリストを全件取得*/
			allMemberList = memberDao.getMembers();
			
			Iterator iterator = allMemberList.iterator();
			
			while(iterator.hasNext()){
				
				member = (MemberBean)iterator.next();
				if(memberId == member.getMemberId()){
					break;
				}
			}
			/*プロフィール情報をListに格納*/
			myPageList.add(member);
			
		/*お気に入り一覧の取得処理ーーーーーーーーーーーーーーーーーーー*/
			
			/*FavoriteDao型の変数ににOraFavoriteDaoインスタンスを入れる*/
			FavoriteDao favoriteDao = factory.getFavoriteDao();
			/*ProductDao型の変数ににOraProductDaoインスタンスを入れる*/
			ProductDao productDao = factory.getProductDao();
			/*お気に入り表全件を取得*/
			favoriteList = favoriteDao.getFavorites();
			iterator = favoriteList.iterator();
			
			while(iterator.hasNext()){
				/*お気に入り表の内容がループ毎に一件ずつ入る*/
				FavoriteBean fb =  (FavoriteBean)iterator.next();
				/*お気に入りを表示したい会員のIDと
				お気に入り表に登録されているIDを比べ、
				等しい会員IDと結びついている商品IDを入れる*/
				if(memberId == fb.getMemberId()){
					memberFavoriteList.add(fb.getProductId());
				}
			}
			
			/*Product表を全件取得*/
			productList = productDao.getProducts();
			iterator = productList.iterator();
			
			while(iterator.hasNext()){
				/*商品情報がループ毎に一件ずつ入る*/
				ProductBean pb =  (ProductBean)iterator.next();
				/*memberFavoriteList内にある
					複数の商品IDのどれかと合致する商品IDの商品を入れる*/
				if(memberFavoriteList.contains(pb.getProductId())){
					memberProductList.add(pb);
				}
			}
			
			myPageList.add(memberProductList);
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*
			responseで送る値をセット
			一つ目にMemberBean
			二つ目にお気に入り商品の入ったArrayList型で、ProductBeanが
			複数入っている
		*/
		responseContext.setResult(myPageList);
		
		/*転送先のビューを指定*/
		responseContext.setTarget("mypage");
		
		/*returnで結果を返す*/
		return responseContext;
	}
}