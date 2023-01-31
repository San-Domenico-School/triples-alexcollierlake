/**
 * Dealer class
 * 
 * @author Alex_CollierLake 
 * @version 1/23/2023
 */

import greenfoot.*;
import java.util.ArrayList;

public class Dealer extends Actor
{
    // instance variables - replace the example below with your own
    private int x;
    private Deck deck;
    private int triplesRemaining;
    

    public void addedToWorld(World world)
    {
        dealBoard();
    }
    
    public Dealer(int numCardsInDeck)
    {
        deck = new Deck(numCardsInDeck);
        triplesRemaining = numCardsInDeck / 3;
        Scorekeeper.setDeckSize(numCardsInDeck);
    }
    
    
    public void dealBoard()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 5; column ++)
            {
                getWorld().addObject(deck.getTopCard(), row * 140 + 75, column * 80
                + 50);
            }
        }
    }
    
    private void setUI()
    {
        String cardsRemainingText = new Integer(triplesRemaining * 3).toString();
        String scoreText = new Integer(Scorekeeper.getScore()).toString();
        getWorld().showText(cardsRemainingText, 310, 470);
        getWorld().showText(scoreText, 310, 504); 
    }
    
    public void checkIfEndGame()
    {
        if(triplesRemaining == 0)
        {
            Greenfoot.stop();
        }
    }
    
    public void checkIfTriple(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, 
                              ArrayList<Integer> selectedCardsIndex)
    {
        // if they all share color or 
        
        // if cards.selected = a color 
        
        // numbers of cards are all divisable by 3
        // 3%3 = 0
        // 6%3 = 0
        
        // 
        int color = cardsSelected[0].getColor().ordinal() +
                    cardsSelected[1].getColor().ordinal() +
                    cardsSelected[2].getColor().ordinal();
                    
        int shape = cardsSelected[0].getShape().ordinal() +
                    cardsSelected[1].getShape().ordinal() +
                    cardsSelected[2].getShape().ordinal();
        
        int number = cardsSelected[0].getNumberOfShapes() +
                    cardsSelected[1].getNumberOfShapes() +
                    cardsSelected[2].getNumberOfShapes();
        
        int shading = cardsSelected[0].getShading() +
                        cardsSelected[1].getShading() +
                        cardsSelected[2].getShading();
        
        if(shape % 3 == 0 && color % 3 == 0 && number % 3 == 0 && shading % 3 == 0)
        {
            removeAndReplace(cardsOnBoard, cardsSelected, selectedCardsIndex);
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
    
    }
    
    private void removeAndReplace(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, 
                                    ArrayList<Integer> selectedCardsIndex)
    {
        // Set position of triple cards by coordinate, 3 cards by 2 coordinates 
       int[][] cardsXYCoordinate = new int[3][2];  
       for(int card = 0; card < 3; card++)
       {
            cardsXYCoordinate[card][0] = cardsSelected[card].getX();
            cardsXYCoordinate[card][1] = cardsSelected[card].getY();
       }
       // Begin card animation off scene view     
       Animations.slideAndTurn(cardsSelected);      

       // Remove and replace triple cards
       for(int card = 0; card < 3; card++)
       { 
           getWorld().removeObject(cardsSelected[card]);
           if(deck.getNumCardsInDeck() > 0)
           {
               cardsOnBoard.set(selectedCardsIndex.get(card),deck.getTopCard());
               getWorld().addObject(cardsOnBoard.get(selectedCardsIndex.get(card)), 
                                                     cardsXYCoordinate[card][0], 
                                                     cardsXYCoordinate[card][1]);
           }
       }
       
       // UI Housekeeping
       triplesRemaining--;
       Scorekeeper.updateScore();
       setUI();
       checkIfEndGame(); 
    }
                        
   
    
    
    
}
