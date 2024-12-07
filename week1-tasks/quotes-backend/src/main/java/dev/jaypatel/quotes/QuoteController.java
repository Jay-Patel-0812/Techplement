package dev.jaypatel.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;


//    public ResponseEntity<List<Quote>> getQuoteOfTheDay(){
//        return new ResponseEntity<List<Quote>>(quoteService.quoteOfTheDay(), HttpStatus.OK);
//    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Quote>> getQuotesByAuthor(@PathVariable String author) {
        List<Quote> quotes = quoteService.getQuotesByAuthor(author);
        return ResponseEntity.ok(quotes);
    }

    @GetMapping("/")
    public ResponseEntity<Quote> getQuoteOfTheDay(){
        return new ResponseEntity<Quote>(quoteService.quoteOfTheDay(), HttpStatus.OK);
    }

//    @GetMapping("/")

}
