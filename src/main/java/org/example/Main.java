package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int height = 0, weight = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int minRand = 1, maxRand = 20;
        int[][] array;
        int type = 0;
        do {
            System.out.println("Input type of work\n 1 - random\t 2 - manual");
            type = sc.nextInt();
        }while(type > 2 || type < 1);

        if(type == 1)
        {
            Random rand = new Random();
            height = rand.nextInt(maxRand) + minRand;
            weight = rand.nextInt(maxRand) + minRand;
            array = new int[weight][height];
            for (int i = 0; i < weight; i++)
            {
                for (int j = 0; j < height; j++)
                {
                    array[i][j] = rand.nextInt(100);
                }
            }
        }
        else
        {
            do {
                System.out.println("Input range. Minimum 1, maximum 20");
                System.out.print("Height: ");
                height = sc.nextInt();
                System.out.print("Weight: ");
                weight = sc.nextInt();
            }while((height < 1 || height > 20) && (weight < 1 || weight > 20));
            array = new int[weight][height];
            System.out.println("Input array: ");
            for (int i = 0; i < weight; i++)
            {
                for (int j = 0; j < height; j++)
                {
                    boolean error_exist = false;
                    do {
                        try {
                            array[i][j] = sc.nextInt();
                            error_exist = false;
                        }catch (Exception exc)
                        {
                            System.out.println("Error! Value is not integer");
                            error_exist = true;
                        }
                    }while (error_exist);
                }
            }
        }
        for (int i = 0; i < weight; i++)
        {
            for (int j = 0; j < height; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Min = " + Min(array) + " Max = " + Max(array) + " Average = " + Average(array) + " Average Geo = " + AverageGeo(array));

    }
    public static int Min(int[][] array)
    {
        int min = array[0][0];
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < height; j++)
            {
                if(array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }
    public static int Max(int[][] array)
    {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < height; j++)
            {
                if(array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }
    public static double Average(int[][] array)
    {
        int average = 0;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < height; j++)
            {
                average += array[i][j];
            }
        }
        return average/(height*weight);
    }

    public static double AverageGeo(int[][] array)
    {
        double average = 1;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < height; j++)
            {
                average *= array[i][j];
            }
        }
        return Math.pow(average, (double)1/(height*weight));
    }
}