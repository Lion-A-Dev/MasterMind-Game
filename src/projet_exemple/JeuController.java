/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_exemple;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author toufi
 */
public class JeuController implements Initializable {
    @FXML
    private Circle c1, c2, c3, c4,c5;
    
    @FXML
    private Circle p11, p12 ,p13 ,p14,
                   p21, p22, p23, p24,
                   p31, p32, p33, p34,
                   p41, p42, p43, p44,
                   p51, p52, p53, p54,
                   p61, p62, p63, p64,
                   p71, p72, p73, p74,
                   p81, p82, p83, p84;
    
    @FXML
    private Circle r1, r2, r3, r4;
    
    @FXML
    private Label resultatTemptative1, resultatTemptative2, resultatTemptative3, resultatTemptative4,
                  resultatTemptative5, resultatTemptative6, resultatTemptative7, resultatTemptative8;
    
    
    Circle[] pions = new Circle[32];
    Circle[] answers = new Circle[4];
    Label[] results = new Label[8];
   
    Random rand = new Random();
    
    static Serie temptative;
    
    Mastermind jeu ;
    static int i = 0;
    
    Alert win = new Alert(Alert.AlertType.CONFIRMATION);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jeu = new Mastermind();
        temptative = new Serie();
        colorAnswersVisual();     
        
        answers[0] = r1; answers[1] = r2; answers[2] = r3; answers[3] = r4;
        //SOLUTION COLORS
        jeu.getSolution().ajouterCouleur((Color)r1.getFill());
        jeu.getSolution().ajouterCouleur((Color)r2.getFill());
        jeu.getSolution().ajouterCouleur((Color)r3.getFill());
        jeu.getSolution().ajouterCouleur((Color)r4.getFill());
        
   
         pions[0] = p11; pions[1] = p12; pions[2] = p13; pions[3] = p14;
         results[0] = resultatTemptative1;

         pions[4] = p21; pions[5] = p22; pions[6] = p23; pions[7] = p24;
         results[1] = resultatTemptative2;
         
         pions[8] = p31; pions[9] = p32; pions[10] = p33; pions[11] = p34;
         results[2] = resultatTemptative3;
         
         pions[12] = p41; pions[13] = p42; pions[14] = p43; pions[15] = p44;
         results[3] = resultatTemptative4;
         
         pions[16] = p51; pions[17] = p52; pions[18] = p53; pions[19] = p54;
         results[4] = resultatTemptative5;
         
         pions[20] = p61; pions[21] = p62; pions[22] = p63; pions[23] = p64;
         results[5] = resultatTemptative6;
         
         pions[24] = p71; pions[25] = p72; pions[26] = p73; pions[27] = p74;
         results[6] = resultatTemptative7;
         
         pions[28] = p81; pions[29] = p82; pions[30] = p83; pions[31] = p84;
         results[7] = resultatTemptative8;
	}



    private Color getColor(String id)
    {
        Color couleur = null;
         switch (id) {

                case "c1":
                    couleur = RED;
                    break;

                case "c2":
                    couleur = YELLOW;
                    break;
        
                case "c3":
                    couleur =BLUE;
                    break;
      
                case "c4":
                     couleur= GREEN;
                    break;
                 case "c5":
                     couleur = ORANGE;
                    break;
                default:
                    break;
            }
            return couleur;
    }
    
        
        
    @FXML
    void Select(MouseEvent event) {
        if (i>=31) {
            Alert lose = new Alert(Alert.AlertType.ERROR);
            lose.setHeaderText("GAME OVER");
            lose.setContentText("Vous avez utilisez tous vos chances");
            r1.visibleProperty().set(true);
            r2.visibleProperty().set(true);
            r3.visibleProperty().set(true);
            r4.visibleProperty().set(true);
            lose.show();
        }

        Circle selected = (Circle)event.getSource();
        String id = selected.getId();

        Color c = getColor(id);
        pions[i].setFill(c);
        i++;
        temptative.ajouterCouleur(c);
        
        if (i % 4 == 0) {
            compareWithSolution(temptative);
            temptative.getCouleurs().clear();
        }
        
}
    
    private void compareWithSolution(Serie serie) {
        // Call lose method to compare playerColors with the solution
        String comparisonResult = jeu.getSolution().comparer(serie);

        // Set the comparison result to the appropriate TextField
        results[i / 4 - 1].setText(comparisonResult);
        
        if (results[i / 4 - 1].getText().trim().equals("NNNN")) {
            win.setHeaderText("WINNER!");
            win.setContentText("Vous avez gagnez le jeu, bravo!");
            win.showAndWait();
            System.exit(0);
        }
}
    
    
    
    private Color answerColorGeneration(int num)
    {
        Color couleur = null;
         switch (num) {

                case 1:
                    couleur = RED;
                    break;

                case 2:
                    couleur = YELLOW;
                    break;
        
                case 3:
                    couleur =BLUE;
                    break;
      
                case 4:
                     couleur= GREEN;
                    break;
                 case 5:
                     couleur = ORANGE;
                    break;
                default:
                    break;
            }
            return couleur;
    }
        
    private void colorAnswersVisual()
    {
        int rando1 = rand.nextInt(5) + 1;
        int rando2 = rand.nextInt(5) + 1;
        int rando3 = rand.nextInt(5) + 1;
        int rando4 = rand.nextInt(5) + 1;
        
        Color an1 = answerColorGeneration(rando1);
        Color an2 = answerColorGeneration(rando2);
        Color an3 = answerColorGeneration(rando3);
        Color an4 = answerColorGeneration(rando4);
        
        r1.setFill(an1);
        r2.setFill(an2);
        r3.setFill(an3);
        r4.setFill(an4);
    }
}
