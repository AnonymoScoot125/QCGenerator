import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import tabs.*;

public class Main extends Application {
	private static VBox rootPanel = new VBox();
	private static MenuBar menuBar = new MenuBar();
	private static TabPane tabPane = new TabPane();

	static {

		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu helpMenu = new Menu("Help");
		MenuItem newItem = new MenuItem("New");
		MenuItem openItem = new MenuItem("Open");
		MenuItem saveItem = new MenuItem("Save");
		MenuItem exitItem = new MenuItem("Exit");

		saveItem.setOnAction(e -> {
			printQCFile();
		});

		fileMenu.getItems().addAll(newItem, openItem, saveItem, exitItem);
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

		Tab tab = new Tab("Fundementals");
		Tab tab2 = new Tab("Collisions");
		Tab tab3 = new Tab("Animations");

		tab.setContent(FundementalTab.getBorderPane());

		tabPane.getTabs().addAll(tab, tab2, tab3);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		rootPanel.getChildren().addAll(menuBar, tabPane);
	}

	private static void printQCFile() {

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output\\output.txt"))) {
			for (String commandString : FundementalTab.getCommandsStringRepresentation())
				bufferedWriter.write(commandString + "\n");
		} catch (IOException e) {
			System.out.println("Input/Output exception when generating QC file.");
		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(rootPanel, 1000, 800);
		scene.getStylesheets().add("styles.css");
		tabPane.prefHeightProperty().bind(scene.heightProperty());
		primaryStage.setScene(scene);
		primaryStage.setTitle("QC Generator");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
