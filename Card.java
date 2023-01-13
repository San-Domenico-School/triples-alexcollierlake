import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cards on the table.
 * 
 * @author Alex_CollierLake 
 * @version 1/12/2023
 */
public class Card extends Actor
{
    private Color color;
    private Shape shape;
    private int numberOfShapes, shading;
    private GreenfootImage cardImage, selectedCardImage;
    private boolean isSelected;
    
    public enum Color
    {
        GREEN, BLUE, RED, NO_COLOR
    }
    
    public enum Shape
    {
        TRIANGLE, CIRCLE, SQUARE, NO_SHAPE
    }
    
    public Card(Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.color = color;
        this.shape = shape;
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        setImage(cardImage); 
        
        
    }
    
    public Color getColor()
    {
        return color; 
    }
    
    public Shape getShape()
    {
        return shape; 
    }
    
    public int getNumberOfShapes()
    {
        return numberOfShapes; 
    }
    
    public int getShading()
    {
        return shading; 
    }
    
    public GreenfootImage getCardImage()
    {
        return cardImage; 
    }
    
    public GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage; 
    }
    
    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }
    
    
    
    
    
}
