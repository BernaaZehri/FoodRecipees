
package GUI.Models;

import BL.RecipeCategory;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class RecipeCategoryComboBox extends AbstractListModel<RecipeCategory> implements ComboBoxModel<RecipeCategory> {

    private List<RecipeCategory> data;
    private RecipeCategory selectedItem;

    public RecipeCategoryComboBox(List<RecipeCategory> data) {
        this.data = data;
    }

    public RecipeCategoryComboBox() {
    }

    public void add(List<RecipeCategory> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public RecipeCategory getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(RecipeCategory)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}

