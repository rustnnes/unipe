package controller;

import java.text.NumberFormat;
import java.util.List;

import model.Votes;

public class VotesController {
	private Votes votes = Votes.getInstance();
	private NumberFormat nf = NumberFormat.getPercentInstance();

	public VotesController() {
		nf.setMaximumFractionDigits(3);
		nf.setMinimumFractionDigits(2);
	}

	public void adicionaOpcao(String s) {
		votes.addOption(s);
	}

	public void votarEm(String s) {
		votes.voteFor(s);
	}

	public int votosOpcao(String s) {
		return votes.getOptionVotes(s);
	}

	public double votosOpcaoPct(String s) {
		if (votes.isEmpty() || votes.zeroVotes())
			return 0D;
		else {
			double oV = new Double(votes.getOptionVotes(s));
			double tV = new Double(votes.getTotalVotes());
			return oV / tV;
		}
	}

	public String votosOpcaoPctFmt(String s) {
		return nf.format(votosOpcaoPct(s));
	}

	public int totalVotos() {
		return votes.getTotalVotes();
	}

	public List<String> opcoes() {
		return votes.Options();
	}
}
