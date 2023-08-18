package commands;

import controls.BooleanToggle;
import controls.IntegerTextField;
import controls.LabeledTextField;
import controls.TextFieldFolderPath;
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
    private static final String DEFAULT_REFERENCE_FOLDER = null;
    private static final String DEFAULT_FILE_EXTENSION = ".smd";
    private static final boolean DEFAULT_REVERSE = false;
    private static final int DEFAULT_SCALE = 1;

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField nameTextField = new LabeledTextField(LABEL_NAME, DEFAULT_NAME);
    private TextFieldFolderPath meshTextField = new TextFieldFolderPath(LABEL_REFERENCE_MESH, DEFAULT_REFERENCE_MESH,
            DEFAULT_REFERENCE_FOLDER, DEFAULT_FILE_EXTENSION);
    private BooleanToggle reverseBooleanToggle = new BooleanToggle(LABEL_REVERSE, DEFAULT_REVERSE);
    private IntegerTextField scaleIntegerTextField = new IntegerTextField(LABEL_SCALE, DEFAULT_SCALE);
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(nameTextField.getControlNode(), meshTextField.getControlNode(),
                reverseBooleanToggle.getControlNode(), scaleIntegerTextField.getControlNode());
    }

    public Body() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + nameTextField.getText() + "\t" + meshTextField.getText() + "\t"
                + reverseBooleanToggle.getValue() + "\t" + scaleIntegerTextField.getValue();
    }

}
