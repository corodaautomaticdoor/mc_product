package com.coroda.dto.response;

import com.coroda.entity.OriginProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailProductResponse {

    private Long id;
    private Long detailId;
    private String material;
    private String dimensions;
    private String color;
    private BigDecimal priceUnit;

}
