package game.terrains;

/**
 * This class model a generic maze that can be solved recursively
 * using the backtracking algorithm.
 * @author linus
 * @version 1.8
 */
import java.util.Arrays;

public class Maze implements Cloneable{
    /**
     * Constant to specify a bi-dimensional array that represents a  DEFAULT_MAZE
     * using the following symbols:
     * 0 - obstacle
     * 1 - open space
     * 2 - path taken
     * 3 - goal
     */
    private static int[][] DEFAULT_MAZE =
                    {{0, 0, 1, 1, 1, 1, 1, 1},
                    {2, 0, 1, 0, 0, 0, 1, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0},
                    {1, 1, 1, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 1, 3, 1, 1},
                    {0, 0, 1, 0, 1, 0, 0, 1},
                    {1, 0, 1, 1, 1, 0, 0, 0},
                    {1, 1, 1, 0, 1, 1, 0, 0}};


    private int[][] maze;

    // use symbols to make reading the output easier...
    // 0 - obstacle - '#'
    // 1 - open space - '.'
    // 2 - path taken - '+'
    // 3 - goal - '*'
    private char[] mazeSymbols = {'#', '.', '+', '*' };

    /**
     * Construct a new Maze using the specified bi-dimensional array
     * @param maze The bidimensional array of ints to be used as maze
     */
    public Maze(int[][] maze){
        this.maze = maze;
    }
    /**
     * Construct a new Maze using the DEFAULT_MAZE =
     {{0, 0, 1, 1, 1, 1, 1, 1},
     {2, 0, 1, 0, 0, 0, 1, 1},
     {1, 0, 1, 0, 0, 0, 0, 0},
     {1, 1, 1, 0, 0, 0, 0, 0},
     {0, 0, 1, 0, 1, 3, 1, 1},
     {0, 0, 1, 0, 1, 0, 0, 1},
     {1, 0, 1, 1, 1, 0, 0, 0},
     {1, 1, 1, 0, 1, 1, 0, 0}};
     */
    public Maze(){
        this(DEFAULT_MAZE);
    }


    /**
     * Method to create an return a copy of the current Maze
     * @return: a Maze that represents the cloned Maze.
     */

    public Maze clone(){
        int[][] clonedMaze = new int[maze.length][maze[0].length];

        for(int i=0; i<maze.length; i++){
            clonedMaze[i] = Arrays.copyOf(maze[i], maze[i].length);
        }
        return new Maze(clonedMaze);
    }

	/* Another way to implement clone method using two loops
	public Maze clone(){
	   int[][] clonedMaze = new int[maze.length][maze[0].length];
	   for(int i=0; i<maze.length; i++){
	       for (int j= 0; j< maze[i].length; j++){
	         clonedMaze[i][j] = maze[i][j];
	       }
	   }
	   return new Maze(clonedMaze);
	}
	*/
    /**
     * Method to find path from an specific position in the array trying all available
     * neighbors.
     * @param row int that represent the index of a row
     * @param col int that represent the index of a column
     * @return a boolean (true if a path have been finded and false if not).
     */
    public boolean findPathFrom(int row, int col) {

        // when we reach the goal we have solved the problem
        if (maze[row][col] == 3) {
            return true;
        }

        // add the position to our path changing its value to '2'
        maze[row][col] = 2;

        //try all available neighbours
        //North (row, col-1), South (row, col+1), East (row+1, col) and West (row-1, col)
        // if any of these return true then we have solved the problem
        if (isAvailablePosition(row - 1, col) && findPathFrom(row - 1, col)) {
            return true;
        }
        if (isAvailablePosition(row + 1, col) && findPathFrom(row + 1, col)) {
            return true;
        }
        if (isAvailablePosition(row, col - 1) && findPathFrom(row, col - 1)) {
            return true;
        }
        if (isAvailablePosition(row, col + 1) && findPathFrom(row, col + 1)) {
            return true;
        }

        //If none of previous positions is valid or matches the goal, it is necessary to revert the
        //temporary state. This reversal or backtrack is what gives name to the algorithm: backtracking
        maze[row][col] = 1;

        return false;
    }

    /**
     * Method to test if an specific position in the array is available.
     * A position is available if:
     * (1) it is inside the bounds of the maze
     * (2) if it is an open space or
     * (3) it is the goal
     * @param row int that represent the index of a row
     * @param col int that represent the index of a column
     * @return True if specified position is available and false if it is not.
     */
    private boolean isAvailablePosition(int row, int col) {
        boolean result =  row >= 0 && row < maze.length
                && col >= 0 && col < maze[row].length
                && (maze[row][col] == 1 || maze[row][col] == 3);
        return result;
    }

    /**
     * Method that prints an array with the maze output using the following MAZE_SYMBOLS:
     * '#' - obstacle
     * '.' - open space
     * '+' path taken
     * '*' goal.
     */
    public void print(){
        for(int row = 0; row < maze.length; ++row) {
            for(int col = 0; col < maze[row].length; ++col) {
                System.out.print(mazeSymbols[maze[row][col]]);
            }
            System.out.println();
        }
    }
    /**
     * Method that prints an array with the maze output using the following MAZE_SYMBOLS:
     * '#' - obstacle
     * '.' - open space
     * '*' goal.
     * and using as path taken the footprint of the character.
     * @param footprint The char to be used as footprint
     */
    public void print(char footprint){
        setFootprint(footprint);
        print();

    }

    /**
     * Replaces the footprint with the specified value.
     * @param footprint The char to be used as footprint
     */
    private void setFootprint(char footprint){
        mazeSymbols[2] = footprint;
    }

}
