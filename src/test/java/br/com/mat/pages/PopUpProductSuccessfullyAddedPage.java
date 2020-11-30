package br.com.mat.pages;

import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.WebElement;

import br.com.mat.utils.PageBase;

public class PopUpProductSuccessfullyAddedPage extends PageBase {
	
	String iconOkClassName = "icon-ok";
	String botaoProceedToCheckoutXpath = "//a[@title='Proceed to checkout']";
	String valorSemDesconto;
	String labelValorComDescontoItemCarrinhoId = "layer_cart_product_price";
	
	public void validarProdutoAdicionadoNoCarrinho() throws InterruptedException, IOException {
		Thread.sleep(1000);
		assertTrue(Constantes.TIRAR_PRINT, "Validando Item Adicionado No Carrinho", elementoExiste(TipoSeletor.CLASSNAME, 
																									iconOkClassName, 
																									Constantes.TIME_WAIT_ELEMENT_EXIST));
	}
	
	public void pegarValorProdutoSemDesconto(String desconto) throws InterruptedException {
		String labelValorElementoSemDescontoXpath = "(//span[text()='-"+desconto+"%'])[4]//..//span[@class='old-price product-price']";
		if( elementoExiste(TipoSeletor.XPATH, labelValorElementoSemDescontoXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement labelValorElementoSemDesconto = pegarElementoWeb(TipoSeletor.XPATH, labelValorElementoSemDescontoXpath);
			valorSemDesconto = labelValorElementoSemDesconto.getText();
		}
	}
	
	public void clicarBotaoProceedToCheckout() throws InterruptedException {
		if( elementoExiste(TipoSeletor.XPATH, botaoProceedToCheckoutXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement botaoProceedToCheckout = pegarElementoWeb(TipoSeletor.XPATH, botaoProceedToCheckoutXpath);
			botaoProceedToCheckout.click();
		}
	}
	
	public void validarDesconto5porcento(String desconto) throws InterruptedException, IOException {
		double labelValorComDesconto;
		double descontoFloat = Double.valueOf(desconto);
		DecimalFormat df = new DecimalFormat("##.##");
		 
		if( elementoExiste(TipoSeletor.ID, labelValorComDescontoItemCarrinhoId, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			float valorSemDescontoFloat = Float.valueOf(valorSemDesconto.replace("$", " "));;
			WebElement labelValorComDescontoItemCarrinho = pegarElementoWeb(TipoSeletor.ID, labelValorComDescontoItemCarrinhoId);
			labelValorComDesconto = Double.valueOf(labelValorComDescontoItemCarrinho.getText().replace("$", " "));
			double valorCalculadoDesconto = valorSemDescontoFloat - ( (descontoFloat/100) * valorSemDescontoFloat);
			valorCalculadoDesconto = Double.valueOf(df.format(valorCalculadoDesconto).replace(",", "."));
			assertTrue(Constantes.TIRAR_PRINT, "Validando desconto aplicado com sucesso!", ( Double.compare(valorCalculadoDesconto, labelValorComDesconto) == 0) );
			System.out.println(valorCalculadoDesconto);
		}
	}
}
