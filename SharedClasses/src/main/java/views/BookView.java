package views;

import models.Book;

/**
 * @deprecated 
 * @author ���������
 */
public class BookView {
    void printBook(Book book) {
        System.out.printf("%25s %15s\n", book.getTitle(), book.getAuthor().getName());
    }
}

