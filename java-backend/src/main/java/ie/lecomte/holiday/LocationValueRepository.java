package ie.lecomte.holiday;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationValueRepository extends MongoRepository<LocationValue, ObjectId> {
}
