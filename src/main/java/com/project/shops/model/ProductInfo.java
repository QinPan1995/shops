package com.project.shops.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinpan
 * @create 2019-12-10 17:47
 */
@Data
public class ProductInfo {
    @TableId(value = "product_id",type = IdType.UUID)//指定自增策略
    private String productId;//商品id
    private String productName;//商品名
    private BigDecimal productPrice;//价格
    private Long productStock;//库存
    private String productDescription;//描述
    private String productIcon;//图片
    private Integer productStatus;//商品状态
    private Long categoryCode;//类别code
    private Date createTime;

}
