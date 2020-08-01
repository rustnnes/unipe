/*
 * Links de refer�ncia:
 * http://www.devmedia.com.br/padrao-de-projeto-singleton-em-java/26392
 * https://pt.wikipedia.org/wiki/Singleton
 * 
 * 
 * Em pesquisa, identifiquei duas implementacoes Singleton:
 * Implementacao Direta 
 *
 *>>>
 * public class FabricaDeCarro {
 * 		private static FabricaDeCarro Instancia = new FabricaDeCarro();
 *		private FabricaDeCarro() {	
 *			// faz alguma coisa...
 *		}
 *		public static FabricaDeCarro getInstance() { 
 *			return Instancia;
 *		}
 *	}
 *<<<
 *
 *
 * A forma de implementacao escolhida apresenta o metodo getInstance
 * sincronizado. Dessa forma evitamos que, devido a concorrencia, seja 
 * possivel criar mais de uma instancia.
 */

public class FabricaDeCarro {

	private static FabricaDeCarro Instancia;

	private FabricaDeCarro() { 
		// faz alguma coisa...
	}

	public static synchronized FabricaDeCarro getInstance() {
		if (Instancia == null)
			Instancia = new FabricaDeCarro(); 
		return Instancia;
	}

	public static void teste() {
		System.out.println(" *\n * FabricaDeCarro\n *");
		System.out.println(" > O teste para a Classe FabricaDeCarro consiste em tentar criar uma nova\n"
				+ " > instancia da mesma e assim obter IDs diferentes.\n"
				+ " > Ora, nao sera possivel instanciar a Classe diretamente, devido construtor\n"
				+ " > privado. Entao, com isso devemos usar o metodo getInstance(), que trara \n"
				+ " > referencia ja criada, ou instanciara uma, caso nao o tenha sido.\n\n");

		System.out.println(" > Instanciando...\n>>> FabricaDeCarro fabrica = FabricaDeCarro.getInstance();\n");
		FabricaDeCarro fabrica = FabricaDeCarro.getInstance();

		System.out.println(" > Verificando ID...\n>>> System.out.println( fabrica.toString() );");
		System.out.println(fabrica.toString());

		System.out.println("\n > Posso tentar instanciar FabricaDeCarro novamente, o que geraria outro ID...\n"
				+ ">>> fabrica = FabricaDeCarro.getInstance();\n");
		fabrica = FabricaDeCarro.getInstance();

		System.out.println(" > Mas nao cria; reutiliza a ja criada...\n>>> System.out.println( fabrica.toString() );");
		System.out.println(fabrica.toString());
	}

}
