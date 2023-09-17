package br.com.biblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Usuario usuario) {
		sessionFactory.getCurrentSession().saveOrUpdate(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> pesquisarUsuarios() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		return criteria.list();
	}

	@Override
	public void deletar(Long idUsuario) {
		Usuario usuario = (Usuario) sessionFactory.getCurrentSession().load(Usuario.class, idUsuario);
		if (null != usuario) {
			this.sessionFactory.getCurrentSession().delete(usuario);
		}
	}

	@Override
	public Usuario pesquisarUsuarioPorId(Long idUsuario) {
		return (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, idUsuario);
	}

	@Override
	public Usuario pesquisarUsuarioPorEmailSenha(String email, String senha) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("senha", senha));

		return (Usuario) criteria.uniqueResult();
	}

}
