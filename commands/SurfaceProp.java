package commands;

import controls.LabeledTextField;
import javafx.scene.control.TitledPane;

public class SurfaceProp extends Command {

    private static final String COMMAND_NAME = "$surfaceprop";
    private static final String LABEL_SURFACE_PROP = "Surface Prop";
    private static final String DEFAULT_SURFACE_PROP = "__surface_prop";

    private TitledPane titledPane = new TitledPane();
    private LabeledTextField surfacePropTextField = new LabeledTextField(LABEL_SURFACE_PROP,
            DEFAULT_SURFACE_PROP);

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(surfacePropTextField.getControlNode());
    }

    public SurfaceProp() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + inQuotes(surfacePropTextField.getText());
    }

}
