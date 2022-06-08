package cl.escalab.project.adminstock.admintstock.repositories;

import cl.escalab.project.adminstock.admintstock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
