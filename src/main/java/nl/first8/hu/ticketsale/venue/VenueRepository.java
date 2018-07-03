package nl.first8.hu.ticketsale.venue;

import nl.first8.hu.ticketsale.util.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VenueRepository {

    private final EntityManager entityManager;

    @Autowired
    public VenueRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Concert> findConcertById(Long concertId) {
        return Optional.ofNullable(entityManager.find(Concert.class, concertId));
    }

    public List<Concert> searchConcert(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Concert> query = builder.createQuery(Concert.class);
        Root r = query.from(Concert.class);

        Predicate predicate = builder.conjunction();


        for (SearchCriteria param : params) {
            if (!isValidCriteriaKey(param.getKey())) {
                //ERROR
            }
            else if (param.getKey().equalsIgnoreCase("min_date")) {
                // Concert heeft geen datum 🙈

            }
            else if (param.getKey().equalsIgnoreCase("artist")) {
                predicate = builder.and(predicate,
                        builder.like(r.join("artist").get("name"), param.getValue()));
            }
            else if (param.getKey().equalsIgnoreCase("genre")) {
                predicate = builder.and(predicate,
                        builder.like(r.get("genre"), param.getValue()));
            }
            else if (param.getKey().equalsIgnoreCase("location")) {
                predicate = builder.and(predicate,
                        builder.like(r.join("location").get("name"), param.getValue()));
            }
        }

        query.where(predicate);
        List<Concert> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    public boolean isValidCriteriaKey(String key) {
        List<String> allowedCriteria = Arrays.asList("artist", "genre", "date", "location");
        List<String> matches = allowedCriteria.stream().filter(it -> it.equalsIgnoreCase(key)).collect(Collectors.toList());
        return matches.size() > 0;
    }
}
