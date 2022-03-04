/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentManagement;

import java.util.List;
import java.util.ArrayList;
import model.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Journal;
import model.Newspaper;
/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */

public class DocumentManagement {
    Connection connection = SQLServerJDBCConnection.getSQLServerConnection();
    
    public ResultSet getDocumentByID(String maTL) {
        String sql = "SELECT * FROM TaiLieu WHERE maTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTL);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getAllDocument() {
        String sql = "SELECT * FROM TaiLieu";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        
        String sql = "SELECT * FROM TaiLieu WHERE LoaiTL = N'Sách'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book= new Book();
                book.setMaTaiLieu(rs.getString("maTL"));
                book.setLoai(rs.getString("loaiTL"));
                book.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                book.setSoTrang(rs.getInt("soTrang"));
                book.setTenTG(rs.getString("tenTG"));
                book.setTenNXB(rs.getString("tenNXB"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Journal> getAllJournal() {
        List<Journal> journals = new ArrayList<Journal>();
        
        String sql = "SELECT * FROM TaiLieu WHERE LoaiTL = N'Tạp chí'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Journal journal = new Journal();
                journal.setMaTaiLieu(rs.getString("maTL"));
                journal.setLoai(rs.getString("loaiTL"));
                journal.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                journal.setTenNXB(rs.getString("tenNXB"));
                journal.setSoPhatHanh(rs.getInt("soPhatHanh"));
                journal.setThangPhatHanh(rs.getString("thangPhatHanh"));
                journals.add(journal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return journals;
    }
    
    public List<Newspaper> getAllNewspaper() {
        List<Newspaper> newspapers = new ArrayList<Newspaper>();
        
        String sql = "SELECT * FROM TaiLieu WHERE LoaiTL = N'Báo'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Newspaper newspaper = new Newspaper();
                newspaper.setMaTaiLieu(rs.getString("maTL"));
                newspaper.setLoai(rs.getString("loaiTL"));
                newspaper.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                newspaper.setTenNXB(rs.getString("tenNXB"));
                newspaper.setNgayPhatHanh(rs.getString("ngayPhatHanh"));
                newspapers.add(newspaper);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newspapers;
    }
    
    public void insertBook(Book book) {
        String sql = "INSERT INTO TaiLieu (maTL, loaiTL, tenNXB, soBanPhatHanh, tenTG, soTrang)"
                   + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getMaTaiLieu());
            preparedStatement.setString(2, book.getLoai());
            preparedStatement.setString(3, book.getTenNXB());
            preparedStatement.setInt(4, book.getSoBanPhatHanh());
            preparedStatement.setString(5, book.getTenTG());
            preparedStatement.setInt(6, book.getSoTrang());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertJournal(Journal journal) {
        String sql = "INSERT INTO TaiLieu (maTL, loaiTL, tenNXB, soBanPhatHanh, soPhatHanh, thangPhatHanh)"
                   + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, journal.getMaTaiLieu());
            preparedStatement.setString(2, journal.getLoai());
            preparedStatement.setString(3, journal.getTenNXB());
            preparedStatement.setInt(4, journal.getSoBanPhatHanh());
            preparedStatement.setInt(5, journal.getSoPhatHanh());
            preparedStatement.setString(6, journal.getThangPhatHanh());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertNewspaper(Newspaper newspaper) {
        String sql = "INSERT INTO TaiLieu (maTL, loaiTL, tenNXB, soBanPhatHanh, ngayPhatHanh)"
                   + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newspaper.getMaTaiLieu());
            preparedStatement.setString(2, newspaper.getLoai());
            preparedStatement.setString(3, newspaper.getTenNXB());
            preparedStatement.setInt(4, newspaper.getSoBanPhatHanh());
            preparedStatement.setString(5, newspaper.getNgayPhatHanh());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBook(Book book) {
        String sql = "UPDATE TaiLieu SET loaiTL = ?, tenNXB = ?, soBanPhatHanh = ?, tenTG = ?, soTrang = ? WHERE maTL = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getLoai());
            preparedStatement.setString(2, book.getTenNXB());
            preparedStatement.setInt(3, book.getSoBanPhatHanh());
            preparedStatement.setString(4, book.getTenTG());
            preparedStatement.setInt(5, book.getSoTrang());
            preparedStatement.setString(6, book.getMaTaiLieu());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateJournal(Journal journal) {
        String sql = "UPDATE TaiLieu SET loaiTL = ?, tenNXB = ?, soBanPhatHanh = ?, soPhatHanh = ?, thangPhatHanh = ? WHERE maTL = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, journal.getLoai());
            preparedStatement.setString(2, journal.getTenNXB());
            preparedStatement.setInt(3, journal.getSoBanPhatHanh());
            preparedStatement.setInt(4, journal.getSoPhatHanh());
            preparedStatement.setString(5, journal.getThangPhatHanh());
            preparedStatement.setString(6, journal.getMaTaiLieu());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public void updateNewspaper(Newspaper newspaper) {
        String sql = "UPDATE TaiLieu SET loaiTL = ?, tenNXB = ?, soBanPhatHanh = ?, ngayPhatHanh = ? WHERE maTL = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newspaper.getLoai());
            preparedStatement.setString(2, newspaper.getTenNXB());
            preparedStatement.setInt(3, newspaper.getSoBanPhatHanh());
            preparedStatement.setString(4, newspaper.getNgayPhatHanh());
            preparedStatement.setString(5, newspaper.getMaTaiLieu());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteDocument(String maTL) {
        String sql = "DELETE TaiLieu WHERE maTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTL);
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
