package GUI.Models;

import BL.Ingredient;
import BL.IngredientCategory;

import BL.Ingredient;
import BL.RecipeIngredient;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class IngredientTableModel extends AbstractTableModel {

    List<Ingredient> list;

    String[] cols = {"Category", "Title"};

    public IngredientTableModel() {

    }

    public IngredientTableModel(List<Ingredient> list) {
        this.list = list;
    }

    public void addList(List<Ingredient> list) {
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

    public Ingredient getIngredient(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ingredient i = list.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return i.getIngredientCategoryID();
            case 1:
                return i.getTitle();
            default:
                return null;

        }

    }

}
