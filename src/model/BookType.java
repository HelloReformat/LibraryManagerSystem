package model;

public class BookType {
     private String id; 
     private String BookTypeName;
     private String BookTypeDesc;
     
     public BookType() {
    	 BookTypeName ="";
     }
     
     
     public BookType( String BookTypeName,String BookTypeDesc) {
    	 this.BookTypeName = BookTypeName;
    	 this.BookTypeDesc = BookTypeDesc;
     }
     
     public BookType(String id, String BookTypeName,String BookTypeDesc) {
     	 this.id = id;
     	 this.BookTypeName = BookTypeName;
     	 this.BookTypeDesc = BookTypeDesc;
      }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookTypeName() {
		return BookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		BookTypeName = bookTypeName;
	}

	public String getBookTypeDesc() {
		return BookTypeDesc;
	}

	public void setBookTdypeDesc(String bookTypeDesc) {
		BookTypeDesc = bookTypeDesc;
	}
     
	public String toString() {
		return BookTypeName;
	}
}
