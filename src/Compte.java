public class Compte
{
    private int numCompte;
    private Personne titulaire;
    private double soldeCompte;
    private double decouvertMaxAutorise;
    private double debitMaxAutorise;

    private static final double MontantDecouvertMaxiAutorise = 800;
    private static final double MontantDebitMaxiAutorise = 1000;

    private static final int MontantSoldeCompte = 0;




    //constructeur permettant de créer un compte avec seulement un numéro de compte et le titulaire.
    public Compte(int numCompte, Personne titulaire)
    {
        this.numCompte = numCompte;
        this.titulaire = titulaire;
        this.soldeCompte=MontantSoldeCompte;
        this.decouvertMaxAutorise=MontantDecouvertMaxiAutorise;
        this.debitMaxAutorise=MontantDebitMaxiAutorise;
    }

    //constructeur permettant de définir à la création du compte, à part le numéro de compte et le titulaire, de nouvelles caractéristiques.
    public Compte(int numCompte, Personne titulaire, double soldeCompte, double decouvertMaxAutorise, double debitMaxAutorise)
    {
       this(numCompte,titulaire);
        this.decouvertMaxAutorise = decouvertMaxAutorise;
        this.debitMaxAutorise = debitMaxAutorise;

        if(soldeCompte<0)
        {
            this.soldeCompte= MontantSoldeCompte;
        }
        else
        {
            this.soldeCompte = soldeCompte;
        }

    }



    public int getNumCompte()
    {
        return numCompte;
    }

    //la méthode getTitulaire permet de recupérer l'objet titulaire lié au compte.
    public Personne getTitulaire() {
        return titulaire;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }
    public double getDecouvertMaxAutorise() {
        return decouvertMaxAutorise;
    }
    public double getDebitMaxAutorise() {
        return debitMaxAutorise;
    }
     public void setDecouvertMaxAutorise(double decouvertMaxAutorise)
    {
        this.decouvertMaxAutorise = decouvertMaxAutorise;
    }
     public void setDebitMaxAutorise(double debitMaxAutorise)
     {
        this.debitMaxAutorise = debitMaxAutorise;
    }



    //la méthode getDecouvertDuCompte permet de vérifier si le compte est à découvert.
    //si le solde est positif ou null, le découvert sera de 0, sinon le découvert sera la valeur absolu du solde.
    public double getDecouvertDuCompte()
    {
        if(soldeCompte>=0)
        {
            return 0;
        }
        return soldeCompte * -1;
    }

    public String messageDecouvert()
    {
        String message="";
        if (getDecouvertDuCompte()>0)
        {
            message="Le compte est à découvert de: "+ getDecouvertDuCompte();

        }
        return message;
    }




    //montantDebitAutorise est une methode qui calcule le montant de débit maximum autorisé.
    public double montantDebitAutorise()
    {
        double TotalPossible= this.soldeCompte + this.decouvertMaxAutorise;

        if( TotalPossible > debitMaxAutorise)
        {
            return  debitMaxAutorise;
        }
        else
        {
            return  TotalPossible;

        }
    }



    // la methode crediterCompte permet d'ajouter un montant positif au solde
    public boolean crediterCompte(double montant)
    {
        if(montant>0)
        {
            this.soldeCompte+=montant;
            return true;

        }
        return false;

    }



    //la methode debiterCompte permet de retirer de l'argent.
    //Pour cela, il vérifie d'abord si le montant a retirer dépasse la limite du débit autorisé.
    //Dans ce cas le débit est refusé, sinon, le débit est effectué.
    public boolean debiterCompte(double montant)
    {

        if (montant> montantDebitAutorise())
        {
            return  false;
        }
        else
        {
            this.soldeCompte-=montant;
            return  true;
        }

    }

    //effectuerVirement est une mthode qui permet d'effectuer un virement vers un commpte beneficiaire.
    // cela entrainera le debit du compte crediteur et le credit du compte bénéficiaire.
    public boolean effectuerVirement( Compte beneficiaire, double montant)
    {
        if(montant<= montantDebitAutorise())
        {
            this.debiterCompte(montant);
            beneficiaire.crediterCompte(montant);
            return true;
        }

            return false;

    }


    public String CaracteristiquesCompte()
    {
        return "----Informations----"+"\n"+
                this.getNumCompte()+" : "+this.getTitulaire().getNom()+" | "+
                "Découvert maximal autorisé : "+this.getDecouvertMaxAutorise()+" "+
                "Débit maximal autorisé : "+this.getDebitMaxAutorise()+" "+
                "Solde du compte : "+this.getSoldeCompte()+" "+
                this.messageDecouvert()+"\n";

    }



}
