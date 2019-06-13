package game.characters;
import game.terrains.Maze;
import game.characters.enemies.Enemy;

/**
 * This class models a generic character to be used in a simple game
 * @author linus
 * @version 1.8
 */
public class Character implements Explorer{
    /** Constant to define the maximum health value */
    public static final int MAX_HEALTH = 10;

    /* constants to describe possible values of secret Weapon */
    /**
     * Constant to describe values of secret weapon cleverness-5 mainly used by heros
     */
    public static final int CLEVERNESS = 5;
    /**
     * Constant to describe values of secret weapon spell-4 mainly used by wizards and witches
     */
    public static final int SPELL = 4;
    /**
     * Constant to describe values of secret weapon sword-3 mainly used by warriors
     */
    public static final int SWORD = 3;
    /**
     * Constant to describe values of secret weapon teeth-2 mainly used by vampires
     */
    public static final int TEETH = 2;
    /**
     * Constant to describe values of secret weapon chains-1 mainly used by ghosts
     */
    public static final int CHAINS = 1;
    /**
     * Constant to describe default value for secret Weapons
     */
    public static final int UNDEFINED = -1;

    /**
     * Constant to describe default value for footprint
     */
    public static final char DEFAULT_FOOTPRINT = '+';

    /* variables to describe the character */
    /**
     * Variable to specify the name of the character
     */
    private String name;
    /**
     * Variable to specify the description of the character
     */
    private String description;
    /**
     * Variable to specify the secret weapon of the character
     */
    private int secretWeapon;
    /**
     * Variable to specify the health points of the character
     */
    private int health;
    /**
     * Variable to specify the footprint of the character
     */
    public char footprint;


    /*Constructor methods*/
    /**
     * Construct a new Character using the specified name, description,
     * health and weapon. *
     * @param otherName The String to be used as the name
     * @param otherDescription The String to be used as the description
     * @param otherHealth The int to be used as health level
     * @param otherSecretWeapon The int to be used as secret weapon
     */
    public Character(String otherName, String otherDescription,
                     int otherHealth, int otherSecretWeapon){
        name = otherName;
        description = otherDescription;
        health = otherHealth;
        setSecretWeapon(otherSecretWeapon);
        footprint=DEFAULT_FOOTPRINT;

    }
    /**
     * Construct a new Character using the specified name, description,
     * and weapon, and a maximum health given by the constant MAX_HEALTH
     * @param otherName The String to be used as the name
     * @param otherDescription The String to be used as the description
     * @param otherSecretWeapon The int to be used as secret weapon
     */
    public Character(String otherName, String otherDescription,
                     int otherSecretWeapon){
        this(otherName, otherDescription, MAX_HEALTH, otherSecretWeapon);
    }

    /**
     * Construct a new Character using the specified name, and using undefined value
     * for description and weapon, and a maximum health given by the constant MAX_HEALTH
     * @param otherName The String to be used as the name
     * @see Enemy
     */
    public Character(String otherName){
        this(otherName, "Undefined description", MAX_HEALTH, UNDEFINED);
    }

    /**
     * Construct a new Character using an undefined value for the name,
     * description and weapon, and a maximum health given by the constant MAX_HEALTH
     * @see Enemy
     */
    public Character(){
        this("Undefined name", "Undefined description", MAX_HEALTH, UNDEFINED);
    }

    /*Accessors and mutators*/

    /**
     * Replaces the name with the specified value n.
     * @param n The String to be used as the new name
     */
    public void setName(String n) {name = n;}

    /**
     * Returns the name of the character
     * @return The String that represents the name of the character
     */
    public String getName(){return name;}
    /**
     * Replaces the description with the specified value d.
     * @param d The String to be used as the new description
     */
    public void setDescription(String d){description = d;}
    /**
     * Returns the descriptoin of the character
     * @return The String that represents the description of the character
     */
    public String getDescription(){return description;}
    /**
     * Returns the secret weapon of the character
     * @return The int that represents the secret weapon of the character
     */
    public int getSecretWeapon(){return secretWeapon;}
    /**
     * Replaces the secretWeapon with the specified value sw.
     * @param sw The int to be used as the secret weapon. Only certain values are
     * allowed: CLEVERNESS, SPELL, SWORD, TEETH, CHAINS
     *
     * @see Character
     */
    public void setSecretWeapon(int sw){
        if(sw == CLEVERNESS || sw == SPELL || sw == SWORD ||
                sw == TEETH || sw == CHAINS){
            secretWeapon = sw;
        }else{
            secretWeapon = UNDEFINED;
        }
    }
    /**
     * Replaces the health with the specified value n.
     * @param h The int to be used as health points
     */
    public void setHealth(int h){health = h;}

    /**
     * Returns the health point of the character
     * @return The int that represents the health points of the character
     */
    public int getHealth(){return health;}

    /*Other methods*/

    /**
     * Replace the health points for its default value MAX_HEALTH
     */
    public void resetHealth(){health=MAX_HEALTH;}

    /**
     * Prints a textual representation of all the information stored about the Character
     */
    public void printInfo(){
        String result =
                "*************************************"+ "\n" +
                        "Name: " + name + "\n" +
                        "Description: " + description + "\n" +
                        "Secret weapon: " + secretWeapon + "\n" +
                        "Health: " + health + "\n" +
                        "Is Alive?: " + isAlive() + "\n" +
                        "*************************************";
        System.out.println(result);
    }

    /**
     * This method represent the action to combat. Receives an enemy as parameter
     * and calculate combat result subtracting the value of the secret weapons of
     * the opponents. This method does not return any value but it is
     * able to change the value of the health variable depending on the result of
     * the combat. If the result is a positive number, we assume that our character
     * has won the battle, and as a consequence will increase the health points.
     * In the same way, if the number is negative our character will have lost the
     * battle, and as a consequence the character will lose health points.
     * @param enemy The Character that represent the enemy
     */

    public void fight (Character enemy){
        int result = secretWeapon - enemy.getSecretWeapon();
        System.out.println("result:"+result);
        health = health + result;
        enemy.setHealth(enemy.getHealth() - result);
    }

    /**
     * This method represent the action to combat. Receives two opponents as parameters
     * and calculate combat result subtracting the value of the secret weapons of
     * the opponents. This method does not return any value but it is
     * able to change the value of the health variable depending on the result of
     * the combat. If the result is a positive number, we assume that our character
     * has won the battle, and as a consequence will increase the health points.
     * In the same way, if the number is negative our character will have lost the
     * battle, and as a consequence the character will lose health points.
     * @param character1 The 1st opponent
     * @param character2 the 2nd opponent
     */
    public void fight (Character character1, Character character2){
        int result = character1.getSecretWeapon() - character2.getSecretWeapon();
        character1.setHealth(character1.getHealth() + result);
        character2.setHealth(character2.getHealth() - result);
    }

    /**
     * This method checks if a character is or not alive checking the value of its
     * attribute health. If health is lower than zero the character is dead, in
     * other case is alive
     * @return a boolean value true (if character is alive) or false (if character is dead)
     */
    public boolean isAlive(){
        return health > 0;
    }


    public char getFootprint(){
        return footprint;
    }

    public void explore(Maze mazeToExplore){
        Maze aux = mazeToExplore.clone();
        if (aux.findPathFrom(1, 0)) {
            aux.print(getFootprint());
        } else {
            System.out.println("no solution found");
        }
    }

}