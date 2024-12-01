package org.example.model;

import java.util.Objects; // Importation de la classe Objects pour les comparaisons et le calcul de hachage

public class Livre {

    private String id;
    private String titre;
    private String auteur;
    private boolean disponible;

    // Constructeur de la classe Livre
    public Livre(String id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = true;
    }

    // Méthode pour obtenir l'identifiant du livre
    public String getId() {
        return id;
    }

    // Méthode pour obtenir le titre du livre
    public String getTitre() {
        return titre;
    }

    // Méthode pour obtenir l'auteur du livre
    public String getAuteur() {
        return auteur;
    }

    // Méthode pour vérifier si le livre est disponible
    public boolean isDisponible() {
        return disponible;
    }

    // Méthode pour mettre à jour la disponibilité du livre
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Méthode pour comparer deux livres
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(id, livre.id);

    }

    // Méthode pour générer un code de hachage pour le livre
    @Override
    public int hashCode() {
        return Objects.hash(id); // Retourne le code de hachage basé sur l'identifiant
    }

    // Méthode pour afficher les informations du livre sous forme de chaîne
    @Override
    public String toString() {
        return "Livre{" + "id='" + id + '\'' + ", titre='" + titre + '\'' + ", auteur='" + auteur + '\'' + '}';
    }
}
