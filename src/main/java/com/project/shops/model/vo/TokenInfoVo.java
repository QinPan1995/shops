package com.project.shops.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author ：luke
 * @date ：Created in 2023/12/18 10:41 AM
 * @description：
 * @modified By：
 */

@Data
public class TokenInfoVo {

    @Schema(description = "令牌")
    @JSONField(name = "app_access_token")
    private String accessToken;

    @Schema(description = "刷新令牌,可以为空")
    @JSONField(name = "tenant_access_token")
    private String refreshToken ;

    private String access_token;
    private String refresh_token;
    private String token_type;
    private int expires_in;
    private int refresh_expires_in;
    private String scope;
}
