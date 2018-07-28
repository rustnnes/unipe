import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (
            Scanner scan = new Scanner(System.in)
        ) {
            Fatura.teste(scan);
            Carro.teste(scan);
            FabricaDeCarro.teste();
        }
    }
}
