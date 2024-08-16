package com.example.inst.discover;

public class ResponseDE {
	
	private String de;
	private String en;
	private String ru;
	private String descriptionEN;
	private String descriptionRU;
	private String descriptionDE;
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	public String getRu() {
		return ru;
	}
	public void setRu(String ru) {
		this.ru = ru;
	}
	public String getDescriptionEN() {
		return descriptionEN;
	}
	public void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}
	public String getDescriptionRU() {
		return descriptionRU;
	}
	public void setDescriptionRU(String descriptionRU) {
		this.descriptionRU = descriptionRU;
	}
	public String getDescriptionDE() {
		return descriptionDE;
	}
	public void setDescriptionDE(String descriptionDE) {
		this.descriptionDE = descriptionDE;
	}
	public ResponseDE(String de, String en, String ru, String descriptionEN, String descriptionRU,
			String descriptionDE) {
		super();
		this.de = de;
		this.en = en;
		this.ru = ru;
		this.descriptionEN = descriptionEN;
		this.descriptionRU = descriptionRU;
		this.descriptionDE = descriptionDE;
	}
	
	

}
