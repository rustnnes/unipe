package br.unipe.mlpIII.Estagio2.Lista1.Fachada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.unipe.mlpIII.Estagio2.Lista1.Modelo.Item;
import br.unipe.mlpIII.Estagio2.Lista1.Utils.Utils;

public class Inventario {

	private static Inventario Instancia;
	private List<Item> inventario;

	private Inventario() {
		inventario = new ArrayList<Item>();
	}

	public static synchronized Inventario getInstance() {
		if (Instancia == null)
			Instancia = new Inventario();
		return Instancia;
	}

	@Override
	public String toString() {
		int sz = inventario.size();
		return "Inventario (" + sz + "ite" + (sz > 1 ? "ns" : "m") + ")";
	}

	private void listarItens() {
		List<Item> listaOrdenada = new ArrayList<Item>(inventario);
		if (isEmpty(listaOrdenada)) {
			System.out.println("Não é possível listar -> nenhum item informado.");
		} else {
			Collections.sort(listaOrdenada);
			// ou ainda: Collections.sort(listaOrdenada, Item.CODIGO);
			for (Item i : listaOrdenada)
				System.out.println(i);
		}
	}

	private void addItem(Scanner scan) {
		boolean ok = true;
		while (ok) {
			long cod = 0;
			String desc = "";
			System.out.printf("Informe codigo: ");
			cod = scan.nextLong();
			if (cod <= 0) {
				System.err.println("!! Informe um codigo valido !!");
			} else {
				System.out.printf("\nInforme a descricao do produto de codigo " + cod + ": ");
				desc = Utils.stringDeliverer(scan);
				if (desc.equals("")) {
					System.err.println("!! Informe a descricao nao vazia !!");
				} else {
					inventario.add(new Item(cod, desc));
					System.out.println("Inserir novo item? ");
					ok = Utils.yesNo();
				}
			}
		}
	}

	private void searchItem(Scanner scan) {
		if (isEmpty(inventario)) {
			System.err.println("Não é possível excluir -> nenhum item informado.");
		} else {
			boolean ok = true, status = false;
			String desc = "";
			long cod = 0;
			while (ok) {
				System.out.println("Informe descricao para busca: ");
				desc = Utils.stringDeliverer(scan);
				if (desc.equals("")) {
					System.err.println("!! Para buscar, informe descricao nao vazia !!");
				} else {
					for (Item i : inventario)
						if (desc.equals(i.getDescricao())) {
							cod = i.getCodigo();
							status = true;
							break;
						}
					if (status)
						System.out.println("Item presente sob o codigo " + cod);
					else
						System.out.println("Item nao presente no inventario");
					System.out.println("\nBuscar outro item? ");
					ok = Utils.yesNo();
				}
			}
		}
	}

	private void editItem(Scanner scan) {
		System.out.println("Nao implementado.");
	}

	private void delItem(Scanner scan) {
		boolean ok = true;
		while (ok) {
			if (isEmpty(inventario)) {
				System.err.println("Não é possível excluir -> Lista vazia; nenhum item informado.");
			} else {
				long cod = 0;
				System.out.println("Listar itens? ");
				if (Utils.yesNo())
					listarItens();
				System.out.printf("Informe codigo para exclusao: ");
				cod = scan.nextLong();
				if (cod <= 0) {
					System.err.println("!! Informe um codigo valido !!");
				} else {
					Item tmpItem = null;
					for (Item i : inventario)
						if (i.getCodigo() == cod) {
							tmpItem = i;
							break;
						}
					if (tmpItem == null) {
						System.out.println("Item nao encontrado. Tentar novamente? ");
					} else {
						System.out.println("Excluindo item " + tmpItem + "...");
						inventario.remove(tmpItem);
						System.out.println("Item Excluido. Deseja excluir outro item? ");
					}
					ok = Utils.yesNo();
				}
			}
		}
	}

	private boolean isEmpty(List<Item> l) {
		return l.isEmpty();
	}

	public static void menu(Scanner scan) {
		Inventario lista = Inventario.getInstance();
		boolean ok = true;
		while (ok) {
			System.out.println("\n\n\nInventario\n");
			System.out.println("[0]\tLista de itens");
			System.out.println("[1]\tAdicionar Item");
			System.out.println("[2]\tBuscar Item");
			System.out.println("[3]\tEditar Item");
			System.out.println("[4]\tExcluir Item");
			System.out.println("[9]\tSair");

			switch (Utils.option("012349")) {
			case '0':
				lista.listarItens();
				break;
			case '1':
				lista.addItem(scan);
				break;
			case '2':
				lista.searchItem(scan);
				break;
			case '3':
				lista.editItem(scan);
				break;
			case '4':
				lista.delItem(scan);
				break;
			case '9':
				ok = false;
				break;
			}
		}
	}

}
