package Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

// arquivo: Principal.java
public class Principal {
	public static void main(String[] args) throws IOException {
		int dia;
		int diaAtual;
		int mes;
		int mesAtual;
		int ano;
		int anoAtual;
		Scanner scan = new Scanner(System.in);
		List<Data> list = new ArrayList<Data>();

		do {
			diaAtual = Calendar.getInstance().get(Calendar.DATE);
			mesAtual = (int) (Calendar.getInstance().get(Calendar.MONTH) + 1);
			anoAtual = Calendar.getInstance().get(Calendar.YEAR);

			System.out.printf("Defina dia [" + diaAtual + "]: ");
			dia = scan.nextInt();
			System.out.printf("Defina mes [" + mesAtual + "]: ");
			mes = scan.nextInt();
			System.out.printf("Defina ano [" + anoAtual + "]: ");
			ano = scan.nextInt();
			try {
				list.add(new Data(dia, mes, ano));
			} catch (IllegalArgumentException e) {
				System.err.println("Data inválida! ?" + dia + "/" + mes + "/" + ano + "? " +
									e.getMessage());
			} finally {
				System.out.println("Inserir nova data? ( [Y]es|[N]o )");
			}
			
		} while (Utils.yesNo());
		scan.close();

		if(list.size() > 0){
			System.out.println("Datas inseridas:\n================\n");
			for (Data d : list)
				System.out.println(d.toString());
		} else {
			System.out.println("Nenhuma data válida foi inserida.");
		}
			

	}
}