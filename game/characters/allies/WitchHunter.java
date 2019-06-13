package game.characters.allies;
import game.characters.Character;
/**
 * This class model an ally that fights against witches.
 * @author linus
 * @version 1.8
 */
public class WitchHunter extends Ally{
    /**
     * Construct a new WitchHunter using the specified name and description
     * the secret weapon for WitchHunters are always SPELL and their footprint is
     * the character 'W' in uppercase
     * @param name The String to be used as the name
     * @param description The String to be used as the description
     * @see Ally
     */
    public WitchHunter(String name, String description){
        super(name, description,Character.SPELL);
        footprint = 'W';
    }
    private void secretSkillAgainstWitches(){
        System.out.println("This is my secret skill against Witches");

    }
}