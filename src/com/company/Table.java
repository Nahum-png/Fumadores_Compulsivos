package com.company;

import java.util.Random;

public class Table {
    private boolean emptyTable = false; ///atributo que me indica si puede pasar el fumador o pasa el agente a acomodar
    private int tobacco = 1, paper = 2, lighter = 3; ///diferentes ingredientes de los fumadores
    private int ingredient; ///atributo de ayuda para poder hacer aleatorio el acomodo de los ingredientes
    private int smokers; ///numero de fumadores

    public Table(int smokers){
        this.smokers = smokers;
    }

    public void putIngredients(){ ///metodo del agente para acomodar los ingredites
        while(emptyTable == false){ ///pone en espera al fumador
            try{
                synchronized (this){ ///sincroniza a los hilos con el buffer
                    wait();
                }
            }catch (InterruptedException e){
            }
        }
        ingredient = new Random().nextInt(3);
        if(ingredient == tobacco){ ///acomodo de los ingredientes
            System.out.println("El agente puso los ingredientes #"+ paper + "papel y el ingrediente #" + lighter +" encendedor");
            emptyTable = false;
        }else if( ingredient == paper){
            System.out.println("El agente puso los ingredientes #"+ tobacco + "tabaco y el ingrediente #" + lighter +" encendedor");
            emptyTable = false;
        }else if (ingredient == lighter){
            System.out.println("El agente puso los ingredientes #"+ paper + "papel y el ingrediente #" + tobacco +" tabaco");
            emptyTable = false;
        }
        synchronized (this){///despierta a los fumadores
            notifyAll();
        }
    }

    public void obtainIngredients(int identifier, int smokeringredient){ ///hace que los fumadores completen sus ingredientes para fumar
        while(emptyTable || smokeringredient == tobacco || smokeringredient == paper){
            try{
                synchronized (this){ ///sincroniza a los hilos con el buffer
                    wait();
                }
            }catch(InterruptedException e){
            }
            System.out.println("El fumador #" + identifier + " Tiene el ingrediente " + smokeringredient); ///muestra al fumador
        }
        emptyTable = true;
        synchronized (this){///despierta al agente para poder acomodar los ingredientes en la mesa
            notifyAll();
        }
    }
}
