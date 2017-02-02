package bean;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable{
	//フィールド
	
	private String name;
	private String kanaName;
	private Date birthday;
	private Integer post;
	private String prefectures;
	private String municipality;
	private String address;
	private String buildingName;
	private Integer telephone;
	private String mail;
	private String confirmationMail;
	private String passWord;
	private String confirmationPass;
	
	
	public UserBean(){}
	
	//氏名のgetter
	public String getName(){
	return name;
	}
	//氏名のsetter
	public void setName(String name){
	this.name = name;
	}
	
	//カナのgetter
	public String getKanaName(){
	return kanaName;
	}
	//カナのsetter
	public void setKanaName(String kanaName){
		this.kanaName = kanaName;
	}
	//生年月日のgetter
	public Date getBirthday(){
	return birthday;
	}
	//生年月日のsetter
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	//郵便番号のgetter
	public Integer getPost(){
	return post;
	}
	//郵便番号のsetter
	public void setPost(Integer post){
		this.post = post;
	}
	//都道府県のgetter
	public String getPrefectures(){
	return prefectures;
	}
	//都道府県のsetter
	public void setPrefectures(String prefectures){
		this.prefectures = prefectures;
	}
	//市区町村のgetter
	public String getMunicipality(){
	return municipality;
	}
	//市区町村のsetter
	public void setMunicipality(String municipality){
		this.municipality = municipality;
	}
	//番地のgetter
	public String getAddress(){
	return address;
	}
	//番地のsetter
	public void setAddress(String address){
		this.address = address;
	}
	
	//建物名のgetter
	public String getBuildingName(){
	return buildingName;
	}
	//建物名のsetter
	public void setBuildingName(String buildingName){
		this.buildingName = buildingName;
	}
	//電話番号のgetter
	public Integer getTelephone(){
	return telephone;
	}
	//電話番号のsetter
	public void setTelephone(Integer telephone){
		this.telephone = telephone;
	}
	//メールアドレスのgetter
	public String getMail(){
	return mail;
	}
	//メールアドレスのsetter
	public void setMail(String mail){
		this.mail = mail;
	}
	//確認用メールアドレスのgetter
	public String getConfirmationMail(){
	return confirmationMail;
	}
	//確認用メールアドレスのsetter
	public void setConfirmationMail(String confirmationMail){
		this.confirmationMail = confirmationMail;
	}
	//パスワードのgetter
	public String getPassWord(){
	return passWord;
	}
	//パスワードのsetter
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	//確認用パスワードのgetter
	public String getConfirmationPass(){
	return confirmationPass;
	}
	//確認用パスワードのsetter
	public void setConfirmationPass(String confirmationPass){
		this.confirmationPass = confirmationPass;
	}
	
	
	
	
}