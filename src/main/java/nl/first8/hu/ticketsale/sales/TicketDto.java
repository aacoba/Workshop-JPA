package nl.first8.hu.ticketsale.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.artist.Artist;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Artist artist;

    private String genre;

    private String location;

}
