package com.coroda.dto.request;

import com.coroda.entity.OriginProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
@ApiModel("Model DetailOperation")
public class DetailProductRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "detailId")
    private Long detailId;

    @ApiModelProperty(value = "material", required = true)
    private String material;

    @ApiModelProperty(value = "dimensions", required = true)
    private String dimensions;

    @ApiModelProperty(value = "color", required = true)
    private String color;

    @ApiModelProperty(value = "priceUnit", required = true)
    private BigDecimal priceUnit;
}
