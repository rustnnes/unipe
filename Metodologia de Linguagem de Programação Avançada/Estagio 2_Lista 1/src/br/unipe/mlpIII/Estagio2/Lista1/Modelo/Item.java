package br.unipe.mlpIII.Estagio2.Lista1.Modelo;

import java.text.DecimalFormat;
import java.util.Comparator;

public class Item implements Comparable<Item>{
	
	protected long codigo;
	protected String descricao;
	
	public long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return new DecimalFormat("000000").format( codigo ) + " - " + descricao.toUpperCase();
	}

	public int compareTo(Item i) {
		if(this.codigo < i.codigo ) return -1; 
		if(this.codigo > i.codigo ) return 1;
		return 0;
	}

	public static final Comparator<Item> CODIGO = new Comparator<Item>() {
		public int compare(Item i1, Item i2) {
			return i2.compareTo(i1);
		}
	};
	
	public static final Comparator<Item> DESCRICAO = new Comparator<Item>() {
		public int compare(Item i1, Item i2) {
			return i2.descricao.compareToIgnoreCase(i1.descricao);
		}
	};

	public Item(long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


}
