package view;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.VotesController;

public class VotesResultsWithPercentuals extends Window {

	private static final long serialVersionUID = 1419327257088158831L;
	private VotesController votos = new VotesController();
	private Map<String, List<Label>> labels = new HashMap<String, List<Label>>();

	public VotesResultsWithPercentuals(Frame parent) {
		super(parent);
		this.setSize(300, 120);
		this.setLocation(600, 120);

		this.setLayout(new GridLayout(0, 3)); // Grid com qualquer numero de linhas e tres colunas

		this.add(new Label("Votos"));
		this.add(new Label());
		this.add(new Label());
		
		this.inicializar();
		this.setVisible(true);
	}

	public void inicializar() {
		Label nome, nVotos, nVotosPct;
		for (String opcao : votos.opcoes()) {
			if (!labels.containsKey(opcao)) {
				nome = new Label(opcao);
				nVotos = new Label("" + 0);
				nVotosPct = new Label("" + 0);
				labels.put(opcao, Arrays.asList(nVotos, nVotosPct));
				this.add(nome);
				this.add(nVotos);
				this.add(nVotosPct);
			}
		}
	}

	public void atualizar() {
		labels.forEach((k, v) -> {
			v.get(0).setText("" + votos.votosOpcao(k));
			v.get(1).setText(votos.votosOpcaoPctFmt(k));
		} );
	}
}