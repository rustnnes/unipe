package view;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import controller.VotesController;

public class VotesPercentuals extends Window {
	
	private static final long serialVersionUID = 6005177288936831234L;
	private VotesController votos = new VotesController();
	private Map<String, Label> labels = new HashMap<String, Label>();

	public VotesPercentuals(Frame parent) {
		super(parent);
		this.setSize(110, 120);
		this.setLocation(450, 120);
		
		this.setLayout(new GridLayout(0, 2)); // Grid com qualquer numero de linhas e duas colunas

		this.add(new Label("Votos"));
		this.add(new Label());
		
		this.inicializar();
		this.setVisible(true);
	}

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

	public void atualizar() {
		labels.forEach((k, v) -> v.setText(votos.votosOpcaoPctFmt(k)) );
	}
}