package bean;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable{
	//�t�B�[���h
	
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
	
	//������getter
	public String getName(){
	return name;
	}
	//������setter
	public void setName(String name){
	this.name = name;
	}
	
	//�J�i��getter
	public String getKanaName(){
	return kanaName;
	}
	//�J�i��setter
	public void setKanaName(String kanaName){
		this.kanaName = kanaName;
	}
	//���N������getter
	public Date getBirthday(){
	return birthday;
	}
	//���N������setter
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	//�X�֔ԍ���getter
	public Integer getPost(){
	return post;
	}
	//�X�֔ԍ���setter
	public void setPost(Integer post){
		this.post = post;
	}
	//�s���{����getter
	public String getPrefectures(){
	return prefectures;
	}
	//�s���{����setter
	public void setPrefectures(String prefectures){
		this.prefectures = prefectures;
	}
	//�s�撬����getter
	public String getMunicipality(){
	return municipality;
	}
	//�s�撬����setter
	public void setMunicipality(String municipality){
		this.municipality = municipality;
	}
	//�Ԓn��getter
	public String getAddress(){
	return address;
	}
	//�Ԓn��setter
	public void setAddress(String address){
		this.address = address;
	}
	
	//��������getter
	public String getBuildingName(){
	return buildingName;
	}
	//��������setter
	public void setBuildingName(String buildingName){
		this.buildingName = buildingName;
	}
	//�d�b�ԍ���getter
	public Integer getTelephone(){
	return telephone;
	}
	//�d�b�ԍ���setter
	public void setTelephone(Integer telephone){
		this.telephone = telephone;
	}
	//���[���A�h���X��getter
	public String getMail(){
	return mail;
	}
	//���[���A�h���X��setter
	public void setMail(String mail){
		this.mail = mail;
	}
	//�m�F�p���[���A�h���X��getter
	public String getConfirmationMail(){
	return confirmationMail;
	}
	//�m�F�p���[���A�h���X��setter
	public void setConfirmationMail(String confirmationMail){
		this.confirmationMail = confirmationMail;
	}
	//�p�X���[�h��getter
	public String getPassWord(){
	return passWord;
	}
	//�p�X���[�h��setter
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	//�m�F�p�p�X���[�h��getter
	public String getConfirmationPass(){
	return confirmationPass;
	}
	//�m�F�p�p�X���[�h��setter
	public void setConfirmationPass(String confirmationPass){
		this.confirmationPass = confirmationPass;
	}
	
	
	
	
}