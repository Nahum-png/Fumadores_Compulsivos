package com.company;

public class Main {

    public static void main(String[] args) {
        final int smokers = 3;///son tres unicos fumadores en el programa

        Table table = new Table(smokers); ///buffer que compartiran fumadores y agente
        Smokers[] activeSmokers = new Smokers[smokers]; ///arreglo para los tres fumadores
        Agent agent = new Agent(table);///unico agente del programa

        for(int i = 0; i < smokers; i++){///incializo a los fumadores
            activeSmokers[i] = new Smokers(table, i, i);
            activeSmokers[i].start();///inicio el hilo smoker
        }
        agent.start();///inicio el hilo agente
    }
}
