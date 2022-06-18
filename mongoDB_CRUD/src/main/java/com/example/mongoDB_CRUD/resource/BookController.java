package com.example.mongoDB_CRUD.resource;

import com.example.mongoDB_CRUD.model.Book;
import com.example.mongoDB_CRUD.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add-book")
    public String saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "Added book with id : " + book.getId();
    }

    @GetMapping("/find-all-book")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return "Book Deleted By Id : " + id;
    }

}
