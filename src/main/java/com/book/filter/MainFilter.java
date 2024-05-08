package com.book.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.entity.User;

@WebFilter("/*")
public class MainFilter extends HttpFilter{
 
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)throws IOException, ServletException {
        String url = req.getRequestURL().toString();
        if (!url.contains("/static/") && !url.endsWith("login")) {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                resp.sendRedirect("login");
            }
        }
        //放行
        chain.doFilter(req, resp);
    }
}
