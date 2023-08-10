package controls;

import java.util.ArrayList;
import java.util.function.Supplier;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ExpandableList<T extends Control> extends Control {

    private Button addButton = new Button("+");
    private Supplier<T> supplier;
    private VBox vBox = new VBox(addButton);
    private ArrayList<T> arrayList = new ArrayList<>();

    {
        this.addButton.setOnAction(e -> {
            add(supplier.get());
        });
    }

    public ExpandableList(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public void add(T control) {
        ListEntry entry = new ListEntry(control);
        arrayList.add(entry.controlElement);
        vBox.getChildren().add(entry.getNode());
    }

    public void remove(ListEntry entry) {
        arrayList.remove(entry.controlElement);
        int currentIndex = vBox.getChildren().indexOf(entry.getNode());
        vBox.getChildren().remove(currentIndex);
    }

    public ArrayList<T> getControls() {
        return arrayList;
    }

    @Override
    public Node getControlNode() {
        return vBox;
    }

    private class ListEntry {
        private Button removeButton = new Button("-");
        private HBox hBox = new HBox(removeButton);
        public T controlElement;

        {
            this.removeButton.setOnAction(e -> {
                remove(this);
            });
        }

        public ListEntry(T controlElement) {
            this.controlElement = controlElement;
            this.hBox.getChildren().add(controlElement.getControlNode());
        }

        public Node getNode() {
            return hBox;
        }
    }

}
