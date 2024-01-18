package com.project.shops.controller;

import com.alibaba.fastjson2.JSONObject;
import com.lark.oapi.Client;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.authen.v1.model.CreateOidcAccessTokenReq;
import com.lark.oapi.service.authen.v1.model.CreateOidcAccessTokenReqBody;
import com.lark.oapi.service.authen.v1.model.CreateOidcAccessTokenResp;
import com.project.shops.model.dao.SysUserDO;
import com.project.shops.model.dto.LoginDto;
import com.project.shops.model.dto.QLoginDto;
import com.project.shops.model.vo.*;
import com.project.shops.model.vo.common.Result;
import com.project.shops.model.vo.common.ResultCodeEnum;
import com.project.shops.service.IUserService;
import com.project.shops.service.ValidateCodeService;
import com.project.shops.utils.AuthContextUtil;
import io.swagger.v3.oas.annotations.Operation;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author qinpan
 * @create 2020-05-03 16:27
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //生成图片验证码
    @GetMapping(value = "/captcha")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo, ResultCodeEnum.SUCCESS);
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
        return Result.build(AuthContextUtil.get(), ResultCodeEnum.SUCCESS);
    }

    //用户退出
    @GetMapping(value = "/logout")
    public Result logout(@RequestHeader(name = "token") String token) {
        iUserService.logout(token);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "登录的方法")
    @PostMapping("/qrLogin")
    public Result<QLoginVo> qlogin(@RequestBody QLoginDto loginDto) throws IOException {
        //获取令牌
        String http = http();
        TokenInfoVo tokenInfoVo = JSONObject.parseObject(http, TokenInfoVo.class);
        QLoginVo qLoginVo = new QLoginVo();
        qLoginVo.setTokenInfo(tokenInfoVo);
        qLoginVo.setQrUserInfo(new QrUserInfo());
        //获取用户信息
        return Result.build(qLoginVo, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "验证code")
    @GetMapping("/verify_code")
    public Result<Boolean> verifyCode(String code,String state) throws Exception {
        //输出参数
        System.out.println(code);
        System.out.println(state);
        String http = http();
        TokenInfoVo tokenInfoVo = JSONObject.parseObject(http, TokenInfoVo.class);
        String s = http2(code, tokenInfoVo.getAccessToken());
        TokenInfo2Vo tokenInfo2Vo = JSONObject.parseObject(s, TokenInfo2Vo.class);

        redisTemplate.opsForValue().set(code,s, tokenInfo2Vo.getExpires_in(), TimeUnit.SECONDS);
        return Result.build(true, ResultCodeEnum.SUCCESS);
    }
    public String http() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, "{\n    \"app_id\":\"cli_a20dbf0edf3b500c\",\n    \"app_secret\":\"w0m1r8yS1ZACI7tE5Lu6ohokfpWkWhbR\"\n}");
        Request request = new Request.Builder()
                .url("https://open.feishu.cn/open-apis/auth/v3/app_access_token/internal")
                .method("POST", body)
                .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {

            return response.body().string();
        }
        return null;
    }

    private String http2(String code,String tenantAccessToken) throws Exception {
        // 构建client
        Client client = Client.newBuilder("cli_a20dbf0edf3b500c", "w0m1r8yS1ZACI7tE5Lu6ohokfpWkWhbR")
                .disableTokenCache() //如需SDK自动管理租户Token的获取与刷新,可删除该行
                .build();

        // 创建请求对象
        CreateOidcAccessTokenReq req = CreateOidcAccessTokenReq.newBuilder()
                .createOidcAccessTokenReqBody(CreateOidcAccessTokenReqBody.newBuilder()
                        .grantType("authorization_code")
                        .code(code)
                        .build())
                .build();

        // 发起请求
        // 如开启了Sdk的token管理功能，就无需调用 RequestOptions.newBuilder().tenantAccessToken("t-xxx").build()来设置租户token了
        CreateOidcAccessTokenResp resp = client.authen().oidcAccessToken().create(req, RequestOptions.newBuilder()
                .tenantAccessToken(tenantAccessToken)
                .build());

        // 处理服务端错误
        if(!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s", resp.getCode(), resp.getMsg(), resp.getRequestId()));
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
        return Jsons.DEFAULT.toJson(resp.getData());
    }
}
