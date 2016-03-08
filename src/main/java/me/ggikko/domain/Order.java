package me.ggikko.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Park Ji Hong, ggikko.
 */

@Entity
@Table(name = "g_order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 12)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "pay_method", length = 12)
    private PayMethod payMethod;

    @Column(name = "order_price")
    private Double orderPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected User user;

    @Column(name = "recipient_name", length = 30)
    private String recipientName;

    @Column(name = "delivery_address", length = 255)
    private String deliveryAddress;

    @Column(name = "recipient_tel", length = 15)
    private String recipientTel;


}
