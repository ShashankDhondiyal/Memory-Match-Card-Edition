package com.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Logic {

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

    private DeckOfCards deck;
    private ArrayList<Integer> cardsPickedFromDeck;
    private ImageView firstCard;
    private ImageView secondCard;
    private boolean isChecking = false;

    @FXML
    private void startGame() {
        deck = new DeckOfCards();
        
        gameGridCards = new ImageView[] {card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16};

        // start pulling cards from deck
        cardsPickedFromDeck = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 8; i++){
           int card = random.nextInt(52) + 1;
                while (cardsPickedFromDeck.contains(card)){
                    card = random.nextInt(52) + 1;
                }
           cardsPickedFromDeck.add(card);
           cardsPickedFromDeck.add(card);
        }
        Collections.shuffle(cardsPickedFromDeck);
        Collections.shuffle(cardsPickedFromDeck);

        for (int i = 0; i < 16; i++){
            gameGridCards[i].setImage(deck.getCard(cardsPickedFromDeck.get(i)));
        }

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            for (int i = 0; i < 16; i++){
                gameGridCards[i].setImage(deck.getCard(53));
            }
        });
        pause.play();
    }

    @FXML
    public void handleClick(MouseEvent event) {
        if (isChecking) {
            return;
        }

        ImageView clickedImageView = (ImageView) event.getSource();
        int index = getIndex(clickedImageView);

        if (firstCard == null) {
            firstCard = clickedImageView;
            firstCard.setImage(deck.getCard(cardsPickedFromDeck.get(index)));
        } else if (secondCard == null && clickedImageView != firstCard) {
            secondCard = clickedImageView;
            secondCard.setImage(deck.getCard(cardsPickedFromDeck.get(index)));

            isChecking = true;

            PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
            pause.setOnFinished(e -> checkMatch());
            pause.play();
        }
    }

    private void checkMatch() {
        int firstIndex = getIndex(firstCard);
        int secondIndex = getIndex(secondCard);

        if (!cardsPickedFromDeck.get(firstIndex).equals(cardsPickedFromDeck.get(secondIndex))) {
            firstCard.setImage(deck.getCard(53));
            secondCard.setImage(deck.getCard(53));
        }

        firstCard = null;
        secondCard = null;
        isChecking = false;
    }

    private int getIndex(ImageView imageView) {
        for (int i = 0; i < gameGridCards.length; i++) {
            if (gameGridCards[i] == imageView) {
                return i;
            }
        }
        return -1;
    }
}
