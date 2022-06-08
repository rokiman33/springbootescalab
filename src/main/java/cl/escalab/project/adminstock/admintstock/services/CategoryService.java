package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Category;
import cl.escalab.project.adminstock.admintstock.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category saveOrUpdate(Category category) {

        return categoryRepository.save(category);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.getById(id);
    }

    public void delete(Long id) {
        Category category = findById(id);
        categoryRepository.delete(category);
    }
}
