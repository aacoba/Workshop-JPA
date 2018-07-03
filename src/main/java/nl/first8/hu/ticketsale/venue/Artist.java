package nl.first8.hu.ticketsale.venue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre_name")
    private Genre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "artist")
    private List<Concert> concerts;



}
