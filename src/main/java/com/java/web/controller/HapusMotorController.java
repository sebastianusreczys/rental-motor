package com.java.web.controller;

import com.java.web.config.FlashMessage;
import com.java.web.domain.Motor;
import com.java.web.service.MotorService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/motor/hapus")
public class HapusMotorController extends HttpServlet {

    private final MotorService motorService = new MotorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Motor m = new Motor();
        m.setNomorPolisi(req.getParameter("nomor_polisi"));
        motorService.hapus(m);

        if (motorService.tambah(m)) {
            FlashMessage message = new FlashMessage("Data gagal dihapus", "error", "alert-danger");
            HttpSession s = req.getSession();
            s.setAttribute("msg", message);
            resp.sendRedirect(req.getServletContext().getContextPath() + "/view/admin/tambah.jsp?=gagal");
        } else {

            FlashMessage message = new FlashMessage("Data Berhasil dihapus", "success", "alert-success");
            req.getSession().setAttribute("msg", message);
            resp.sendRedirect(req.getServletContext().getContextPath() + "/index.jsp?=sukses");

        }
    }
}
