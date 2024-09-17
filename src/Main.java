import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Personne p1 =new Personne("J. DUPONT ");
        Compte c1 =new Compte(p1,1000);


        Personne p2 =new Personne("C. DURANT  ");
        Compte c2 =new Compte(p2,50000,5000,6000);

        Personne p3 =new Personne("test  ");
        Compte c3= new Compte(p3, -200, 5000, 6000);
        System.out.println(c3.CaracteristiquesCompte());


        System.out.println(c1.CaracteristiquesCompte()+c2.CaracteristiquesCompte());


        c1.debiterCompte(300);
        System.out.println("c1 apres debit de 300 : Solde => "+c1.getSoldeCompte());
        c2.debiterCompte(600);
        System.out.println("c2 apres debit de 600 : Solde => "+c2.getSoldeCompte());
        c1.crediterCompte(500);
        System.out.println("c1 apres credit de 500: Solde => "+c1.getSoldeCompte());

        System.out.println(c1.CaracteristiquesCompte()+c2.CaracteristiquesCompte());


        c2.effectuerVirement(c1,1000);


        System.out.println("c1  et c2 après virement de 1000 de c2 vers c1: "+"\n"+c1.CaracteristiquesCompte()+c2.CaracteristiquesCompte());


        //Tests pertinents:

        // essai d'un debit supérieur au débit max autorisé (tester l'erreur)
        c1.debiterCompte(1100);

        //réatribution du débit max a 1200
        c1.setDebitMaxAutorise(1200);

        //verification du montant de débit max du compte c1
        c1.montantDebitAutorise();

        // 2ème essai d'un debit maintenant inférieur au débit max autorisé
        c1.debiterCompte(1100);

        //caracteristiques du compte c1 apres les différents testsq
        System.out.println(c1.CaracteristiquesCompte());

        //ttes entrées et sortie normal et exception de chaque fonction + test cascade





    }



}