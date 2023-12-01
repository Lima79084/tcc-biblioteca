package br.com.biblioteca.service;

import java.util.List;

import br.com.biblioteca.model.Cliente;

public interface ClienteService {

	public void salvar(Cliente cliente);

	public List<Cliente> pesquisarClientes();

	public void deletar(Long idCliente);

	public Cliente pesquisarClientePorId(Long idCliente);

	public Cliente pesquisarClientePorEmail(String email);
	
	public Cliente pesquisarClientePorCPF(String cpf);
	
}