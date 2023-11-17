package com.project.shops.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.shops.model.dao.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author luke
 * @since 2023-11-09
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {

}
