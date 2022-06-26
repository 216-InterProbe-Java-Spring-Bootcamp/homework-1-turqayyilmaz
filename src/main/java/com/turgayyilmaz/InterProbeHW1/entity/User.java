package com.turgayyilmaz.InterProbeHW1.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "\"USER\"")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productCommentList"})

public class User{

    @Id
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;


    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Email
    @Column(name = "EMAIL", length = 50)
    private String email;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="user_id",foreignKey = @ForeignKey(name="FK_USER_ID"))
    private Set<ProductComment> productCommentList = new HashSet<>();


}
