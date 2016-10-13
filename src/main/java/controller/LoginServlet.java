package controller;

import com.sun.tools.internal.ws.processor.model.Model;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.util.WebUtils;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by DuHongcai on 2016/10/11.
 */
@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("capatcha");
        String remember = request.getParameter("remember");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(true);
        String existCap = (String) session.getAttribute("SE_KEY_MM_CODE");
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        if (!StringUtils.hasText(captcha)||!StringUtils.hasText(existCap)||!existCap.equalsIgnoreCase(captcha)){
            //throw new CaptcacheException("验证码不正确");
            request.setAttribute("error","验证码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        if (StringUtils.hasText(remember)&&remember.equals("1")){
            token.setRememberMe(true);
        }
        try {
            subject.login(token);
            if (subject.hasRole("admin")){
                System.out.println("admin用户");
            }
            //request.getRequestDispatcher("/index.jsp").forward(request,response);
            response.sendRedirect("index");
        }catch (Exception e){
            request.setAttribute("error","用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
