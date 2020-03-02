package com.project.shops.service;

import java.util.List;

import com.project.shops.model.CareInfo;


public interface CareInfoService {

    //根据页面传来的参数查询
    public List<CareInfo> getCareById(List<Integer> id);

    public List<CareInfo> getSelectAll();

    /*@Select("SELECT * from card t where t.id=#{id}")
    public Card getCareInfoById(String id);*/


}
