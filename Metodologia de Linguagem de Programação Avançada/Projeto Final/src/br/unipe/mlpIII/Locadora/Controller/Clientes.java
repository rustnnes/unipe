package br.unipe.mlpIII.Locadora.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.unipe.mlpIII.Locadora.DAO.ClienteDAO;
import br.unipe.mlpIII.Locadora.Model.Cliente;
import br.unipe.mlpIII.Locadora.Utils.MessageBoxes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Clientes implements Initializable {
	@FXML
	private TableView<Cliente> tblVwClientes;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ClienteDAO clientes = new ClienteDAO();
		if (clientes != null) {
			for (String colName : clientes.metaData("")) {
				TableColumn<Cliente, String> col = new TableColumn<Cliente, String>(colName);
				col.setCellValueFactory(new PropertyValueFactory<Cliente, String>(colName));
				col.setMinWidth(80);
				col.setPrefWidth(110);
				col.setMaxWidth(150);
				// if (colName.equals("CodC")) col.setVisible(false);
				tblVwClientes.getColumns().add(col);
			}
			ObservableList<Cliente> dados = FXCollections.observableArrayList();
			dados.addAll(clientes.getClientes());
			tblVwClientes.setItems(dados);
		} else
			MessageBoxes.Crit("Sistema", "Não foi possível conectar ao banco de dados.", "Erro SQL");
	}
}
