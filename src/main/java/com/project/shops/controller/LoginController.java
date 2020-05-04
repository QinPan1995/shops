package com.project.shops.controller;

import com.project.shops.utils.RSAUtil;
import com.project.shops.utils.RSAUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinpan
 * @create 2020-05-03 16:27
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(String password,String uname) throws Exception {
        //String PRIVATEKEY = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBANdCRngdxwBhYGieVrjUO7NCtfdYGnP6qSY99vsJiJi/1m+QAxjC7wZLBs/3zFDxEGffUE9Ra9iXdBVDmlFHGXCXgkpyN/KFc7AwUI1UbJpYrtDlyDHRGATPTP/jPrfnLmr4jR3441VlNJIxlYkbqbTL0atrUxItp7jsLHwTAJ/RAgMBAAECgYEAhcNMcRXn9KeONlS2hTJ1SsbYtrRL8+g+tmHpGURqWqlTQo5WLkvsJpf2ysMsdtvmGvYdPLzW7Ifo/dG9kmZBOp8GiZGTleS3xWU4I1WSjaqEW/r2JNmVd2wshSl5NFFA/8ExQzBPqtaSL4W1yQKwfQOs1QCVagKVWrHG9NJq/bECQQD2OH1Qow8qSaP3oziDodg6MMl4ysVpB3+cXvf7bFKJyzXdzMKf9Sn5+rQcKQiC5d/E3bJrFu0b9TMhkkopP0itAkEA3875YMl5cLcJhLj4OULG0HnNOJao+XWP/o+bFMvdtWjIeucm6wG/8C61i6Z0j+4OuDowphpMAUnWyvZ7s+9kNQJBANzeXaOJMiBoALsy4o5KD3Jbs0807hNCU7nNAzy5tey/qml1tZzRyr7gotKkCGuLk8jAar1fyoEK2rwhw37ust0CQQDZ9WdHqu5pptfOOZUDrtSQEw6ZHaBR0Pv6nUAacK/qC7Gyf4qXM40JC3QiHGlIAj6zi3f1S4bZel+EKacvBORBAkEA1juS56Q+oAIZrBoQPH1gUxOV2g/xHm4Egbvh7Pcz+CxQX3xObecUvO1SQ0Ka2tRz3NegyGN89bFQLNGQOtU0yQ==";
        String PRIVATEKEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIVgQSyCMVrEVpIzB++a5u+nsXM2sySPRe7rbY8eiDXKw2Z9FmTnqtO/2BVQAWlAMtptT349/BBZYeic4SAOKm9a1uXqk62tQSNJ9qsFGLrWxqF8BZES/R0ef0/aBwCDlrZ7caqj+9TRdOJ95FlVeuNQO1BRGhKxGYt1S6ptDLmzAgMBAAECgYABANlcqVoPsbxo+yNLJSIpmVxXXoj4dG91PaYkVnl11iGkKrq5ZZi+YQoSFvj7vrTjOcFIVNUJlnKLGmsDH7gn/YI9KBe1JX1eZGf1je///POVkvsslYEhP3iFNbGMdmgdeoCgY8Chvj8FN/EP0QlkmrH5uMan0EBDvJuQlr+gSQJBALm/w3pAmg9xLVfWoFtMj7kUrKQwnXrkUfiKi3t0EaWm5who6Tfy3BUlastmqF9irHCQ3GNL1K3IoMErfsW8hn8CQQC30bnktiINtQUfHoEcRK16WONp4JntZ9nlKu/ghE/+Wc0NM+k1gCV0xiOYYca4MVNjQmHiL48RS7r/Q2D5w/rNAkAeQuyg3Sd8Po8JkXDcjvOXTpP1x+nQHKRyHngs67L4TuGy0Ay2zb0nQMpOSvJBX/0B9cfB8Ze7nET8U466vkUXAkBr7eiIMaitA6yOKQsF3g092RMuB4JZsrBtrlhKK2YMog2TwvcbQrK7bdtYjZBwdgXQMhnnBKWsMhsJ5jX6cOfBAkBIuWZ3IHyRQOjQx7TvStDPKtIeEFoZZubSkCrFfkBx8qUja3h0K9arYHHUSU6vSJG+0N2JnbOiFyG+OUYURPXL";
        // 解密
        //uname = RSAUtils.decryptDataOnJava(uname, PRIVATEKEY);
        //password = RSAUtils.decryptDataOnJava(password, PRIVATEKEY);
        uname = RSAUtil.decryptDataOnJava(uname, PRIVATEKEY);
        password = RSAUtil.decryptDataOnJava(password, PRIVATEKEY);
        if (password.contains("key")) {
            System.err.println("包含");
        }
        System.err.println(uname);
        System.err.println(password);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("uname", uname);
        result.put("password", password);
        /*Map<String, Object> map = RSAUtils.genKeyPair();
        String getPublicKey = RSAUtils.getPublicKey(map);
        String getPrivateKey = RSAUtils.getPrivateKey(map);
        System.out.println(getPublicKey);
        System.out.print(getPrivateKey);*/
        return result;
    }
}
