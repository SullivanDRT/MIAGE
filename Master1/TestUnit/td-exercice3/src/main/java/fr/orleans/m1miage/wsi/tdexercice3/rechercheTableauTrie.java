package td2Exo3;

public class rechercheTableauTrie {

    public boolean rechercheDico(int t[], int x) {

        int min, max, milieu;
        min = 0;
        max = t.length - 1;
        while (min < max) {
            milieu = (min + max) / 2;
            if (x > t[milieu]) {
                min= milieu + 1;
            } else {
                max =milieu;
            }
        }
        boolean trouve;
        if (t[min] == x) {
            trouve = true;
        } else {
            trouve = false;
        }
        return trouve;
    }

}
