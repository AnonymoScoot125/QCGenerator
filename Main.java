import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.Command;

public class Main {
    private static List<Command> commandList = new ArrayList<>();

    public Main() {
    }

    public static void printQCFile() {

        try {
            FileWriter fileWriter = new FileWriter("output\\output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Command command : commandList)
                bufferedWriter.write(command.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Input/Output exception when generating QC file.");
        }

    }

    public static void main(String[] args) {
        commandList.add(new Command("modelname"));
        printQCFile();
    }

}