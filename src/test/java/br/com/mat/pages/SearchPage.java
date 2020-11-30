package br.com.mat.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.mat.utils.PageBase;

public class SearchPage extends PageBase {
	
	String alertProdutoNaoExistenteXpath = "//p[contains(text(),'No results were found for your search') and contains(text(), 'ProdutoNãoExistente') ]";
	
	
	public void conferirResultadoDaBusca(String produto) throws InterruptedException, IOException {
		String produtoXpath = "//a[@title='"+ produto +"' and @class='product-name']";
		if( elementoExiste(TipoSeletor.XPATH, produtoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement produtoBuscado = pegarElementoWeb(TipoSeletor.XPATH, produtoXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", produtoBuscado);
			assertTrue(Constantes.TIRAR_PRINT, "Validando busca do produto - " + produto, produtoBuscado.getText().contains(produto) );
		}
	}
	
	public void conferindoMensagemDeErroProdutoNaoExistente() throws InterruptedException, IOException {
		if( elementoExiste(TipoSeletor.XPATH, alertProdutoNaoExistenteXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement alertProdutoNaoExistente = pegarElementoWeb(TipoSeletor.XPATH, alertProdutoNaoExistenteXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando erro na busca Produto Nao existente", alertProdutoNaoExistente.getText().contains("ProdutoNãoExistente") );
		}
	}
	
	public void clicarBotaoAddToCartDoProdutoProcurado(String produto) throws InterruptedException, IOException {
		String produtoXpath = "//h5[@itemprop='name']//a[contains(text(), '"+produto+"') and @class='product-name']";
		String botaoAddToCartProdutoBuscadoXpath = "//h5[@itemprop='name']//a[@class='product-name' and contains(text(), '"+produto+"')]//..//..//a[@title='Add to cart']";

		if( elementoExiste(TipoSeletor.XPATH, produtoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement produtoBuscado = pegarElementoWeb(TipoSeletor.XPATH, produtoXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", produtoBuscado);
			Actions action = new Actions(getDriver());
			action.moveToElement(produtoBuscado).perform();
		}
		
		if( elementoExiste(TipoSeletor.XPATH, botaoAddToCartProdutoBuscadoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement botaoAddToCartProdutoBuscado = pegarElementoWeb(TipoSeletor.XPATH, botaoAddToCartProdutoBuscadoXpath);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", botaoAddToCartProdutoBuscado);
			botaoAddToCartProdutoBuscado.click();
		}
	}
	
	//a[@title='Add to cart']
}
