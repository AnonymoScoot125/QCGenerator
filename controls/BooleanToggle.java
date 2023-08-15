package controls;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

public class BooleanToggle extends Control {
    private boolean defaultValue;
    private Label label = new Label();
    private ToggleButton toggleButton = new ToggleButton();
    private HBox hBox = new HBox(label, toggleButton);

    {
        this.hBox.setAlignment(Pos.CENTER_LEFT);
        this.toggleButton.setOnAction(e -> {
            if (toggleButton.isSelected()) {
                toggleButton.setText("true");
            } else {
                toggleButton.setText("false");
            }
        });
    }

    public BooleanToggle(String text, boolean defaultValue) {
        this.label.setText(text);
        this.defaultValue = defaultValue;

        if (this.defaultValue) {
            toggleButton.setText("true");
            toggleButton.setSelected(true);
        } else {
            toggleButton.setText("false");
            toggleButton.setSelected(false);
        }

    }

    public boolean getValue() {
        return toggleButton.isSelected();
    }

    @Override
    public Node getControlNode() {
        return hBox;
    }

    @Override
    public String toString() {
        return toggleButton.isSelected() ? "true" : "false";
    }

}
