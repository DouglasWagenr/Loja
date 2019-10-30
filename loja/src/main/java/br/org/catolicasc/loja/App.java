package br.org.catolicasc.loja;

import br.org.catolicasc.loja.entities.Cliente;
import br.org.catolicasc.loja.entities.ItemPedido;
import br.org.catolicasc.loja.entities.PessoaJuridica;
import br.org.catolicasc.loja.entities.PessoaFisica;
import br.org.catolicasc.loja.entities.Pedido;
import br.org.catolicasc.loja.entities.Produto;

import br.org.catolicasc.loja.dao.DaoFactory;
import br.org.catolicasc.loja.dao.IDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	// Create Products
    	IDao<Cliente> clienteDao = DaoFactory.getClienteDao();
    	IDao<Produto> produtoDao = DaoFactory.getProdutoDao();
    	IDao<Pedido> pedidoDao = DaoFactory.getPedidoDao();
    	IDao<ItemPedido> itemPedidoDao = DaoFactory.getItemPedidoDao();
    	
    	Produto produto1 = new Produto();
    	produto1.setNome("Produto1");
    	produto1.setPreco(99.50);

    	Produto produto2 = new Produto();
    	produto2.setNome("Produto2");
    	produto2.setPreco(10.00);

    	produtoDao.save(produto1);
    	produtoDao.save(produto2);

    	PessoaJuridica pj1 = new PessoaJuridica();
    	pj1.setCnpj("11111111");
    	pj1.setName("Oracle");
    	
    	PessoaFisica pf1 = new PessoaFisica();
    	pf1.setCpf("222222222");
    	pf1.setName("Pessoa 1");
    	clienteDao.save(pj1);
    	clienteDao.save(pf1);
    	
    	Pedido pjPedido = new Pedido();
    	Pedido pfPedido = new Pedido();
    	pjPedido.setCliente(pj1);
    	pfPedido.setCliente(pf1);
    	pedidoDao.save(pjPedido);
    	pedidoDao.save(pfPedido);

    	ItemPedido pjItemPedido = new ItemPedido();
    	pjItemPedido.setPedido(pjPedido);
    	pjItemPedido.setQuantidade(1);
    	pjItemPedido.setProduto(produto1);

    	ItemPedido pfItemPedido = new ItemPedido();
    	pfItemPedido.setPedido(pfPedido);
    	pfItemPedido.setQuantidade(1);
    	pfItemPedido.setProduto(produto2);
    	itemPedidoDao.save(pjItemPedido);
    	itemPedidoDao.save(pfItemPedido);
    	
    }
}
