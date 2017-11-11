import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int hitDelay = 0;
    int nextImage = 0;
    int health = 3 ;
    public void act() 
    {
        followMouse();
        checkForCollisions();
    }    
    
    private void followMouse() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if(mi != null) {
            setLocation(mi.getX(), mi.getY());
        }
    }
    
    private void checkForCollisions() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if( hitDelay == 0 && enemy != null ) {
            if( health == 0 ) {
                AvoiderWorld world = (AvoiderWorld) getWorld();
                world.endGame();
            }
            else {  
                health--;
                setImage("skull" + ++nextImage + ".png");
                hitDelay = 20;
            }
        }
        if( hitDelay > 0 ) hitDelay--;
    }
}
