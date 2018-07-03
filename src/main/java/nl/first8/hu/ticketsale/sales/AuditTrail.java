package nl.first8.hu.ticketsale.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditTrail {
    @Id
    @GeneratedValue
    private Long id;

    private Long sale_id;

    private Long account_id;
}
