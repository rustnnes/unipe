package br.unipe.fabrica.desafio_pageObject.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.unipe.fabrica.desafio_pageObject.base.Base;
import br.unipe.fabrica.desafio_pageObject.utils.Utils;

public class Page extends Base {

	// ******** Elementos em comum entre páginas ********
	static By NOME = By.xpath("//*[@id=\"nome\"]");
	static By EMAIL = By.xpath("//*[@id=\"email\"]");
	static By PASS = By.xpath("//*[@id=\"senha\"]");
	
	// ******** Elementos para criação novo usuário ********
	static By NOVO_USUARIO = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a");
	static By NOVO_USUARIO_SUBMIT = By.xpath("/html/body/div[2]/form/input");
	
	// ******** Elementos para Login ********
	static By LOGIN_SUBMIT = By.xpath("/html/body/div[2]/form/button");
	
	// ******** Elementos Contas ********
	static By CONTAS = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a");
	static By CONTAS_ADD = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a");
	static By CONTAS_ADD_NOME = NOME;
	static By CONTAS_ADD_SALVAR = By.xpath("/html/body/div[2]/form/div[2]/button");
	static By CONTAS_LST = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a");
	//static By CONTAS_LST_PATTERN = By.xpath("/html/body/table/tbody/tr/td[1]");
	static By CONTAS_LST_TBL = By.xpath("/html/body/table/tbody/tr/td[1]");
	
	// ******** Elementos Criar Movimentação ********
	static By CRIAR_MOV = By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a");
	static By CRIAR_MOV_TIPO = By.xpath("//*[@id=\"tipo\"]");
	static By CRIAR_MOV_DATAMOV = By.xpath("//*[@id=\"data_transacao\"]");
	static By CRIAR_MOV_DATATRANS = By.xpath("//*[@id=\"data_pagamento\"]");
	static By CRIAR_MOV_DESC = By.xpath("//*[@id=\"descricao\"]");
	static By CRIAR_MOV_INTERESSADO = By.xpath("//*[@id=\"interessado\"]");
	static By CRIAR_MOV_VLR = By.xpath("//*[@id=\"valor\"]");
	static By CRIAR_MOV_CONTA = By.xpath("//*[@id=\"conta\"]");
	static By CRIAR_MOV_PAGO = By.xpath("//*[@id=\"status_pago\"]");
	static By CRIAR_MOV_PENDENTE = By.xpath("//*[@id=\"status_pendente\"]");
	static By CRIAR_MOV_SALVAR = By.xpath("/html/body/div[2]/form/div[4]/button");

	// ******** Elementos Visualizar Resumo ********
	static By RESUMO = By.xpath("/html/body/nav/div/div[2]/ul/li[4]/a");
	static By RESUMO_MOV = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]");

	// ******** Elementos de confirmação do teste ********
	static By RESULTADO = By.xpath("/html/body/div[1]"); 

	// ******** Construtor ********
	public Page(WebDriver drv) { util = new Utils(drv); }
	
	// ******** Método para criação de novo usuário ********
	public boolean novoUsuario(String nome, String email, String pass) {
		util.clica(NOVO_USUARIO);
		util.preencherCampo(NOME, nome);
		util.preencherCampo(EMAIL, email);
		util.preencherCampo(PASS, pass);
		util.clica(NOVO_USUARIO_SUBMIT);
		return sucesso_NovoUsuario();
	}

	public void goHome() { this.util.navegarPara(TEST_TARGET); }

	public void setEmail(String n) { this.util.preencherCampo(EMAIL, n); }
	public void setNome(String text) { this.util.preencherCampo(NOME, text); }
	public void setPass(String n) { this.util.preencherCampo(PASS, n); }

	public void Submit() { this.util.clica(LOGIN_SUBMIT); }
	
	// ******** Métodos para Contas ********
	public void contas_Adicionar() {
		this.util.clica(CONTAS);
		this.util.clica(CONTAS_ADD);
	}
	public boolean contas_Listar(String text) {
		this.util.clica(CONTAS);
		this.util.clica(CONTAS_LST);
		return this.util.checa(CONTAS_LST_TBL, text);
	}
	public void contas_Checar() {
		this.util.clica(CONTAS_ADD_SALVAR);
	}
	public void contas_Salvar() { this.util.clica(CONTAS_ADD_SALVAR); }
	public void contas_setNome(String text) { this.util.preencherCampo(CONTAS_ADD_NOME, text); }

	// ******** Métodos para Movimentações ********
	public void movimentacaoCriar() { this.util.clica(CRIAR_MOV); }
	public void movimentacaoCriar_Tipo(String text) { this.util.selecionaValorVisivel(CRIAR_MOV_TIPO, text); }
	public void movimentacaoCriar_DataMov(String text) { this.util.preencherCampo(CRIAR_MOV_DATAMOV, text); }
	public void movimentacaoCriar_DataTrans(String text) { this.util.preencherCampo(CRIAR_MOV_DATATRANS, text); }
	public void movimentacaoCriar_Desc(String text) { this.util.preencherCampo(CRIAR_MOV_DESC, text); }
	public void movimentacaoCriar_Interessado(String text) { this.util.preencherCampo(CRIAR_MOV_INTERESSADO, text); }
	public void movimentacaoCriar_Valor(String text) { this.util.preencherCampo(CRIAR_MOV_VLR, text); }
	public void movimentacaoCriar_Conta(String text) { this.util.selecionaValorVisivel(CRIAR_MOV_CONTA, text); }
	public void movimentacaoCriar_Pago() { this.util.clica(CRIAR_MOV_PAGO); }
	public void movimentacaoCriar_Pendente() { this.util.clica(CRIAR_MOV_PENDENTE); }
	public void movimentacaoCriar_Salvar() { this.util.clica(CRIAR_MOV_SALVAR); }
	
	// ******** Métodos para checagem de sucesso das operações ********S
	public boolean sucesso_Login() { return this.util.checa(RESULTADO, "Bem vindo"); }
	public boolean sucesso_NovaConta() { return this.util.checa(RESULTADO, "Conta adicionada com sucesso"); }
	public boolean sucesso_NovoUsuario() { return this.util.checa(RESULTADO, "Usuário inserido com sucesso"); }
	public boolean sucesso_NovaMovimentacao() { return this.util.checa(RESULTADO, "Movimentação adicionada com sucesso"); }
	public boolean sucesso_ResumoMensal() { return this.util.checa(RESUMO_MOV, "Entrada de Fundos"); }

	// ******** Métodos para Visualização de resumo ********
	public void resumo_Visualizar() { this.util.clica(RESUMO); }
	
}
