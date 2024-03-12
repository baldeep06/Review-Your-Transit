package ca.baldeeppannu.transit;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transit")
@CrossOrigin
public class TController {
    @Autowired
    private TransitService transitService;
    @GetMapping
    public ResponseEntity<List<Transit>> getAllTransit() {
        return new ResponseEntity<List<Transit>>(transitService.getAllTransit(), HttpStatus.OK);
    }

    @GetMapping("/{busId}")
    public ResponseEntity<Optional<Transit>> getSingleTransit(@PathVariable String busId) {
        return new ResponseEntity<Optional<Transit>>(transitService.singleTransit(busId), HttpStatus.OK);
    }

}