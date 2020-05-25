/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Refresh
 */
public class GENERATEREPORT extends javax.swing.JInternalFrame {

    /**
     * Creates new form GENERATEREPORT
     */
    public GENERATEREPORT() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        generate.setText("Generate Recipe");
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });

        jButton1.setText("Generate Unit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(generate, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(generate)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
       String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Databaza";
        String user = "sa";
        String password = "sa";
            try {
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url, user, password);
                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Refresh\\Desktop\\FoodRecipees\\src\\GUI\\Receta.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint print = JasperFillManager.fillReport(jr, null, con);
                JasperViewer.viewReport(print);
            } catch (JRException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GENERATEREPORT.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_generateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Databaza";
        String user = "sa";
        String password = "sa";
            try {
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url, user, password);
                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Refresh\\Desktop\\FoodRecipees\\src\\GUI\\Unit.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint print = JasperFillManager.fillReport(jr, null, con);
                JasperViewer.viewReport(print);
            } catch (JRException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GENERATEREPORT.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generate;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}