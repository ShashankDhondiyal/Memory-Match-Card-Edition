package com.game;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Logic implements Initializable {

    @FXML private Button startButton;
    @FXML private Text statusBar;

    private ImageView[] gameGridCards;
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
    private boolean gameStarted = false;
    private int clickCount = 0;
    private Timeline timeline;
    private int secondsElapsed = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        statusBar.setVisible(false);
    }

    @FXML
    private void startGame() {
        startButton.setVisible(false);
        statusBar.setVisible(true);

        deck = new DeckOfCards();
        
        gameGridCards = new ImageView[] {card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16};

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

        Timeline countdown = new Timeline(
            new KeyFrame(Duration.seconds(0), event -> statusBar.setText("                 00:03")),
            new KeyFrame(Duration.seconds(1), event -> statusBar.setText("                 00:02")),
            new KeyFrame(Duration.seconds(2), event -> statusBar.setText("                 00:01")),
            new KeyFrame(Duration.seconds(3), event -> {
                statusBar.setText("           00:00  |  Clicks: 0");
                startClock();
                updateStatusBar();
                statusBar.setVisible(true);
                for (int i = 0; i < 16; i++){
                    gameGridCards[i].setImage(deck.getCard(53));
                }
                gameStarted = true; // Set gameStarted to true after countdown
            })
        );
        countdown.play();
    }

    @FXML
    public void handleClick(MouseEvent event) {
        if (!gameStarted || isChecking) {
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

            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> checkMatch());
            pause.play();
        }

        clickCount++;
        updateStatusBar();
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

    private void startClock() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            secondsElapsed++;
            updateStatusBar();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateStatusBar() {
        int minutes = secondsElapsed / 60;
        int seconds = secondsElapsed % 60;
        statusBar.setText(String.format("        %02d:%02d  |  Clicks: %d", minutes, seconds, clickCount));
    }
}
