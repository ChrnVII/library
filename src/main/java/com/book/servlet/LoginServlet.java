package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import com.book.service.LoginService;
import com.book.utils.ThymeleafUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{


    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        Context context = new Context();
        HttpSession session = req.getSession();
        Object loginFailure = session.getAttribute("loginFailure");
        if (loginFailure != null) {//登陆失败
            context.setVariable("loginStatus0", "用户名或密码错误,请重新输入");
            session.removeAttribute("loginFailure");
        } else {
            context.setVariable("loginStatus1", "请输入用户名和密码");
        }
        ThymeleafUtil.process("login.html", context, resp.getWriter());
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LoginService service = new LoginService();
        if (service.auth(username, password, req)) {
            resp.sendRedirect("index");
            return;
        } else {
            System.out.println("login failed");
            req.getSession().setAttribute("loginFailure", true);
            resp.sendRedirect("login");  
        }
    }
}
