package homework_47;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
/*
написать автотест JUnit
проверить краевые случаи
 */

public class BookTitleAuthorComparatorTests {
  private Comparator<Book> comparator = new BookTitleAuthorComparator();

  @Test
  public void differentTitleComparison() {
    //сравниваем разные названия

    //arrange
    Book book1 = new Book("Author","A",1);
    Book book2 = new Book("Author","B",1);

    //act
    int result1 = comparator.compare(book1, book2);
    int result2 = comparator.compare(book2, book1);

    //assert
    assertTrue(result1 < 0);
    assertTrue(result2 > 0);

  }
  @Test
  public void consistency() {
    Book book1 = new Book("Author","Title 1",1);
    Book book2 = new Book("Buthor","Title 2",2);

    int result1 = comparator.compare(book1, book2);
    int result2 = comparator.compare(book1, book2);

    //assertEquals(result1, -result2); // результаты должны получиться с разными знаками
     assertTrue(result1 * result2 < 0);  //так правильно
  }

  @Test
  public void sameTitleDifferentAuthorComparison() {
    //сравниваем разные названия

    //arrange
    Book book1 = new Book("Author","A",1);
    Book book2 = new Book("Buthor","A",1);

    //act
    int result1 = comparator.compare(book1, book2);
    int result2 = comparator.compare(book2, book1);

    //assert
    assertEquals( 0, result1);
    assertEquals( 0, result2);

  }
}
