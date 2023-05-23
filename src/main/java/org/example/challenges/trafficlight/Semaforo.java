package org.example.challenges.trafficlight;

import static java.lang.Thread.sleep;

public class Semaforo implements Runnable {

    private CorSemaforo cor;
    private boolean parar;
    private boolean corMudou;

    public Semaforo() {
        this.cor = CorSemaforo.VERMELHO;
        this.parar = false;
        this.corMudou = false;

        new Thread(this).start();
    }


    @Override
    public void run() {

        while (!parar) {
            try {
                sleep(this.cor.getTempoEspera());
                this.mudarCor2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private synchronized void mudarCor2(){
        this.cor = CorSemaforo.valueOf(this.cor.getProximaCor());
        this.corMudou = true;
        notify();
    }
    private synchronized void mudarCor() {
        switch (this.cor) {
            case VERMELHO:
                this.cor = CorSemaforo.VERDE;
                break;
            case AMARELO:
                this.cor = CorSemaforo.VERMELHO;
                break;
            case VERDE:
                this.cor = CorSemaforo.AMARELO;
                break;
            default:
                break;
        }
        this.corMudou = true;
        notify();
    }

    public synchronized void esperaCorMudar() {
        while (!this.corMudou) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.corMudou = false;
    }

    public synchronized void desligarSemaforo() {
        this.parar = true;
    }

    public CorSemaforo getCor() {
        return cor;
    }
}
