package fr.orleans.m1miage.wsi;

import java.util.List;

public class RechercheNombre {

    public Integer rechercheNombreentier(Integer nombre, List<Integer> liste){
        for(int i=0; i < liste.size(); ++i){
            if(liste.get(i) == nombre){
                return i;
            }
        }
        return null;
    }
}
