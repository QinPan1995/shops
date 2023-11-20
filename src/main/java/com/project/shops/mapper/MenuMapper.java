package com.project.shops.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.shops.model.dao.SysMenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    //1 查询所有菜单，返回list集合
    List<SysMenuDO> findAll();

    //添加
    void save(SysMenuDO sysMenu);

    //菜单修改
    void update(SysMenuDO sysMenu);

    //根据当前菜单id，查询是否包含子菜单
    int selectCountById(Long id);

    //删除
    void delete(Long id);

    //根据userId查询可以操作菜单
    List<SysMenuDO> findMenusByUserId(Long userId);

    //获取当前添加菜单的父菜单
    SysMenuDO selectParentMenu(Long parentId);
}
