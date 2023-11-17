package com.project.shops.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.shops.mapper.UserRoleMapper;
import com.project.shops.model.dao.UserRoleDO;
import com.project.shops.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author luke
 * @since 2023-11-09
 */
@Service
public class IUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleDO> implements IUserRoleService {

}
