package com.turgayyilmaz.InterProbeHW1.entity;


import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PRODUCT_COMMENT")
@Getter
@Setter
public class ProductComment{
    @Id
    @GeneratedValue(generator = "ProductComment")
    @SequenceGenerator(name = "ProductComment", sequenceName = "PRODUCT_COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name = "COMMENT_DATE",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="product_id", foreignKey = @ForeignKey(name="FK_PRODUCT_ID"))
    private Product product ;

    @ManyToOne
    @JoinColumn(name="user_id",foreignKey = @ForeignKey(name="FK_USER_ID"))
    @JsonIgnore
    private User user ;
}