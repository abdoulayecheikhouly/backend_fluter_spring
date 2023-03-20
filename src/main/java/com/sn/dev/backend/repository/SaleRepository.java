package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository  extends JpaRepository<Sale,Long> {
}
