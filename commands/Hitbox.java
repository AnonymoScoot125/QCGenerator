package commands;

import controls.IntegerTextField;
import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class Hitbox extends Command {
    private static final String COMMAND_NAME = "$hbox";
    private static final String LABEL_GROUP_NUMBER = "Group number";
    private static final String LABEL_BONE_NAME = "Bone name";
    private static final String LABEL_MIN_X = "Min X";
    private static final String LABEL_MIN_Y = "Min Y";
    private static final String LABEL_MIN_Z = "Min Z";
    private static final String LABEL_MAX_X = "Max X";
    private static final String LABEL_MAX_Y = "Max Y";
    private static final String LABEL_MAX_Z = "Max Z";
    private static final int DEFAULT_GROUP_NUMBER = 0;
    private static final String DEFAULT_BONE_NAME = "__bone_name";
    private static final int DEFAULT_MIN_X = 0;
    private static final int DEFAULT_MIN_Y = 0;
    private static final int DEFAULT_MIN_Z = 0;
    private static final int DEFAULT_MAX_X = 0;
    private static final int DEFAULT_MAX_Y = 0;
    private static final int DEFAULT_MAX_Z = 0;

    private TitledPane titledPane = new TitledPane();
    private IntegerTextField groupNumberIntegerTextField = new IntegerTextField(LABEL_GROUP_NUMBER,
            DEFAULT_GROUP_NUMBER);
    private LabeledTextField boneNameTextField = new LabeledTextField(LABEL_BONE_NAME, DEFAULT_BONE_NAME);
    private IntegerTextField minXIntegerTextField = new IntegerTextField(LABEL_MIN_X, DEFAULT_MAX_X);
    private IntegerTextField minYIntegerTextField = new IntegerTextField(LABEL_MIN_Y, DEFAULT_MAX_Y);
    private IntegerTextField minZIntegerTextField = new IntegerTextField(LABEL_MIN_Z, DEFAULT_MAX_Z);
    private IntegerTextField maxXIntegerTextField = new IntegerTextField(LABEL_MAX_X, DEFAULT_MIN_X);
    private IntegerTextField maxYIntegerTextField = new IntegerTextField(LABEL_MAX_Y, DEFAULT_MIN_Y);
    private IntegerTextField maxZIntegerTextField = new IntegerTextField(LABEL_MAX_Z, DEFAULT_MIN_Z);
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(
                groupNumberIntegerTextField.getControlNode(),
                boneNameTextField.getControlNode(),
                minXIntegerTextField.getControlNode(),
                minYIntegerTextField.getControlNode(),
                minZIntegerTextField.getControlNode(),
                maxXIntegerTextField.getControlNode(),
                maxYIntegerTextField.getControlNode(),
                maxZIntegerTextField.getControlNode());
    }

    public Hitbox() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t"
                + groupNumberIntegerTextField.getValue() + "\t"
                + boneNameTextField.getText() + "\t"
                + minXIntegerTextField.getValue() + "\t"
                + minYIntegerTextField.getValue() + "\t"
                + minZIntegerTextField.getValue() + "\t"
                + maxXIntegerTextField.getValue() + "\t"
                + maxYIntegerTextField.getValue() + "\t"
                + maxZIntegerTextField.getValue() + "\t";
    }

}
