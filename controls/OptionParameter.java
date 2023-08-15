package controls;

import java.util.Map;
import java.util.function.Supplier;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class OptionParameter extends Control {
    private ComboBox<String> comboBox = new ComboBox<>();
    private Control control;
    private String command;
    private VBox vBox = new VBox(comboBox);

    public OptionParameter(Map<String, Supplier<Control>> map) {
        for (Map.Entry<String, Supplier<Control>> entry : map.entrySet()) {
            comboBox.getItems().add(entry.getKey());
        }
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.command = newValue;
            this.control = map.get(newValue).get();
            vBox.getChildren().clear();
            vBox.getChildren().add(comboBox);
            if (this.control != null)
                vBox.getChildren().add(control.getControlNode());
        });
    }

    @Override
    public Node getControlNode() {
        return vBox;
    }

    @Override
    public String toString() {
        if (this.control != null)
            return command + "\t" + control.toString();
        else
            return command;
    }

}
