package vadya_zakusylo.library.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.dao.LibraryDao;

public class LibraryDaoTest {
	LibraryDao libraryDao;
	List<Book> bookList;

	@Before
	public void oneTimeSetUp() {
		libraryDao = mock(LibraryDao.class);
		bookList = new ArrayList<Book>();
	}

	@After
	public void oneTimeTearDown() {
		libraryDao = null;
		bookList = null;
	}

	@Test(expected = SQLException.class)
	public void shouldGetBookList_whenResourceNotExist() throws SQLException {
		// when
		when(libraryDao.getBookList()).thenThrow(new SQLException());
		// then
		libraryDao.getBookList();
	}

	@Test
	public void shouldGetBookList_whenBooksNotExist() throws SQLException {
		// when
		when(libraryDao.getBookList()).thenReturn(bookList);
		bookList = null;
		// then
		assertTrue(libraryDao.getBookList().size() == 0);
	}

	@Test
	public void shouldGetBookList_whenOneBook() throws SQLException {
		// when
		when(libraryDao.getBookList()).thenReturn(bookList);
		assertEquals(0, libraryDao.getBookList().size());
		bookList.add(new Book(1, "bookAutor1", "bookTitle1", 2001, 101));
		// then
		assertEquals(1, libraryDao.getBookList().size());
	}

	@Test
	public void shouldGetBookList_whenTwoBooks() throws SQLException {
		// when
		when(libraryDao.getBookList()).thenReturn(bookList);
		assertEquals(0, libraryDao.getBookList().size());
		bookList.add(new Book(1, "bookAutor1", "bookTitle1", 2001, 101));
		bookList.add(new Book(2, "bookAutor2", "bookTitle2", 2002, 102));
		// then
		assertEquals(2, libraryDao.getBookList().size());
	}
}
