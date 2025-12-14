package br.com.senai.lastdance.services;

import java.text.Normalizer;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senai.lastdance.models.Categoria;
import br.com.senai.lastdance.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // 🔹 Listar todas as categorias
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    // 🔹 Criar categoria (gera slug automaticamente)
    public Categoria criarCategoria(String nome) {

        String slug = gerarSlug(nome);

        if (categoriaRepository.existsBySlug(slug)) {
            throw new RuntimeException("Categoria já existe");
        }

        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        categoria.setSlug(slug);

        return categoriaRepository.save(categoria);
    }

    // 🔹 Gerador de slug (ex: "Celulares e Acessórios" → "celulares-e-acessorios")
    private String gerarSlug(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");
    }
}
