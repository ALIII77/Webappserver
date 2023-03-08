package cmpt213.assignment4.packagedeliveries.webappserver.control.service;

import cmpt213.assignment4.packagedeliveries.webappserver.model.Package;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 *
 * Service layer interface that contain methods that without body and implementation method impl class (PackageServiceImplementation)
 *
 */

@Service
public interface PackageService {


    /**
     * @param p : p is instance of Package class
     * for save instance of package to database
     */
    void save(Package p);


    /**
     *
     * @param id : use for removing a instance of package that can be Booklet, Electronic or Perishable  from database
     * @return after deleting an record from database return all packages as the question asked
     */
    List<Package> delete(Long id);


    /**
     *
     * @return : return all packages that stored in database
     *
     */

    List<Package> findAll();

    /**
     * @return : return all delivered packages that stored in database
     */
    List<Package>findAllDelivered();

    /**
     * @param p : p is a instance of package for finding package in database for change of delivery status
     * @return after changing delivery status, return all updated package
     */
    List<Package>changeDeliveredStatus(Package p);

    /**
     * @return return all overdue packages
     * return all undelivered packages with expected delivery date
     * before the current date (and time), ordered by their expected
     * delivery dates (oldest first).
     */
    List<Package>overduePackage();

    /**
     * @return : return all upcoming packages
     * Return all undelivered packages with expected delivery dates on or
     * after the current date (and time), ordered by their expected
     * delivery dates (oldest first)
     */
    List<Package>listUpcomingPackage();





}
