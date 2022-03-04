package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import documentManagement.DocumentManagement;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Book;
import model.Journal;
import model.Newspaper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */
public class ListDocumentFrame extends javax.swing.JFrame {
    DocumentManagement docManagement;
    DefaultTableModel defaultTableModel;
    /**
     * Creates new form MainFrame
     */
    public ListDocumentFrame() {
        initComponents();
        docManagement = new DocumentManagement();
        defaultTableModel = new DefaultTableModel() {
            // Không cho phép nhập dữ liệu vào table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setColumnTable("Tất cả");
        try {
            // Đặt mặc định List book khi khởi chạy Frame
            setDocumentDataTable(docManagement.getAllDocument());
        } catch (SQLException ex) {
            Logger.getLogger(ListDocumentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setColumnTable(String docType) {
        documentTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("MaTL");
        defaultTableModel.addColumn("LoaiTL");
        defaultTableModel.addColumn("TenNXB");
        defaultTableModel.addColumn("SoBanPH");
        if (docType.equals("Sách") || docType.equals("Tất cả")) {
            defaultTableModel.addColumn("TenTG");
            defaultTableModel.addColumn("SoTrang");
        }
        if (docType.equals("Tạp chí") || docType.equals("Tất cả")) {
            defaultTableModel.addColumn("SoPH");
            defaultTableModel.addColumn("ThangPH");
        }
        
        if (docType.equals("Báo") || docType.equals("Tất cả")){ 
            defaultTableModel.addColumn("NgayPH");
        }
        
    }
    
    private void setDocumentDataTable(ResultSet rs) throws SQLException {
        defaultTableModel.setRowCount(0);
        while(rs.next()) {
            defaultTableModel.addRow(new Object[]{rs.getString("maTL"), rs.getString("loaiTL"), rs.getString("tenNXB"),rs.getInt("soBanPhatHanh"), rs.getString("tenTG"), rs.getInt("soTrang"), rs.getInt("soPhatHanh"), rs.getString("thangPhatHanh"), rs.getString("ngayPhatHanh")});
        }
    }
    
    private void setBookDataTable(List<Book> books) {
        defaultTableModel.setRowCount(0);
        for (Book book : books) {
            defaultTableModel.addRow(new Object[]{book.getMaTaiLieu(), book.getLoai(), book.getTenNXB(), book.getSoBanPhatHanh(), book.getTenTG(), book.getSoTrang()});
        }
    }
    
    private void setJournalDataTable(List<Journal> journals) {
        defaultTableModel.setRowCount(0);
        for (Journal journal : journals) {
            defaultTableModel.addRow(new Object[]{journal.getMaTaiLieu(), journal.getLoai(), journal.getTenNXB(), journal.getSoBanPhatHanh(),journal.getSoPhatHanh(), journal.getThangPhatHanh()});
        }
    }
    
    private void setNewspaperDataTable(List<Newspaper> newspapers) {
        defaultTableModel.setRowCount(0);
        for (Newspaper newspaper : newspapers) {
            defaultTableModel.addRow(new Object[]{newspaper.getMaTaiLieu(), newspaper.getLoai(), newspaper.getTenNXB(), newspaper.getSoBanPhatHanh(), newspaper.getNgayPhatHanh()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        docTypeComboBox = new javax.swing.JComboBox<>();
        addDocButton = new javax.swing.JButton();
        editDocButton = new javax.swing.JButton();
        deleteDocButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentTable = new javax.swing.JTable();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        docTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sách", "Tạp chí", "Báo" }));
        docTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docTypeComboBoxActionPerformed(evt);
            }
        });

        addDocButton.setText("Thêm");
        addDocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocButtonActionPerformed(evt);
            }
        });

        editDocButton.setText("Sửa");
        editDocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDocButtonActionPerformed(evt);
            }
        });

        deleteDocButton.setText("Xóa");
        deleteDocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDocButtonActionPerformed(evt);
            }
        });

        documentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        documentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(documentTable);

        exitButton.setText("Thoát");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(docTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(addDocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editDocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteDocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(docTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addDocButton)
                        .addComponent(editDocButton)
                        .addComponent(deleteDocButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void docTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docTypeComboBoxActionPerformed
        String docType  = (String) docTypeComboBox.getSelectedItem();
        
        // Đặt số cột thành 0
        defaultTableModel.setColumnCount(0);
        
        // set column theo type
        setColumnTable(docType);
        
        // set row theo type
        if(docType.equals("Sách")) {
            setBookDataTable(docManagement.getAllBooks());
        }
        if(docType.equals("Tạp chí")) {
            setJournalDataTable(docManagement.getAllJournal());
        }
        if(docType.equals("Báo")) {
            setNewspaperDataTable(docManagement.getAllNewspaper());
        }
        if(docType.equals("Tất cả")) {
            try {
                setDocumentDataTable(docManagement.getAllDocument());
            } catch (SQLException ex) {
                Logger.getLogger(ListDocumentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_docTypeComboBoxActionPerformed

    private void addDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocButtonActionPerformed
        new AddDocumentFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addDocButtonActionPerformed

    private void deleteDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDocButtonActionPerformed
        int row = documentTable.getSelectedRow();
        if (row == -1) { // chưa chọn
            JOptionPane.showMessageDialog(ListDocumentFrame.this, "Vui lòng chọn tài liệu cần xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ListDocumentFrame.this, "Bạn có chắc chắn muốn xóa không");
            
            if (confirm == JOptionPane.YES_OPTION) {
                String maTL = (String) documentTable.getValueAt(row, 0);
                // Xoa
                docManagement.deleteDocument(maTL);
                // Refresh
                defaultTableModel.setRowCount(0);
                try {
                    setDocumentDataTable(docManagement.getAllDocument());
                } catch (SQLException ex) {
                    Logger.getLogger(ListDocumentFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_deleteDocButtonActionPerformed

    private void editDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDocButtonActionPerformed
        int row = documentTable.getSelectedRow();
        if (row == -1) { // chưa chọn
            JOptionPane.showMessageDialog(ListDocumentFrame.this, "Vui lòng chọn tài liệu cần chỉnh sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            
            String maTL = String.valueOf(documentTable.getValueAt(row, 0));
            try {
                new EditDocumentFrame(maTL).setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ListDocumentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_editDocButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListDocumentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListDocumentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListDocumentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListDocumentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListDocumentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDocButton;
    private javax.swing.JButton deleteDocButton;
    private javax.swing.JComboBox<String> docTypeComboBox;
    private javax.swing.JTable documentTable;
    private javax.swing.JButton editDocButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
