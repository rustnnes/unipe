package br.unipe.fabrica.desafio_pageObject.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.unipe.fabrica.desafio_pageObject.base.Base;

public class Utils extends Base {
	
	public Utils(WebDriver drv) {
		this.drv = drv;
	}

	public void navegarPara(String url) {
		this.drv.navigate().to(url);
	}

	public void preencherCampo(By element, String text) {
		this.drv.findElement(element).sendKeys(text);
	}

	public void clica(By element) {
		this.drv.findElement(element).click();
	}

	public void selecionaValorVisivel(By element, String text) {
		Select combo = new Select(this.drv.findElement(element));
		combo.selectByVisibleText(text);
	}

	public void espera(long tempo) throws InterruptedException {
		drv.wait(tempo);
	}

	public boolean checa(By element, String text) {
		try {
			WebElement el = drv.findElement(element);
			return el.getText().startsWith(text);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
