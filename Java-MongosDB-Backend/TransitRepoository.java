package ca.baldeeppannu.transit;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransitRepoository extends MongoRepository<Transit, ObjectId> {
    Optional<Transit> findTransitByBusId(String busId);
}
