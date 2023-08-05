import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import commands.*;

public class Main extends Application {
	private static List<Command> commandList = new ArrayList<>();

	public Main() {

	}

	// private JMenuBar createJMenuBar() {
	// JMenuBar menuBar = new JMenuBar();

	// JMenu fileMenu = new JMenu("File");
	// JMenuItem generateFile = new JMenuItem("Generate QC File");
	// generateFile.addActionListener((e) -> {
	// printQCFile();
	// });

	// fileMenu.add(generateFile);
	// fileMenu.addSeparator();

	// menuBar.add(fileMenu);

	// return menuBar;
	// }

	// private JTabbedPane createTabbedPane() {
	// JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	// // JButton button = new JButton("Fundementals");
	// tabbedPane.setBounds(50, 100, 200, 200);
	// tabbedPane.add("Fundementals", new JPanel());
	// tabbedPane.add("Animations", new JPanel());
	// tabbedPane.add("Collision", new JPanel());

	// return tabbedPane;
	// }

	public static void printQCFile() {

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output\\output.txt"))) {
			for (Command command : commandList)
				bufferedWriter.write(command.getStringRepresentation() + "\n");
		} catch (IOException e) {
			System.out.println("Input/Output exception when generating QC file.");
		}

	}

	public MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu helpMenu = new Menu("Help");
		MenuItem newItem = new MenuItem("New");
		MenuItem openItem = new MenuItem("Open");
		MenuItem saveItem = new MenuItem("Save");
		MenuItem exitItem = new MenuItem("Exit");
		fileMenu.getItems().addAll(newItem, openItem, saveItem, exitItem);
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

		return menuBar;
	}

	public TabPane createTabPane() {
		TabPane tabPane = new TabPane();
		Tab tab = new Tab("Fundementals");
		Tab tab2 = new Tab("Collisions");
		Tab tab3 = new Tab("Animations");
		tabPane.getTabs().addAll(tab, tab2, tab3);

		tab.setContent(creatBorderPane());

		return tabPane;
	}

	public BorderPane creatBorderPane() {
		BorderPane borderPane = new BorderPane();
		borderPane.getStyleClass().add("border");

		FlowPane topPane = new FlowPane(new Label("Fundemental things"));
		VBox leftPane = new VBox(100, new Button("Button"), new Button("Ber"));
		VBox centerPane = new VBox(5, new Button("STYLESHEET_CASPIAN"));
		ScrollPane scrollPane = new ScrollPane(leftPane);

		topPane.getStyleClass().add("pane");
		leftPane.getStyleClass().add("pane");
		centerPane.getStyleClass().add("pane");

		leftPane.setPrefWidth(200);
		scrollPane.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);

		borderPane.setTop(topPane);
		borderPane.setLeft(scrollPane);
		borderPane.setCenter(centerPane);

		return borderPane;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TabPane tabPane = createTabPane();
		VBox root = new VBox(createMenuBar(), tabPane);

		Scene scene = new Scene(root, 1000, 800);
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