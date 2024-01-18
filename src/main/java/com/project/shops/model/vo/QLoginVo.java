package com.project.shops.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录成功响应结果实体类")
public class QLoginVo {

    private Integer code=200;

    private TokenInfoVo tokenInfo;

    private QrUserInfo qrUserInfo;
}
