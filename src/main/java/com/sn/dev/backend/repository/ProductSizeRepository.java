package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductSizeRepository extends JpaRepository<ProductSize,Long> {
}
