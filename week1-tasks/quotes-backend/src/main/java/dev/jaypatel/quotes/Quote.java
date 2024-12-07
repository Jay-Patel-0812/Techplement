package dev.jaypatel.quotes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "quotes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {

//    @Id
    @Field("_id")
    private ObjectId id;

    @Field("Author")
    private String author; // Corresponds to "Author"

    @Field("Tags")
    private List<String> tags; // Corresponds to "Tags"

    @Field("Popularity")
    private double popularity; // Corresponds to "Popularity"

    @Field("Category")
    private String category; // Corresponds to "Category"

    @Field("Text")
    private String text;
}
