package com.example.picturetestw3.service.impl;

import com.example.picturetestw3.model.Book;
import com.example.picturetestw3.repository.IBookRepository;
import com.example.picturetestw3.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        iBookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return iBookRepository.findByAuthor("%"+author+"%");
    }

    @Override
    public List<Book> findByName(String name) {
        return iBookRepository.findByName("%"+name+"%");
    }

    @Override
    public Double showTotalPrice() {
        return iBookRepository.showTotalPrice();
    }

    @Override
    public List<Book> findBookByPrice(Double minPrice, Double maxPrice) {
        return iBookRepository.findBookByPrice(minPrice,maxPrice);
    }

}
