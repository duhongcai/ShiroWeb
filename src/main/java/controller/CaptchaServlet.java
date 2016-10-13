package controller;

import utils.CaptchaUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by DuHongcai on 2016/10/12.
 */
@WebServlet(name = "captchServlet",urlPatterns = "/getCaptcha")
public class CaptchaServlet extends HttpServlet{
    public static final String KEY_CAPTCHA = "SE_KEY_MM_CODE";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        resp.setHeader("Pargma","No-Cache");
        resp.setHeader("Cache-Control","no-cacge");
        resp.setDateHeader("Expire",0);
        try{
            HttpSession session = req.getSession();

            CaptchaUtil tool = new CaptchaUtil();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.getRandomCodeImage(code);
            session.removeAttribute(KEY_CAPTCHA);
            session.setAttribute(KEY_CAPTCHA,code.toString());

            ImageIO.write(image,"JPEG",resp.getOutputStream());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
