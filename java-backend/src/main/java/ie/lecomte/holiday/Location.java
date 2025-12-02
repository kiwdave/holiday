package ie.lecomte.holiday;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Location")
@Getter
public class Location {
    @Id
    private String id;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    @DocumentReference
    @JsonIgnore
    private Country country;

    private Double latitude;

    private Double longitude;

    private String image;

    @DocumentReference
    private List<LocationValue> values;
}
