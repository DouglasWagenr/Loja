package br.org.catolicasc.loja.dao;

import br.org.catolicasc.loja.entities.Cliente;
import br.org.catolicasc.loja.entities.Pedido;
import br.org.catolicasc.loja.entities.ItemPedido;
import br.org.catolicasc.loja.entities.Produto;

public class DaoFactory {
	
	public static IDao<Cliente> getClienteDao() {
		return new ClienteDao();
	}
	public static IDao<Pedido> getPedidoDao() {
		return new PedidoDao();
	}
	public static IDao<ItemPedido> getItemPedidoDao() {
		return new ItemPedidoDao();
	}
	public static IDao<Produto> getProdutoDao() {
		return new ProdutoDao();
	}
}
