
package GUI.Models;

import BL.IngredientCategory;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class IngredientCategoryComboBox extends AbstractListModel<IngredientCategory> implements ComboBoxModel<IngredientCategory> {

    private List<IngredientCategory> data;
    private IngredientCategory selectedItem;

    public IngredientCategoryComboBox(List<IngredientCategory> data) {
        this.data = data;
    }

    public IngredientCategoryComboBox() {
    }

    public void add(List<IngredientCategory> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public IngredientCategory getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(IngredientCategory)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}

