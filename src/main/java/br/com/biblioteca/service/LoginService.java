package br.com.biblioteca.service;

import br.com.biblioteca.model.Funcionario;

public interface LoginService {

	public Funcionario realizarLogin(String login, String senha);

}