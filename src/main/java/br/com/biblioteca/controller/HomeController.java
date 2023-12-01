package br.com.biblioteca.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.model.Funcionario;
import br.com.biblioteca.service.FuncionarioService;

@Controller
public class HomeController {

	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView model) throws IOException {
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/meus-dados", method = RequestMethod.GET)
	public ModelAndView meusDados(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));

		Funcionario funcionarioLogado = funcionarioService.pesquisarFuncionarioPorId(id);

		ModelAndView model = new ModelAndView();

		Funcionario funcionario = (Funcionario) funcionarioLogado;
		model.addObject("funcionario", funcionario);
		model.setViewName("funcionario-dados-pessoais-form");

		return model;
	}
}
