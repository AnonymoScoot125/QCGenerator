package controls;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IntegerTextField extends Control {
    private int defaultValue;
    private Label label = new Label();
    private TextField integerTextField = new TextField();
    private HBox hBox = new HBox(label, integerTextField);

    {
        this.hBox.setAlignment(Pos.CENTER_LEFT);
        this.integerTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("-?\\d*")) {
                integerTextField.setText(oldValue);
            }
        });
    }

    public IntegerTextField(String text, int defaultValue) {
        this.label.setText(text);
        this.defaultValue = defaultValue;
    }

    public int getValue() {
        return integerTextField.getText().isEmpty() ? defaultValue : Integer.parseInt(integerTextField.getText());
    }

    @Override
    public Node getControlNode() {
        return hBox;
    }
}
