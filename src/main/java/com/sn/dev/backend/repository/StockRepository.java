package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    List<Stock> findByArticle_id(Long id);
}
