package com.project.shops.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.shops.model.dao.SysMenuDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author luke
 * @since 2023-11-17
 */
@Mapper
public interface MenuMapper extends BaseMapper<SysMenuDO> {

}
