package com.chagawa.member.vo;

public class MemberVO {
	
	private String id, pw, nickname, name, profileImage;
	private long myPoint;
	private String gender, birth, tel, bank, account, regDate, conDate;
	private long gradeNo;
	private String status, gradeName, carModel, carNo, licenseNo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public long getMyPoint() {
		return myPoint;
	}
	public void setMyPoint(long myPoint) {
		this.myPoint = myPoint;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getConDate() {
		return conDate;
	}
	public void setConDate(String conDate) {
		this.conDate = conDate;
	}
	public long getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(long gradeNo) {
		this.gradeNo = gradeNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", name=" + name + ", profileImage="
				+ profileImage + ", myPoint=" + myPoint + ", gender=" + gender + ", birth=" + birth + ", tel=" + tel
				+ ", bank=" + bank + ", account=" + account + ", regDate=" + regDate + ", conDate=" + conDate
				+ ", gradeNo=" + gradeNo + ", status=" + status + ", gradeName=" + gradeName + ", carModel=" + carModel
				+ ", carNo=" + carNo + ", licenseNo=" + licenseNo + "]";
	}
	
}
