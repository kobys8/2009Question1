/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2009question1;

/**
 *
 * @author kms080
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberCube cube = new NumberCube();
        int[] tosses = getCubeTosses(cube, 17);
        for(int i = 0; i <= tosses.length - 1; i++) {
            System.out.println(i + " : " + tosses[i]);
        }
        System.out.println(getLongestRun(tosses));
    }
     /** Returns an array of the values obtained by tossing a number cube numTosses times.
    * @param cube a NumberCube 
    * @param numTosses the number of tosses to be recorded
    * Precondition: numTosses > 0 
    * @return an array of numTosses values 
    */ 
    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        int[] tossValues = new int[numTosses + 1];
        for(int i = 0; i < tossValues.length; i++) {
            tossValues[i] = cube.toss();
        }
        return tossValues;
    }
    /** Returns the starting index of a longest run of two or more consecutive repeated values 
    * in the array values.
    * @param values an array of integer values representing a series of number cube tosses 
    * Precondition: values.length > 0 
    * @return the starting index of a run of maximum size; 
    * -1 if there is no run
    */ 
    public static int getLongestRun(int[] values) {
        int runLength = 0;
        int runNum = 0;
        int runIndex = 0;
        int maxRunIndex = 0;
        int maxRunLength = 0;
        for(int i = 1; i <= values.length - 1; i++) {
            if(values[i] == values[i - 1]) {
                runLength++;
                if(runLength > maxRunLength) {
                    maxRunLength = runLength;
                    maxRunIndex = runIndex;
                }
            }
            else {
                runIndex = i;
            }
            //System.out.println(runLength + " " + runNum + " " + runIndex);
        }
        if(runLength == 0 && runNum == 0 && runIndex == 0) {
            return -1;
        }
        else {
            return maxRunIndex;
        }
    }
}

class NumberCube 
{ 
    private int sides = 6;
    public NumberCube() {
        
    }
    /** @return an integer value between 1 and 6, inclusive 
    */ 
    public int toss() {
        int toss = (int)(Math.random() * 6) + 1;
        return toss;
    }
    // There may be instance variables, constructors, and methods that are not shown.
} 