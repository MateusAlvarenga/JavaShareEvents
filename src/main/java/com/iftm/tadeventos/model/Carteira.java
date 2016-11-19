package com.iftm.tadeventos.model;


public class Carteira {
    
    private int proprietario;
    private Double saldo;

    public Carteira() {
    }
        
    public Carteira(int proprietario, Double saldo) {
        this.proprietario = proprietario;
        this.saldo = saldo;
    }    
    
    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    public void atualizaSaldo(Double incremento){
        this.saldo = this.saldo + (incremento * 0.8);
    }
    
}
