package commands;

import controls.LabeledTextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class HitboxSet extends Command {
    private static final String COMMAND_NAME = "$hboxset";
    private static final String LABEL_SET = "Hitbox set";
    private static final String DEFAULT_SET = "__hitbox_set";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField hitboxSetTextField = new LabeledTextField(LABEL_SET, DEFAULT_SET);
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(hitboxSetTextField.getControlNode());
    }

    public HitboxSet() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + hitboxSetTextField.getText();
    }

}
