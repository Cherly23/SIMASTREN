/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cherly
 */
public class DataKelas extends koneksi{
    private String nama_kelas, wali_ustadz;
    private int id_kelas;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public DataKelas() {
        koneksi = super.configDB();
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getWali_ustadz() {
        return wali_ustadz;
    }

    public void setWali_ustadz(String wali_ustadz) {
        this.wali_ustadz = wali_ustadz;
    }

    public int getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(int id_kelas) {
        this.id_kelas = id_kelas;
    }
    
    public void SimpanKelas() {
        query = "INSERT INTO kelas (nama_kelas, wali_kelas_id) VALUES (?,?)";

    try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, nama_kelas);
            ps.setString(2, wali_ustadz);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan, Eror : " + sQLException.getMessage());
    }
   
}
}
