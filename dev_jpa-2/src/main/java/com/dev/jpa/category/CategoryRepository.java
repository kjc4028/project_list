package com.dev.jpa.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	public List<CategoryEntity> findByUseYn(String useYn);
}
