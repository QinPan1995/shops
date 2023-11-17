package com.project.shops.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.shops.model.dao.SysUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author luke
 * @since 2023-11-09
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUserDO> {

}
