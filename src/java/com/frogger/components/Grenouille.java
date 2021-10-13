package com.frogger.components;

public class Grenouille {
    private float b,h,g,d;
    private boolean bord_b,bord_h, bord_g, bord_d;

    // insérer la photo ici je crois

    public Grenouille ( float b, float g) {
        this.b = b + Plateau.eps;
        this.g = g + Plateau.eps;
        this.h = b + Plateau.y_taille_case - Plateau.eps;
        this.d = g + Plateau.x_taille_case - Plateau.eps;
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
        if (h == Plateau.y_plateau - Plateau.eps){
            Partie.You_Win = true;
        }
        else {
            Partie.You_Win = false;
        }
        if (b == Plateau.eps){
            bord_b = true;
        }
        else {
           bord_b = false;
        }
        if (g == Plateau.eps){
            bord_g = true;
        }
        else {
            bord_g = false;
        }
        if (d == Plateau.x_plateau - Plateau.eps){
            bord_d = true;
        }
        else {
            bord_d = false;
        }
    }

    public boolean collision (Voiture voiture){
        if ((voiture.g_voiture <= this.g && this.g <= voiture.d_voiture) || (voiture.g_voiture <= this.d && this.d <= voiture.d_voiture) || (this.g <= voiture.g_voiture && voiture.g_voiture <= this.d)
                || (this.g <= voiture.d_voiture && voiture.d_voiture <= this.d)){
            return true;
    }
        return false;
    }

}
