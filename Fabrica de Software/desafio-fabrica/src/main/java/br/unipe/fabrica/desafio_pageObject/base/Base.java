package br.unipe.fabrica.desafio_pageObject.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.unipe.fabrica.desafio_pageObject.pageObject.Page;
import br.unipe.fabrica.desafio_pageObject.utils.Utils;

public class Base {

	protected WebDriver drv;
	protected Utils util;
	protected Page page;
	protected static String TEST_TARGET = "https://seubarriga.wcaquino.me/login";
	
	// ******** Início dos testes ********
	@Before
	public void hi() {
		// System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "geckodriver");
		System.out.println("****** Inicializando teste… ******");
		System.out.println("****** Instanciando Driver Firefox… ******");
		drv = new FirefoxDriver();
		drv.manage().window().setSize(new Dimension(1024, 768));
		System.out.println("****** Navegando para o alvo dos testes… ******");
		drv.get(TEST_TARGET);
		System.out.println("****** Instanciando PageObject… ******");
		page = new Page(drv);
	}
	
	// ******** Encerramento do teste ********
	@After
	public void bye () { drv.quit(); }
	
}
