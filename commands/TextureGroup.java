package commands;

import controls.ExpandableList;
import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class TextureGroup extends Command {
    private static final String COMMAND_NAME = "$texturegroup";
    private static final String LABEL_TEXTURE_GROUP = "Texture Group";
    private static final String LABEL_TEXTURE = "Texture";
    private static final String DEFAULT_TEXTURE_GROUP = "__texture_group";
    private static final String DEFAULT_TEXTURE = "__texture";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField nameTextField = new LabeledTextField(LABEL_TEXTURE_GROUP, DEFAULT_TEXTURE_GROUP);
    private ExpandableList<ExpandableList<LabeledTextField>> expandableList = new ExpandableList<>(
            () -> new ExpandableList<LabeledTextField>(
                    () -> new LabeledTextField(LABEL_TEXTURE, DEFAULT_TEXTURE)));
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(nameTextField.getControlNode(), expandableList.getControlNode());
    }

    public TextureGroup() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        StringBuilder sbCommand = new StringBuilder(COMMAND_NAME + "\t" + inQuotes(nameTextField.getText()) + "\n");
        StringBuilder sbBlock = new StringBuilder();

        for (ExpandableList<LabeledTextField> list : expandableList.getControls()) {
            StringBuilder sbTextures = new StringBuilder();

            sbBlock.append("\t{ ");
            for (LabeledTextField textField : list.getControls()) {
                sbTextures.append(inQuotes(textField.getText()) + "\t");
            }
            sbBlock.append(sbTextures.toString().trim() + " }\n");
        }
        if (!sbBlock.isEmpty())
            sbBlock.deleteCharAt(sbBlock.length() - 1);

        return sbCommand.append(inBlock(sbBlock.toString())).toString();
    }
}
