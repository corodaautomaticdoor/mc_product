package com.coroda.dto.response;

import com.coroda.entity.OriginProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long id;
    private String model;
    private String brand;
    private String category;
    private String description;
    private OriginProduct origin;

    private List<DetailProductResponse> detail;

}
