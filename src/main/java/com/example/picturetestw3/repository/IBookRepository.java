package com.example.picturetestw3.repository;

import com.example.picturetestw3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
    @Query(value = "select b from Book b where b.author like :author")
    List<Book> findByAuthor(@Param("author") String author);

    @Query(value = "select b from Book b where b.name like :name")
    List<Book> findByName(@Param("name") String name);

    @Query("SELECT SUM(b.price) FROM Book b")
    Double showTotalPrice();

    @Query("SELECT b FROM Book b WHERE b.price BETWEEN :minPrice AND :maxPrice")
    List<Book> findBookByPrice(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
}
