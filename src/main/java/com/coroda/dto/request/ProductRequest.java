package com.coroda.dto.request;

import com.coroda.entity.OriginProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("Model Product")
public class ProductRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "category", required = true)
    private String category; //puerta,equipo de seguridad ,motores ,sistemas

    @ApiModelProperty(value = "subCategory", required = true)
    private String subCategory; //puerta garage, puer..  ,cercoelectrico , etc

    @ApiModelProperty(value = "model", required = true)
    private String model;

    @ApiModelProperty(value = "brand", required = true)
    private String brand; // marca

    @ApiModelProperty(value = "description", required = true)
    private String description;

    @ApiModelProperty(value = "origin", required = true)
    private OriginProduct origin;// nacional o importado

    @ApiModelProperty(value = "material", required = true)
    private String material;

    @ApiModelProperty(value = "dimensions", required = true)
    private String dimensions;

    @ApiModelProperty(value = "color", required = true)
    private String color;

    @ApiModelProperty(value = "priceUnit", required = true)
    private BigDecimal priceUnit;

    @ApiModelProperty(value = "image", required = true)
    private String image;
}
