package br.com.senai.lastdance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.lastdance.models.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

    List<Produtos> findByAtivoTrue();

    List<Produtos> findByCategoriaId(Integer categoriaId);

    List<Produtos> findByLojaIgnoreCase(String loja);

    List<Produtos> findByCategoriaIdAndAtivoTrue(Integer categoriaId);
}