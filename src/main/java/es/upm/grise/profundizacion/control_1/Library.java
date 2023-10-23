package es.upm.grise.profundizacion.control_1;

import java.util.ArrayList;

public class Library {
	
	
	private ArrayList<Book> books;
	
	public Library() {
		this.books = new ArrayList<Book>();
	}
	
	public void addBook(Book book) throws DuplicatedBookException {
		for(Book b:books) {
			if(b.getTitle().equals(book.getTitle())) {
				throw new DuplicatedBookException();				
			}
		}
		this.books.add(book);
	}
	
	public void removeBook(Book book) {
		if(this.books.isEmpty()){
			return;
		}
		int position = books.indexOf(book);
		if(position==-1){
			return;
		}
		books.remove(position);
	}

	public Book getBook(String title) throws NonExistingBookException, EmptyLibraryException {
		
		if(books.isEmpty()) {
			throw new EmptyLibraryException();
		}
		
		for(int position = 0; position < books.size(); position++) {
			Book book = books.get(position);
			if(book.getTitle().equals(title)) {
				return book;
			}
		}
	
		throw new NonExistingBookException();
	
	}

}
