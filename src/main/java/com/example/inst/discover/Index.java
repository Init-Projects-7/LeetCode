package com.example.inst.discover;

class Trio{
	public String de;
	public String en;
	public String ru;
	
	public Trio(String de, String en, String ru) {
		super();
		this.de = de;
		this.en = en;
		this.ru = ru;
	}
	
}

public class Index {
	
	public Trio name;
	public Trio description;
	public String level;
	public String file;
	public String image;
	public String words;
	public String multi;
	public String yesNo;
	
	
	public Trio getName() {
		return name;
	}
	public void setName(Trio name) {
		this.name = name;
	}
	public Trio getDescription() {
		return description;
	}
	public void setDescription(Trio description) {
		this.description = description;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getMulti() {
		return multi;
	}
	public void setMulti(String multi) {
		this.multi = multi;
	}
	public String getYesNo() {
		return yesNo;
	}
	public void setYesNo(String yesNo) {
		this.yesNo = yesNo;
	}
	
	

}
