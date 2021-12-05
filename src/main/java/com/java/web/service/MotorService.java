package com.java.web.service;

import com.java.web.config.DatabaseConfig;
import com.java.web.dao.MotorDao;
import com.java.web.domain.Motor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MotorService implements MotorDao {

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
    public List<Motor> daftarMotor() throws SQLException {
        connect();
        List<Motor> daftarMotor = new ArrayList<>();

        String sql = "SELECT * FROM motor";

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Motor m = new Motor();
            m.setNomorPolisi(rs.getString(1));
            m.setType(rs.getString(2));
            m.setWarna(rs.getString(3));
            m.setTahunPerakitan(rs.getString(4));
            m.setJenis(rs.getString(5));
            m.setNomorMesin(rs.getString(6));
            m.setNomorRangka(rs.getString(7));
            m.setGambar(rs.getString(8));

            daftarMotor.add(m);
        }
        return daftarMotor;
    }

    @Override
    public boolean tambah(Motor m) {
        try {
            connect();
            String sql = "INSERT INTO motor (nomor_polisi, type, warna, tahun_perakitan, jenis, nomor_mesin, nomor_rangka, gambar)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, m.getNomorPolisi());
            stm.setString(2, m.getType());
            stm.setString(3, m.getWarna());
            stm.setString(4, m.getTahunPerakitan());
            stm.setString(5, m.getJenis());
            stm.setString(6, m.getNomorMesin());
            stm.setString(7, m.getNomorRangka());
            stm.setString(8, m.getGambar());

            boolean row = stm.executeUpdate() > 0;
            stm.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean ubah(Motor m) {

        try {
            connect();
            String sql = "UPDATE motor SET type = ?, warna = ?, tahun_perakitan = ?, jenis = ?, nomor_mesin = ?, nomor_rangka = ?, gambar = ? WHERE nomor_polisi = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, m.getType());
            stm.setString(2, m.getWarna());
            stm.setString(3, m.getTahunPerakitan());
            stm.setString(4, m.getJenis());
            stm.setString(5, m.getNomorMesin());
            stm.setString(6, m.getNomorRangka());
            stm.setString(7, m.getGambar());
            stm.setString(8, m.getNomorPolisi());

            boolean row = stm.executeUpdate() > 0;
            stm.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    @Override
    public boolean hapus(Motor m) {

        try {
            connect();
            String sql = "DELETE FROM motor WHERE nomor_polisi = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, m.getNomorPolisi());

            boolean row = stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MotorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Motor> findById(String nomor_polisi) throws SQLException {
        connect();
        List<Motor> findById = new ArrayList<>();
        Motor m = new Motor();
        String sql = "SELECT * FROM motor where nomor_polisi = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, nomor_polisi);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            m.setNomorPolisi(rs.getString(1));
            m.setType(rs.getString(2));
            m.setWarna(rs.getString(3));
            m.setTahunPerakitan(rs.getString(4));
            m.setJenis(rs.getString(5));
            m.setNomorMesin(rs.getString(6));
            m.setNomorRangka(rs.getString(7));
            m.setGambar(rs.getString(8));
            findById.add(m);
        }
        return findById;
    }

    @Override
    public List<Motor> getId(String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
