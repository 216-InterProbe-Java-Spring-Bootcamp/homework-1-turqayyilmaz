package com.turgayyilmaz.InterProbeHW1.controller;

import com.turgayyilmaz.InterProbeHW1.dao.ProductCommentDao;
import com.turgayyilmaz.InterProbeHW1.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productcomments")
public class ProductCommentController {
    private final ProductCommentDao productCommentDao;

    @PostMapping
    public ProductComment save(ProductComment productComment){
        return productCommentDao.save(productComment);
    }

    @GetMapping
    public List<ProductComment> findAll(){
        return productCommentDao.findAll();
    }

    @GetMapping("/productId/{productId}")
    public List<ProductComment> findAllByProduct_Id(@PathVariable Long id){
        return productCommentDao.findAllByProduct_Id(id);
    }


    @GetMapping("findProductCommentsByCommentDateBetweenAndProduct_Id")
    public List<ProductComment> findProductCommentsByCommentDateBetweenAndProduct_Id(
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date end,
            @RequestParam Long id){

        return productCommentDao.findProductCommentsByCommentDateBetweenAndProduct_Id(start,end,id);
    }
    @GetMapping("findAllByUser_Id")
    public List<ProductComment> findAllByUser_Id(@RequestParam  Long id){
        return productCommentDao.findAllByUser_Id(id);
    }

    @GetMapping("findAllByUser_IdAndCommentDateBetween")
    public List<ProductComment> findAllByUser_IdAndCommentDateBetween(@RequestParam Long id,
                                                                      @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date start,
                                                                      @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date end){
        return productCommentDao.findAllByUser_IdAndCommentDateBetween(id,start,end);
    }


}
