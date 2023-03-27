package com.chagawa.message.vo;


public class MessageVO {

	private  long no,roomno;
	private String content, sender, accepter, sendDate, acceptDate, profileImage;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getRoomno() {
		return roomno;
	}
	public void setRoomno(long roomno) {
		this.roomno = roomno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getAccepter() {
		return accepter;
	}
	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	@Override
	public String toString() {
		return "MessageVO [no=" + no + ", roomno=" + roomno + ", content=" + content + ", sender=" + sender
				+ ", accepter=" + accepter + ", sendDate=" + sendDate + ", acceptDate=" + acceptDate + ", profileImage="
				+ profileImage + "]";
	}
	
	
	
}
