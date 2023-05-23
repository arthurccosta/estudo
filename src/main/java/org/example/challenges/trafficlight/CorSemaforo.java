package org.example.challenges.trafficlight;

public enum CorSemaforo {

    VERDE(10000, "AMARELO"),
    AMARELO(3000, "VERMELHO"),
    VERMELHO(5000, "VERDE");

    private int tempoEspera;
    private String proximaCor;

    CorSemaforo(int tempoEspera, String proximaCor) {
        this.tempoEspera = tempoEspera;
        this.proximaCor = proximaCor;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public String getProximaCor() {
        return proximaCor;
    }


}
