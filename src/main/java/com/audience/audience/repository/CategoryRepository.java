package com.audience.audience.repository;

import com.audience.audience.repository.repositoryImp.ICategoryRepository;
import java.util.List;
import java.util.Optional;

import com.audience.audience.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {

     @Autowired
     ICategoryRepository  iCategoryRepository;

    public List<Category> getAll(){
        return (List<Category>)iCategoryRepository.findAll();
    }

    public Optional<Category>getCategory(int id){
        return iCategoryRepository.findById(id);
    }

    public Category save(Category category){
        return iCategoryRepository.save(category);
    }
    
}
