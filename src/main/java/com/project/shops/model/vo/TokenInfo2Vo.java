package com.project.shops.model.vo;

import lombok.Data;

/**
 * @author ：luke
 * @date ：Created in 2023/12/18 10:41 AM
 * @description：
 * @modified By：
 */

@Data
public class TokenInfo2Vo {

    private String access_token;
    private String refresh_token;
    private String token_type;
    private long expires_in;
    private long refresh_expires_in;
    private String scope;
}
