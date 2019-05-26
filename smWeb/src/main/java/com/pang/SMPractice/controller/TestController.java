package com.pang.SMPractice.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {
    //    /test/show.do
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("NAME","pangPang");
        request.getRequestDispatcher("../index.jsp").forward(request,response);
    }

}
