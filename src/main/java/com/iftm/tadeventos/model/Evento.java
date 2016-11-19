package com.iftm.tadeventos.model;


import javax.persistence.*;

@Entity
@Table(name = "evento")
public class Evento {


    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long idevento;
    @Column private String titulo;
    @Column private String cidade;
    @Column private String estado;
    @Column private String Pais;
    @Column private String Descricao;
    @Column private String anfitriao;
    @Column private String datafim;
    @Column private String datainicio;
    @Column private String endereco;
    @Column private Double preco_entrada;
    @Column private int count_entradas;
    @Transient private int participantes;

    @Override public String toString() {
        return "Evento{" + "idevento=" + idevento + ", titulo=" + titulo + 
                ", cidade=" + cidade + ", estado=" + estado + ", Pais=" + Pais + 
                ", Descricao=" + Descricao + ", anfitriao=" + anfitriao + 
                ", datafim=" + datafim + ", datainicio=" + datainicio + ", endereco=" + endereco + 
                ", preco_entrada=" + preco_entrada + ", count_entradas=" + count_entradas + '}';
    }



	/**
	* Returns value of idevento
	* @return
	*/
	public Long getIdevento() {
		return idevento;
	}

	/**
	* Sets new value of idevento
	* @param
	*/
	public void setIdevento(Long idevento) {
		this.idevento = idevento;
	}

	/**
	* Returns value of titulo
	* @return
	*/
	public String getTitulo() {
		return titulo;
	}

	/**
	* Sets new value of titulo
	* @param
	*/
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	* Returns value of cidade
	* @return
	*/
	public String getCidade() {
		return cidade;
	}

	/**
	* Sets new value of cidade
	* @param
	*/
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	* Returns value of estado
	* @return
	*/
	public String getEstado() {
		return estado;
	}

	/**
	* Sets new value of estado
	* @param
	*/
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	* Returns value of Pais
	* @return
	*/
	public String getPais() {
		return Pais;
	}

	/**
	* Sets new value of Pais
	* @param
	*/
	public void setPais(String Pais) {
		this.Pais = Pais;
	}

	/**
	* Returns value of Descricao
	* @return
	*/
	public String getDescricao() {
		return Descricao;
	}

	/**
	* Sets new value of Descricao
	* @param
	*/
	public void setDescricao(String Descricao) {
		this.Descricao = Descricao;
	}

	/**
	* Returns value of anfitriao
	* @return
	*/
	public String getAnfitriao() {
		return anfitriao;
	}

	/**
	* Sets new value of anfitriao
	* @param
	*/
	public void setAnfitriao(String anfitriao) {
		this.anfitriao = anfitriao;
	}

	/**
	* Returns value of datafim
	* @return
	*/
	public String getDatafim() {
		return datafim;
	}

	/**
	* Sets new value of datafim
	* @param
	*/
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}

	/**
	* Returns value of datainicio
	* @return
	*/
	public String getDatainicio() {
		return datainicio;
	}

	/**
	* Sets new value of datainicio
	* @param
	*/
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}

	/**
	* Returns value of endereco
	* @return
	*/
	public String getEndereco() {
		return endereco;
	}

	/**
	* Sets new value of endereco
	* @param
	*/
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	* Returns value of preco_entrada
	* @return
	*/
	public Double getPreco_entrada() {
		return preco_entrada;
	}

	/**
	* Sets new value of preco_entrada
	* @param
	*/
	public void setPreco_entrada(Double preco_entrada) {
		this.preco_entrada = preco_entrada;
	}

	/**
	* Returns value of count_entradas
	* @return
	*/
	public int getCount_entradas() {
		return count_entradas;
	}

	/**
	* Sets new value of count_entradas
	* @param
	*/
	public void setCount_entradas(int count_entradas) {
		this.count_entradas = count_entradas;
	}

	/**
	* Returns value of participantes
	* @return
	*/
	public int getParticipantes() {
		return participantes;
	}

	/**
	* Sets new value of participantes
	* @param
	*/
	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}


}
