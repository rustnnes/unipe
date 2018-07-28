package view;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import controller.VotesController;

public class VotesResults extends Window {

	private static final long serialVersionUID = 1419327257088158831L;
	private VotesController votos = new VotesController();
	private Map<String, Label> labels = new HashMap<String, Label>();

	public VotesResults(Frame parent) {
		super(parent);
		this.setSize(110, 120);
		this.setLocation(300, 120);

		this.setLayout(new GridLayout(0, 2)); // Grid com qualquer numero de linhas e duas colunas

		this.add(new Label("Votos"));
		this.add(new Label());
		
		this.inicializar();
		this.setVisible(true);
	}

	// Recebe a lista de opcoes inicial
	public void inicializar() {
		Label nome, nVotos;
		for (String opcao : votos.opcoes()) {
			if (!labels.containsKey(opcao)) {
				nome = new Label(opcao);
				nVotos = new Label("" + 0);
				labels.put(opcao, nVotos);
				this.add(nome);
				this.add(nVotos);
			}
		}
	}

	public void novoVoto(String opcao, int nvotos) {
		labels.get(opcao).setText(Integer.toString(nvotos));
	}
}