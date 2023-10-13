package br.com.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.biblioteca.dao.AutorDAO;
import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.model.Autor;
import br.com.biblioteca.model.Livro;

@Service
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroDAO livroDAO;

	@Autowired
	private AutorDAO autorDAO;

	@Override
	@Transactional
	public void salvar(Livro livro) {

		String idsAutores[] = livro.getIdsAutores().split(",");

		List<Autor> autores = new ArrayList<Autor>();
		for (int i = 0; i < idsAutores.length; i++) {
			Autor autor = autorDAO.pesquisarAutorPorId(Long.parseLong(idsAutores[i]));
			autores.add(autor);
		}

		livro.setAutores(autores);
		livro.setQtdDisponivel(livro.getQtdExemplares());
		livroDAO.salvar(livro);
	}

	@Override
	@Transactional
	public List<Livro> pesquisarLivros() {
		return livroDAO.pesquisarLivros();
	}

	@Override
	@Transactional
	public void deletar(Long idLivro) {
		livroDAO.deletar(idLivro);
	}

	@Override
	@Transactional
	public Livro pesquisarLivroPorId(Long idLivro) {
		return livroDAO.pesquisarLivroPorId(idLivro);
	}

	@Override
	@Transactional
	public Livro pesquisarLivroPorISBN(String isbn) {
		return livroDAO.pesquisarLivroPorISBN(isbn);
	}

	@Override
	@Transactional
	public boolean existeLivroParaISBN(String isbn) {

		Livro livro = this.pesquisarLivroPorISBN(isbn);
		if (livro != null)
			return true;

		return false;
	}

	@Override
	@Transactional
	public List<Livro> pesquisarLivrosDisponiveis() {
		return livroDAO.pesquisarLivrosDisponiveis();
	}

}