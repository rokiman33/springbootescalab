package cl.escalab.project.adminstock.admintstock.repositories;

import cl.escalab.project.adminstock.admintstock.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
