package com.project.shops.service;


import com.project.shops.model.vo.ValidateCodeVo;

public interface ValidateCodeService {

    //生成图片验证码
    ValidateCodeVo generateValidateCode();
}
