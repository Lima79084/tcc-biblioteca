package br.com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.utils.SenhaUtils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public Usuario realizarLogin(String email, String senha) {
		return usuarioDAO.pesquisarUsuarioPorEmailSenha(email, SenhaUtils.convertStringToMd5(senha));
	}

}