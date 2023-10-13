package br.com.biblioteca.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.model.Autor;
import br.com.biblioteca.service.AutorService;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	public AutorController() {
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<Autor> listAutor = autorService.pesquisarAutores();
		model.addObject("listAutor", listAutor);
		model.setViewName("autor-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		
		Autor autor = new Autor();
		model.addObject("autor", autor);
		model.setViewName("autor-form");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Autor autor) {

		autorService.salvar(autor);
		List<Autor> listAutor = autorService.pesquisarAutores();

		ModelAndView model = new ModelAndView();
		model.addObject("listAutor", listAutor);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("autor-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		autorService.deletar(id);

		List<Autor> listAutor = autorService.pesquisarAutores();

		ModelAndView model = new ModelAndView();
		model.addObject("listAutor", listAutor);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("autor-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Autor autor = autorService.pesquisarAutorPorId(id);
		ModelAndView model = new ModelAndView("autor-form");
		model.addObject("autor", autor);

		return model;
	}
	
}
