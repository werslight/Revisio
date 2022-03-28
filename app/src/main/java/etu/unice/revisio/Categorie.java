package etu.unice.revisio;

import androidx.annotation.NonNull;

public class Categorie {
    private String nom;
    private String numberFiche;

    public Categorie(String n, String nbf) {
        this.nom = n;
        this.numberFiche = nbf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumberFiche() {
        return numberFiche;
    }

    public void setNumberFiche(String numberFiche) {
        this.numberFiche = numberFiche;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nom +" ("+ this.numberFiche+" fiches)";
    }
}
