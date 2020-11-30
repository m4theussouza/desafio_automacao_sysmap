#language:pt
Funcionalidade: Buscas e Validacoes Site de Compras
	@Teste01
    Cenário: CT0001 Pesquisar produto existente
	    Dado que eu acesse a página home do site
	    E digitar o nome do produto "Blouse" no campo de pesquisa
	    Quando clicar no botão pesquisar
	    Então devo conferir se o produto "Blouse" foi listado no site
	
	@Teste02
    Cenário: CT0002 Pesquisar produto não existente
	    Dado que eu acesse a página home do site
	    E digitar o nome do produto "ProdutoNãoExistente" no campo de pesquisa
	    Quando clicar no botão pesquisar
	    Então devo conferir mensagem de erro "No results were found for your search "ProdutoNãoExistente""
	
	@Teste03
    Cenário: CT0003 Selecionar Categoria
	    Dado que eu acesse a página home do site
	    E passar o mouse por cima da categoria "Women" no menu principal superior de categorias
	    Quando clicar na sub categoria "Summer Dresses" com categoria superior "Women"
	    Então devo conferir se sub categoria "SUMMER DRESSES " foi apresentada
	
	@Teste04
    Cenário: CT0004 Adicionar Produtos no Carrinho
	    Dado que eu acesse a página home do site
	    E digitar o nome do produto "T-shirts" no campo de pesquisa
	    Quando clicar no botão pesquisar
	    E clicar no botão Add to cart do produto "T-shirts"
	    E clicar no botão Proceed to checkout
	    Então valido que a descriacao do produto contem "T-shirts"
	    E valido que a quantidade de produtos adicionados é igual a "1"
	
	@Teste05
    Cenário: CT0005 Adicionar Produtos no Carrinho
	    Dado que eu acesse a página home do site
	    E dar um scroll até a aba Best Sellers
	    Quando clicar na aba Best Sellers
	    E selecionar um item que tenha 5% de desconto
	    E adicionar no carrinho
	    E validar os valores que são apresentados no pop-up Product successfully added to your shopping cart
	    E clicar em Proceed to checkout
	    Então devo realizar as asserções referentes ao produto adicionado, que considere importante para a validação do cenário, na tela Shopping-cart sumary.

