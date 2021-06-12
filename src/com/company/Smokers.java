package com.company;

public class Smokers extends Thread{
    private Table table; ///Mesa que compartiran los fumadores y el agente
    private int currentIngredient; ///ingredientes actuales de los fumadores
    private int smokerIndentifier; /// id de cada fumador

    public Smokers(Table table, int ingredient, int identifier){
        this.table = table;
        currentIngredient = ingredient;
        smokerIndentifier = identifier;
    }

    public void run(){
        while(true){
            table.obtainIngredients(currentIngredient,smokerIndentifier);
            try{
                sleep((int) Math.random() * 150); ///duerme al fumador hasta que ya no este vacia la mesa para poder ir a fumar
            }catch (InterruptedException e){
            }
        }
    }
}
