package commands;

import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class JointSurfaceProp extends Command {

    private static final String COMMAND_NAME = "$jointsurfaceprop";
    private static final String LABEL_BONE_NAME = "Bone Name";
    private static final String LABEL_SURFACE_PROP = "Surface Prop";
    private static final String DEFAULT_BONE_NAME = "__bone_name";
    private static final String DEFAULT_SURFACE_PROP = "__surface_prop";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField currentMaterialTextField = new LabeledTextField(LABEL_BONE_NAME,
            DEFAULT_BONE_NAME);
    private LabeledTextField newMaterialTextField = new LabeledTextField(LABEL_SURFACE_PROP, DEFAULT_SURFACE_PROP);
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(currentMaterialTextField.getControlNode(),
                newMaterialTextField.getControlNode());
    }

    public JointSurfaceProp() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + inQuotes(currentMaterialTextField.getText()) + "\t"
                + inQuotes(newMaterialTextField.getText());
    }

}
