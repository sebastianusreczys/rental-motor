package com.java.web.controller;

import com.java.web.domain.Costumer;
import com.java.web.service.CostumerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/user/daftar")
public class RegistrasiUserController extends HttpServlet {

    private final CostumerService costumerService = new CostumerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Costumer cos = new Costumer();
        String nama = req.getParameter("nama");
//        cos.setNama(req.getParameter("nama").trim().toLowerCase());
//        cos.setEmail(req.getParameter("email").trim().toLowerCase());
//        cos.setAlamat(req.getParameter("alamat").trim().toLowerCase());
//        cos.setNomorHp(req.getParameter("nomor_handphone").trim().toLowerCase());
//        cos.setPassword(req.getParameter("password").trim().toLowerCase());
        
        if(nama.isEmpty()){
//             resp.sendRedirect(req.getServletContext().getContextPath() + "/registrasi.jsp");
        
        }
        
//        costumerService.daftar(cos);
//        resp.sendRedirect(req.getServletContext().getContextPath() + "/konfirmasi.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect(req.getServletContext().getContextPath() + "/registrasi.jsp");
    }

}
