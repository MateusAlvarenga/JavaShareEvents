package br.edu.iftm.tadeventos.model;

public class Evento {

    private Long id;
    private User anfitriao;
    private String titulo;
    private String descricao;
    private String dataFim;
    private String dataInicio;
    private String endereco;
    private Double precoEntrada;
    private int participantes;
    
    public Evento(){
        
    }

 

    public Evento(User anfitriao, String titulo, String descricao, String dataFim, String dataInicio, String endereco, Double precoEntrada, int participantes) {
     
        this.anfitriao = anfitriao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.endereco = endereco;
        this.precoEntrada = precoEntrada;
        this.participantes = participantes;
        
    }

 

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", descricao=" + descricao + ", anfitriao=" + anfitriao + ", dataFim=" + dataFim + ", dataInicio=" + dataInicio + ", endereco=" + endereco + ", precoEntrada=" + precoEntrada + ", participantes=" + participantes + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public User getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(User anfitriao) {
        this.anfitriao = anfitriao;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getPrecoEntrada() {
        return precoEntrada;
    }

    public void setPrecoEntrada(Double precoEntrada) {
        this.precoEntrada = precoEntrada;
    }

    public int getParticipantes() {
        return participantes;
    }

    public void setParticipantes(int participantes) {
        this.participantes = participantes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void addParticipantes() {
        participantes++;
    }

}
