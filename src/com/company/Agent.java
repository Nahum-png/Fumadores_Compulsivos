package com.company;

public class Agent extends Thread{
    private Table table; ///Mesa que compartiran los fumadores y el agente

    /*Constructor de la clase*/
    public Agent(Table table){
        this.table = table;
    }

    /*Metodos de la clase*/
    public void run(){
        while (true) {///infinito
            System.out.println("El agente esta acomodando los ingredientes.......");
            table.putIngredients();///metodo para que el agente coloque los materiales disponibles
        }
    }
}
