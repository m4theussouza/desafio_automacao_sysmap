package br.com.mat.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import br.com.mat.utils.PageBase;

public class HomePage extends PageBase {
	
	String logoImgXpath = "//img[@alt='My Store']";
	String campoDePesquisaName = "search_query";
	String botaoPesquisarName = "submit_search";
	
	public void validarTelaHome() throws InterruptedException, IOException {
		assertTrue(Constantes.TIRAR_PRINT, "Validando Home Page", elementoExiste(TipoSeletor.XPATH, logoImgXpath,
																				Constantes.TIME_WAIT_ELEMENT_EXIST));
	}

	public void digitarProdutoCampoDePesquisa(String produto) throws InterruptedException, IOException {
		if( elementoExiste(TipoSeletor.NAME, campoDePesquisaName, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement campoDePesquisa = pegarElementoWeb(TipoSeletor.NAME, campoDePesquisaName);
			campoDePesquisa.sendKeys(produto);
			assertTrue(Constantes.TIRAR_PRINT, "Digitando produto "+ produto + " no campo de busca", true);
		}	
	}
	
	public void clicarBotaoPesquisar() throws InterruptedException {
		if( elementoExiste(TipoSeletor.NAME, botaoPesquisarName, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement botaoPesquisar = pegarElementoWeb(TipoSeletor.NAME, botaoPesquisarName);
			botaoPesquisar.click();
		}	
	}
}
