package com.project.shops.utils;

import com.lark.oapi.Client;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.authen.v1.model.CreateOidcAccessTokenReq;
import com.lark.oapi.service.authen.v1.model.CreateOidcAccessTokenReqBody;
import com.lark.oapi.service.authen.v1.model.CreateOidcAccessTokenResp;

/**
 * @author ：luke
 * @date ：Created in 2023/12/18 4:11 PM
 * @description：
 * @modified By：
 */


public class CreateOidcAccessTokenSample {
    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("cli_a20dbf0edf3b500c", "w0m1r8yS1ZACI7tE5Lu6ohokfpWkWhbR")
                .disableTokenCache() //如需SDK自动管理租户Token的获取与刷新,可删除该行
                .build();

        // 创建请求对象
        CreateOidcAccessTokenReq req = CreateOidcAccessTokenReq.newBuilder()
                .createOidcAccessTokenReqBody(CreateOidcAccessTokenReqBody.newBuilder()
                        .grantType("authorization_code")
                        .code("fa7u20a64b404c99b8d61cebc8750c14")
                        .build())
                .build();

        // 发起请求
        // 如开启了Sdk的token管理功能，就无需调用 RequestOptions.newBuilder().tenantAccessToken("t-xxx").build()来设置租户token了
        CreateOidcAccessTokenResp resp = client.authen().oidcAccessToken().create(req, RequestOptions.newBuilder()
                .tenantAccessToken("t-g104cigaUW2T4AITSIUMJEMM56JNOKTEYNSL5Q2U")
                .build());

        // 处理服务端错误
        if(!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s", resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
