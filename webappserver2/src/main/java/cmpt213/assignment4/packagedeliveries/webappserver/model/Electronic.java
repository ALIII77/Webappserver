package cmpt213.assignment4.packagedeliveries.webappserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 *
 * Electronic class is a class that extends Package class know type of package
 *
 */

@Entity
@Setter
@Getter
@ToString
public class Electronic extends Package {

    public Electronic(String name, String note, double price, double weight, LocalDateTime expectedDeliveryDate) {
        super(name, note, price, weight, expectedDeliveryDate);
    }

    public Electronic(String name, double price, double weight, LocalDateTime expectedDeliveryDate) {
        super(name, price, weight, expectedDeliveryDate);
    }

    public Electronic() {

    }

}
