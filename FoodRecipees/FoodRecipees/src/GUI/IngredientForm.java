    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Difficulty;
import BL.Ingredient;
import BL.IngredientCategory;
import BL.IngredientCategory;
import BL.PreparationWay;
import BL.Recipe;
import BL.RecipeCategory;
import BL.RecipeIngredient;
import BL.RecipeType;
import BL.UnitDetails;
import DAL.IngredientRepository;
import DAL.IngredientCategoryRepository;
import DAL.RecetaException;
import DAL.RecipeIngredientRepository;
import DAL.UnitDetailsRepository;
import GUI.Models.IngredientTableModel;
import GUI.Models.IngredientCategoryComboBox;
import GUI.Models.RecipeIngredientTableModel;
import GUI.Models.UnitDetailsComboBox;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Table;
import javax.swing.ComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import static org.eclipse.persistence.internal.jpa.metadata.xml.XMLEntityMappingsReader.clear;

/**
 *
 * @author User
 */
public class IngredientForm extends javax.swing.JInternalFrame {

    IngredientRepository ir = new IngredientRepository();
    IngredientTableModel it = new IngredientTableModel();
    IngredientCategoryRepository icr = new IngredientCategoryRepository();
    IngredientCategoryComboBox iccb = new IngredientCategoryComboBox();
    UnitDetailsComboBox udcb = new UnitDetailsComboBox();
    UnitDetailsRepository udr = new UnitDetailsRepository();
    IngredientRepository irr = new IngredientRepository();
    JDesktopPane desktopPane;

    /**
     * Creates new form IngredientForm
     */
    public IngredientForm() {
        initComponents();
        loadTable();
        loadComboBox();
        tabelaSelectedIndexChange();
    }

    public IngredientForm(JDesktopPane desktopPane) {
        initComponents();
        loadTable();
        loadComboBox();
        tabelaSelectedIndexChange();
        this.desktopPane = desktopPane;
    }
    
  

    public void loadComboBox() {
        try {
            List<IngredientCategory> lista = icr.findAll();

            iccb.add(lista);
//            ingredientCategoryCMB.setModel(iccb);
//            ingredientCategoryCMB.repaint();

        } catch (RecetaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = ingredientTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Ingredient i = it.getIngredient(selectedIndex);
                    //EntityName en = entm.getEntityName(selectedIndex);

                    //component1.setText(en.getParam() + "");
                }
            }
        });
    }

    public void clear() {
        ingredientTable.clearSelection();
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ingredientTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        titleTxt = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        ingredientTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    new RecipeForm().setVisible(true);
                }
            }
        });
        ingredientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ingredientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingredientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ingredientTable);

        jButton1.setText("Add Entry");
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
                .addContainerGap()
                .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
   
       private void loadTable() {
        try {
            List<Ingredient> list = ir.findAll();
            it.addList(list);
            ingredientTable.setModel(it);
            it.fireTableDataChanged();
        } catch (RecetaException ex) {
            Logger.getLogger(RecipeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RecipeIngredientForm rf = new RecipeIngredientForm(desktopPane);
        desktopPane.add(rf);
        rf.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed
          RecipeIngredientForm rf = new RecipeIngredientForm();
   
    private void ingredientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingredientTableMouseClicked
       int row   = ingredientTable.getSelectedRow();
       int column = ingredientTable.getSelectedColumn();
       TableModel model = ingredientTable.getModel();
       
        if (evt.getClickCount() == 2){
        
       String category = model.getValueAt(row, 0).toString();
      
      String title = model.getValueAt(row, 1).toString();
       
         desktopPane.add(rf);
        rf.setVisible(true);
         
         rf.pack();
         rf.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
         
         
         rf.categoryTxt.setText(category);
         rf.titleTxt.setText(title);
         
          
        
         
        
         
         
        
       }
       
    }//GEN-LAST:event_ingredientTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ingredientTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField titleTxt;
    // End of variables declaration//GEN-END:variables

}
