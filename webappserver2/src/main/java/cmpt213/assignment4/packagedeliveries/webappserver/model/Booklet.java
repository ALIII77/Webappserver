package cmpt213.assignment4.packagedeliveries.webappserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 *
 * Booklet class is a class that extends Package class know type of package
 *
 */


@Entity
@Setter
@Getter
@ToString
public class Booklet extends Package  {


    private String author;


    public Booklet(String name, String note, double price, double weight, LocalDateTime expectedDeliveryDate, String author) {
        super(name, note, price, weight, expectedDeliveryDate);
        this.author = author;
    }

    public Booklet(String name, double price, double weight, LocalDateTime expectedDeliveryDate, String author) {
        super(name, price, weight, expectedDeliveryDate);
        this.author = author;
    }

    public Booklet() {
        super();
    }
}
