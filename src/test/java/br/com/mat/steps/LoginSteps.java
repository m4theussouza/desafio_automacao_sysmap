 package br.com.mat.steps;

import java.io.IOException;

import br.com.mat.pages.HomePage;
import br.com.mat.pages.LoginPage;
import br.com.mat.pages.SearchPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	 	
	 	LoginPage loginPage = new LoginPage();
	 	HomePage homePage = new HomePage();
	 	SearchPage searchPage = new SearchPage();
	 	
	 	@Dado("que eu acesse a página home do site")
	 	public void que_eu_acesse_a_página_home_do_site() throws InterruptedException, IOException {
	 		homePage.validarTelaHome();
	 	}

	 	@Dado("digitar o nome do produto {string} no campo de pesquisa")
	 	public void digitar_o_nome_do_produto_no_campo_de_pesquisa(String produto) throws InterruptedException, IOException {
	 	    homePage.digitarProdutoCampoDePesquisa(produto);
	 	}

	 	@Quando("clicar no botão pesquisar")
	 	public void clicar_no_botão_pesquisar() throws InterruptedException {
	 		homePage.clicarBotaoPesquisar();
	 	}

	 	@Então("devo conferir se o produto {string} foi listado no site")
	 	public void devo_conferir_se_o_produto_foi_listado_no_site(String produto) throws InterruptedException, IOException {
	 		searchPage.conferirResultadoDaBusca(produto);
	 	}

	 	@Então("devo conferir mensagem de erro \"No results were found for your search \"ProdutoNãoExistente\"\"")
	 	public void devo_conferir_mensagem_de_erro_No_results_were_found_for_your_search_ProdutoNãoExistente() throws InterruptedException, IOException {
	 		searchPage.conferindoMensagemDeErroProdutoNaoExistente();
	 	}

	 	@Dado("passar o mouse por cima da categoria {string} no menu principal superior de categorias")
	 	public void passar_o_mouse_por_cima_da_categoria_no_menu_principal_superior_de_categorias(String string) {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Quando("clicar na sub categoria {string}")
	 	public void clicar_na_sub_categoria(String string) {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Então("devo conferir se sub categoria {string} foi apresentada")
	 	public void devo_conferir_se_sub_categoria_foi_apresentada(String string) {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}
	 	
	 	@Quando("clicar no botão Add to cart do produto")
	 	public void clicar_no_botão_Add_to_cart_do_produto() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Quando("clicar no botão Proceed to checkout")
	 	public void clicar_no_botão_Proceed_to_checkout() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Então("devo realizar as asserções referentes ao produto adicionado, que considere importante para a validação do cenário, na tela Shopping-cart sumary.")
	 	public void devo_realizar_as_asserções_referentes_ao_produto_adicionado_que_considere_importante_para_a_validação_do_cenário_na_tela_Shopping_cart_sumary() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}


	 	@Dado("dar um scroll até a aba Best Sellers")
	 	public void dar_um_scroll_até_a_aba_Best_Sellers() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Quando("clicar na aba Best Sellers")
	 	public void clicar_na_aba_Best_Sellers() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Quando("selecionar um item que tenha {int}% de desconto")
	 	public void selecionar_um_item_que_tenha_de_desconto(Integer int1) {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Quando("adicionar no carrinho")
	 	public void adicionar_no_carrinho() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Quando("validar os valores que são apresentados no pop-up Product successfully added to your shopping cart")
	 	public void validar_os_valores_que_são_apresentados_no_pop_up_Product_successfully_added_to_your_shopping_cart() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}

	 	@Quando("clicar em Proceed to checkout")
	 	public void clicar_em_Proceed_to_checkout() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}
}





