package com.turgayyilmaz.InterProbeHW1.dao;


import com.turgayyilmaz.InterProbeHW1.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentDao extends JpaRepository<ProductComment,Long> {
    List<ProductComment> findAllByProduct_Id(Long id);

    List<ProductComment> findAllByProduct_IdAndCommentDateBetween(Long id, Date start, Date end);

    List<ProductComment> findAllByUser_Id(Long id);

    List<ProductComment> findAllByUser_IdAndCommentDateBetween(Long id, Date start, Date end);
}
