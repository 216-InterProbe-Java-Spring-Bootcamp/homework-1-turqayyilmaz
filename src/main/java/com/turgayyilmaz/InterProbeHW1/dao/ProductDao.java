package com.turgayyilmaz.InterProbeHW1.dao;

import com.turgayyilmaz.InterProbeHW1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findAllByExpirationDateIsNullOrExpirationDateGreaterThan(Date date);

    List<Product> findAllByExpirationDateLessThan(Date date);
}
