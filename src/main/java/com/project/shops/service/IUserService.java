package com.project.shops.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.shops.model.dao.SysUserDO;
import com.project.shops.model.dto.LoginDto;
import com.project.shops.model.vo.LoginVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author luke
 * @since 2023-11-09
 */
public interface IUserService extends IService<SysUserDO> {

    //用户登录
    LoginVo login(LoginDto loginDto);

    //用户退出
    void logout(String token);
}
