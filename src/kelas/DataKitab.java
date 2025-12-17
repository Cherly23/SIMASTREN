/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author cherly
 */
public class DataKitab extends koneksi{
    private String nama_kitab;
    private int id_kitab, ustadz_id, kelas_id;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public DataKitab(){
        koneksi = super.configDB();
    }
    
    public String getNama_kitab() {
        return nama_kitab;
    }

    public void setNama_kitab(String nama_kitab) {
        this.nama_kitab = nama_kitab;
    }

    public int getId_kitab() {
        return id_kitab;
    }

    public void setId_kitab(int id_kitab) {
        this.id_kitab = id_kitab;
    }

    public int getUstadz_id() {
        return ustadz_id;
    }

    public void setUstadz_id(int ustadz_id) {
        this.ustadz_id = ustadz_id;
    }

    public int getKelas_id() {
        return kelas_id;
    }

    public void setKelas_id(int kelas_id) {
        this.kelas_id = kelas_id;
    }
    
    
        public ResultSet dataComboBox() {
        try {
            query = "SELECT ustadz_id FROM ustadz";
            
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet konversi() {
        try {
            query = "SELECT categoryId FROM category WHERE categoryName = ?";
            
            ps = koneksi.prepareStatement(query);
            ps.setInt(1, this.ustadz_id);
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;  
    }

}
