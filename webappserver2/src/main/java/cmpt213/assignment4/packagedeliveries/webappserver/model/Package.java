package cmpt213.assignment4.packagedeliveries.webappserver.model;

import cmpt213.assignment4.packagedeliveries.webappserver.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

/**
 *
 *  Package class is a superclass that has with fields that specify a package that can be booklet or perishable or electronic
 *  Classes that extend this class » Booklet and Electronic and Perishable
 *
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Setter
@Getter
@ToString
public class Package extends BaseEntity<Long> {

    private String name;

    private String note;

    private Double price;

    private Double weight;

    private LocalDateTime expectedDeliveryDate;

    private boolean delivered;


    public Package(String name, String note, double price, double weight, LocalDateTime expectedDeliveryDate) {
        this.name = name;
        this.note = note;
        this.price = price;
        this.weight = weight;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Package(String name, double price, double weight, LocalDateTime expectedDeliveryDate) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Package() {

    }

    @PrePersist
    public void prePersist(){
        setDelivered(false);
    }


}
