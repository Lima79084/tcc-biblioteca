package br.com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.biblioteca.dao.FuncionarioDAO;
import br.com.biblioteca.model.Funcionario;
import br.com.biblioteca.utils.SenhaUtils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@Override
	@Transactional
	public Funcionario realizarLogin(String login, String senha) {
		return funcionarioDAO.pesquisarUsuarioPorLoginSenha(login, SenhaUtils.convertStringToMd5(senha));
	}

}