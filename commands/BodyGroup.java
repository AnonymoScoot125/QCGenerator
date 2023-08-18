package commands;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import controls.Control;
import controls.ExpandableList;
import controls.LabeledTextField;
import controls.OptionParameter;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class BodyGroup extends Command {

    private static final String COMMAND_NAME = "$bodygroup";
    private static final String LABEL_BODY_GROUP = "Body Group";
    private static final String LABEL_GROUP = "Group";
    private static final String DEFAULT_BODY_GROUP = "__body_group";
    private static final String DEFAULT_GROUP = "__group";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField nameTextField = new LabeledTextField(LABEL_BODY_GROUP, DEFAULT_BODY_GROUP);
    private ExpandableList<OptionParameter> expandableList = new ExpandableList<>(
            () -> new OptionParameter(getOptions()));
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
        return COMMAND_NAME + "\t" + nameTextField.getText() + "\n" + expandableList.toString();
    }

    private Map<String, Supplier<Control>> getOptions() {
        Map<String, Supplier<Control>> map = new LinkedHashMap<>();
        map.put("studio", () -> new LabeledTextField(LABEL_GROUP, DEFAULT_GROUP));
        map.put("blank", () -> null);

        return map;
    }

}
