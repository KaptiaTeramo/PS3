package pkgLibrary;

public class BookException extends Throwable{
	public BookException(Book a){
		this.A = a;
	}
	public Book getD(){
		return A;
	}
	private Book A;
}
