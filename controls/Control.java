package controls;

import javafx.scene.Node;

public abstract class Control {
    public abstract Node getControlNode();

    public abstract String toString();

    protected String inQuotes(String inpuString) {
        return "\"" + inpuString + "\"";
    }

    protected String inQuotes(Boolean inputBoolean) {
        return "\"" + inputBoolean.toString() + "\"";
    }

    protected String inQuotes(Integer inputInteger) {
        return "\"" + inputInteger.toString() + "\"";
    }

    protected String formatFileName(String inpuString, String fileName) {
        if (inpuString.endsWith(fileName))
            return inpuString;
        else
            return inpuString + fileName;
    }

    protected String inBlock(String inpuString) {
        return "{\n" + inpuString + "\n}";
    }
}
