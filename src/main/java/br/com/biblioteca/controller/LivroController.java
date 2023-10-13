package br.com.biblioteca.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.model.Autor;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.service.AutorService;
import br.com.biblioteca.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@Autowired
	private AutorService autorService;

	public LivroController() {
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listarLivro(ModelAndView model) throws IOException {
		List<Livro> listLivro = livroService.pesquisarLivros();
		model.addObject("listLivro", listLivro);
		model.setViewName("livro-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {

		List<Autor> autores = autorService.pesquisarAutores();

		Livro livro = new Livro();
		model.addObject("livro", livro);
		model.addObject("autores", autores);
		model.setViewName("livro-form");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Livro livro) {

		ModelAndView model = new ModelAndView();

		livroService.salvar(livro);

		List<Livro> listLivro = livroService.pesquisarLivros();

		model.addObject("listLivro", listLivro);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("livro-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		livroService.deletar(id);

		List<Livro> listLivro = livroService.pesquisarLivros();

		ModelAndView model = new ModelAndView();
		model.addObject("listLivro", listLivro);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("livro-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Livro livro = livroService.pesquisarLivroPorId(id);

		List<Autor> autores = autorService.pesquisarAutores();

		for (Autor autor : autores) {
			for (Autor autorSelecionado : livro.getAutores()) {
				if (autor.getId() == autorSelecionado.getId()) {
					autor.setSelecionado(true);
				}
			}
		}

		ModelAndView model = new ModelAndView("livro-form");
		model.addObject("autores", autores);
		model.addObject("livro", livro);

		return model;
	}

}
