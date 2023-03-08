package cmpt213.assignment4.packagedeliveries.webappserver.controller.dto;


import cmpt213.assignment4.packagedeliveries.webappserver.model.Package;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

/**
 *
 * PackageDto class is a super class
 *
 * All constraints of fields are in this class
 *
 * Classes that extend this class » BookletDto and ElectronicDto and PerishableDto
 *
 * This class created for store a package without  id
 */
@Setter
@Getter

public class PackageDto {

    @Column(nullable = false)
    @NotEmpty(message = "can not be inset space in name")
    @NotNull
    private String name;

    private String note;

    @Column(nullable = false)
    @NotNull
    @Positive
    private Double price;

    @Column(nullable = false)
    @Positive
    @NotNull
    private Double weight;

    @NotNull
    private LocalDateTime expectedDeliveryDate;

}
