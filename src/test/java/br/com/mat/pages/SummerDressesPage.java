package br.com.mat.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import br.com.mat.utils.PageBase;

public class SummerDressesPage extends PageBase{
	String labelSummerDressesXpath = "//span[contains(text(),'Summer Dresses ')]";
	
	public void validarSummerDressesPage() throws InterruptedException, IOException {
		if( elementoExiste(TipoSeletor.XPATH, labelSummerDressesXpath, Constantes.TIME_WAIT_ELEMENT_EXIST) ) {
			WebElement labelSummerDresses = pegarElementoWeb(TipoSeletor.XPATH, labelSummerDressesXpath);
			assertTrue(Constantes.TIRAR_PRINT, "Validando Pagina Summer Dresses", labelSummerDresses.getText().contains("Summer Dresses"));
		}
	}
}
