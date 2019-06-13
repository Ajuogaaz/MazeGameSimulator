package game.characters.enemies;
import game.characters.Character;
/**
 * This class model a generic witch to be used in a simple game
 * @author: linus
 * @version: 1.8
 */
public class Witch extends Enemy{
    /**
     * Construct a new Witch using the specified name and description
     * the secret weapon for Witches are always SPELL and their footprint is
     * the character 'w' in lowercase
     * @param name The String to be used as the name
     * @param description The String to be used as the description
     * @see Enemy
     */
    public Witch(String name, String description){
        super(name, description, Character.SPELL);
        footprint = 'w';
    }

}