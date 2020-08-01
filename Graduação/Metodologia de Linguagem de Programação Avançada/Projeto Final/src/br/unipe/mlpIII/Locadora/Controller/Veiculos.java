package br.unipe.mlpIII.Locadora.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.unipe.mlpIII.Locadora.DAO.VeiculoDAO;
import br.unipe.mlpIII.Locadora.Model.Veiculo;
import br.unipe.mlpIII.Locadora.Utils.MessageBoxes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Veiculos implements Initializable {
	@FXML
	private TableView<Veiculo> tblVwVeiculos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		VeiculoDAO veiculos = new VeiculoDAO();
		if (veiculos != null) {
			for (String colName : veiculos.metaData("")) {
				TableColumn<Veiculo, String> col = new TableColumn<Veiculo, String>(colName);
				col.setCellValueFactory(new PropertyValueFactory<Veiculo, String>(colName));
				col.setMinWidth(80);
				col.setPrefWidth(110);
				col.setMaxWidth(150);
				// if (colName.equals("CodC")) col.setVisible(false);
				tblVwVeiculos.getColumns().add(col);
			}
			ObservableList<Veiculo> dados = FXCollections.observableArrayList();
			dados.addAll(veiculos.getVeiculos());
			tblVwVeiculos.setItems(dados);
		} else
			MessageBoxes.Crit("Sistema", "Não foi possível conectar ao banco de dados.", "Erro SQL");
	}
}
