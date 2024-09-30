package projet_exemple;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import static javafx.scene.paint.Color.YELLOW;


/**
 * Classe Serie
 */
public class Serie {
    private ArrayList<Color> couleurs ;
    private Scanner reader;

    private int k;

    
    
    
   public ArrayList<Color> getCouleurs() {
            return couleurs;
    }

    /**
     * Constructeur Série Instancie un ArrayList de couleurs vide
     */
   public Serie() {
            couleurs = new ArrayList<>();
      
    }

 
   public Color getCouleur(int position) {

            return null;
    }


   public void ajouterCouleur(Color uneCouleur) {
        couleurs.add(uneCouleur);

    }
    
    /**
     * Methode qui retourne vrai si la série comporte les même couleur et 
     * faux si elle ne la comporte
     * pas.
     *
     * @param uneSérie
     * @return equal
     */
   public boolean equals(Serie uneSerie) {
        boolean egal = false;
            if (couleurs.containsAll(uneSerie.getCouleurs())) {
            egal = true;
        }
            return egal;
    }

    /**
     * Methode comparer qui compare la serie noir des blancs
     *
     * @param uneSérie
     * @return
     */
   public String comparer(Serie uneSerie) {
        //variables--------------------------------------------
        int noirCompteur = 0;
        int blancCompteur = 0;
        String b = "";
        String n = "";
        
        ArrayList<Color> answerCopy = new ArrayList<Color>();
        ArrayList<Color> inputCopy = new ArrayList<Color>();
        //-------------------------------------------------------
        //FILL UP A COPY OF ANSWERS
        for (int i = 0; i < couleurs.size(); i++) {
            answerCopy.add(couleurs.get(i));
        }
        //PRINTING OF ANSWERS
        System.out.println("\nANSWERS ARE : ");
        for (int i = 0; i < 4; i++) {
            System.out.print(getAbréviation(answerCopy.get(i)));
        }
        //-------------------------------------------------------
        //FILL UP COPY OF INPUT
        for (int i = 0; i < uneSerie.getCouleurs().size(); i++) {
            inputCopy.add(uneSerie.getCouleurs().get(i));
        }
        System.out.println("\nYOUR ATTEMPT IS : ");
        //PRINTING ON CONSOLE OF INPUTTED COMBINATIONS
        for (int i = 0; i < 4; i++) {
            System.out.print(getAbréviation(inputCopy.get(i)));
        }
        //--------------------------------------------------------
        //#BLACK
        for (int i = 0; i < uneSerie.getCouleurs().size(); i++) {
            if (uneSerie.getCouleurs().get(i) == couleurs.get(i)) {
                noirCompteur++;
                inputCopy.set(i, BLACK);
                answerCopy.set(i, BLACK);
            }
        }
        //---------------------------------------------------------
        //#WHITE
        for (int i = 0; i < 4; i++) {
            if (inputCopy.get(i)==BLACK) {
                continue;
            }
            else
            {
                for (int j = 0; j < 4; j++) {
                    if (inputCopy.get(i).equals(answerCopy.get(j))) {
                        blancCompteur++;
                        answerCopy.set(j, WHITE);
                        break;
                    }
                }
            }
        }
        //-----------------------------------------------------------
        n = getBLACKResult(noirCompteur);
        
        //-------------------------------------------------------------
        b = getWHITEResult(blancCompteur);
        
        
        return String.valueOf(n +" "+ b);
    }

   public String getAbréviation(Color color)
   {
       String abr ="";
        if (color.equals(RED)) 
            abr = "R";
        else if (color.equals(BLUE)) {
            abr = "B";
        }
        else if (color.equals(GREEN)) {
            abr = "G";
        }
        else if (color.equals(YELLOW)) {
            abr = "Y";
        }
        else if(color.equals(ORANGE))
             abr = "O";
        return abr;


}
   
   public String getBLACKResult(int compteur)
   {
       String result = "";
       if (compteur == 0) {
           result = "";
       }
       else if(compteur == 1)
       {
           result = "N";
       }
       else if(compteur == 2)
       {
           result = "NN";
       }
       else if(compteur == 3)
       {
           result = "NNN";
       }
       else if(compteur == 4)
       {
           result = "NNNN";
       }
       return result;
   }
   
   public String getWHITEResult(int compteur)
   {
       String result = "";
       
       if (compteur == 0) {
           result = "";
       }
       else if(compteur == 1)
       {
           result = "B";
       }
       else if(compteur == 2)
       {
           result = "BB";
       }
       else if(compteur == 3)
       {
           result = "BBB";
       }
       else if(compteur == 4)
       {
           result = "BBBB";
       }
       return result;
   }
         
}
