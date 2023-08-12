package commands;

import controls.ExpandableList;
import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class CollisionModel extends Command {

    private static final String COMMAND_NAME = "$bodygroup";
    private static final String LABEL_COLLISION_MESH = "Body Group";
    private static final String DEFAULT_COLLISION_MESH = "__body_group";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField nameTextField = new LabeledTextField(LABEL_COLLISION_MESH, DEFAULT_COLLISION_MESH);
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(nameTextField.getControlNode());
    }

    public CollisionModel() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return "";
    }

    private class Options {
        private LabeledTextField massParameter = new LabeledTextField(COMMAND_NAME, COMMAND_NAME);
    }

}
