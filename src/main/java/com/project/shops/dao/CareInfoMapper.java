package com.project.shops.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.shops.model.CareInfo;
import com.project.shops.model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CareInfoMapper {

    //根据页面传来的参数查询
    public List<CareInfo> getCareById(List<Integer> id);

    public List<CareInfo> getSelectAll();

    /*@Select("SELECT * from card t where t.id=#{id}")
    public Card getCareInfoById(String id);*/


}
