package commands;

public class Modelname extends Command {

    private static final String DEFAULT_NAME = "NAME";

    public Modelname() {
        super("modelname");
    }

    @Override
    public String toString() {
        return DEFAULT_NAME;
    }

}
