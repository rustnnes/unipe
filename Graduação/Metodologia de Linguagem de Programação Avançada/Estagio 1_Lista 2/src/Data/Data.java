package Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

//arquivo: Data.java
public class Data {
	private static int anoAtual = (int) Calendar.getInstance().get(Calendar.YEAR);
	private int dia;
	private int mes;
	private int ano;

	public int getDia() { return dia; }
	public int getMes() { return mes; }
	public int getAno() { return ano; }

	public void setDia(int dia) {
		try{
			DateFormat d = SimpleDateFormat.getDateInstance(
							DateFormat.SHORT, 
							Locale.getDefault(Locale.Category.FORMAT));
			d.setLenient(false);
			d.parse(dia + "/" + this.getMes() + "/" + this.getAno() );
			this.dia = dia;
		} catch ( Exception e){
			throw new IllegalArgumentException ("Dia inválido: deve ser entre 1 e 31.");
		} 
	}

	public void setMes(int m) {
		if( (m > 1) && (m < 12) ){
			this.mes = m;
		} else {
			throw new IllegalArgumentException ("Mês inválido: deve ser entre 1 e 12.");
		}
	}

	public void setAno(int ano) {
		if( (ano > (anoAtual - 150)) && (ano < (anoAtual + 150))  ){
			this.ano = ano;
		} else {
			throw new IllegalArgumentException ("Ano inválido: deve ser entre " + (anoAtual - 150) 
												+ " e " + (anoAtual + 150) + ".");
		}
	}

	public Data(int dia, int mes, int ano) {
		// http://stackoverflow.com/questions/3220163/how-to-find-leap-year-programatically-in-c
		if (( (ano & 3) == 0 && ((ano % 25) != 0 || (ano & 15) == 0)) && ((mes == 2) && (dia > 29))) {
			throw new IllegalArgumentException ("Para anos bissextos, fevereiro tem 29 dias.");
		} else {
			this.setAno (ano);
			this.setMes (mes);
			this.setDia (dia);
		}
	}

	public Data(int dia, int mes) {
		this(dia, mes, anoAtual);
	}

	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}
