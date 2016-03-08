package me.ggikko.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Park Ji Hong, ggikko.
 */

@Entity
@Table(name = "g_product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(name = "image_file_name", length = 100)
    private String imageFileName;

    @Column(length = 10)
    private String color;

    @Lob
    private String description;


}
