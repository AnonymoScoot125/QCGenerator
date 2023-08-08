package commands;

import controls.LabeledTextField;
import javafx.scene.control.TitledPane;

public class Modelname extends Command {

    private static final String COMMAND_NAME = "$modelname";
    private static final String LABEL_NAME = "Filepath";
    private static final String DEFAULT_VALUE = "__default.mdl";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField textField = new LabeledTextField(LABEL_NAME, DEFAULT_VALUE);

    {
        super.addCommandNode(titledPane);
        this.titledPane.setAnimated(false);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setContent(textField.getControlNode());
    }

    public Modelname() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        if (textField.getText().endsWith(".mdl"))
            return COMMAND_NAME + "\t" + inQuotes(textField.getText());
        else
            return COMMAND_NAME + "\t" + inQuotes(textField.getText() + ".mdl");
    }

}
