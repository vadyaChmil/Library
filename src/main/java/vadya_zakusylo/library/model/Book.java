package vadya_zakusylo.library.model;

public class Book {

	private int id;
	private String bookAutor;
	private String bookTitle;
	private int yearEdition;
	private int pages;

	public Book(int id, String bookAutor, String bookTitle, int yearEdition, int pages) {
		this.id = id;
		this.bookAutor = bookAutor;
		this.bookTitle = bookTitle;
		this.yearEdition = yearEdition;
		this.pages = pages;
	}

	public int getBookId() {
		return id;
	}

	public String getBookAutor() {
		return bookAutor;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public int getYearEdition() {
		return yearEdition;
	}

	public int getPages() {
		return pages;
	}
}
