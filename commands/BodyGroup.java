package commands;

import controls.ExpandableList;
import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class BodyGroup extends Command {

    private static final String COMMAND_NAME = "$bodygroup";
    private static final String LABEL_BODY_GROUP = "Body Group";
    private static final String LABEL_GROUP = "Group";
    private static final String DEFAULT_BODY_GROUP = "__body_group";
    private static final String DEFAULT_GROUP = "";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField nameTextField = new LabeledTextField(LABEL_BODY_GROUP, DEFAULT_BODY_GROUP);
    private ExpandableList<LabeledTextField> expandableList = new ExpandableList<>(
            () -> new LabeledTextField(LABEL_GROUP, DEFAULT_GROUP));
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(nameTextField.getControlNode(), expandableList.getControlNode());
    }

    public BodyGroup() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        StringBuilder sbCommand = new StringBuilder(COMMAND_NAME + "\t" + inQuotes(nameTextField.getText()) + "\n");
        StringBuilder sbBlock = new StringBuilder();

        for (LabeledTextField s : expandableList.getControls()) {
            if (s.getText().isEmpty()) {
                sbBlock.append("\tblank\n");
            } else {
                sbBlock.append("\tstudio\t" + inQuotes(s.getText()) + "\n");
            }
        }
        if (!sbBlock.isEmpty())
            sbBlock.deleteCharAt(sbBlock.length() - 1);

        return sbCommand.append(inBlock(sbBlock.toString())).toString();
    }

}
