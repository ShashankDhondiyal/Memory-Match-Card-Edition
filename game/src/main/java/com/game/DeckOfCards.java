package com.game;

import java.util.HashMap;

import javafx.scene.image.Image;

public final class DeckOfCards {

    private HashMap<Integer, Image> Deck;

    public DeckOfCards(){
        Deck = new HashMap<>();
        Deck.put(1, new Image(getClass().getResourceAsStream("/images/2_of_clubs.png")));        Deck.put(14, new Image(getClass().getResourceAsStream("/images/2_of_diamonds.png")));
        Deck.put(2, new Image(getClass().getResourceAsStream("/images/3_of_clubs.png")));        Deck.put(15, new Image(getClass().getResourceAsStream("/images/3_of_diamonds.png")));
        Deck.put(3, new Image(getClass().getResourceAsStream("/images/4_of_clubs.png")));        Deck.put(16, new Image(getClass().getResourceAsStream("/images/4_of_diamonds.png")));
        Deck.put(4, new Image(getClass().getResourceAsStream("/images/5_of_clubs.png")));        Deck.put(17, new Image(getClass().getResourceAsStream("/images/5_of_diamonds.png")));
        Deck.put(5, new Image(getClass().getResourceAsStream("/images/6_of_clubs.png")));        Deck.put(18, new Image(getClass().getResourceAsStream("/images/6_of_diamonds.png")));
        Deck.put(6, new Image(getClass().getResourceAsStream("/images/7_of_clubs.png")));        Deck.put(19, new Image(getClass().getResourceAsStream("/images/7_of_diamonds.png")));
        Deck.put(7, new Image(getClass().getResourceAsStream("/images/8_of_clubs.png")));        Deck.put(20, new Image(getClass().getResourceAsStream("/images/8_of_diamonds.png")));
        Deck.put(8, new Image(getClass().getResourceAsStream("/images/9_of_clubs.png")));        Deck.put(21, new Image(getClass().getResourceAsStream("/images/9_of_diamonds.png")));
        Deck.put(9, new Image(getClass().getResourceAsStream("/images/10_of_clubs.png")));       Deck.put(22, new Image(getClass().getResourceAsStream("/images/10_of_diamonds.png")));
        Deck.put(10, new Image(getClass().getResourceAsStream("/images/jack_of_clubs.png")));    Deck.put(23, new Image(getClass().getResourceAsStream("/images/jack_of_diamonds.png")));
        Deck.put(11, new Image(getClass().getResourceAsStream("/images/queen_of_clubs.png")));   Deck.put(24, new Image(getClass().getResourceAsStream("/images/queen_of_diamonds.png")));
        Deck.put(12, new Image(getClass().getResourceAsStream("/images/king_of_clubs.png")));    Deck.put(25, new Image(getClass().getResourceAsStream("/images/king_of_diamonds.png")));
        Deck.put(13, new Image(getClass().getResourceAsStream("/images/ace_of_clubs.png")));     Deck.put(26, new Image(getClass().getResourceAsStream("/images/ace_of_diamonds.png")));
        
        Deck.put(27, new Image(getClass().getResourceAsStream("/images/2_of_hearts.png")));      Deck.put(40, new Image(getClass().getResourceAsStream("/images/2_of_spades.png")));
        Deck.put(28, new Image(getClass().getResourceAsStream("/images/3_of_hearts.png")));      Deck.put(41, new Image(getClass().getResourceAsStream("/images/3_of_spades.png")));
        Deck.put(29, new Image(getClass().getResourceAsStream("/images/4_of_hearts.png")));      Deck.put(42, new Image(getClass().getResourceAsStream("/images/4_of_spades.png")));
        Deck.put(30, new Image(getClass().getResourceAsStream("/images/5_of_hearts.png")));      Deck.put(43, new Image(getClass().getResourceAsStream("/images/5_of_spades.png")));
        Deck.put(31, new Image(getClass().getResourceAsStream("/images/6_of_hearts.png")));      Deck.put(44, new Image(getClass().getResourceAsStream("/images/6_of_spades.png")));
        Deck.put(32, new Image(getClass().getResourceAsStream("/images/7_of_hearts.png")));      Deck.put(45, new Image(getClass().getResourceAsStream("/images/7_of_spades.png")));
        Deck.put(33, new Image(getClass().getResourceAsStream("/images/8_of_hearts.png")));      Deck.put(46, new Image(getClass().getResourceAsStream("/images/8_of_spades.png")));
        Deck.put(34, new Image(getClass().getResourceAsStream("/images/9_of_hearts.png")));      Deck.put(47, new Image(getClass().getResourceAsStream("/images/9_of_spades.png")));
        Deck.put(35, new Image(getClass().getResourceAsStream("/images/10_of_hearts.png")));     Deck.put(48, new Image(getClass().getResourceAsStream("/images/10_of_spades.png")));
        Deck.put(36, new Image(getClass().getResourceAsStream("/images/jack_of_hearts.png")));   Deck.put(49, new Image(getClass().getResourceAsStream("/images/jack_of_spades.png")));
        Deck.put(37, new Image(getClass().getResourceAsStream("/images/queen_of_hearts.png")));  Deck.put(50, new Image(getClass().getResourceAsStream("/images/queen_of_spades.png")));
        Deck.put(38, new Image(getClass().getResourceAsStream("/images/king_of_hearts.png")));   Deck.put(51, new Image(getClass().getResourceAsStream("/images/king_of_spades.png")));
        Deck.put(39, new Image(getClass().getResourceAsStream("/images/ace_of_hearts.png")));    Deck.put(52, new Image(getClass().getResourceAsStream("/images/ace_of_spades.png")));
        
        Deck.put(53, new Image(getClass().getResourceAsStream("/images/cover.png")));
    }

    public Image getCard(int n){
        return Deck.get(n);
    }
}
