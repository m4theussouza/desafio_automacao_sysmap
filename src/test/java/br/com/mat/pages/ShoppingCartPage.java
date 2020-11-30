package br.com.mat.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.com.mat.utils.PageBase;

public class ShoppingCartPage extends PageBase {
	String labelShoppingCartSummaryId = "cart_title";
	String inputQuantidadeItensXpath = "//input[@class='cart_quantity_input form-control grey']";
	String descricaoProdutoXpath = "//th[text()='Description']//..//..//..//td[@class='cart_description']//p//a";
	String tableHeaderDescriptionXpath = "//th[text()='Description']";
	String labelInStockXpath = "//th[text()='Avail.']//..//..//..//td[@class='cart_avail']//span";
	
	public void validarTelaShoppingCart() throws InterruptedException, IOException {
		assertTrue(Constantes.TIRAR_PRINT, "Validando Pagina Shopping Cart Summary", elementoExiste(TipoSeletor.ID, labelShoppingCartSummaryId,
																									Constantes.TIME_WAIT_ELEMENT_EXIST));
	}
	
	public void validarExistenciaDoNomeDoProdutoNaDescricao(String produto) throws InterruptedException, IOException {
		if( elementoExiste(TipoSeletor.XPATH, tableHeaderDescriptionXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement tableHeaderDescription = pegarElementoWeb(TipoSeletor.XPATH, tableHeaderDescriptionXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", tableHeaderDescription);
		}
		
		if( elementoExiste(TipoSeletor.XPATH, descricaoProdutoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement descricaoProduto = pegarElementoWeb(TipoSeletor.XPATH, descricaoProdutoXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando que a descrição do produto contenha - "+ produto, descricaoProduto.getText().contains(produto));
		}
	}
	
	public void validarQuantidadeDeProdutosNoAdicionados(String quantidade) throws InterruptedException, IOException {
		if( elementoExiste(TipoSeletor.XPATH, tableHeaderDescriptionXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement tableHeaderDescription = pegarElementoWeb(TipoSeletor.XPATH, tableHeaderDescriptionXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", tableHeaderDescription);
		}
		
		if( elementoExiste(TipoSeletor.XPATH, inputQuantidadeItensXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement inputQuantidadeItens = pegarElementoWeb(TipoSeletor.XPATH, inputQuantidadeItensXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando que a quantidade de produtos no carrinho seja igual a "+ quantidade, inputQuantidadeItens.getAttribute("value").equals(quantidade) );
		}
	}
	
	public void validarProdutoEmEstoque() throws InterruptedException, IOException {
		if( elementoExiste(TipoSeletor.XPATH, tableHeaderDescriptionXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement tableHeaderDescription = pegarElementoWeb(TipoSeletor.XPATH, tableHeaderDescriptionXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", tableHeaderDescription);
		}
		
		if( elementoExiste(TipoSeletor.XPATH, labelInStockXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement labelInStock = pegarElementoWeb(TipoSeletor.XPATH, labelInStockXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando que o produto esta em Estoque", labelInStock.getText().equals("In stock"));
		}
	}

	public void validarQueProdutoPossuiPorcentagemDeDesconto(String desconto) throws InterruptedException, IOException {
		String labelDescontoXpath = "//span[contains(text(),'-"+desconto+"%')]";
		if( elementoExiste(TipoSeletor.XPATH, tableHeaderDescriptionXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement tableHeaderDescription = pegarElementoWeb(TipoSeletor.XPATH, tableHeaderDescriptionXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", tableHeaderDescription);
		}
		
		if( elementoExiste(TipoSeletor.XPATH, labelDescontoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement labelDesconto = pegarElementoWeb(TipoSeletor.XPATH, labelDescontoXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando que o produto esta em Estoque", labelDesconto.getText().contains("-"+desconto+"%"));
		}
	}
	
	
}
