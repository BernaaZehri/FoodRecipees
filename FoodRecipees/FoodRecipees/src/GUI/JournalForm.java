/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Difficulty;
import BL.PreparationWay;
import BL.Recipe;
import BL.RecipeCategory;
import BL.RecipeType;
import DAL.DifficultyRepository;
import DAL.IngredientRepository;
import DAL.PreparationWayRepository;
import DAL.RecetaException;
import DAL.RecipeCategoryRepository;
import DAL.RecipeRepository;
import DAL.RecipeTypeRepository;
import GUI.Models.DifficultyComboBox;
import GUI.Models.IngredientTableModel;
import GUI.Models.PreparationWayComboBox;
import GUI.Models.RecipeCategoryComboBox;
import GUI.Models.RecipeTableModel;
import GUI.Models.RecipeTypeComboBox;
import java.awt.Color;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author User
 */
public class JournalForm extends javax.swing.JInternalFrame {
 RecipeCategoryRepository rcr = new RecipeCategoryRepository();
    RecipeTypeRepository rtr = new RecipeTypeRepository();
    DifficultyRepository dr = new DifficultyRepository();
    PreparationWayRepository pwr = new PreparationWayRepository();
    RecipeRepository rr = new RecipeRepository();
    RecipeTableModel rtm = new RecipeTableModel();
    RecipeTableModel tm = new RecipeTableModel();
    RecipeCategoryComboBox rccb = new RecipeCategoryComboBox();
    RecipeTypeComboBox rtcb = new RecipeTypeComboBox();
    DifficultyComboBox dcb = new DifficultyComboBox();
    PreparationWayComboBox pwcb = new PreparationWayComboBox();
    IngredientRepository ir = new IngredientRepository();
    IngredientTableModel itm = new IngredientTableModel();
    /**
     * Creates new form JournalForm
     */
    public JournalForm() {
        initComponents();
        
//        loadComboBox();
        loadTable();
        tabelaSelectedIndexChange();
    }
    
   

      private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = recipeTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Recipe i = rtm.getRecipe(selectedIndex);
                    
                }
            }
        });
    }
      
      /*
      public void loadComboBox() {
        try {
            List<RecipeCategory> lista = rcr.findAll();
            List<RecipeType> lista1 = rtr.findAll();
            List<Difficulty> lista2 = dr.findAll();
            List<PreparationWay> lista3 = pwr.findAll();
            rccb.add(lista);
            //categoryCMB.setModel(rccb);
           // categoryCMB.repaint();
            rtcb.add(lista1);
           // recipeTypeCMB.setModel(rtcb);
            //recipeTypeCMB.repaint();
            pwcb.add(lista3);
           // prepWayCMB.setModel(pwcb);
           // prepWayCMB.repaint();
            dcb.add(lista2);
            //difficultyCMB.setModel(dcb);
           // difficultyCMB.repaint();

        } catch (RecetaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }*/
      
      
       public void loadTable() {
        try {
            List<Recipe> list = rr.findAll();
            rtm.addList(list);
            recipeTable.setModel(rtm);
            rtm.fireTableDataChanged();
        } catch (RecetaException ex) {
            Logger.getLogger(RecipeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public int ratingValue=0;
       public String recipeTitle;             
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        filterTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        starBtn1 = new javax.swing.JButton();
        starBtn2 = new javax.swing.JButton();
        starBtn3 = new javax.swing.JButton();
        starBtn4 = new javax.swing.JButton();
        saveRatingbtn = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Filter:");

        filterTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTxtActionPerformed(evt);
            }
        });
        filterTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTxtKeyPressed(evt);
            }
        });

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        recipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(recipeTable);

        starBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/zbrazet.png"))); // NOI18N
        starBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                starBtn1MouseClicked(evt);
            }
        });
        starBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starBtn1ActionPerformed(evt);
            }
        });

        starBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/zbrazet.png"))); // NOI18N
        starBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                starBtn2MouseClicked(evt);
            }
        });

        starBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/zbrazet.png"))); // NOI18N
        starBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                starBtn3MouseClicked(evt);
            }
        });

        starBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/zbrazet.png"))); // NOI18N
        starBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                starBtn4MouseClicked(evt);
            }
        });

        saveRatingbtn.setText("Save Rating");
        saveRatingbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRatingbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveRatingbtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(starBtn1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(starBtn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starBtn3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starBtn4))
                            .addComponent(filterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(filterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(starBtn1)
                            .addComponent(starBtn2)
                            .addComponent(starBtn3)
                            .addComponent(starBtn4))
                        .addGap(18, 18, 18)
                        .addComponent(saveRatingbtn)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTxtKeyPressed
       
      String query = filterTxt.getText();
        filter(query);
    }//GEN-LAST:event_filterTxtKeyPressed

    private void starBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starBtn1MouseClicked
       System.out.println("1");
        starBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               starBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               System.out.println("1");
            }
            });
        ratingValue = 1;
    }//GEN-LAST:event_starBtn1MouseClicked

    private void starBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starBtn2MouseClicked
        // TODO add your handling code here:
         starBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               starBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               starBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               System.out.println("1");
            }
            });
                 ratingValue = 2;
    }//GEN-LAST:event_starBtn2MouseClicked

    private void starBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starBtn3MouseClicked
        // TODO add your handling code here:
         starBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               starBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               starBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               starBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               System.out.println("1");
            }
            });
                 ratingValue = 3;
    }//GEN-LAST:event_starBtn3MouseClicked

    private void starBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starBtn4MouseClicked
        // TODO add your handling code here:
        starBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               starBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               starBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               starBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
               starBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/verdhe.png")));
            }
            });
                ratingValue = 4;
    }//GEN-LAST:event_starBtn4MouseClicked

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked
        // TODO add your handling code here:
        recipeTable = (JTable)evt.getSource();
            int row = recipeTable.rowAtPoint( evt.getPoint() );
            int column = recipeTable.columnAtPoint( evt.getPoint() );
            recipeTitle =recipeTable.getModel().getValueAt(row, column)+"";
            String printRating = "Cilësuat "+(ratingValue)+" yje recetën '"+recipeTitle+"' ! ";
            JOptionPane.showMessageDialog(null, printRating);
//     try {
//         rr.addRating((ratingValue/2), recipeTitle);
//     } catch (RecetaException ex) {
//         Logger.getLogger(JournalForm.class.getName()).log(Level.SEVERE, null, ex);
//     }
    }//GEN-LAST:event_recipeTableMouseClicked

    private void saveRatingbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRatingbtnActionPerformed
        // TODO add your handling code here:
        Recipe rcp = new Recipe();
        rcp.setRecipeRating(ratingValue);
        
     try {
         rr.submitRating();
     } catch (RecetaException ex) {
         Logger.getLogger(JournalForm.class.getName()).log(Level.SEVERE, null, ex);
     }
        System.out.println("This recipe has been raited: "+rcp.getRecipeRating());
    }//GEN-LAST:event_saveRatingbtnActionPerformed

    private void starBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_starBtn1ActionPerformed

    private void filterTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterTxtActionPerformed

private void filter(String query) {
        TableRowSorter<RecipeTableModel> rt = new TableRowSorter<RecipeTableModel>(rtm);
        recipeTable.setRowSorter(rt);
        rt.setRowFilter(RowFilter.regexFilter(query));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filterTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable recipeTable;
    private javax.swing.JButton saveRatingbtn;
    private javax.swing.JButton starBtn1;
    private javax.swing.JButton starBtn2;
    private javax.swing.JButton starBtn3;
    private javax.swing.JButton starBtn4;
    // End of variables declaration//GEN-END:variables
}
