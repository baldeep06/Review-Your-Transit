package ca.baldeeppannu.transit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String busId) {
        Reviews review = repository.insert(new Reviews(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Transit.class)
                .matching(Criteria.where("imdbId").is(busId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }
}
