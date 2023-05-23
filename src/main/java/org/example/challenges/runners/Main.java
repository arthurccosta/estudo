package org.example.challenges.runners;

import java.util.concurrent.Semaphore;

/**
 * 4 pessoas caminham, cada uma em um corredor diferente.
 * Os 4 corredores terminam em uma única porta.
 * Apenas 1 pessoa pode cruzar a porta por vez.
 * Considere que cada corredor tem 200m e cada pessoa anda de 4 a 6 m/s.
 * Cada pessoa leva de 1 a 2 segundos para abrir e cruzar a porta.
 * Faça  uma aplicação em java que simule essa situação.
 */
public class Main {

    public static void main(String[] args) {
        int permissions = 1;
        Semaphore port = new Semaphore(permissions);

        for (int person = 1; person <= 4; person++){
            Thread threadPort = new ThreadPort(person, port);
            threadPort.start();
        }
    }
}
