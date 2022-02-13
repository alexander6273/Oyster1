import java.util.Random;

public class testingMethods
{

    public static void main(String[] args)
    {
        Random ranGen = new Random();
        int nanoSecondConvertVal = 1000000;
        int arraySize = 1000000;
        int numberOfElements = 100;

//-------------------------------------------------------------------//

        int[] arr = new int[arraySize];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = ranGen.nextInt(100);
        }

        double timeStart = System.nanoTime();

            int runCount = 0;
            while (runCount < numberOfElements)
            {
                int temporary = arr[0];
                for (int i = 0; i < arr.length - 1; i++)
                {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length -1] = temporary;
                runCount++;
            }
        double timeStop = System.nanoTime();
        double deltaTime1 = timeStop - timeStart;
        System.out.printf("det tog %.3f millisekunder at rotere listen med den første metode%n", deltaTime1/nanoSecondConvertVal);

//-------------------------------------------------------------------//

        int[] arr2 = new int[arraySize];
        for (int i = 0; i < arr2.length; i++)
        {
            arr2[i] = ranGen.nextInt(100);
        }

        timeStart = System.nanoTime();

            int[] temp2 = new int[numberOfElements];
            for (int i = 0; i < numberOfElements; i++)
            {
                temp2[i] = arr2[i];
            }

            for (int i = 0; i < arr2.length - numberOfElements; i++)
            {
                arr2[i] = arr2[i + numberOfElements];
            }

            int counter = 0;
            for (int i = arr2.length - numberOfElements; i < arr2.length; i++)
            {
                arr2[i] = temp2[counter];
                counter ++;
            }
        timeStop = System.nanoTime();
        double deltaTime2 = timeStop - timeStart;
        System.out.printf("det tog %.3f millisekunder at rotere listen med den anden metode %n", deltaTime2/nanoSecondConvertVal);
        double ratio = deltaTime1 / deltaTime2;
        System.out.printf("den anden metode var %.0f gange hurtigere end den første metode", ratio);
    }
}
