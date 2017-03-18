package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Book GetBook(String id) throws BookException{
		Book temp = null;
		for(Book b: books){
			if(b.getId().equals(id))
				temp = b;
		}
		if(temp == null){
			temp = new Book(id);
			throw new BookException(temp);
		}
		return temp;
	}
	
	public void AddBook(Book book) throws BookException{
		Book temp = null;
		boolean within = false;

		for(Book b: books){
			if(b.getId().equals(book.getId()))
				throw new BookException(book);
			within = true;
		}
		if(! within) 
			books.add(book);
	}
}
