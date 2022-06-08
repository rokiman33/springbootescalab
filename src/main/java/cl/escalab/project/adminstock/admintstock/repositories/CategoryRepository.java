package cl.escalab.project.adminstock.admintstock.repositories;

import cl.escalab.project.adminstock.admintstock.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
