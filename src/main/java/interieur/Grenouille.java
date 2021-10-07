package interieur ;
import interieur.Plateau;
import interieur.Partie;

public class Grenouille {
    private float b,h,g,d;  //  coordonée de gauche, droite, haut bas de la grenouille
    private boolean bord_b, bord_g, bord_d;  // boolean qui sont à vrai sur la grenouille est au bord du jeu (et ne pourra plus se déplacer du coté de ce bord)

    // insérer la photo ici je crois, ou pas jcp

    public Grenouille ( float b, float g) {   // on instancie la grenouille en entrant ses cooordonnées de gauche et du bas de départ. Celles du haut et de droite sont déduites par translation de la taille d'une case (x_taille_case et y_taille_case))
        this.b = b + interieur.Plateau.eps;    // on rajoute le eps pour ne pas remplir pile la case et avoir des pb de collisions avec les voies voisines
        this.g = g + interieur.Plateau.eps;
        this.h = b + interieur.Plateau.y_taille_case - interieur.Plateau.eps;
        this.d = g + interieur.Plateau.x_taille_case - interieur.Plateau.eps;
        this.bord_b = true;  // à sa création, la grenouille est placée en bas au centre du jeu (donc seulement proche du bord bas)
        this.bord_g = false ;
        this.bord_d = false;
    }

    public void deplacement (float dx, float dy){   // on déplace la grenouille de dx vers la droite et de dy vers le haut
        this.g += dx;
        this.d+= dx;
        this.b += dy;
        this.h += dy;

        // Mettre à jour la position de la grenouille dans l'IHM

        if (h == Plateau.y_plateau - interieur.Plateau.eps){ // si la grenouille est arrivée en haut du parcours
            interieur.Partie.You_Win = true;  // c'est gagné
        }
        else {
            Partie.You_Win = false;
        }
        if (b == + interieur.Plateau.eps){  // si la grenouille est tout en bas du parcours
            bord_b = true; // elle ne pourra pas reculer au prochain mouvement
        }
        else {
           bord_b = false;
        }
        if (g == interieur.Plateau.eps){
            bord_g = true;
        }
        else {
            bord_g = false;
        }
        if (d == Plateau.x_plateau - interieur.Plateau.eps){
            bord_d = true;
        }
        else {
            bord_d = false;
        }
    }

    public boolean collision (Voiture voiture){  // on regarde si la voiture entrée en paramètre intercepte la grenouille
        if ((voiture.g_voiture <= this.g && this.g <= voiture.d_voiture) || (voiture.g_voiture <= this.d && this.d <= voiture.d_voiture) || (this.g <= voiture.g_voiture && voiture.g_voiture <= this.d)
                || (this.g <= voiture.d_voiture && voiture.d_voiture <= this.d)){
            return true;
    }
        return false;
    }

}
