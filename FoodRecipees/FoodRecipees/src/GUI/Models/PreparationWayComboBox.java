
package GUI.Models;

import BL.PreparationWay;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class PreparationWayComboBox extends AbstractListModel<PreparationWay> implements ComboBoxModel<PreparationWay> {

    private List<PreparationWay> data;
    private PreparationWay selectedItem;

    public PreparationWayComboBox(List<PreparationWay> data) {
        this.data = data;
    }

    public PreparationWayComboBox() {
    }

    public void add(List<PreparationWay> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public PreparationWay getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(PreparationWay)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}

