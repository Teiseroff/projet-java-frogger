package interieur ;
import interieur.Plateau;
import interieur.Partie;

public class Grenouille {
    private float b,h,g,d;
    private boolean bord_b,bord_h, bord_g, bord_d;

    // insérer la photo ici je crois

    public Grenouille ( float b, float g) {
        this.b = b + interieur.Plateau.eps;
        this.g = g + interieur.Plateau.eps;
        this.h = b + interieur.Plateau.y_taille_case - interieur.Plateau.eps;
        this.d = g + interieur.Plateau.x_taille_case - interieur.Plateau.eps;
        this.bord_b = true;
        this.bord_h = false;
        this.bord_g = false ;
        this.bord_d = true;
    }

    public void deplacement (float dx, float dy){
        this.g += dx;
        this.d+= dx;
        this.b += dy;
        this.h += dy;
        // Mettre à jour la position de la grenouille
        if (h == Plateau.y_plateau - interieur.Plateau.eps){
            interieur.Partie.You_Win = true;
        }
        else {
            Partie.You_Win = false;
        }
        if (b == interieur.Plateau.eps){
            bord_b = true;
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

    public boolean collision (float voiture_g, float voiture_d){
        if ((voiture_g <= this.g && this.g <= voiture_d) || (voiture_g <= this.d && this.d <= voiture_d) || (this.g <= voiture_g && voiture_g <= this.d)
                || (this.g <= voiture_d && voiture_d <= this.d)){
            return true;
    }
        return false;
    }

}
