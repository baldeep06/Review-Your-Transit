package ca.baldeeppannu.transit;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransitService {
    @Autowired
    private TransitRepoository transitRepository;
    public List<Transit> getAllTransit() {
        return transitRepository.findAll();
    }

    public Optional<Transit> singleTransit(String busId) {
        return transitRepository.findTransitByBusId(busId);
    }
}
