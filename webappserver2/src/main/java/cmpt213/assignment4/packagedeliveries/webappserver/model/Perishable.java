package cmpt213.assignment4.packagedeliveries.webappserver.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 *
 * Perishable class is a class that extends Package class know type of package
 *
 */

@Entity
@Setter
@Getter
@ToString
public class Perishable extends Package {


    private LocalDateTime expiryDate;

    public Perishable(String name, String note, double price, double weight, LocalDateTime expectedDeliveryDate, LocalDateTime expiryDate) {
        super(name, note, price, weight, expectedDeliveryDate);
        this.expiryDate = expiryDate;
    }

    public Perishable(String name, double price, double weight, LocalDateTime expectedDeliveryDate, LocalDateTime expiryDate) {
        super(name, price, weight, expectedDeliveryDate);
        this.expiryDate = expiryDate;
    }

    public Perishable() {

    }

}
