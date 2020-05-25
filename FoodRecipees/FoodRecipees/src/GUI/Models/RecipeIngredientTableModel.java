package GUI.Models;

import BL.Ingredient;
import BL.RecipeIngredient;
import BL.IngredientCategory;
import BL.RecipeIngredient;
import BL.RecipeIngredient;
import BL.Unit;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RecipeIngredientTableModel extends AbstractTableModel {
    List<IngredientCategory> list2;
    List<RecipeIngredient> list;
    List<Ingredient> list1;
    RecipeIngredient ri = new RecipeIngredient();
    Ingredient ii = new Ingredient();
    IngredientCategory ic = new IngredientCategory();
   
    String[] cols = { "Category","Title", "Quantity", "Unit"};

    public RecipeIngredientTableModel() {

    }

    public RecipeIngredientTableModel(List<RecipeIngredient> list) {
        this.list = list;
    }

    public void addList(List<RecipeIngredient> list) {
        this.list = list;

    }

    @Override
    public String getColumnName(int col) {
        return cols[col];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    public void remove(int row) {
        list.remove(row);
    }

    public RecipeIngredient getRecipeIngredient(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     
       
               
       RecipeIngredient i = list.get(rowIndex);
  
        
        switch (columnIndex) {

            case 0:
                return i.getRecipeIngredientID();
            case 1:
                return i.getRecipeID();
            case 2:
                return i.getIngredientID();
            case 3:
                return i.getQuantity();
            case 4:
                return i.getUnitDetailsID();
             default:
                return null;
   
         
                
           
        }

    }

}
