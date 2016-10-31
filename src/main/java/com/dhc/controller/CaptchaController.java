package com.dhc.controller;


import com.dhc.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by DuHongcai on 2016/10/12.
 */
@Controller
@RequestMapping(value = "/")
public class CaptchaController {
    public static final String KEY_CAPTCHA = "SE_KEY_MM_CODE";

    @RequestMapping(value = "/getCaptcha")
    public void getCaptcha(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("image/jpeg");
        resp.setHeader("Pargma", "No-Cache");
        resp.setHeader("Cache-Control", "No-Cache");
        resp.setDateHeader("Expire", 0);
        try {
            HttpSession session = req.getSession();
            CaptchaUtil tool = new CaptchaUtil();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.getRandomCodeImage(code);
            session.removeAttribute(KEY_CAPTCHA);
            session.setAttribute(KEY_CAPTCHA, code.toString());

            ImageIO.write(image, "JPEG", resp.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
