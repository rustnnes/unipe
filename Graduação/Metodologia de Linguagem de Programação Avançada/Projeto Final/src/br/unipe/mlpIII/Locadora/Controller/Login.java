package br.unipe.mlpIII.Locadora.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.unipe.mlpIII.Locadora.Utils.LoginManager;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Login implements Initializable {

	@FXML
	private TextField txtUsr;
	@FXML
	private TextField txtPwd;
	@FXML
	private Button btnSair;
	@FXML
	private Button btnEntrar;
	@FXML
	private Label lblMessage;
	@FXML
	private AnchorPane ancPnLogin;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	private void animateMessage(Node node, double from, double to, double during) {
		FadeTransition ft = new FadeTransition(new Duration(during), node);
		ft.setFromValue(from);
		ft.setToValue(to);
		ft.play();
	}

	public void init(final LoginManager loginManager) {
		btnSair.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				Platform.exit();
			}
		});

		btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				Credentials cr = new Credentials(txtUsr.getText(), txtPwd.getText());
//				if (loginManager.authorize(cr)) {
				if (loginManager.authorize(txtUsr.getText(), txtPwd.getText())) {
					lblMessage.setOpacity(0);
					loginManager.authenticated();
				} else {
					animateMessage(lblMessage, 0, 1, 1500);
				}
			}
		});

		txtUsr.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				lblMessage.setOpacity(0);
			}
		});
	}



}
