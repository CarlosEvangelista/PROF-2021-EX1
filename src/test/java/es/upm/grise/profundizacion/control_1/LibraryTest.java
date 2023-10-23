package es.upm.grise.profundizacion.control_1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class LibraryTest {
	
	static final Book[] books = new Book[]{new Book("Lazarillo de Tormes"),new Book("El Quijote"),new Book("La verdad sobre el caso Savolta")};

	@Test
	public void whenCallingAddBookDoNotThrow() {
		Library lib = new Library();
		assertDoesNotThrow(() -> lib.addBook(books[0]), "Error, el método addBook no debería lanzar excepción, no se ha añadido libro repetido");	
	}

	@Test
	public void whenCallingAddBookWithRepeatedBookThrow() throws DuplicatedBookException {
		Library lib = new Library();
		lib.addBook(books[0]);
		assertThrows(DuplicatedBookException.class, () -> lib.addBook(books[0]), "Error, el método addBook debería lanzar excepción, no se ha añadido libro repetido");
	}

	@Test
	public void whenCallingAddBookWithDifferentBooksDoNotThrow() {
		Library lib = new Library();
		for (Book book : books) {
			assertDoesNotThrow(() -> lib.addBook(book), "Error, el método addBook no debería lanzar excepción, no se ha añadido libro repetido");	
		}
	}

	@Test
	public void whenCallingRemoveBookWithNoBooksOnLibraryDoNotThrow(){
		Library lib = new Library();
		assertDoesNotThrow(() -> lib.removeBook(books[0]), "Error, el método removeBook no debería lanzar excepción cuando es invocado sobre una biblioteca vacia");	
	}

	@Test
	public void whenCallingRemoveBookWithNonExistingBookAndBooksOnLibraryDoNotThrow(){
		Library lib = new Library();
		assertDoesNotThrow(() -> addBooksToLib(books, lib), "Error, el método addBook no debería lanzar excepción, no se ha añadido libro repetido");
		Book b = new Book("nonexistent");
		assertDoesNotThrow(() -> lib.removeBook(b), "Error, el método removeBook no debería lanzar excepción cuando es invocado con un libro que no existe en la biblioteca");	
	}


	
	private void addBooksToLib(Book[] books, Library lib) throws DuplicatedBookException{
		for (Book book : books) {
			lib.addBook(book);
		}
	}
}
