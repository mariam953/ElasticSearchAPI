package com.biblio.repository.Mongo;

import com.biblio.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Book findBytitle(String title);

    Book findByIsbn(String isbn);

}