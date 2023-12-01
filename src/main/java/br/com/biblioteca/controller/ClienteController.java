package br.com.biblioteca.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.model.Cliente;
import br.com.biblioteca.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	public ClienteController() {
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<Cliente> listCliente = clienteService.pesquisarClientes();
		model.addObject("listCliente", listCliente);
		model.setViewName("cliente-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {

		Cliente cliente = new Cliente();
		model.addObject("cliente", cliente);
		model.setViewName("cliente-form");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Cliente cliente) {

		ModelAndView model = new ModelAndView();

		List<String> erros = new ArrayList<String>();
		boolean erro = false;
		if (isCpfCadastrado(cliente)) {
			erro = true;
			erros.add("Já existe um cliente cadastrado para o CPF informado.");
		}
		if (isEmailCadastrado(cliente)) {
			erro = true;
			erros.add("Já existe um cliente cadastrado para o e-mail informado.");
		}

		if (erro) {
			model.addObject("cliente", cliente);
			model.addObject("erro", erro);
			model.addObject("erros", erros);
			model.setViewName("cliente-form");

		} else {
			clienteService.salvar(cliente);
			List<Cliente> listCliente = clienteService.pesquisarClientes();

			model.addObject("listCliente", listCliente);
			model.addObject("sucesso", Boolean.TRUE);
			model.setViewName("cliente-lista");
		}

		return model;
	}

	private boolean isCpfCadastrado(Cliente cliente) {

		Cliente clienteBD = clienteService.pesquisarClientePorCPF(cliente.getCpf());

		if (clienteBD != null) {
			// cpf já cadastrado

			if (cliente.getId() != null) {
				// edição
				if (clienteBD.getCpf().equals(cliente.getCpf())) {
					if (clienteBD.getId() == cliente.getId())
						return false;
					else
						return true;
				}
			}

			return true;
		} else {

			// cpf não cadastrado
			return false;
		}

	}

	private boolean isEmailCadastrado(Cliente cliente) {

		Cliente clienteBD = clienteService.pesquisarClientePorEmail(cliente.getEmail());

		if (clienteBD != null) {
			// email já cadastrado

			if (cliente.getId() != null) {
				// edição
				if (clienteBD.getEmail().equals(cliente.getEmail())) {
					if (clienteBD.getId() == cliente.getId())
						return false;
					else
						return true;
				}
			}

			return true;
		} else {

			// email não cadastrado
			return false;
		}

	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		clienteService.deletar(id);

		List<Cliente> listCliente = clienteService.pesquisarClientes();

		ModelAndView model = new ModelAndView();
		model.addObject("listCliente", listCliente);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("cliente-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Cliente cliente = clienteService.pesquisarClientePorId(id);

		ModelAndView model = new ModelAndView("cliente-form");
		model.addObject("cliente", cliente);

		return model;
	}

}
