package mt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Machine {

	List<Head> heads = new LinkedList<Head>();
	Set<State> states = new HashSet<State>();
	String blankSymbol;
	Properties props;

	private void getProperties(String fileName) {
		try {
			if (props == null) {
				props = new Properties();
				props.load(new FileInputStream(fileName));
			}
		} catch (InvalidPropertiesFormatException e) {
			System.err.println("Propriedades inválidas\n" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado!\n" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Falha I/O!\n" + e.getMessage());
		}
	}
	
	/*
	 * Cria uma cabeça com uma fita para cada chamada da função. As fitas vem do
	 * arquivo "mt.properties", configurada na propriedade "tapes" separada por
	 * vírgulas.
	 */
	public void initTape(String input) {
		List<String> tape = new LinkedList<String>();
		for (char pos : input.toCharArray())
			tape.add(String.valueOf(pos));
		heads.add(new Head(tape));
	}

	public Machine(String fileName) throws Throwable {
		getProperties(fileName);

		// cancela construtor se argumentos são nulos ou vazios
		for (String s: Arrays.asList("nStates","finalStates","blank","alphabet","tapes","transitions")) 
			if(!props.containsKey(s) || props.getProperty(s).isEmpty())
				throw new IllegalArgumentException("Something got wrong :'(");

		//nStates
		for (int i = 0; i < Integer.parseInt(props.getProperty("nStates")); i++)
			states.add(new State());
		
		//finalStates
		states.forEach(s -> {
			if (Arrays.asList(props.getProperty("finalStates").split(",")).contains(s.Id))
				s.setFinal();
		});
		
		//blank
		blankSymbol = props.getProperty("blank");
		
		//alphabet
		//alphabet = props.getProperty("alphabet");

		//tapes
		for(String s: Arrays.asList(props.getProperty("tapes").split(","))) 
			initTape(s);
		
		//transitions
		for(String s: Arrays.asList(props.getProperty("transitions").split(",")))
			for(String t: Arrays.asList(s.split(";"))){}
	}

	public void run() {
		for (Head head : heads) {
			if (head.tape.size() == 0)
				head.tape.add(blankSymbol);
		}
	}
}
