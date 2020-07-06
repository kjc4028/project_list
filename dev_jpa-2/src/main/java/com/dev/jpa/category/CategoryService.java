package com.dev.jpa.category;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void save(CategoryEntity categoryEntity) {
		categoryRepository.save(categoryEntity);
	}
	
	public List<CategoryEntity> findAll(){
		return categoryRepository.findAll();
	}
}
