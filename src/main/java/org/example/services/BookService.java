package org.example.services;

import org.example.dao.BookDAO;
import org.example.models.Book;
import org.example.models.Person;
import org.example.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookRepository bookRepository, BookDAO bookDAO) {
        this.bookRepository = bookRepository;
        this.bookDAO = bookDAO;
    }


    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = bookRepository.findById(id);
        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        bookRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public Optional<Person> getBookOwner(int id) {
        return bookRepository.findOwnerById(id);
    }

    @Transactional
    public void assign(int bookId, Person selectedPerson) {
        bookDAO.assign(bookId, selectedPerson);
    }

    @Transactional
    public void release(int id) {
        bookDAO.release(id);
    }
}
