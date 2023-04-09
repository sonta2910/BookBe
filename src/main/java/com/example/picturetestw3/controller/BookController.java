package com.example.picturetestw3.controller;

import com.example.picturetestw3.model.Book;
import com.example.picturetestw3.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @GetMapping
    public ResponseEntity<List<Book>>findAll(){
        List<Book>books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Book book){
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book>findById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByAuthor(@RequestParam("author") String author) {
        List<Book> books = bookService.findByAuthor(author);
        if (books.isEmpty()) {
            books = bookService.findAll();
            return new ResponseEntity<>(books,HttpStatus.OK);
        }
       return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Book>> searchByName(@RequestParam("name") String name) {
        List<Book> books1 = bookService.findByName(name);
        if (books1.isEmpty()) {
            books1 = bookService.findAll();
            return new ResponseEntity<>(books1,HttpStatus.OK);
        }
        return new ResponseEntity<>(books1,HttpStatus.OK);
    }

    @GetMapping("/showSumPrice")
    public ResponseEntity<Double>showSumPrice(){
         Double price =  bookService.showTotalPrice();
        return new ResponseEntity<>(price,HttpStatus.OK);
    }

    @GetMapping("/searchByPrice")
    public ResponseEntity<List<Book>>searchByPrice(@RequestParam("minPrice") Double minPrice,@RequestParam("maxPrice") Double maxPrice){
        List<Book> books = bookService.findBookByPrice(minPrice,maxPrice);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}
