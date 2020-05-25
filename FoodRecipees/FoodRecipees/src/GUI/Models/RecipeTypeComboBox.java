
package GUI.Models;

import BL.RecipeType;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class RecipeTypeComboBox extends AbstractListModel<RecipeType> implements ComboBoxModel<RecipeType> {

    private List<RecipeType> data;
    private RecipeType selectedItem;

    public RecipeTypeComboBox(List<RecipeType> data) {
        this.data = data;
    }

    public RecipeTypeComboBox() {
    }

    public void add(List<RecipeType> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public RecipeType getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(RecipeType)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}

