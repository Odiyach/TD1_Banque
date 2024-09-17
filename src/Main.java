import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Tests des trois constructeurs

        System.out.println("==== Test des trois constructeurs ====");
        Personne p1 = new Personne("J. DUPONT");

        // Test du premier constructeur (seulement titulaire)
        Compte c1 = new Compte(p1);
        System.out.println(c1.CaracteristiquesCompte());

        // Test du deuxième constructeur (titulaire + solde initial positif)
        Compte c2 = new Compte(p1, 500);
        System.out.println(c2.CaracteristiquesCompte());

        // Test du deuxième constructeur (titulaire + solde initial négatif)
        Compte c3 = new Compte(p1, -100);
        System.out.println(c3.CaracteristiquesCompte());

        // Test du troisième constructeur (titulaire + solde initial + découvert max + débit max)
        Compte c4 = new Compte(p1, 1000, 500, 1200);
        System.out.println(c4.CaracteristiquesCompte());

        // Test du troisième constructeur (titulaire + solde initial négatif + découvert max + débit max)
        Compte c5 = new Compte(p1, -500, 1000, 1200);
        System.out.println(c5.CaracteristiquesCompte());

        // Tests getter et setter
        System.out.println("==== Test des getters et setters ====");
        System.out.println("Titulaire compte c1 : " + c1.getTitulaire().getNom());
        System.out.println("Numéro de compte c1 : " + c1.getNumCompte());
        System.out.println("Numéro de compte c2 : " + c2.getNumCompte());

        // Tests des méthodes crediterCompte et debiterCompte
        System.out.println("==== Test des méthodes crediterCompte et debiterCompte ====");

        // Créditer un compte
        System.out.println("Créditer 100 sur c1: " + c1.crediterCompte(100)); // true
        System.out.println("Nouveau solde: " + c1.getSoldeCompte()); // 100

        // Créditer un montant négatif (cas invalide)
        System.out.println("Créditer -50 sur c1: " + c1.crediterCompte(-50)); // false
        System.out.println("Solde inchangé: " + c1.getSoldeCompte()); // 100

        // Débiter un compte
        System.out.println("Débiter 50 sur c1: " + c1.debiterCompte(50)); // true
        System.out.println("Nouveau solde: " + c1.getSoldeCompte()); // 50

        // Débiter un montant supérieur au débit autorisé
        System.out.println("Débiter 5000 sur c1: " + c1.debiterCompte(5000)); // false
        System.out.println("Solde inchangé: " + c1.getSoldeCompte()); // 50

        // Test découvert
        c1.debiterCompte(100);  // Compte à découvert
        System.out.println("Nouveau solde après débit 100: " + c1.getSoldeCompte());
        System.out.println(c1.messageDecouvert()); // Message de découvert

        // Tests des méthodes effectuerVirement et montantDebitAutorise
        System.out.println("==== Test des méthodes effectuerVirement et montantDebitAutorise ====");

        Compte compte1 = new Compte(new Personne("Personne 1"), 1000, 500, 1500);
        Compte compte2 = new Compte(new Personne("Personne 2"), 200);

        // Virement valide
        System.out.println("Virement de 200 de compte1 vers compte2: " + compte1.effectuerVirement(compte2, 200));
        System.out.println("Nouveau solde compte1: " + compte1.getSoldeCompte()); // 800
        System.out.println("Nouveau solde compte2: " + compte2.getSoldeCompte()); // 400

        // Virement invalide (montant supérieur au débit autorisé)
        System.out.println("Virement de 2000 de compte1 vers compte2: " + compte1.effectuerVirement(compte2, 2000)); // false

        // Test de montant de débit autorisé
        System.out.println("Montant de débit autorisé compte1: " + compte1.montantDebitAutorise()); // calcul basé sur découvert

        // Tests des méthodes estDecouvert et getDecouvertDuCompte
        System.out.println("==== Test des méthodes estDecouvert et getDecouvertDuCompte ====");

        // Création d'un compte à découvert
        Compte compteDecouvert = new Compte(new Personne("Personne 1"), -300, 1000, 1500);
        System.out.println("Compte à découvert: " + compteDecouvert.estDecouvert()); // true
        System.out.println("Montant du découvert: " + compteDecouvert.getDecouvertDuCompte()); // 300

        // Remettons le compte à l'équilibre
        compteDecouvert.crediterCompte(300);
        System.out.println("Compte après crédit de 300: " + compteDecouvert.getSoldeCompte()); // 0
        System.out.println("Compte à découvert: " + compteDecouvert.estDecouvert()); // false

        // Tests des setters setDecouvertMaxAutorise et setDebitMaxAutorise
        System.out.println("==== Test des setters setDecouvertMaxAutorise et setDebitMaxAutorise ====");

        Compte compteTest = new Compte(new Personne("Personne 3"), 500);

        // Changer le découvert maximal autorisé
        compteTest.setDecouvertMaxAutorise(2000);
        System.out.println("Nouveau découvert max autorisé: " + compteTest.getDecouvertMaxAutorise()); // 2000

        // Changer le débit maximal autorisé
        compteTest.setDebitMaxAutorise(3000);
        System.out.println("Nouveau débit max autorisé: " + compteTest.getDebitMaxAutorise()); // 3000
    }
}
