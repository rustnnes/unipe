package br.unipe.fabrica.desafio_pageObject;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.unipe.fabrica.desafio_pageObject.base.Base;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DesafioTest extends Base {
	
	static String NOME = "TESTES DO DIEGO";
	static String EMAIL = "u000@hax0r.net";
	static String PASS = "123$567*";
	static String NOME_CONTA = "CONTA_TESTE_1";
//	static String NOME_CONTA() {
//		int i = 1;
//		return "RUSTNNES_" + Integer.toString(i);
//	}

	@Test
	public void test_1_criaUsuario() {
		assertTrue(page.novoUsuario(NOME, EMAIL, PASS));
	}

	@Test
	public void test_2_Login() {
		page.goHome();
		page.setEmail(EMAIL);
		page.setPass(PASS);
		page.Submit();
		assertTrue(page.sucesso_Login());
	}

	@Test
	public void test_3_AdicionarConta() {
		test_2_Login();
		page.contas_Adicionar();
		page.contas_setNome(NOME_CONTA);
		page.contas_Salvar();
		assertTrue(page.sucesso_NovaConta());
	}

	@Test
	public void test_4_CriarMovimentacao() {
		test_2_Login();
		page.movimentacaoCriar();
		page.movimentacaoCriar_Tipo("Receita");
		page.movimentacaoCriar_DataMov("23/08/2018");
		page.movimentacaoCriar_DataTrans("27/08/2018");
		page.movimentacaoCriar_Desc("Entrada de Fundos");
		page.movimentacaoCriar_Interessado("Israel");
		page.movimentacaoCriar_Valor("1000.00");
		page.movimentacaoCriar_Conta(NOME_CONTA);
		page.movimentacaoCriar_Pago();
		page.movimentacaoCriar_Salvar();
		assertTrue(page.sucesso_NovaMovimentacao());
	}

	@Test
	public void test_5_VisualizarResumo() {
		test_2_Login();
		page.resumo_Visualizar();
		assertTrue(page.sucesso_ResumoMensal());
	}

}
