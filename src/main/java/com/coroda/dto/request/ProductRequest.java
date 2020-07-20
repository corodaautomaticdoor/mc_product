package com.coroda.dto.request;

import com.coroda.entity.DetailProduct;
import com.coroda.entity.OriginProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@ApiModel("Model Product")
public class ProductRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "model", required = true)
    private String model;

    @ApiModelProperty(value = "brand", required = true)
    private String brand; // marca

    @ApiModelProperty(value = "category", required = true)
    private String category; //puerta o motores

    @ApiModelProperty(value = "description", required = true)
    private String description;

    @ApiModelProperty(value = "origin", required = true)
    private OriginProduct origin;// nacional o importado

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
       private List<DetailProductRequest> detail;
}
