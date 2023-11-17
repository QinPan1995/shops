package com.project.shops.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.shops.model.dao.SysMenuDO;
import com.project.shops.model.vo.SysMenuVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author luke
 * @since 2023-11-17
 */
public interface IMenuService extends IService<SysMenuDO> {

    //查询用户可以操作菜单
    List<SysMenuVo> findMenusByUserId();
}
