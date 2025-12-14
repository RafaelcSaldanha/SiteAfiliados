package br.com.senai.lastdance.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.lastdance.models.Categoria;
import br.com.senai.lastdance.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // 🔹 Listar categorias (FlutterFlow)
    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarTodas();
    }

    // 🔹 Criar categoria (admin / painel)
    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.criarCategoria(categoria.getNome());
    }
}
