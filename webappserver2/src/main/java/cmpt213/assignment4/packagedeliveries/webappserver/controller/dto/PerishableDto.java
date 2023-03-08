package cmpt213.assignment4.packagedeliveries.webappserver.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 *
 * Perishable class is a DTO class that use for store an object of the class Perishable class with desired fields
 *
 */


@Setter
@Getter
public class PerishableDto extends PackageDto {

    private LocalDateTime expiryDate;

}
