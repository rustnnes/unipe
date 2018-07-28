package br.unipe.mlpIII.Modelo;
import java.util.Comparator;


public class Item implements Comparable<Item>{
	
	private int codigo;
	private String descricao;
	private double preco;
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Item(int codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	
	@Override
	public int compareTo(Item i) {
		if(this.codigo > i.codigo) return 1;
		if(this.codigo < i.codigo) return -1;
		return 0;
	}
	
	public static final Comparator<Item> DESCRICAO = new Comparator<Item>() {
		public int compare(Item i1, Item i2) {
			return i1.descricao.compareToIgnoreCase(i2.descricao);
		}
	};
	
}
