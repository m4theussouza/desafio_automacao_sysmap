package br.com.mat.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


/**
 * @author Matheus
 *
 */

/**
 * 
 * Caso queira executar somente um teste especifico adicione tags = {"@Teste01"}
 * Em Cucumber options
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"br.com.mat.test", "br.com.mat.steps", "br.com.mat.utils"}, //
		features = "src\\test\\resources\\features", 
		plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json", "junit:target/cucumber.xml"},
		monochrome = false)
public class Runner extends AbstractTestNGCucumberTests {

}
