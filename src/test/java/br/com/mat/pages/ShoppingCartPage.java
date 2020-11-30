package br.com.mat.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.com.mat.utils.PageBase;

public class ShoppingCartPage extends PageBase {
	String labelShoppingCartSummaryId = "cart_title";
	String inputQuantidadeItensXpath = "//input[@name='quantity_1_1_0_0']";
	
	public void validarTelaShoppingCart() throws InterruptedException, IOException {
		assertTrue(Constantes.TIRAR_PRINT, "Validando Pagina Shopping Cart Summary", elementoExiste(TipoSeletor.ID, labelShoppingCartSummaryId,
																									Constantes.TIME_WAIT_ELEMENT_EXIST));
	}
	
	public void validarExistenciaDoNomeDoProdutoNaDescricao(String produto) throws InterruptedException, IOException {
		String descricaoProdutoXpath = "//th[text()='Description']//..//..//..//td[@class='cart_description']//p//a";
		String tableHeaderDescriptionXpath = "//th[text()='Description']";
		
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
		if( elementoExiste(TipoSeletor.XPATH, inputQuantidadeItensXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement inputQuantidadeItens = pegarElementoWeb(TipoSeletor.XPATH, inputQuantidadeItensXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando que a quantidade de produtos no carrinho seja igual a "+ quantidade, inputQuantidadeItens.getAttribute("value").equals(quantidade) );
		}
	}
}
