package br.edu.iftm.tadeventos.model;

public class Evento {

    private Long idevento;
    private String titulo;
    private String cidade;
    private String estado;
    private String Pais;
    private String descricao;
    private String anfitriao;
    private String datafim;
    private String datainicio;
    private String endereco;
    private Double preco_entrada;
    private int count_entradas;
    private int participantes;

    @Override
    public String toString() {
        return "Evento{" + "idevento=" + idevento + ", titulo=" + titulo
                + ", cidade=" + cidade + ", estado=" + estado + ", Pais=" + Pais
                + ", Descricao=" + descricao + ", anfitriao=" + anfitriao
                + ", datafim=" + datafim + ", datainicio=" + datainicio + ", endereco=" + endereco
                + ", preco_entrada=" + preco_entrada + ", count_entradas=" + count_entradas + '}';
    }
    
    public Long getIdevento() {
        return idevento;
    }
    
    public void setIdevento(Long idevento) {
        this.idevento = idevento;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getPais() {
        return Pais;
    }
    
    public void setPais(String Pais) {
        this.Pais = Pais;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getAnfitriao() {
        return anfitriao;
    }
    
    public void setAnfitriao(String anfitriao) {
        this.anfitriao = anfitriao;
    }

    public String getDatafim() {
        return datafim;
    }
    
    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }
    
    public String getDatainicio() {
        return datainicio;
    }
    
    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
    
    public int getParticipantes() {
        return participantes;
    }
    
    public void setParticipantes(int participantes) {
        this.participantes = participantes;
    }

}
