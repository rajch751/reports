package com.repots.model;

public class ToCOeExcercise {
	

	private String sno;
	private String groupType;
	private String transType;
	private String debitsa;
	private String debitca;
    private String debitamt;
    
    
	public ToCOeExcercise(String sno, String groupType, String transType, String debitsa, String debitca,
			String debitamt) {
		super();
		this.sno = sno;
		this.groupType = groupType;
		this.transType = transType;
		this.debitsa = debitsa;
		this.debitca = debitca;
		this.debitamt = debitamt;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getDebitsa() {
		return debitsa;
	}
	public void setDebitsa(String debitsa) {
		this.debitsa = debitsa;
	}
	public String getDebitca() {
		return debitca;
	}
	public void setDebitca(String debitca) {
		this.debitca = debitca;
	}
	public String getDebitamt() {
		return debitamt;
	}
	public void setDebitamt(String debitamt) {
		this.debitamt = debitamt;
	}
    
    
	
}

