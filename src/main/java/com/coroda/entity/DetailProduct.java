package com.coroda.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "detail_product")
public class DetailProduct {

    @Column(name = "id")
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "detailId")
    @Column(name = "detailId")
    private Long detailId;

    @Column(name = "material")
    private String material;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "color")
    private String color;

    @Column(name = "priceUnit")
    private BigDecimal priceUnit;
}
