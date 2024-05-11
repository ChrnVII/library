package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import com.book.entity.User;
import com.book.utils.ThymeleafUtil;

@WebServlet("/books")
public class BooksServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        Context context = new Context();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        context.setVariable("username", user.getUsername());
        context.setVariable("nickname", user.getNickname());
        ThymeleafUtil.process("books.html", context, resp.getWriter());
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
