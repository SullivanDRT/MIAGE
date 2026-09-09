package fr.orleans.m1miage.wsi.td2exercice2;



public class Fibonnacci {
    public Fibonnacci() {

    }

    public Integer calculFibonnaci(Integer nombre) {
        if(nombre == 1 || nombre == 0){
            return 1;
        }
        return calculFibonnaci(nombre -1) + calculFibonnaci(nombre - 2);
    }
}
