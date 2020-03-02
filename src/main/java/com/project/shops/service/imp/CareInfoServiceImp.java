package com.project.shops.service.imp;

import java.util.List;


import com.project.shops.dao.CareInfoMapper;
import com.project.shops.model.CareInfo;
import com.project.shops.model.ProductInfo;
import com.project.shops.service.CareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CareInfoServiceImp implements CareInfoService {

    @Autowired
    CareInfoMapper careInfoMapper;

    public List<CareInfo> getCareById(List<Integer> id) {
        List<CareInfo> list = careInfoMapper.getCareById(id);
        return list;
    }

    public List<CareInfo> getSelectAll() {
        List<CareInfo> list = careInfoMapper.getSelectAll();
        return list;
    }


    //@Cacheable(cacheNames="card")
    /*public Card getCareInfoById(String id) {
        System.out.println("查询sql");
        return careInfoService.getCareInfoById(id);
    }*/

}
