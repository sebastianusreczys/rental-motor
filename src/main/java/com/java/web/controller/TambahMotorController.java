package com.java.web.controller;

import com.java.web.config.FlashMessage;
import com.java.web.domain.Motor;
import com.java.web.service.MotorService;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet(urlPatterns = "/motor/add")
public class TambahMotorController extends HttpServlet {

    private final MotorService motorService = new MotorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lokasi = new File("C:\\Users\\SEBASTIAN-HP\\Documents\\NetBeansProjects\\rental-motor\\src\\main\\webapp\\img").getAbsolutePath();
        Motor m = new Motor();
        m.setNomorPolisi(req.getParameter("nomor_polisi"));
        m.setType(req.getParameter("type"));
        m.setWarna(req.getParameter("warna"));
        m.setTahunPerakitan(req.getParameter("tahun_perakitan"));
        m.setJenis(req.getParameter("jenis"));
        m.setNomorMesin(req.getParameter("nomor_mesin"));
        m.setNomorRangka(req.getParameter("nomor_rangka"));
        Part filePart = req.getPart("gambar");
        String fileName = getFileName(filePart);
        m.setGambar(fileName);
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = resp.getWriter();

        try {
            out = new FileOutputStream(new File(lokasi + File.separator + fileName));
            filecontent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            if (motorService.tambah(m)) {
                FlashMessage message = new FlashMessage("Data gagal ditambah", "error", "alert-danger");
                HttpSession s = req.getSession();
                s.setAttribute("msg", message);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/view/admin/tambah.jsp?=gagal");

            } else {
                FlashMessage message = new FlashMessage("Data Berhasil ditambah", "success", "alert-success");
                req.getSession().setAttribute("msg", message);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.jsp?=sukses");
            }
        } catch (FileNotFoundException fne) {
            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/admin/tambah.jsp").forward(req, resp);

    }

}
