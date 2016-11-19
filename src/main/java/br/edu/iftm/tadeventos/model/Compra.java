package br.edu.iftm.tadeventos.model;

public class Compra {

    private int idCompra;
    private int evento_idevento;
    private String numero_cartao;
    private String bandeira;
    private String data_vencimento;
    private String digito_validador;
    private String user;
    private int qtd;
    private Double valorTotal;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * Returns value of idCompra
     *
     * @return
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * Sets new value of idCompra
     *
     * @param
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * Returns value of evento_idevento
     *
     * @return
     */
    public int getEvento_idevento() {
        return evento_idevento;
    }

    /**
     * Sets new value of evento_idevento
     *
     * @param
     */
    public void setEvento_idevento(int evento_idevento) {
        this.evento_idevento = evento_idevento;
    }

    /**
     * Returns value of numero_cartao
     *
     * @return
     */
    public String getNumero_cartao() {
        return numero_cartao;
    }

    /**
     * Sets new value of numero_cartao
     *
     * @param
     */
    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    /**
     * Returns value of bandeira
     *
     * @return
     */
    public String getBandeira() {
        return bandeira;
    }

    /**
     * Sets new value of bandeira
     *
     * @param
     */
    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    /**
     * Returns value of data_vencimento
     *
     * @return
     */
    public String getData_vencimento() {
        return data_vencimento;
    }

    /**
     * Sets new value of data_vencimento
     *
     * @param
     */
    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    /**
     * Returns value of digito_validador
     *
     * @return
     */
    public String getDigito_validador() {
        return digito_validador;
    }

    /**
     * Sets new value of digito_validador
     *
     * @param
     */
    public void setDigito_validador(String digito_validador) {
        this.digito_validador = digito_validador;
    }

    /**
     * Returns value of user
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets new value of user
     *
     * @param
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Create string representation of Evento for printing
     *
     * @return
     */
    @Override
    public String toString() {
        return "compra[idCompra=" + idCompra + ", evento_idevento=" + evento_idevento + ", numero_cartao=" + numero_cartao + ", bandeira=" + bandeira + ", data_vencimento=" + data_vencimento + ", digito_validador=" + digito_validador + ", user=" + user + ", qtd=" + qtd +"]";
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
