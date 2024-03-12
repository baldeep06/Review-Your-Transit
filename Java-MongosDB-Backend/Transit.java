package ca.baldeeppannu.transit;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "transit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transit {
    @Id
    private ObjectId id;
    private String busId;
    private String title;
    private String frequency;
    private String trailerLink;
    private List<String> facts;
    private String poster;
    private List<String> backdrops;
    @DocumentReference
    private List<Reviews> reviewIds;

}
