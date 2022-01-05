package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int maxSize = inputInt("What would you like the max size of the shape to be"); //Gets the maximum size of the shape
        String character = inputString("What would you like the character to be?"); //Gets the character of the shape

        String symmetry = inputString("Would you like a symmetry line (Y/N)"); //Checks if the user wants a line
        symmetry = checkChoice(symmetry); //Ensures its either Y/N

        String finalShape = "";
        for (int i = 1; i <= maxSize; i++) { //For loop to repeat and create a shape for each loop
            finalShape = createShape(character, i); //Using the createShape method to both create the shape and then get the character of the final shape as a string
        }


        if (symmetry.equals("Y"))
        {
            int lineSize = maxSize * 2;
            createLine(lineSize);
        } //If the user wants a symmetry line it creates it using the maxSize multiplied by 2

        for (int i = maxSize; i > 0 ; i--) {
            bringBackShape(finalShape, i);
        } //Using a reverse for loop to bring back the shape of the object to how it was originally

    }

    public static void bringBackShape(String finalShape, int size)
    {
        String[] shapeArray = finalShape.split("");
        String secondShape = "";

        for (int i = 0; i < size; i++) {
            secondShape = secondShape + shapeArray[i];
        }

        for (int i = 0; i < size; i++) {
            print(secondShape);
        }
    } //This method creates an array using the finalShape split, and then creates a second shape that is print howevr many times the size is currently based on the reverse for loop
    public static void createLine(int size)
    {
        String line = "";

        for (int i = 0; i < size; i++) {
            line = line + "-";
        }
        print(line);
    } //Creayes a line using the size determined with "-"
    public static String createShape(String shape, int size)
    {
        String secondShape = "";
        for (int i = 0; i < size; i++) {
            secondShape = secondShape + shape;
        }

        printShapes(secondShape, size);

        return secondShape;
    } //Creates a shape using the character and size determined by the user and then returns the final secondShape

    public static void printShapes(String secondShape, int size)
    {
        for (int j = 0; j < size; j++) {
            print(secondShape);
        }
    } //Prints the shape determined by the user however many times the user asks

    public static String checkChoice(String symmetryLine)
    {
        while (!symmetryLine.equals("Y") && !symmetryLine.equals("N"))
        {
            symmetryLine = inputString("Choose from the two options");
        }

        return symmetryLine;
    } //Checks the choice is either yes or no
    public static void print(String m) {
        System.out.println(m);
    } //Prints a message

    public static String inputString(String m) {
        String answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextLine();
        return answer;
    } //Returns a string input

    public static int inputInt(String m) {
        int answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextInt();
        return answer;
    } //Returns an integer input
}
