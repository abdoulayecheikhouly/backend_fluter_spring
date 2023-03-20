package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepository extends JpaRepository<ProductColor,Long> {
}
