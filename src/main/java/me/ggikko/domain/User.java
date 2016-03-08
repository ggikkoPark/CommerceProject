package me.ggikko.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Park Ji Hong, ggikko.
 */
@Entity
@Table(name = "g_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("orderDate desc")
    private Set<Order> orders = new HashSet<Order>();


    @Column(length = 30)
    private String name;

    @Column(length = 50)
    private String username;

    @Column(length = 255)
    private String password;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String mobile;

}
