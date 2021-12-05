package com.java.web.dao;

import com.java.web.domain.Motor;
import java.sql.SQLException;
import java.util.List;

public interface MotorDao {

    List<Motor> daftarMotor() throws SQLException;
    
    List<Motor> getId(String nomor_polisi) throws SQLException;

    public boolean tambah(Motor m);

    public boolean ubah(Motor m) throws SQLException;

    public boolean hapus(Motor m) throws SQLException;
}
