package interieur;

import java.util.ArrayList;
import interieur.Voiture;

public class Voie {
    int sens ;
    double v;
    double frequence;
    public ArrayList <Voiture> voitures = new ArrayList <Voiture> ();

    public Voie () {
        sens = (int)(Math.random() -1);
        v = sens* 20* Math.random();
        frequence = Math.random();
        this.voitures = new ArrayList <> (10);
    }

    public void nouvelle_voiture (){
        double r = Math.random ();
        if (r < this.frequence) {
            voitures.add( new Voiture (v));
        }
    }

}
