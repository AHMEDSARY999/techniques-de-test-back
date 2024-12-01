package service;
import org.example.model.Livre;
import org.example.model.Utilisateur;
import org.example.service.ServiceBibliotheque;
import org.junit.jupiter.api.BeforeEach; // Importation de l'annotation BeforeEach pour initialiser les tests
import org.junit.jupiter.api.Test; // Importation de l'annotation Test pour définir les méthodes de test

import static org.junit.jupiter.api.Assertions.*; // Importation des assertions JUnit pour les tests


public class ServiceBibliothequeTest {

    private ServiceBibliotheque serviceBibliotheque; // Instance du service de bibliothèque

    // Méthode pour initialiser l'objet avant chaque test
    @BeforeEach
    public void setUp() {
        serviceBibliotheque = new ServiceBibliotheque(); // Création d'une nouvelle instance de ServiceBibliotheque
    }

    // Test pour vérifier l'ajout d'un livre
    @Test
    public void testAjouterLivre() {
        Livre livre = new Livre("1", "Effective Java", "Joshua Bloch"); // Création d'un livre
        serviceBibliotheque.ajouterLivre(livre); // Ajout du livre au service
        assertEquals(livre, serviceBibliotheque.obtenirLivre("1")); // Vérification que le livre a été ajouté correctement
    }

    // Test pour vérifier l'enregistrement d'un utilisateur
    @Test
    public void testEnregistrerUtilisateur() {
        Utilisateur utilisateur = new Utilisateur("1", "Alice"); // Création d'un utilisateur
        serviceBibliotheque.enregistrerUtilisateur(utilisateur); // Enregistrement de l'utilisateur
        assertEquals(utilisateur, serviceBibliotheque.obtenirUtilisateur("1")); // Vérification que l'utilisateur a été enregistré correctement
    }

    // Test pour vérifier l'emprunt d'un livre
    @Test
    public void testEmprunterLivre() {
        Livre livre = new Livre("1", "Effective Java", "Joshua Bloch"); // Création d'un livre
        Utilisateur utilisateur = new Utilisateur("1", "Alice"); // Création d'un utilisateur

        serviceBibliotheque.ajouterLivre(livre); // Ajout du livre au service
        serviceBibliotheque.enregistrerUtilisateur(utilisateur); // Enregistrement de l'utilisateur

        boolean succes = serviceBibliotheque.emprunterLivre("1", "1"); // Tentative d'emprunt du livre
        assertTrue(succes); // Vérification que l'emprunt a réussi
        assertFalse(serviceBibliotheque.obtenirLivre("1").isDisponible()); // Vérification que le livre n'est plus disponible
    }

    // Test pour vérifier l'emprunt d'un livre non disponible
    @Test
    public void testEmprunterLivreNonDisponible() {
        Livre livre = new Livre("1", "Effective Java", "Joshua Bloch"); // Création d'un livre
        Utilisateur utilisateur = new Utilisateur("1", "Alice"); // Création d'un utilisateur

        serviceBibliotheque.ajouterLivre(livre); // Ajout du livre au service
        serviceBibliotheque.enregistrerUtilisateur(utilisateur); // Enregistrement de l'utilisateur

        serviceBibliotheque.emprunterLivre("1", "1"); // Emprunt du livre
        boolean succes = serviceBibliotheque.emprunterLivre("1", "1"); // Tentative d'emprunt à nouveau
        assertFalse(succes); // Vérification que l'emprunt a échoué car le livre est déjà emprunté
    }

    // Test pour vérifier le retour d'un livre
    @Test
    public void testRetournerLivre() {
        Livre livre = new Livre("1", "Effective Java", "Joshua Bloch"); // Création d'un livre
        Utilisateur utilisateur = new Utilisateur("1", "Alice"); // Création d'un utilisateur

        serviceBibliotheque.ajouterLivre(livre); // Ajout du livre au service
        serviceBibliotheque.enregistrerUtilisateur(utilisateur); // Enregistrement de l'utilisateur

        serviceBibliotheque.emprunterLivre("1", "1"); // Emprunt du livre
        boolean retourne = serviceBibliotheque.retournerLivre("1"); // Tentative de retour du livre
        assertTrue(retourne); // Vérification que le retour a réussi
        assertTrue(serviceBibliotheque.obtenirLivre("1").isDisponible()); // Vérification que le livre est à nouveau disponible
    }
}
