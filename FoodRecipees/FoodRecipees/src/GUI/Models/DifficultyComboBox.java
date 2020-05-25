
package GUI.Models;

import BL.Difficulty;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class DifficultyComboBox extends AbstractListModel<Difficulty> implements ComboBoxModel<Difficulty> {

    private List<Difficulty> data;
    private Difficulty selectedItem;

    public DifficultyComboBox(List<Difficulty> data) {
        this.data = data;
    }

    public DifficultyComboBox() {
    }

    public void add(List<Difficulty> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Difficulty getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Difficulty)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}

