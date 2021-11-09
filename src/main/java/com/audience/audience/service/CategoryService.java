package com.audience.audience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.audience.audience.entity.Category;
import com.audience.audience.repository.CategoryRepository;
import com.audience.audience.repository.repositoryImp.ICategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;

    public List<Category>getAll(){
        return (List<Category>) iCategoryRepository.findAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if (category.getId() ==null) {
            return categoryRepository.save(category);
            
        } else {
            Optional<Category> consulta=categoryRepository.getCategory(category.getId());
            if (consulta.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;                
            }
            
        }
    }
}
