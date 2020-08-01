package br.unipe.mlpIII.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.unipe.mlpIII.Modelo.Item;

public class Principal {

	public static void main(String[] args) {
		List<Item> estoque = new ArrayList<Item>();
		estoque.add(new Item(1, "item 1", 2.00));
		estoque.add(new Item(2, "item 2", 32.00));
		estoque.add(new Item(3, "item 4", 64.00));
		estoque.add(new Item(4, "item 8", 128.00));
		System.out.println("Lista em ordem crescente de código");
		Collections.sort(estoque);
		estoque.forEach(i -> System.out.println(i));
		System.out.println("\nLista em ordem decrescente de código");
		Collections.reverse(estoque);
		estoque.forEach(i -> System.out.println(i));
	}

}
