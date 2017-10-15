package com.YiDong.pojo;

public class Tuser {
	private String uid;
	private long number;
	private String roaming;
	private String level;
	private String cid;
	private String isAvailable;

	public long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRoaming() {
		return roaming;
	}

	public void setRoaming(String roaming) {
		this.roaming = roaming;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
}
