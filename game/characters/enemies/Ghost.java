package game.characters.enemies;
import game.characters.Character;

/**
 * This class model a generic ghost to be used in a simple game
 * @author linus
 * @version 1.8
 */
public class Ghost extends Enemy {
    /**
     * Construct a new Ghost using the specified name and description
     * the secret weapon for Ghosts are always CHAINS and their footprint is
     * the character 'g' in lowercase
     * @param name The String to be used as the name
     * @param description The String to be used as the description
     * @see Enemy
     */
    public Ghost(String name, String description){
        super(name, description, Character.CHAINS);
        footprint = 'g';
    }

}