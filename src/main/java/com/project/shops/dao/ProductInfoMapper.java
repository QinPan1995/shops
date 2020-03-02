package com.project.shops.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.shops.model.CareInfo;
import com.project.shops.model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {


}
