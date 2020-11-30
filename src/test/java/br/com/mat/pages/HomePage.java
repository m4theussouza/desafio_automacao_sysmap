package br.com.mat.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.mat.utils.PageBase;

public class HomePage extends PageBase {
	
	String logoImgXpath = "//img[@alt='My Store']";
	String campoDePesquisaName = "search_query";
	String botaoPesquisarName = "submit_search";
	String guiaBestSellersXpath = "//a[text()='Best Sellers']";
	
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
	
	public void colocarMouseEmCimaDaCategoria(String categoria) throws InterruptedException {
		String categoriaXpath = "//a[@title='"+categoria+"']";
		if( elementoExiste(TipoSeletor.XPATH, categoriaXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement categoriaElemento = pegarElementoWeb(TipoSeletor.XPATH, categoriaXpath);
			Actions action = new Actions(getDriver());
			action.moveToElement(categoriaElemento).perform();
		}
	}
	
	public void validarMouseEmCimaDaCategoria(String categoria) throws IOException, InterruptedException {
		String categoriaXpath = "//a[@title='"+categoria+"']";
		if( elementoExiste(TipoSeletor.XPATH,  categoriaXpath, Constantes.TIME_WAIT_ELEMENT_EXIST)  ) {
			WebElement categoriaElemento = pegarElementoWeb(TipoSeletor.XPATH, categoriaXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando mouse em cima da categoria - " + categoria, categoriaElemento.getText().contains("WOMEN"));
		}
	}

	public void clicarSubCategoria(String categoriaPrincipal, String subCategoria) throws InterruptedException {
		String subCategoriaXpath = "//a[@title='"+categoriaPrincipal+"']//..//a[@title='"+subCategoria+"']";
		if( elementoExiste(TipoSeletor.XPATH,  subCategoriaXpath, Constantes.TIME_WAIT_ELEMENT_EXIST)  ) {
			WebElement subCategoriaElemento = pegarElementoWeb(TipoSeletor.XPATH, subCategoriaXpath);
			subCategoriaElemento.click();
		}
	}
	
	public void scrollAbaBestSellers() throws InterruptedException {
		if( elementoExiste(TipoSeletor.XPATH, guiaBestSellersXpath , Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement guiaBestSellers = pegarElementoWeb(TipoSeletor.XPATH, guiaBestSellersXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", guiaBestSellers);
		}
	}

	public void clicarAbaBestSellers() throws InterruptedException {
		if( elementoExiste(TipoSeletor.XPATH, guiaBestSellersXpath , Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement guiaBestSellers = pegarElementoWeb(TipoSeletor.XPATH, guiaBestSellersXpath);
			guiaBestSellers.click();
		}
	}

		public void clicarElementoComPorcentagemDeDesconto(String desconto) throws InterruptedException {
			String itemComDescontoXpath = "(//span[text()='-"+desconto+"%'])[1]";
			String imgProdutoComDescontoNomeXpath = "(//span[text()='-"+String.valueOf(desconto)+"%'])[3]//..//..//..//..//img";
			
			if( elementoExiste(TipoSeletor.XPATH, itemComDescontoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
				WebElement itemComDesconto = pegarElementoWeb(TipoSeletor.XPATH, itemComDescontoXpath);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", itemComDesconto);			
			}
			
			if( elementoExiste(TipoSeletor.XPATH, imgProdutoComDescontoNomeXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
				WebElement labelProdutoComDescontoNome = pegarElementoWeb(TipoSeletor.XPATH, imgProdutoComDescontoNomeXpath);
				Actions action = new Actions(getDriver());
				action.moveToElement(labelProdutoComDescontoNome).perform();			
			}
		}
		
		public void adicionarItemNoCarrinho(String desconto) throws InterruptedException {
			String botaoAddToCartDescontoXpath = "(//span[text()='-"+desconto+"%'])[3]//..//..//..//..//a[@title='Add to cart']";
			if( elementoExiste(TipoSeletor.XPATH, botaoAddToCartDescontoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
				WebElement botaoAddToCartDesconto = pegarElementoWeb(TipoSeletor.XPATH, botaoAddToCartDescontoXpath);
				botaoAddToCartDesconto.click();
				System.out.println("Break");
			}
		}
		
}

