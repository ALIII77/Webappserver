package cmpt213.assignment4.packagedeliveries.webappserver.controller;


import cmpt213.assignment4.packagedeliveries.webappserver.control.service.PackageService;
import cmpt213.assignment4.packagedeliveries.webappserver.controller.dto.BookletDto;
import cmpt213.assignment4.packagedeliveries.webappserver.controller.dto.ElectronicDto;
import cmpt213.assignment4.packagedeliveries.webappserver.controller.dto.PackageDto;
import cmpt213.assignment4.packagedeliveries.webappserver.controller.dto.PerishableDto;
import cmpt213.assignment4.packagedeliveries.webappserver.model.Booklet;
import cmpt213.assignment4.packagedeliveries.webappserver.model.Electronic;
import cmpt213.assignment4.packagedeliveries.webappserver.model.Package;
import cmpt213.assignment4.packagedeliveries.webappserver.model.Perishable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 *
 * PackageController class is a class in controller layer for implementation REST API of program to response of client request
 *
 */

@RestController
@RequestMapping("/program")
@RequiredArgsConstructor
public class PackageController {

    private final PackageService packageService;
    ModelMapper modelMapper = new ModelMapper() ;



    /**
     * @return
     * As the question asked .../ping return a string contain " System is up! "
     */
    @GetMapping("ping")
    public String systemUp(){
        return " System is up ! ";
    }



    /**
     *
     *  then conversion to BookletDto object with @RequestBody
     *  then save Booklet object to database with packageService save method
     * @param bookletDto : we received a Json Object
     */
    @PostMapping("add-booklet")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBooklet(@RequestBody @Valid BookletDto bookletDto){
        Booklet booklet = modelMapper.map(bookletDto,Booklet.class);
        packageService.save(booklet);
    }



    /**
     * @param electronicDto : we received a Json Object
     *                   then conversion to electronicDto object with @RequestBody
     *                   then map to electronicDto to Electronic object with ModelMapper class
     *                   then save Electronic object to database with packageService save method
     *
     */

    @PostMapping("add-electronic")
    @ResponseStatus(HttpStatus.CREATED)
    public void addElectronic(@RequestBody @Valid ElectronicDto electronicDto){
        Electronic electronic =modelMapper.map(electronicDto,Electronic.class);
        packageService.save(electronic);
    }



    /**
     * @param perishableDto : we received a Json Object
     *                   then conversion to perishableDto object with @RequestBody
     *                   then map to perishableDto to Perishable object with ModelMapper class
     *                   then save Perishable object to database with packageService save method
     *
     */
    @PostMapping("add-perishable")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBooklet(@RequestBody @Valid PerishableDto perishableDto){
        Perishable perishable =modelMapper.map(perishableDto,Perishable.class);
        packageService.save(perishable);
    }



    /**
     * @return : return all packages that stored in database
     */
    @GetMapping("list-all")
    public List<Package> listAll(){
        return packageService.findAll();
    }




    /**
     * @return : return all undelivered packages with expected delivery date
     * before the current date (and time), ordered by their expected
     * delivery dates (oldest first).
     *
     */
    @GetMapping("list-overdue-package")
    public List<Package>listOverduePackage(){
        return packageService.overduePackage();
    }


    /**
     * @return : return all undelivered packages with expected delivery dates on or
     * after the current date (and time), ordered by their expected
     * delivery dates (oldest first)
     */
    @GetMapping("list-upcoming-package")
    public List<Package>listUpcomingPackage(){
        return packageService.listUpcomingPackage();
    }


    /**
     * @param packageId : get id as path variable way to find package and change delivery status
     * @return after change delivery status, then return all updated package
     */
    @PutMapping("change-delivered-status/{packageId}")
    public List<Package>changeDeliveredStatus(@PathVariable Long packageId){
        Package p = new Package();
        p.setId(packageId);
        return packageService.changeDeliveredStatus(p);
    }


    /**
     * @param packageId : get id as path variable way to delete package from database
     * @return after deleting excepted package, then return all updated package
     */
    @DeleteMapping("delete-package/{packageId}")
    public List<Package>delete(@PathVariable Long packageId){
        return packageService.delete(packageId);
    }



    /**
     * @return return all delivered package
     */
    @GetMapping("all-delivered")
    public List<Package>allDeliveredPackage(){
        return packageService.findAllDelivered();
    }


}
