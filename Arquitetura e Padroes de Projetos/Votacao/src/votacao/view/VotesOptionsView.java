package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import controller.VotesController;

public class VotesOptionsView extends Frame implements ActionListener {
	private static final long serialVersionUID = 8469792198491541243L;

	private VotesController votos = new VotesController();
	private VotesResults results;
	private VotesPercentuals percentuals;
	private VotesResultsWithPercentuals resultsPercentuals;

	public VotesOptionsView() {
		super("Tela de Votacao - Enquete");
		this.setLocation(120, 120);
		
		for(String n : Arrays.asList("Lula", "Temer", "FHC", "Marina"))
			votos.adicionaOpcao(n);
		
		criarBotoes();

		this.setSize(100, 120);
		this.setLayout(new GridLayout(0, 1));

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		});

		this.setVisible(true);
		results = new VotesResults(this);
		percentuals = new VotesPercentuals(this);
		resultsPercentuals = new VotesResultsWithPercentuals(this);
	}

	public void criarBotoes() {
		for (String opcao : votos.opcoes()) {
			Button botao;
			botao = new Button(opcao);
			botao.setActionCommand(opcao);
			botao.addActionListener(this);
			this.add(botao);
		}
	}

	public void actionPerformed(ActionEvent event) {
		String opcao = event.getActionCommand();
		if(opcao != null){
			votos.votarEm(opcao); 
			results.novoVoto(opcao, votos.votosOpcao(opcao));
			percentuals.atualizar();
			resultsPercentuals.atualizar();
		}
	}

}