
/*
@ author 宇津野光
*/

package bean;

import java.io.Serializable;

public class MemberBean implements Serializable{

	private int memberId;
	private String memberName;
	private String memberKana;
	private String memberZipCode;
	private String memberAddress;
	private String memberPhoneNumber;
	private String memberBirthday;
	private String memberEmail;
	private String memberPassword;
	private int memberStatusId;

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberKana() {
		return memberKana;
	}
	public void setMemberKana(String memberKana) {
		this.memberKana = memberKana;
	}
	public String getMemberZipCode() {
		return memberZipCode;
	}
	public void setMemberZipCode(String memberZipCode) {
		this.memberZipCode = memberZipCode;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public String getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public int getMemberStatusId() {
		return memberStatusId;
	}
	public void setMemberStatusId(int memberStatusId) {
		this.memberStatusId = memberStatusId;
	}


}