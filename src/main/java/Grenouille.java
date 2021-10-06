package interieur ;

public class Grenouille {
    private float b,h,g,d;
    private boolean bord_b,bord_h, bord_g, bord_d;

    // insérer la poto ici je crois

    public Grenouille ( float b, float g) {
        this.b = b + Plateau.eps;
        this.g = g + eps;
        this.h = b + taille_case - eps;
        this.d = g + taille_case - eps;
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
        if (h == Plateau.y - eps){
            Partie.You_Win = true;
        }
        else {
            Partie.You_Win = false;
        }
        if (b == eps){
            bord_b = true;
        }
        else {
           bord_b = false;
        }
        if (g == eps){
            bord_g = true;
        }
        else {
            bord_g = false;
        }
        if (d == Plateau.x - eps){
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
