package commands;

public class Body extends Command {

    private static final String DEFAULT_NAME = "NAME";
    private static final String DEFAULT_REFERENCE_MESH = "MESH";
    private static final String DEFAULT_REVERSE = "FALSE";
    private static final String DEFAULT_SCALE = "FALSE";

    public Body() {
        super("body");
    }

    @Override
    public String toString() {
        return DEFAULT_NAME + DEFAULT_REFERENCE_MESH + DEFAULT_REVERSE + DEFAULT_SCALE;
    }

}
