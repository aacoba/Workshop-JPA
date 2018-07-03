package nl.first8.hu.ticketsale.venue;


import nl.first8.hu.ticketsale.util.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/concert")
public class ConcertResource {

    final VenueRepository repository;

    @Autowired
    public ConcertResource(VenueRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Concert>> search(@RequestParam(value = "q", required = true) final String rawQuery) {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (rawQuery != null) {
            Pattern pattern = Pattern.compile("(\\w+?):([\\w\\s]+?),");
            Matcher matcher = pattern.matcher(rawQuery + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2)));
            }
        }
        List<Concert> results = repository.searchConcert(params);
        return ResponseEntity.ok(results);
    }
}
