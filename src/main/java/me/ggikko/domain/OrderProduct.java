package me.ggikko.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Park Ji Hong, ggikko.
 */

@Entity
@Table(name = "g_order_product")
@Getter
@Setter
@NoArgsConstructor
public class OrderProduct {

    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    @MapsId("orderId")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column(name = "order_count")
    private Integer orderCount;

    public OrderProduct(Order order, Product product) {
        this.id.orderId = order.getId();
        this.id.productId = product.getId();
        this.order = order;
        this.product = product;
    }

    @Embeddable
    @Data
    @EqualsAndHashCode(callSuper = false, of = { "orderId", "productId" })
    public static class Id implements Serializable {

        private static final long serialVersionUID = 226636815858337409L;

        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "product_id")
        private Long productId;

    }

}
