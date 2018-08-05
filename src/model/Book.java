package model;

public class Book {
	private String ID;
	private String bookName;
	private String author;
	private String sex;
	private String price;
	private String typeID;
	private String typeName;
	private String desc;
	
	public Book() {
		ID = "";
	}
	
	public Book( String bookName, String author, String sex, String price, String typeID,String desc) {
		ID = "";
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.typeID = typeID;
		this.desc = desc;
	}
	
	public Book(String iD, String bookName, String author, String sex, String price, String typeID,String desc) {
		ID = iD;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.typeID = typeID;
		this.desc = desc;
	}
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
