import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {


        Personne p1 = new Personne("J. DUPONT");

        // Test du constructeur (titulaire, solde positif)
        Compte c1 = new Compte(p1,1000);
        System.out.println(c1.CaracteristiquesCompte());

        Personne p2 =new Personne("C. DURANT ");

        // Test du constructeur (titulaire,solde,decouvertMax,debitMax)
        Compte c2 =new Compte(p2,50000,5000,6000);
        System.out.println(c1.CaracteristiquesCompte()+"\n"+c2.CaracteristiquesCompte());

        c1.debiterCompte(300);
        System.out.println("c1 apres debit de 300 : Solde => "+c1.getSoldeCompte());
        c2.debiterCompte(600);
        System.out.println("c2 apres debit de 600 : Solde => "+c2.getSoldeCompte());
        c1.crediterCompte(500);
        System.out.println("c1 apres credit de 500: Solde => "+c1.getSoldeCompte());

        System.out.println(c1.CaracteristiquesCompte()+c2.CaracteristiquesCompte());

        c2.effectuerVirement(c1,1000);


        System.out.println("c1  et c2 après virement de 1000 de c2 vers c1: "+"\n"+c1.CaracteristiquesCompte()+c2.CaracteristiquesCompte());




        // Test du deuxième constructeur (titulaire + solde négatif)
        // solde mis à 0
        Compte c3 = new Compte(p1, -100);
        System.out.println(c3.CaracteristiquesCompte());

        // Test du troisième constructeur (titulaire + solde + découvert max + débit max)
        Compte c4 = new Compte(p1, 1000, 500, 1200);
        System.out.println(c4.CaracteristiquesCompte());

        // Test du troisième constructeur (titulaire + solde négatif + découvert max + débit max)
        Compte c5 = new Compte(p1, -500, 1000, 1200);
        System.out.println(c5.CaracteristiquesCompte());



        // Tests Créditer un compte
        System.out.println("Créditer 100 sur c1: " + c1.crediterCompte(100)); // renvoie true
        System.out.println("Nouveau solde: " + c1.getSoldeCompte());

        // Créditer un montant négatif (erreur)
        System.out.println("Créditer -50 sur c1: " + c1.crediterCompte(-50)); // renvoie false
        System.out.println("Solde inchangé: " + c1.getSoldeCompte());

        // Débiter un compte
        System.out.println("Débiter 50 sur c1: " + c1.debiterCompte(50)); // renvoie true
        System.out.println("Nouveau solde: " + c1.getSoldeCompte());

        // Débiter un montant supérieur au débit autorisé: erreur
        System.out.println("Débiter 5000 sur c1: " + c1.debiterCompte(5000)); // renvoie false
        System.out.println("Solde inchangé: " + c1.getSoldeCompte());



        Compte c6 = new Compte(p1, 1000, 500, 1500);
        Compte c7 = new Compte(p2, 200);

        // Virement valide
        System.out.println("Virement de 200 de c6 vers c7: " + c6.effectuerVirement(c7, 200));
        System.out.println("Nouveau solde c6: " + c6.getSoldeCompte()); // 800
        System.out.println("Nouveau solde c7: " + c7.getSoldeCompte()); // 400

        // Erreur (montant supérieur au débit autorisé)
        System.out.println("Virement de 2000 de c6 vers c7: " + c6.effectuerVirement(c7, 2000)); // renvoie false

        // Test de montant de débit autorisé
        System.out.println("Montant de débit autorisé de c6: " + c6.montantDebitAutorise());


        // Création d'un compte à découvert
        Compte compteDecouvert = new Compte(new Personne("Personne 1"), -300, 1000, 1500);
        System.out.println("Compte à découvert: " + compteDecouvert.estDecouvert()); // renvoie true
        System.out.println("Montant du découvert: " + compteDecouvert.getDecouvertDuCompte());



        Compte c8 = new Compte(p1, 500);

        // Changer le découvert maximal autorisé
        c8.setDecouvertMaxAutorise(2000);
        System.out.println("Nouveau découvert max autorisé: " + c8.getDecouvertMaxAutorise()); // 2000

        // Changer le débit maximal autorisé
        c8.setDebitMaxAutorise(3000);
        System.out.println("Nouveau débit max autorisé: " + c8.getDebitMaxAutorise()); // 3000
        System.out.println(c8.CaracteristiquesCompte());

        Compte c9= new Compte(p1);
        c9.crediterCompte(500);
        c9.debiterCompte(600);
        System.out.println("c9 : " + c9.CaracteristiquesCompte());


        // essai d'un debit supérieur au débit max autorisé (tester l'erreur)
        c9.debiterCompte(1300);
        System.out.println("Statut du débit : "+c9.debiterCompte(1300));
        //réatribution du débit max a 1500
        c9.setDebitMaxAutorise(1500);

        //verification du montant de débit max du compte c9
        c9.montantDebitAutorise();
        System.out.println(c9.montantDebitAutorise());//700

        // 2ème essai d'un debit maintenant inférieur au débit max autorisé
        c9.debiterCompte(600);

        //caracteristiques du compte c1 apres les différents testsq
        System.out.println(c9.CaracteristiquesCompte());


    }
}
