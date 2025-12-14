package br.com.senai.lastdance.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senai.lastdance.models.Produtos;
import br.com.senai.lastdance.repositories.ProdutosRepository;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    // 🔹 Buscar todos os produtos ativos
    public List<Produtos> buscarAtivos() {
        return produtosRepository.findByAtivoTrue();
    }

    // 🔹 Buscar produtos por categoria
    public List<Produtos> buscarPorCategoria(Integer categoriaId) {
        return produtosRepository.findByCategoriaIdAndAtivoTrue(categoriaId);
    }

    // 🔹 Buscar produtos por loja
    public List<Produtos> buscarPorLoja(String loja) {
        return produtosRepository.findByLojaIgnoreCase(loja);
    }

    // 🔹 Buscar produtos por categoria + loja
    public List<Produtos> buscarPorCategoriaELoja(Integer categoriaId, String loja) {
        return produtosRepository.findByCategoriaIdAndAtivoTrue(categoriaId)
                .stream()
                .filter(p -> p.getLoja().equalsIgnoreCase(loja))
                .toList();
    }
}

