package br.com.senai.lastdance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.lastdance.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    boolean existsBySlug(String slug);
}
