package com.project.shops.controller;

import com.project.shops.model.dto.LoginDto;
import com.project.shops.model.vo.LoginVo;
import com.project.shops.model.vo.ValidateCodeVo;
import com.project.shops.model.vo.common.Result;
import com.project.shops.model.vo.common.ResultCodeEnum;
import com.project.shops.service.IUserService;
import com.project.shops.service.ValidateCodeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinpan
 * @create 2020-05-03 16:27
 */
@RestController
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ValidateCodeService validateCodeService;

    //生成图片验证码
    @GetMapping(value = "/generateValidateCode")
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
}
