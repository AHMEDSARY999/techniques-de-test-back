package org.example.service;

import org.example.model.Livre;
import org.example.model.Utilisateur;

import java.util.HashMap; // Importation de la classe HashMap pour stocker les livres et utilisateurs
import java.util.Map; // Importation de l'interface Map pour définir les types de données

// Déclaration de la classe ServiceBibliotheque
public class ServiceBibliotheque {

    private Map<String, Livre> livres = new HashMap<>(); // Stockage des livres par leur ID
    private Map<String, Utilisateur> utilisateurs = new HashMap<>(); // Stockage des utilisateurs par leur ID
    private Map<String, String> livresEmpruntes = new HashMap<>(); // Livre ID -> Utilisateur ID

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(Livre livre) {
        livres.put(livre.getId(), livre); // Ajoute le livre à la collection de livres
    }


    // Méthode pour enregistrer un utilisateur dans la bibliothèque
    public void enregistrerUtilisateur(Utilisateur utilisateur) {
        utilisateurs.put(utilisateur.getId(), utilisateur); // Ajoute l'utilisateur à la collection d'utilisateurs
    }

    // Méthode pour emprunter un livre
    public boolean emprunterLivre(String idLivre, String idUtilisateur) {
        Livre livre = livres.get(idLivre); // Recherche le livre par son ID
        // Vérifie si le livre est non disponible ou n'existe pas
        if (livre == null || !livre.isDisponible()) {
            return false; // Livre non disponible
        }

        livre.setDisponible(false); // Marque le livre comme non disponible
        livresEmpruntes.put(idLivre, idUtilisateur); // Enregistre l'emprunt du livre par l'utilisateur
        return true;
    }

    // Méthode pour retourner un livre
    public boolean retournerLivre(String idLivre) {
        // Vérifie si le livre a été emprunté
        if (!livresEmpruntes.containsKey(idLivre)) {
            return false; // Livre non emprunté
        }

        Livre livre = livres.get(idLivre); // Recherche le livre par son ID
        livre.setDisponible(true); // Marque le livre comme disponible
        livresEmpruntes.remove(idLivre); // Retire l'emprunt du livre
        return true;
    }

    // Méthode pour obtenir un livre par son ID
    public Livre obtenirLivre(String idLivre) {
        return livres.get(idLivre); // Retourne le livre correspondant à l'ID
    }

    // Méthode pour obtenir un utilisateur par son ID
    public Utilisateur obtenirUtilisateur(String idUtilisateur) {
        return utilisateurs.get(idUtilisateur); // Retourne l'utilisateur correspondant à l'ID
    }
}
