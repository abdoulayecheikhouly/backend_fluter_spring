package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Long> {

    List<Stock> findByArticle_id(Long id);
}
