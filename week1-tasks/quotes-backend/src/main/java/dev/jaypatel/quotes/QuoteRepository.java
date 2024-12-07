package dev.jaypatel.quotes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuoteRepository extends MongoRepository<Quote, ObjectId> {
//        List<Quote> findByAuthorIgnoreCase(String author);
    @Query("{ 'author': { $regex: ?0, $options: 'i' } }")
    List<Quote> findByAuthorContainingIgnoreCase(String searchString);
}

