import java.util.*;

class Book {
	private String title;
	private int year;

	public Book(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}
}

public class Library {
	private List<Book> books = new ArrayList<>();

	public void addBook(String title, int year) {
		books.add(new Book(title, year));
	}

	class BookShelf implements Iterable<Book> {
		private int minYear;

		public BookShelf(int minYear) {
			this.minYear = minYear;
		}

		@Override
		public Iterator<Book> iterator() {
			List<Book> filtered = new ArrayList<>();
			for (Book book : books) {
				if (book.getYear() >= minYear) {
					filtered.add(book);
				}
			}
			return filtered.iterator();
		}
	}

	public BookShelf getRecentBooks(int minYear) {
		return new BookShelf(minYear);
	}

	public static void main(String[] args) {
		Library library = new Library();
		library.addBook("Suun zam", 2020);
		library.addBook("Ertnii tuuh", 1999);
		library.addBook("Orchlon", 2005);

		for (Book book : library.getRecentBooks(2000)) {
			System.out.println(book.getTitle() + ": " + book.getYear());
		}
	}
}