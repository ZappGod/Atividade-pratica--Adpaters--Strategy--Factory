package midiasocial.unific.models;

// Modelo de dados unificado para estatísticas
public class Estatisticas {
    private int curtidas;
    private int compartilhamentos;
    private int comentarios;

    public Estatisticas(int curtidas, int compartilhamentos, int comentarios) {
        this.curtidas = curtidas;
        this.compartilhamentos = compartilhamentos;
        this.comentarios = comentarios;
    }
    
    @Override
    public String toString() {
        return "Estatisticas [curtidas=" + curtidas + ", compartilhamentos=" + compartilhamentos + ", comentarios=" + comentarios + "]";
    }
}