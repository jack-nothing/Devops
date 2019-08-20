package com.kechun.controller;


import com.kechun.conf.ContentSet;
import com.kechun.conf.kaptcha.AppKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    AppKaptcha appKaptcha;

    @PostMapping("/login")
    public ContentSet login(@RequestParam(name="email",required = true) String email,
                            @RequestParam(name="password",required = true)String password,
                            @RequestParam(name="vrifyCode",required = false,defaultValue = "test-vrifyCode") String vrifyCode){






        return ContentSet.getContentSet(200,"","登录成功");
    }


    @PostMapping("/logout/{userId}")
    public ContentSet logout(@PathVariable(name="userId") String userId){


        return ContentSet.getContentSet(200,"","登录成功");
    }






    @PostMapping("/kaptcha")
    public void kaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = appKaptcha.createText();
            System.out.println(createText);
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = appKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}