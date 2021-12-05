package com.java.web.controller;

import com.java.web.config.DatabaseConfig;
import com.java.web.service.MotorService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/motor/detail")
public class DetailMotorController extends HttpServlet {

    private MotorService motorService = new MotorService();
    Connection conn;

    protected void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DatabaseConfig.url, DatabaseConfig.username, DatabaseConfig.password);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connect();
            String nomor_polisi = req.getParameter("nomor_polisi");
            if (nomor_polisi != null) {
                motorService.findById(nomor_polisi).iterator();
                req.setAttribute("detailMotor", motorService.findById(nomor_polisi));
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/detail.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarMotorController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
