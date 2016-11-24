package br.edu.iftm.tadeventos.model;

public class Compra {

    private Long id;
    private Evento evento;
    private User user;
    private int quantidade;
    private Double total;

    public Compra() {
    }

    public Compra(Evento evento, User user, int i, double d) {
       
        this.evento = evento;
        this.user = user;
        this.quantidade = quantidade;
        this.total = total; }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    } 

    public void addQuantidade() {
        quantidade++;
        total = evento.getPrecoEntrada() * quantidade;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", evento=" + evento + ", user=" + user + ", quantidade=" + quantidade + ", total=" + total + '}';
    }   
}
