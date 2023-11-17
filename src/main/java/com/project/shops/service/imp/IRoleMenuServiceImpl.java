package com.project.shops.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.shops.mapper.RoleMenuMapper;
import com.project.shops.model.dao.SysRoleMenuDO;
import com.project.shops.service.IRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author luke
 * @since 2023-11-17
 */
@Service
public class IRoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, SysRoleMenuDO> implements IRoleMenuService {

}
