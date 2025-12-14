package br.com.senai.lastdance.models;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Produtos")
public class Produtos{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column (name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column (name="imagem_url")
    private String imagemUrl;

    @Column(name="preco", precision=10, scale=2)
    private BigDecimal preco;

    @Column(name="loja")
    private String loja;

    @Column(name="link_afiliado")
    private String linkAfiliado;

    @Column(name="ativo")
    private  boolean ativo;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Produtos() {
    }

    public Produtos(Integer id, String nome, String descricao, String imagemUrl, BigDecimal preco, String loja,
            String linkAfiliado, boolean ativo, LocalDateTime dataCriacao, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.preco = preco;
        this.loja = loja;
        this.linkAfiliado = linkAfiliado;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getLinkAfiliado() {
        return linkAfiliado;
    }

    public void setLinkAfiliado(String linkAfiliado) {
        this.linkAfiliado = linkAfiliado;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}