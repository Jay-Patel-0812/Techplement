package dev.jaypatel.quotes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.Aggregation;
//import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.math.BigInteger;
import org.springframework.data.mongodb.core.query.Query;





import java.util.List;
//import java.util.Optional;
//import java.util.Random;


@Service
public class QuoteService {
//    @Autowired
//    private QuoteRepository quoteRepository;
//
//    public Quote quoteOfTheDay(){
//        return
//    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private QuoteRepository quoteRepository;

//    public List<Quote> quoteOfTheDay(){
//        return quoteRepository.findAll();
//    }

//    public Quote quoteOfTheDay() {
//        List<Quote> quotes = quoteRepository.findAll();
//        if (quotes.isEmpty()) {
//            return null; // Handle the case where there are no quotes
//        }
//        Random random = new Random();
//        int randomIndex = random.nextInt(quotes.size());
//        return quotes.get(randomIndex);
//    }

//    public List<Quote> getQuotesByAuthor(String author) {
//        return quoteRepository.findByAuthorIgnoreCase(author);
//    }
    public List<Quote> getQuotesByAuthor(String author) {
        // Call the repository method with the search string
        return quoteRepository.findByAuthorContainingIgnoreCase(author);
    }

    public Quote quoteOfTheDay() {
        // Get today's date as a string
        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

        // Generate a hash based on the date
        int hash = generateHash(today);

        // Use the hash to pick a quote deterministically
        int index = Math.abs(hash) % 1000; // Assuming there are 1000 quotes

        // Fetch the quote from the database based on the index
        Query query = new Query().skip(index).limit(1);
        List<Quote> quotes = mongoTemplate.find(query, Quote.class, "quotes");

        return quotes.isEmpty() ? null : quotes.get(0);
    }

    private int generateHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return new BigInteger(1, digest).intValue();
        } catch (Exception e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }

}
