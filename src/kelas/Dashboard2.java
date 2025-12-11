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
public class Dashboard2 extends koneksi{
    private int JSantri, Jpengurus;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    
    public Dashboard2(){
        koneksi = super.configDB();
    }
    
    public int getJSantri() {
        return JSantri;
    }

    public void setJSantri(int JSantri) {
        this.JSantri = JSantri;
    }

    public int getJpengurus() {
        return Jpengurus;
    }

    public void setJpengurus(int Jpengurus) {
        this.Jpengurus = Jpengurus;
    }
    
    public ResultSet JumlahSantri () {
        query = "SELECT COUNT(*) AS jumlahS FROM santri;";
        
        try { 
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan" + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet JumlahPengajar () {
        query = "SELECT COUNT(*) AS jumlahP FROM ustadz;";
        
        try { 
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan" + sQLException.getMessage());
        }
        return rs;
    }
}

//private void pencarian(String key) {
//    DefaultTableModel model = new DefaultTableModel();
//    model.addColumn("ID Santri");
//    model.addColumn("Nama");
//    model.addColumn("Tempat Lahir");
//    model.addColumn("Tanggal Lahir");
//    model.addColumn("Alamat");
//    model.addColumn("Gender");
//    model.addColumn("Wali Santri");
//    model.addColumn("No HP");
//    model.addColumn("Tanggal Masuk");
//    model.addColumn("Status");
//
//    try {
//        Santri snr = new Santri();
//        ResultSet result = snr.cariSantri  (key);
//
//        while (result.next()) {
//            String status = (result.getInt("Status") == 1) ? "Mukim" : "Tidak Mukim";
//            model.addRow(new Object[]{
//                result.getInt("id_santri"),
//                result.getString("NamaSantri"),
//                result.getString("tempat_lahir"),
//                result.getString("tanggal_lahir"),
//                result.getString("alamat"),
//                result.getString("jenis_kelamin"),
//                result.getString("wali_santri"),
//                result.getString("no_hp"),
//                result.getString("tanggal_masuk"),
//                status
//            });
//        }
//
//        tblSantri.setModel(model);
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, "Error saat mencari: " + e.getMessage());
//    }
//}
