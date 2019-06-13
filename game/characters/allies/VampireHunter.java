package game.characters.allies;
import game.characters.Character;

/**
 * This class model an ally that fights against Vampires.
 * @author: linus
 * @version: 1.8
 */
public class VampireHunter extends Ally{
    /**
     * Construct a new VampireHunter using the specified name and description
     * the secret weapon for VampireHunters are always TEETH and their footprint is
     * the character 'V' in uppercase
     * @param name The String to be used as the name
     * @param description The String to be used as the description
     * @see Ally
     */
    public VampireHunter(String name, String description){
        super(name, description,Character.TEETH);
        footprint = 'V';
    }
    private void secretSkillAgainstVampire(){
        System.out.println("This is my secret skill against Vampires");

    }
}