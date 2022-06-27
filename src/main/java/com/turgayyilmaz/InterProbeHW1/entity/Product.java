package com.turgayyilmaz.InterProbeHW1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productComments"})

public class Product  {
    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", length = 50, nullable = false)
    private int price;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;


    @OneToMany
    @JoinColumn(name="product_id", foreignKey =@ForeignKey(name = "FK_PRODUCT_ID"))
    @JsonIgnore
    private Set<ProductComment> productComments = new HashSet<>();


}