
package GUI.Models;

import BL.Ingredient;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class IngredientComboBox extends AbstractListModel<Ingredient> implements ComboBoxModel<Ingredient> {

    private List<Ingredient> data;
    private Ingredient selectedItem;

    public IngredientComboBox(List<Ingredient> data) {
        this.data = data;
    }

    public IngredientComboBox() {
    }

    public void add(List<Ingredient> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Ingredient getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Ingredient)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}

