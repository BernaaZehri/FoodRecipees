package GUI.Models;

import BL.Ingredient;
import BL.IngredientCategory;

import BL.RecipeCategory;
import BL.RecipeIngredient;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RecipeCategoryTableModel extends AbstractTableModel {

    List<RecipeCategory> list;

    String[] cols = {"ID", "Title"};

    public RecipeCategoryTableModel() {

    }

    public RecipeCategoryTableModel(List<RecipeCategory> list) {
        this.list = list;
    }

    public void addList(List<RecipeCategory> list) {
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

    public RecipeCategory getRecipeCategory(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RecipeCategory rc = list.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return rc.getId();
            case 1:
                return rc.getRecipeCategoryDescription();
            default:
                return null;

        }

    }

}
