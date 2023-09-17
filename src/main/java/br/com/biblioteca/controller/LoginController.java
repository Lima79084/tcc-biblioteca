package br.com.biblioteca.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "login")
	public ModelAndView login(Usuario usuario, HttpSession session) throws IOException, GeneralSecurityException {

		Usuario usuarioLogado = loginService.realizarLogin(usuario.getEmail(), usuario.getSenha());

		ModelAndView model = new ModelAndView();

		if (usuarioLogado != null) {
			// usu�rio logado
			session.setAttribute("usuarioLogado", usuarioLogado);
			session.setAttribute("idUsuarioLogado", usuarioLogado.getId());
			
			model.addObject("sucesso", Boolean.TRUE);
			model.setViewName("principal");
			return model;
		}
		
		// usu�rio n�o logado
		model.addObject("sucesso", Boolean.FALSE);
		model.setViewName("index");
		return model;
	}

	@RequestMapping("sair")
	public ModelAndView sair(HttpSession session) {
		session.invalidate();

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

}
