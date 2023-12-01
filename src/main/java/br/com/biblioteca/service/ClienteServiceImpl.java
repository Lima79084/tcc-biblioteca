package br.com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.biblioteca.dao.ClienteDAO;
import br.com.biblioteca.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	@Transactional
	public void salvar(Cliente cliente) {
		this.clienteDAO.salvar(cliente);
	}

	@Override
	@Transactional
	public List<Cliente> pesquisarClientes() {
		return clienteDAO.pesquisarClientes();
	}

	@Override
	@Transactional
	public void deletar(Long idCliente) {
		clienteDAO.deletar(idCliente);
	}

	@Override
	@Transactional
	public Cliente pesquisarClientePorId(Long idCliente) {
		return clienteDAO.pesquisarClientePorId(idCliente);
	}

	@Override
	@Transactional
	public Cliente pesquisarClientePorCPF(String cpf) {
		return clienteDAO.pesquisarClientePorCPF(cpf);
	}

	@Override
	@Transactional
	public Cliente pesquisarClientePorEmail(String email) {
		return clienteDAO.pesquisarClientePorEmail(email);
	}

}