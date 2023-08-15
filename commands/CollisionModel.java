package commands;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import controls.Control;
import controls.ExpandableList;
import controls.IntegerTextField;
import controls.LabeledTextField;
import controls.OptionParameter;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class CollisionModel extends Command {

    private static final String COMMAND_NAME = "$collisionmodel";
    private static final String LABEL_COLLISION_MESH = "Collision Model";
    private static final String DEFAULT_COLLISION_MESH = "__collision_model";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField meshTextField = new LabeledTextField(LABEL_COLLISION_MESH, DEFAULT_COLLISION_MESH);
    private ExpandableList<OptionParameter> expandableList = new ExpandableList<>(
            () -> new OptionParameter(getOptions()));
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(meshTextField.getControlNode(), expandableList.getControlNode());
    }

    public CollisionModel() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                COMMAND_NAME + "\t" + inQuotes(meshTextField.getText()) + "\n" + expandableList.toString());

        return sb.toString();
    }

    private Map<String, Supplier<Control>> getOptions() {
        Map<String, Supplier<Control>> map = new LinkedHashMap<>();
        map.put("$mass", () -> new IntegerTextField("Mass", 1));
        map.put("$automass", () -> null);
        map.put("$concave", () -> null);
        map.put("$maxconvexpieces", () -> new IntegerTextField("Maximum convex pieces", 1));
        map.put("$masscenter", () -> null);
        map.put("$inertia", () -> null);
        map.put("$damping", () -> null);
        map.put("$rotdamping", () -> null);
        map.put("$drag", () -> null);
        map.put("$jointskip", () -> null);
        map.put("$jointmerge", () -> null);
        map.put("$jointinertia", () -> null);
        map.put("$jointdamping", () -> null);
        map.put("$jointmassbias", () -> null);
        map.put("$jointrotdamping", () -> null);
        map.put("$jointcollide", () -> null);
        map.put("$jointconstrain", () -> null);
        map.put("$rootbone", () -> null);
        map.put("$noselfcollisions", () -> null);
        map.put("$animatedfriction", () -> null);
        map.put("$addconvexsrc", () -> null);
        map.put("$remove2d", () -> null);
        map.put("$weldposition", () -> null);
        map.put("$weldnormal", () -> null);
        map.put("$assumeworldspace", () -> null);

        return map;
    }

}
