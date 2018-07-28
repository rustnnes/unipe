package br.unipe.mlpIII.Locadora.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import br.unipe.mlpIII.Locadora.Utils.LoginManager;
import br.unipe.mlpIII.Locadora.Utils.MessageBoxes;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	private static String rootDir = "/br/unipe/mlpIII/Locadora";
	private static Properties props;

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static String getRootDir(String s) {
		return rootDir + (s == null ? "" : s);
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}

	public static Properties getProperties() {
		try {
			if (props == null) props = new Properties();
			props.loadFromXML(new FileInputStream("database.properties"));
		} catch (InvalidPropertiesFormatException e) {
			MessageBoxes.Crit("Sistema", e.getMessage(), "Propriedades inválidas");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			MessageBoxes.Crit("Sistema", e.getMessage(), "Arquivo não encontrado!");
			e.printStackTrace();
		} catch (IOException e) {
			MessageBoxes.Crit("Sistema", e.getMessage(), "Falha I/O!");
			e.printStackTrace();
		}
		return props;
	}

	@Override
	public void start(Stage stage) {
		try {
			Main.primaryStage = stage;
			// LoginManager loginManager = new LoginManager(getPrimaryStage());
			new LoginManager(getPrimaryStage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}