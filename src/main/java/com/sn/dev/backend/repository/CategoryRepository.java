package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {
}
