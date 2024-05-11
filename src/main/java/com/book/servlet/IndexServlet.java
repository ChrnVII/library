package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.exceptions.PersistenceException;
import org.thymeleaf.context.Context;

import com.book.entity.User;
import com.book.service.BorrowService;
import com.book.utils.ThymeleafUtil;

@WebServlet("/index")
public class IndexServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        Context context = new Context();
        HttpSession session = req.getSession();
        BorrowService service = new BorrowService();
        User user = (User) session.getAttribute("user");
        context.setVariable("username", user.getUsername());
        context.setVariable("nickname", user.getNickname());
        context.setVariable("borrowList", service.getBorrowList());
        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        Context context = new Context();
        BorrowService service = new BorrowService();
        String sidString = req.getParameter("sid");
        String bidString = req.getParameter("bid");
        try {
            int sid = Integer.parseInt(sidString);
            int bid = Integer.parseInt(bidString);
            service.addBorrow(sid, bid);
            context.setVariable("insertDialog", "插入成功");
        } catch (NumberFormatException e) {
            context.setVariable("insertDialog", "格式错误");

        } catch (PersistenceException e) {
            context.setVariable("insertDialog", "插入失败");

        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        context.setVariable("username", user.getUsername());
        context.setVariable("nickname", user.getNickname());
        context.setVariable("borrowList", service.getBorrowList());
        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }
}
