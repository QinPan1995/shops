package com.project.shops.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.shops.model.dao.SysRoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色菜单 Mapper 接口
 * </p>
 *
 * @author luke
 * @since 2023-11-17
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<SysRoleMenuDO> {

}
