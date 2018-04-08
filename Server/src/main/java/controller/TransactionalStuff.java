/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.service.AuthorService;
import database.service.BookService;
import database.service.PublisherService;
import entity.Author;
import entity.Book;
import entity.Publisher;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import models.YearOutOfBoundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author Алескандр
 */
@Service
@Transactional
public class TransactionalStuff {
    
    @Autowired
    BookService bookService;
    
    @Autowired
    AuthorService authorService;
    
    @Autowired
    PublisherService publisherService;
    
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void bookEditTransaction(MultiValueMap<String, String> params, Model model) throws YearOutOfBoundsException{
        Book b = bookService.getByID(Integer.parseInt(params.get("id").get(0)));
            for (Author author : b.getAuthors()) {
                author.getBooks().remove(b);
                authorService.editAuthor(author);
            }
            List<String> aNames = params.get("author");
            List<Author> newAuthors = new LinkedList<>();
            for (String aname : aNames) {
                newAuthors.add(authorService.getByName(aname));
            }
            Publisher p = publisherService.getByName(params.get("publisher").get(0));
            b.setBookName(params.get("booktitle").get(0));
            b.setBrief(params.get("brief").get(0));
            b.setPublishYear(Integer.parseInt(params.get("publishYear").get(0)));
            if (b.getPublishYear() < 0 && b.getPublishYear() > Calendar.YEAR) {
                throw new YearOutOfBoundsException();
            }
            b.setPublisher(p);
            //bookService.editBook(b);
            
            b.setAuthors(newAuthors);
            
            bookService.editBook(b);
            for (int i = 0; i < newAuthors.size(); i++) {
                newAuthors.get(i).getBooks().add(b);
                authorService.editAuthor(newAuthors.get(i));
            }
    }
}
