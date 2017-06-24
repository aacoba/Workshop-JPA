package nl.first8.hu.ticketsale.artist;


import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.venue.Concert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Artist implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private Genre genre;

    @JoinTable()
    private List<Concert> concerts;

}



