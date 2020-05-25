
package GUI.Models;

import BL.UnitDetails;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class UnitDetailsComboBox extends AbstractListModel<UnitDetails> implements ComboBoxModel<UnitDetails> {

    private List<UnitDetails> data;
    private UnitDetails selectedItem;

    public UnitDetailsComboBox(List<UnitDetails> data) {
        this.data = data;
    }

    public UnitDetailsComboBox() {
    }

    public void add(List<UnitDetails> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public UnitDetails getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(UnitDetails)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}

