package org.example.challenges.runners;

import java.util.concurrent.Semaphore;

import static java.nio.file.Files.walk;

public class ThreadPort extends Thread {
    private int person;
    private Semaphore port;

    public ThreadPort(int person, Semaphore port) {
        this.person = person;
        this.port = port;
    }

    @Override
    public void run() {
        walk();
        try {
            System.out.println("Pessoa #" + person + " chegou na porta");
            port.acquire();
            Thread.sleep((int) (Math.random() * 1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            port.release();
            personCrossed();
        }
    }

    private void walk() {
        int distance = 0;
        System.out.println("Pessoa #" + person + " começou a andar");
        while (distance < 200) {
            distance += (int) (Math.random() * 2) + 4;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void personCrossed(){
        System.out.println("Pessoa #" + person + " passou a porta");
    }
}
