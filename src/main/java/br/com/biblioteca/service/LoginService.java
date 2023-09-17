package br.com.biblioteca.service;

import br.com.biblioteca.model.Usuario;

public interface LoginService {

	public Usuario realizarLogin(String login, String senha);

}