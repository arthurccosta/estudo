package org.example.challenges.trafficlight;

/**
 * Simule um semáforo de transito.
 */
public class SimularSemaforo {

    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();

        for(int i=0; i<=10; i++){
            System.out.println(semaforo.getCor());
            semaforo.esperaCorMudar();
        }
        semaforo.desligarSemaforo();
    }
}
