package controls;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class LabeledTextField extends Control {
    private String defaultValue;
    private Label label = new Label();
    private TextField textField = new TextField();
    private HBox hBox = new HBox(label, textField);

    {
        this.hBox.setAlignment(Pos.CENTER_LEFT);
    }

    public LabeledTextField(String text, String defaultValue) {
        this.label.setText(text);
        this.defaultValue = defaultValue;
    }

    public String getText() {
        return textField.getText().isEmpty() ? defaultValue : textField.getText();
    }

    @Override
    public Node getControlNode() {
        return hBox;
    }

    @Override
    public String toString() {
        return getText();
    }

}
