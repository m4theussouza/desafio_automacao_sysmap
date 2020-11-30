 package br.com.mat.steps;

import java.io.IOException;

import br.com.mat.pages.HomePage;
import br.com.mat.pages.LoginPage;
import br.com.mat.pages.SearchPage;
import br.com.mat.pages.ShoppingCartPage;
import br.com.mat.pages.SummerDressesPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class BuscasEValidacoesSteps {
	 	
	 	LoginPage loginPage = new LoginPage();
	 	HomePage homePage = new HomePage();
	 	SearchPage searchPage = new SearchPage();
	 	SummerDressesPage summerDressesPage = new SummerDressesPage();
	 	ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
	 	
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
	 	public void passar_o_mouse_por_cima_da_categoria_no_menu_principal_superior_de_categorias(String categoria) throws InterruptedException, IOException {
	 		homePage.colocarMouseEmCimaDaCategoria(categoria);
	 		homePage.validarMouseEmCimaDaCategoria(categoria);
	 	}

	 	@Quando("clicar na sub categoria {string} com categoria superior {string}")
	 	public void clicar_na_sub_categoria(String subCategoria, String categoriaPrincipal) throws InterruptedException {
	 	    homePage.clicarSubCategoria(categoriaPrincipal, subCategoria);
	 	}

	 	@Então("devo conferir se sub categoria {string} foi apresentada")
	 	public void devo_conferir_se_sub_categoria_foi_apresentada(String string) throws InterruptedException, IOException {
	 		summerDressesPage.validarSummerDressesPage();
	 	}
	 	
	 	@Quando("clicar no botão Add to cart do produto {string}")
	 	public void clicar_no_botão_Add_to_cart_do_produto(String produto) throws InterruptedException, IOException {
	 	    searchPage.clicarBotaoAddToCartDoProdutoProcurado(produto);
	 	    searchPage.validarProdutoAdicionadoNoCarrinho();
	 	}

	 	@Quando("clicar no botão Proceed to checkout")
	 	public void clicar_no_botão_Proceed_to_checkout() throws InterruptedException, IOException {
	 	   searchPage.clicarBotaoProceedToCheckout();
	 	   shoppingCartPage.validarTelaShoppingCart();
	 	}

	 	@Então("valido que a descriacao do produto contem {string}")
	 	public void valido_que_a_descriacao_do_produto_contem(String produto) throws InterruptedException, IOException {
	 		shoppingCartPage.validarExistenciaDoNomeDoProdutoNaDescricao(produto);
	 	}
	 	
	 	@Então("valido que a quantidade de produtos adicionados é igual a {string}")
	 	public void valido_que_a_quantidade_de_produtos_adicionados_e_igual_a(String quantidadeAdicionada) throws InterruptedException, IOException {
	 		shoppingCartPage.validarQuantidadeDeProdutosNoAdicionados(quantidadeAdicionada);
	 	}

	 	@Dado("dar um scroll até a aba Best Sellers")
	 	public void dar_um_scroll_até_a_aba_Best_Sellers() throws InterruptedException {
	 	    homePage.scrollAbaBestSellers();
	 	}

	 	@Quando("clicar na aba Best Sellers")
	 	public void clicar_na_aba_Best_Sellers() throws InterruptedException {
	 	    homePage.clicarAbaBestSellers();
	 	}

	 	@Quando("selecionar um item que tenha {int}% de desconto")
	 	public void selecionar_um_item_que_tenha_de_desconto(Integer desconto) throws InterruptedException {
	 	    homePage.clicarElementoComPorcentagemDeDesconto(desconto);
	 	    System.out.println("Break");
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
	 	
	 	@Então("devo realizar as asserções referentes ao produto adicionado, que considere importante para a validação do cenário, na tela Shopping-cart sumary.")
	 	public void devo_realizar_as_asserções_referentes_ao_produto_adicionado_que_considere_importante_para_a_validação_do_cenário_na_tela_Shopping_cart_sumary() {
	 	    // Write code here that turns the phrase above into concrete actions
	 	    throw new io.cucumber.java.PendingException();
	 	}
}





