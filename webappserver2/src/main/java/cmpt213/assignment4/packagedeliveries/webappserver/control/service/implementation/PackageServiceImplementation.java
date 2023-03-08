package cmpt213.assignment4.packagedeliveries.webappserver.control.service.implementation;

import cmpt213.assignment4.packagedeliveries.webappserver.control.exception.NotFoundException;
import cmpt213.assignment4.packagedeliveries.webappserver.control.repository.PackageRepository;
import cmpt213.assignment4.packagedeliveries.webappserver.control.service.PackageService;
import cmpt213.assignment4.packagedeliveries.webappserver.model.Package;
import jakarta.validation.Valid;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * PackageServiceImplementation class that implementation {@link PackageService}  interface method
 *
 * service layer use repository layer
 */


@Service
public class PackageServiceImplementation implements PackageService {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageServiceImplementation(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Transactional
    @Override
    public void save(Package p) {
        packageRepository.save(p);
    }

    @Transactional
    @Override
    public List<Package> delete(Long id) {
        Package findPackage = packageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not exists package with id= " + id));
        packageRepository.delete(findPackage);
        return findAll();
    }

    @Override
    public List<Package> findAll() {
        return packageRepository.findAll();
    }

    @Override
    public List<Package> findAllDelivered() {
        return packageRepository.findAllDelivered();
    }

    @Override
    public List<Package> changeDeliveredStatus(Package p) {
        Package findPackage = packageRepository.findById(p.getId())
                .orElseThrow(() -> new NotFoundException("Not exists package with id = " + p.getId()));
        findPackage.setDelivered(true);
        packageRepository.save(findPackage);
        return findAll();
    }

    @Override
    public List<Package> overduePackage() {
        List<Package>currentPackage;
        List<Package> findAllPackage = packageRepository.findAll();
        currentPackage=findAllPackage.stream()
                .filter((p)-> !p.isDelivered())
                .filter((p)->p.getExpectedDeliveryDate().isBefore(LocalDateTime.now()))
                .sorted(Comparator.comparing(p->p.getExpectedDeliveryDate()))
                .toList();
        return currentPackage;
    }

    @Override
    public List<Package> listUpcomingPackage() {
        List<Package>currentPackage;
        List<Package> findAllPackage = packageRepository.findAll();
        currentPackage=findAllPackage.stream()
                .filter((p)-> !p.isDelivered())
                .filter((p)->p.getExpectedDeliveryDate().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(p->p.getExpectedDeliveryDate()))
                .collect(Collectors.toList());
        return currentPackage;
    }


}
