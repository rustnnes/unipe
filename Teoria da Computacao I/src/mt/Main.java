package mt;

public class Main {
	
	public static void main(String[] args) {
		try {
			Machine turingMachine = new Machine("mt.properties");
			turingMachine.run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
