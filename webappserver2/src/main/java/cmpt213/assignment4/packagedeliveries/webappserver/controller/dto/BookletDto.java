package cmpt213.assignment4.packagedeliveries.webappserver.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 *
 * Booklet class is a DTO class that use for store an object of the class Booklet class with desired fields
 *
 */

@Setter
@Getter
public class BookletDto extends PackageDto {

    private String author;



}
