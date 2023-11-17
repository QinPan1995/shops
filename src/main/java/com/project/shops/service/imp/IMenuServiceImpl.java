package com.project.shops.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.shops.mapper.MenuMapper;
import com.project.shops.model.dao.SysMenuDO;
import com.project.shops.model.dao.SysUserDO;
import com.project.shops.model.vo.SysMenuVo;
import com.project.shops.service.IMenuService;
import com.project.shops.utils.AuthContextUtil;
import com.project.shops.utils.MenuHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author luke
 * @since 2023-11-17
 */
@Service
public class IMenuServiceImpl extends ServiceImpl<MenuMapper, SysMenuDO> implements IMenuService {

    //查询用户可以操作菜单
    @Override
    public List<SysMenuVo> findMenusByUserId() {
        //获取当前用户id
        SysUserDO sysUser = AuthContextUtil.get();
        Long userId = sysUser.getId();

        //根据userId查询可以操作菜单
        //封装要求数据格式，返回
        List<SysMenuDO> sysMenuList =
                MenuHelper.buildTree(MenuMapper.findMenusByUserId(userId));
        List<SysMenuVo> sysMenuVos = this.buildMenus(sysMenuList);
        return sysMenuVos;
    }

    // 将List<SysMenu>对象转换成List<SysMenuVo>对象
    private List<SysMenuVo> buildMenus(List<SysMenuDO> menus) {

        List<SysMenuVo> sysMenuVoList = new LinkedList<SysMenuVo>();
        for (SysMenuDO sysMenu : menus) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setTitle(sysMenu.getTitle());
            sysMenuVo.setName(sysMenu.getComponent());
            List<SysMenuDO> children = sysMenu.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                sysMenuVo.setChildren(buildMenus(children));
            }
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }
}
