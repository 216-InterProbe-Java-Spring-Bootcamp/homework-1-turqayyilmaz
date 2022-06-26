package com.turgayyilmaz.InterProbeHW1.entity;


import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product  {
    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "Price", length = 50, nullable = false)
    private int price;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;


    @OneToMany
    @JoinColumn(name="product_id", foreignKey =@ForeignKey(name = "FK_PRODUCT_ID"))
    @JsonIgnore
    private Set<ProductComment> productComments = new HashSet<>();


}