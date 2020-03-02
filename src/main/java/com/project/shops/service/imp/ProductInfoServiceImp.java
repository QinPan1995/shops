package com.project.shops.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.shops.dao.ProductInfoMapper;
import com.project.shops.model.ProductInfo;
import com.project.shops.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImp extends ServiceImpl<ProductInfoMapper,ProductInfo> implements ProductInfoService {

    @Autowired
    ProductInfoMapper productInfoMapper;

    /*@Override
    public void insertProductInfo(ProductInfo productInfo) {
        productInfoMapper.insert(productInfo);
    }

    @Override
    public List<ProductInfo> selectAll() {
        return productInfoMapper.selectList(null);
    }*/
}
