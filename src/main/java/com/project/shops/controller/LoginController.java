package com.project.shops.controller;

import com.project.shops.model.dao.SysUserDO;
import com.project.shops.model.dto.LoginDto;
import com.project.shops.model.vo.LoginVo;
import com.project.shops.model.vo.SysMenuVo;
import com.project.shops.model.vo.ValidateCodeVo;
import com.project.shops.model.vo.common.Result;
import com.project.shops.model.vo.common.ResultCodeEnum;
import com.project.shops.service.IMenuService;
import com.project.shops.service.IUserService;
import com.project.shops.service.ValidateCodeService;
import com.project.shops.utils.AuthContextUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qinpan
 * @create 2020-05-03 16:27
 */
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IMenuService iMenuService;

    @Autowired
    private ValidateCodeService validateCodeService;

    //生成图片验证码
    @GetMapping(value = "/captcha")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo,ResultCodeEnum.SUCCESS);
    }

    //用户登录
    @Operation(summary = "登录的方法")
    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = iUserService.login(loginDto);
        return Result.build(loginVo, ResultCodeEnum.SUCCESS);
    }

    @GetMapping(value = "/getUserInfo")
    public Result<SysUserDO> getUserInfo() {
        return Result.build(AuthContextUtil.get(),ResultCodeEnum.SUCCESS);
    }

    //查询用户可以操作菜单
    @GetMapping("/menus")
    public Result menus() {
        List<SysMenuVo> list = iMenuService.findMenusByUserId();
        return Result.build(list,ResultCodeEnum.SUCCESS);
    }

    //用户退出
    @GetMapping(value = "/logout")
    public Result logout(@RequestHeader(name = "token") String token) {
        iUserService.logout(token);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
}
