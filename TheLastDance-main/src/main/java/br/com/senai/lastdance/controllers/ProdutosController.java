package br.com.senai.lastdance.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.lastdance.models.Produtos;
import br.com.senai.lastdance.services.ProdutosService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    private final ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @GetMapping
    public List<Produtos> listarProdutos(
            @RequestParam(required = false) Integer categoriaId,
            @RequestParam(required = false) String loja
    ) {

        if (categoriaId != null && loja != null) {
            return produtosService.buscarPorCategoriaELoja(categoriaId, loja);
        }

        if (categoriaId != null) {
            return produtosService.buscarPorCategoria(categoriaId);
        }

        if (loja != null) {
            return produtosService.buscarPorLoja(loja);
        }

        return produtosService.buscarAtivos();
    }
}
