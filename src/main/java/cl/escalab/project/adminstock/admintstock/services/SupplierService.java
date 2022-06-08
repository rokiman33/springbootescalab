package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Supplier;
import cl.escalab.project.adminstock.admintstock.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Supplier saveOrUpdate(Supplier supplier) {

        return supplierRepository.save(supplier);
    }

    public Iterable<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        return supplierRepository.getById(id);
    }

    public void delete(Long id) {
        Supplier supplier = findById(id);
        supplierRepository.delete(supplier);
    }
}
