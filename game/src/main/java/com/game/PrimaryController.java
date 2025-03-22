package com.game;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    @FXML private ImageView[] gameGridCards;
    @FXML private ImageView card1;
    @FXML private ImageView card2;
    @FXML private ImageView card3;
    @FXML private ImageView card4;
    @FXML private ImageView card5;
    @FXML private ImageView card6;
    @FXML private ImageView card7;
    @FXML private ImageView card8;
    @FXML private ImageView card9;
    @FXML private ImageView card10;
    @FXML private ImageView card11;
    @FXML private ImageView card12;
    @FXML private ImageView card13;
    @FXML private ImageView card14;
    @FXML private ImageView card15;
    @FXML private ImageView card16;

    @FXML
    private void startGame() {
        DeckOfCards deck = new DeckOfCards();
        
        gameGridCards = new ImageView[] {card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16};

        for (int i = 0; i < 16; i++) {
            gameGridCards[i].setImage(deck.getCard(53));
        }

        // maybe make other java for making the game display other cards

    }

    @FXML
    public void handleClick(MouseEvent event) {
        Object source = event.getSource();

        if (source instanceof ImageView) {
            ImageView clickedImageView = (ImageView) source;
            
            String imageViewId = clickedImageView.getId();
            
            switch (imageViewId){
                case "card1":
                    // add logic 
                    break;
                case "card2":
                    // add logic 
                    break;
                case "card3":
                    // add logic 
                    break;
                case "card4":
                    // add logic 
                    break;
                case "card5":
                    // add logic 
                    break;
                case "card6":
                    // add logic 
                    break;
                case "card7":
                    // add logic 
                    break;
                case "card8":
                    // add logic 
                    break;
                case "card9":
                    // add logic 
                    break;
                case "card10":
                    // add logic 
                    break;
                case "card11":
                    // add logic 
                    break;
                case "card12":
                    // add logic 
                    break;
                case "card13":
                    // add logic 
                    break;
                case "card14":
                    // add logic 
                    break;
                case "card15":
                    // add logic 
                    break;
                case "card16":
                    // add logic 
                    break;
            }           
        }
    }
}
