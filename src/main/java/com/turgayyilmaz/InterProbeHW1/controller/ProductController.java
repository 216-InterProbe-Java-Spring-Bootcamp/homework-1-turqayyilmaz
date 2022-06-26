package com.turgayyilmaz.InterProbeHW1.controller;

import com.turgayyilmaz.InterProbeHW1.dao.ProductDao;
import com.turgayyilmaz.InterProbeHW1.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductDao productDao;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productDao.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return productDao.findAll();
    }

    @GetMapping("/expirationdateisnullorgraterthan")
    public List<Product> findAllByExpirationDateIsNullOrExpirationDateGreaterThan(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return productDao.findAllByExpirationDateIsNullOrExpirationDateGreaterThan(date);
    }

    @GetMapping("/expirationdateisnotvalid")
    public List<Product> findAllByExpirationDateLessThan(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  Date date){
        return productDao.findAllByExpirationDateLessThan(date);
    }



}
