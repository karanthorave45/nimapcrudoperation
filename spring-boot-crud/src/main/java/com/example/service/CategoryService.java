package com.example.service;

 

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

@Service
public class CategoryService {
	
	 @Autowired
	 private CategoryRepository categoryRepository;

	 public Page<Category> getAllCategories(Pageable pageable) {
	     return categoryRepository.findAll(pageable);
	 }

	 public Category createCategory(Category category) {
	     return categoryRepository.save(category);
	 }

	 public Optional<Category> getCategoryById(Long id) {
	     return categoryRepository.findById(id);
	 }

	 public Category updateCategory(Long id, Category categoryDetails) {
	     Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
	     category.setName(categoryDetails.getName());
	     return categoryRepository.save(category);
	 }

	 public void deleteCategory(Long id) {
	     categoryRepository.deleteById(id);
	 }
}
