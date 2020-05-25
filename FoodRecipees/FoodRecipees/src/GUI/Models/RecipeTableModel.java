package GUI.Models;

import BL.Recipe;
import BL.RecipeCategory;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RecipeTableModel extends AbstractTableModel {

    List<Recipe> list;
    String[] cols = {"Title", "RecipeNumber", "CreationDate", "Category", "RecipeType", "PrepWay", "Difficulty", "CookingTime", "Calories", "Author", "Rating"};

    public RecipeTableModel() {
    }

    public RecipeTableModel(List<Recipe> list) {
        this.list = list;
    }

    public void addList(List<Recipe> list) {
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

    public Recipe getRecipe(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recipe r = list.get(rowIndex);

        switch (columnIndex) {       // E MODIFIKUAR-----------------------------------------------------------------
            case 0:
                return r.getTitle();
            case 1:
                return r.getRecipeNumber();
            case 2:
                return r.getCreationDate();
            case 3:
                return r.getRecipeCategoryID();
            case 4:
                return r.getRecipeTypeID();
            case 5:
                return r.getPreparationWayID();
            case 6:
                return r.getDifficultyID();
            case 7:
                return r.getCookingTime();
            case 8:
                return r.getCalories();
            case 9:
                return r.getAuthorComment();
            case 10:
                return r.getRecipeRating();

            default:
                return null;
        }
    }

}