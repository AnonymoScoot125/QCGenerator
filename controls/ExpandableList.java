package controls;

import java.util.ArrayList;
import java.util.function.Supplier;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ExpandableList<T extends Control> extends Control {

    private Button addButton = new Button("+");
    private Supplier<T> supplier;
    private String name;
    private VBox vBox = new VBox(addButton);
    private ArrayList<T> arrayList = new ArrayList<>();

    {
        this.addButton.setOnAction(e -> {
            add(supplier.get());
        });
    }

    public ExpandableList(Supplier<T> supplier) {
        this(supplier, "");
    }

    public ExpandableList(Supplier<T> supplier, String name) {
        this.supplier = supplier;
        this.name = name;
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

    @Override
    public String toString() {
        StringBuilder sbBlock = new StringBuilder("{\n");

        if (!name.isEmpty())
            sbBlock.insert(0, this.name + "\t");

        for (Control control : arrayList) {
            sbBlock.append(control.toString() + "\n");
        }

        sbBlock.append("}\n");

        return sbBlock.toString();
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
