public class Main {


    public static void main(String[] args) throws Exception {


        Personne p1 = new Personne("J. DUPONT");

        // Test du constructeur (titulaire, solde positif)
        Compte c1 = new Compte(p1,1000);
        Compte c2 = new Compte(p1);
        System.out.println(c1.CaracteristiquesCompte());






        try {
            c1.crediterCompte(-500);
        } catch (CompteException e) {
            System.out.println(e.getMessage());
        }
        try {
            c1.crediterCompte(1500);
            System.out.println(c1.getSoldeCompte());
        } catch (CompteException e) {
            System.out.println(e.getMessage());

        }

        try {
            c1.debiterCompte(200);
            System.out.println(c1.getSoldeCompte());

        } catch (CompteException e) {
            System.out.println(e.getMessage());
        }

        try {
            c1.effectuerVirement(c2, 10000);
        } catch (CompteException e) {
            System.out.println(e.getMessage());
        }





    }
}
