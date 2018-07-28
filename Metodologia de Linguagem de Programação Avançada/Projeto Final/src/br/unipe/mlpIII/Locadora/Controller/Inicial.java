package br.unipe.mlpIII.Locadora.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.unipe.mlpIII.Locadora.Utils.LoginManager;
import br.unipe.mlpIII.Locadora.Utils.Windows;
import br.unipe.mlpIII.Locadora.View.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class Inicial implements Initializable {

	@FXML
	private Menu mnuClientes;
	@FXML
	private MenuItem mnuItVerClientes;
	@FXML
	private Menu mnuVeiculos;
	@FXML
	private MenuItem mnuVerVeiculos;
	@FXML
	private Menu mnuAjuda;
	@FXML
	private MenuItem mnuSite;
	@FXML
	private MenuItem mnuSobre;
	@FXML
	private Button btnLogout;
	@FXML
	private Label lblUser;
	@FXML
	private AnchorPane ancPnMain;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mnuItVerClientes.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Windows.open(Main.class, Main.getPrimaryStage(), Main.getRootDir("/View/Clientes.fxml"),
						"application.css", "Clientes", "clientes.png", true, false).show();
				event.consume();
			}
		});

		mnuVerVeiculos.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//todo icone veiculos
				Windows.open(Main.class, Main.getPrimaryStage(), Main.getRootDir("/View/Veiculos.fxml"),
						"application.css", "Veículos", "clientes.png", true, false).show();
				event.consume();
			}
		});
		
		mnuSobre.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Windows.open(Main.class, Main.getPrimaryStage(), Main.getRootDir("/View/Sobre.fxml"), "application.css",
						"Sobre", "sobre.png", true, false).show();
				event.consume();
			}
		});
	}
	public void init(final LoginManager loginManager) {
	    lblUser.setText(loginManager.getLoggedUser().getUsr());
		btnLogout.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loginManager.logout();
			}
		});
	  }
}
