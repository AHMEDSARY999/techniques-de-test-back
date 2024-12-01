package org.example.model;

import java.util.Objects;

public class Utilisateur {

    private String id;
    private String nom;

    // Constructeur de la classe Utilisateur
    public Utilisateur(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    // Méthode pour comparer deux utilisateurs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur utilisateur = (Utilisateur) o;
        return Objects.equals(id, utilisateur.id);
    }

    // Méthode pour générer un code de hachage pour l'utilisateur
    @Override
    public int hashCode() {
        return Objects.hash(id); // Retourne le code de hachage basé sur l'identifiant
    }

    // Méthode pour afficher les informations de l'utilisateur sous forme de chaîne
    @Override
    public String toString() {
        return "Utilisateur{" + "id='" + id + '\'' + ", nom='" + nom + '\'' + '}';
    }
}
