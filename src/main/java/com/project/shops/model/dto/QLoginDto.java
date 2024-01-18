package com.project.shops.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户登录请求参数")
public class QLoginDto {


    private Long loginTime;
    private String redirectUri;
    private String url;
}
