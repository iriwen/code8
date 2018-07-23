package com.mocktest;


import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by a0285 on 2018/7/19.
 */

public class BookDaoTest {
    private static BookDao mockedBookDao;


    @Mock
    private static BookDao mockedBookDao2;

    private static Book book1;
    private static Book book2;

    /*@BeforeClass*/
    @Before
    public  void setUp(){

        //初始化对象的注解
        MockitoAnnotations.initMocks(this);
        mockedBookDao =  mock(BookDao.class);
        book1 = new Book("8131721019","Compilers Principles",
                Arrays.asList("D. Jeffrey Ulman","Ravi Sethi", "Alfred V. Aho", "Monica S. Lam"),
                "Pearson Education Singapore Pte Ltd", 2008,1009,"BOOK_IMAGE");

        book2 = new Book("9788183331630","Let Us C 13th Edition",
                Arrays.asList("Yashavant Kanetkar"),"BPB PUBLICATIONS", 2012,675,"BOOK_IMAGE");

        //Stubbing the methods of mocked BookDao with mocked data. 设置预期
        when(mockedBookDao.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
        when(mockedBookDao.getBook("8131721019")).thenReturn(book1);
        when(mockedBookDao.addBook(book1)).thenReturn(book1.getIsbn());
        when(mockedBookDao.updateBook(book1)).thenReturn(book1.getIsbn());

         /* 验证操作，验证 get(0) 调用了 2 次 */
        // verify(list, times(2)).get(0);
        //String ret = (String)list.get(0);
        //Assert.assertEquals(ret, "111");


    }


    @Test
    public void testGetAllBooks() throws Exception {

        List<Book> allBooks = mockedBookDao.getAllBooks();
        assertEquals(2, allBooks.size());
        Book myBook = allBooks.get(0);
        assertEquals("8131721019", myBook.getIsbn());
        assertEquals("Compilers Principles", myBook.getTitle());
        assertEquals(4, myBook.getAuthors().size());
        assertEquals((Integer)2008, myBook.getYearOfPublication());
        assertEquals((Integer) 1009, myBook.getNumberOfPages());
        assertEquals("Pearson Education Singapore Pte Ltd", myBook.getPublication());
        assertEquals("BOOK_IMAGE", myBook.getImage());
    }

    @Test
    public void testGetBook(){

        String isbn = "8131721019";

        Book myBook = mockedBookDao.getBook(isbn);

        assertNotNull(myBook);
        assertEquals(isbn, myBook.getIsbn());
        assertEquals("Compilers Principles", myBook.getTitle());
        assertEquals(4, myBook.getAuthors().size());
        assertEquals("Pearson Education Singapore Pte Ltd", myBook.getPublication());
        assertEquals((Integer)2008, myBook.getYearOfPublication());
        assertEquals((Integer)1009, myBook.getNumberOfPages());

    }

    @Test
    public void testAddBook(){
        String isbn = mockedBookDao.addBook(book1);
        assertNotNull(isbn);
        assertEquals(book1.getIsbn(), isbn);
    }

    @Test
    public void testUpdateBook(){

        String isbn = mockedBookDao.updateBook(book1);
        assertNotNull(isbn);
        assertEquals(book1.getIsbn(), isbn);
    }

    @AfterClass
    public static void after(){
        System.out.println("after test ....");
    }

}

