package br.com.mat.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.itextpdf.text.DocumentException;

import br.com.mat.steps.BuscasEValidacoesSteps;
import br.com.mat.utils.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class FazerLoginTest extends Setup {

	public static WebDriver driver;
	
	
	public BuscasEValidacoesSteps loginSteps = new BuscasEValidacoesSteps();
	
	@Before
	public void setupStart(Scenario scenario) throws IOException {
		beforeConfiguracao(scenario);
		iniciar(driver, caminhoPastas);
	}
	
	@After
	public void setupEnd(Scenario scenario) throws IOException, DocumentException {
		afterConfiguracao(scenario);
		fechar();
	}
	
}
