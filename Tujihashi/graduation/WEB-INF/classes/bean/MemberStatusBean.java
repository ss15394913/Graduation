package bean;

import java.io.Serializable;

public class MemberStatusBean implements Serializable{
	private int memberStatusId;
	private String memberStatusName;
	
	public int getMemberStatusId() {
		return memberStatusId;
	}
	public void setMemberStatusId(int memberStatusId) {
		this.memberStatusId = memberStatusId;
	}
	public String getMemberStatusName() {
		return memberStatusName;
	}
	public void setMemberStatusName(String memberStatusName) {
		this.memberStatusName = memberStatusName;
	}

}
