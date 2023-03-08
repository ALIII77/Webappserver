package cmpt213.assignment4.packagedeliveries.webappserver.control.repository;

import cmpt213.assignment4.packagedeliveries.webappserver.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 * Package Repository Interface contains methods that connectivity with database
 *
 */

@Repository
public interface PackageRepository extends JpaRepository<Package,Long> {

    @Query("select p from Package as p where p.delivered=true")
    List<Package>findAllDelivered();

}
