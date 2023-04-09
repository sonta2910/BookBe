package com.example.picturetestw3.service;

import com.example.picturetestw3.model.Book;
import com.example.picturetestw3.service.core.ICoreService;

import java.util.List;

public interface IBookService extends ICoreService<Book> {
    List<Book> findByAuthor(String author);
    List<Book> findByName(String name);
    Double showTotalPrice();
    List<Book> findBookByPrice(Double minPrice,Double maxPrice);
}
