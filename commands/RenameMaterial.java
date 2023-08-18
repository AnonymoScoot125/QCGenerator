package commands;

import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class RenameMaterial extends Command {

    private static final String COMMAND_NAME = "$renamematerial";
    private static final String LABEL_CURRENT_MATERIAL = "Current Material";
    private static final String LABEL_NEW_MATERIAL = "New Material";
    private static final String DEFAULT_CURRENT_MATERIAL = "__current_material";
    private static final String DEFAULT_NEW_MATERIAL = "__new_material";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField currentMaterialTextField = new LabeledTextField(LABEL_CURRENT_MATERIAL,
            DEFAULT_CURRENT_MATERIAL);
    private LabeledTextField newMaterialTextField = new LabeledTextField(LABEL_NEW_MATERIAL, DEFAULT_NEW_MATERIAL);
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(currentMaterialTextField.getControlNode(),
                newMaterialTextField.getControlNode());
    }

    public RenameMaterial() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + currentMaterialTextField.getText() + "\t"
                + newMaterialTextField.getText();
    }

}
