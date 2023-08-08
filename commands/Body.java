package commands;

import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class Body extends Command {

    private static final String COMMAND_NAME = "$body";
    private static final String LABEL_NAME = "Name";
    private static final String LABEL_REFERENCE_MESH = "Reference Mesh";
    private static final String LABEL_REVERSE = "Reverse";
    private static final String LABEL_SCALE = "Scale";
    private static final String DEFAULT_NAME = "__name";
    private static final String DEFAULT_REFERENCE_MESH = "__reference_mesh";
    private static final String DEFAULT_REVERSE = "__reverse";
    private static final String DEFAULT_SCALE = "__scale";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField nameTextField = new LabeledTextField(LABEL_NAME, DEFAULT_NAME);
    private LabeledTextField meshTextField = new LabeledTextField(LABEL_REFERENCE_MESH, DEFAULT_REFERENCE_MESH);
    private LabeledTextField reverseTextField = new LabeledTextField(LABEL_REVERSE, DEFAULT_REVERSE);
    private LabeledTextField scaleTextField = new LabeledTextField(LABEL_SCALE, DEFAULT_SCALE);
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(nameTextField.getControlNode(), meshTextField.getControlNode(),
                reverseTextField.getControlNode(), scaleTextField.getControlNode());
    }

    public Body() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {

        if (meshTextField.getText().endsWith(".smd"))
            return COMMAND_NAME + "\t" + inQuotes(nameTextField.getText()) + "\t" + inQuotes(meshTextField.getText())
                    + "\t" + inQuotes(reverseTextField.getText()) + "\t" + inQuotes(scaleTextField.getText());
        else
            return COMMAND_NAME + "\t" + inQuotes(nameTextField.getText()) + "\t"
                    + inQuotes(meshTextField.getText() + ".smd")
                    + "\t" + inQuotes(reverseTextField.getText()) + "\t" + inQuotes(scaleTextField.getText());
    }

}
