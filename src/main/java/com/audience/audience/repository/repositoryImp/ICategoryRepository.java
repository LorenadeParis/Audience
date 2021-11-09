package com.audience.audience.repository.repositoryImp;
import com.audience.audience.entity.Category;

import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category,Integer> {
    
}
