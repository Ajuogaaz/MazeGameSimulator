package game.characters.enemies;
import game.characters.Character;
/**
 * This class model a generic enemy to be used in a simple game
 * @author linus
 * @version 1.8
 */
public class Enemy extends Character{
    public static final String DEFAULT_SCARY_MSG = "Do you want to know what the fear is?";

    /**
     * Construct a new Enemy using the specified name, description and weapon
     * @param name The String to be used as the name
     * @param description The String to be used as the description
     * @param secretWeapon The int to be used as secretWeapon.
     * @see Character
     */
    public Enemy(String name, String description, int secretWeapon){
        super(name, description,secretWeapon);
    }
    /**
     * This method has been designed to frighten enemies with a default scary message
     */
    public void scare(){
        System.out.println(DEFAULT_SCARY_MSG);
    }
    /**
     * This method has been designed to frighten enemies with the specified
     * scary message
     * @param otherScaryMessage The String to be used as the scary message
     */
    public void scare (String otherScaryMessage){
        System.out.println(otherScaryMessage);
    }

}
