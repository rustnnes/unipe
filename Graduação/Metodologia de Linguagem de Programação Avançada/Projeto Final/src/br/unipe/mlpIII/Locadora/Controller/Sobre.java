package br.unipe.mlpIII.Locadora.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.unipe.mlpIII.Locadora.View.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class Sobre implements Initializable {

	//	@FXML
	//	private Button		btnOk;
	@FXML
	private WebView		wbVwSobre;
	@FXML
	private AnchorPane	ancPnSobre;

	private String		htmlContent	= "";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//		btnOk.addEventHandler(ActionEvent.ACTION, new EventHandler <ActionEvent>() {
		//			@Override
		//			public void handle(ActionEvent event) {
		//				Stage stage = (Stage) btnOk.getScene().getWindow();
		//				stage.close();
		//			}
		//		});

		wbVwSobre.getEngine().setUserStyleSheetLocation(Main.class.getResource("webview.css").toExternalForm());

		htmlContent  = "<html>";
		htmlContent += "<head></head>";
		htmlContent += "<body>";
		htmlContent += "<p class='projeto'>Projeto Locadora e Seguros</p>";
		htmlContent += "<p class='descricao'>Gerenciador de Seguros e Locação de veículos</p>";
		htmlContent += "<p class='alunos'>Alunos:</p>";
		htmlContent += "<ul>";
		htmlContent += "<li>Diego Bandeira</li>";
		htmlContent += "<li>Diego Paiva</li>";
		//htmlContent += "<li>Edyara Araújo</li>";
		htmlContent += "</ul>";
		htmlContent += "</body>";
		htmlContent += "</html>";

		wbVwSobre.getEngine().loadContent(htmlContent);
	}

}
