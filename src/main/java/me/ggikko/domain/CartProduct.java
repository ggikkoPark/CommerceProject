package me.ggikko.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Park Ji Hong, ggikko.
 */


@Entity
@Table(name = "g_cart_product")
@Getter
@Setter
@NoArgsConstructor
public class CartProduct {

    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    @MapsId("cartId")
    private Cart cart;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column(name = "buy_count")
    private Integer buyCount;

    public CartProduct(Cart cart, Product product) {
        this.id.cartId = cart.getId();
        this.id.productId = product.getId();
        this.cart = cart;
        this.product = product;
    }

    @Embeddable
    @Data
    @EqualsAndHashCode(callSuper = false, of = { "cartId", "productId" })
    public static class Id implements Serializable {

        private static final long serialVersionUID = 340765999204142798L;

        @Column(name = "cart_id")
        private Long cartId;

        @Column(name = "product_id")
        private Long productId;

    }
}
