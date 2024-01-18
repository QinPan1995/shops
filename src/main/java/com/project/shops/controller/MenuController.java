package com.project.shops.controller;

import com.project.shops.model.vo.SysMenuVo;
import com.project.shops.model.vo.common.Result;
import com.project.shops.model.vo.common.ResultCodeEnum;
import com.project.shops.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：luke
 * @date ：Created in 2023/12/14 4:19 PM
 * @description：菜单
 * @modified By：
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    //查询用户可以操作菜单
    @GetMapping("/menus/routes")
    public Result<List<SysMenuVo>> menus() {
        List<SysMenuVo> list = iMenuService.findMenusByUserId();
        return Result.build(list, ResultCodeEnum.SUCCESS);
    }
}
