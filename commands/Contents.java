package commands;

import controls.ExpandableList;
import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class Contents extends Command {
    private static final String COMMAND_NAME = "$contents";
    private static final String LABEL_CONTENTS = "Contents";
    private static final String DEFAULT_CONTENTS = "__contents";

    private TitledPane titledPane = new TitledPane();
    private ExpandableList<LabeledTextField> expandableList = new ExpandableList<>(
            () -> new LabeledTextField(LABEL_CONTENTS, DEFAULT_CONTENTS));
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(expandableList.getControlNode());
    }

    public Contents() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + expandableList.toString();
    }

}
