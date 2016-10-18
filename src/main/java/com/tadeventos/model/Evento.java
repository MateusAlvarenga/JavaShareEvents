package com.tadeventos.model;


import javax.persistence.*;

@Entity
@Table(name = "evento")
public class Evento {
    
 
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idevento;
    @Column
    private String titulo;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private String Pais;
    @Column
    private String Descricao;
    @Column
    private String anfitriao;
    @Column
    private String datafim;
    @Column
    private String datainicio;
    @Column
    private String endereco;
    @Column
    private Double preco_entrada;
    @Column
    private int count_entradas;


    public Long getIdevento() {
            return idevento;
    }

    public Double getPreco_entrada() {
        return preco_entrada;
    }

    public void setPreco_entrada(Double preco_entrada) {
        this.preco_entrada = preco_entrada;
    }

    public int getCount_entradas() {
        return count_entradas;
    }

    public void setCount_entradas(int count_entradas) {
        this.count_entradas = count_entradas;
    }

    public String getTitulo() {
            return titulo;
    }

    public String getCidade() {
            return cidade;
    }

    public String getEstado() {
            return estado;
    }

    public String getPais() {
            return Pais;
    }

    public String getDescricao() {
            return Descricao;
    }

    public String getAnfitriao() {
            return anfitriao;
    }

    public String getDatafim() {
            return datafim;
    }

    public String getDatainicio() {
            return datainicio;
    }

    public String getEndereco() {
            return endereco;
    }

    public void setIdevento(Long idevento) {
            this.idevento = idevento;
    }

    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }

    public void setCidade(String cidade) {
            this.cidade = cidade;
    }

    public void setEstado(String estado) {
            this.estado = estado;
    }

    public void setPais(String Pais) {
            this.Pais = Pais;
    }

    public void setDescricao(String Descricao) {
            this.Descricao = Descricao;
    }

    public void setAnfitriao(String anfitriao) {
            this.anfitriao = anfitriao;
    }

    public void setDatafim(String datafim) {
            this.datafim = datafim;
    }

    public void setDatainicio(String datainicio) {
            this.datainicio = datainicio;
    }

    public void setEndereco(String endereco) {
            this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Evento{" + "idevento=" + idevento + ", titulo=" + titulo + ", cidade=" + cidade + ", estado=" + estado + ", Pais=" + Pais + ", Descricao=" + Descricao + ", anfitriao=" + anfitriao + ", datafim=" + datafim + ", datainicio=" + datainicio + ", endereco=" + endereco + '}';
    }


}
