package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.Sale;
import com.sn.dev.backend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository  extends JpaRepository<Sale,Long> {
}
