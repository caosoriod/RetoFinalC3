
package com.usa.ciclo3.retociclo3.service;


import com.usa.ciclo3.retociclo3.model.Category;
import java.util.List;
import java.util.Optional;
import static org.hibernate.criterion.Projections.id;

import com.usa.ciclo3.retociclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return categoryRepository.getAll();
               
    }
        public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
          }
    
    public Category save(Category category){
        if (category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> tmpCategory = categoryRepository.getCategory(category.getId());
            if(tmpCategory.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
            
        }
        
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
        Optional<Category> tmpCategory = categoryRepository.getCategory(category.getId());
            if(tmpCategory.isEmpty()){
                return categoryRepository.save(category);
            }
            
        }
        return null;
    }
    
    public boolean deleteCategory(int id){
        Boolean aBoolean=getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
