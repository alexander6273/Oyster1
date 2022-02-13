import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        //first solution

        int[] arr = {1,2,3,4,5,6};
        int numberOfElements = 2;

        int runCount = 0;
        while (runCount < numberOfElements)
        {
            //temporarily storing the first element before shifting the list
            //then adding it back to the end of the list
            //running the while loop k number of times
            int temporary = arr[0];
            for (int i = 0; i < arr.length - 1; i++)
            {
                arr[i] = arr[i + 1];
            }
            arr[arr.length -1] = temporary;
            runCount++;
        }
        System.out.println(Arrays.toString(arr));

//-------------------------------------------------------------------//
        //second faster solution

        int[] arr2 = {1,2,3,4,5,6};
        int numberOfElements2 = 2;

        //temporarily storing the elements that need to be shifted
        int[] temp2 = new int[numberOfElements2];
        for (int i = 0; i < numberOfElements2; i++)
        {
            temp2[i] = arr2[i];
        }

        //shifting the list by the amount of elements
        for (int i = 0; i < arr2.length - numberOfElements2; i++)
        {
            arr2[i] = arr2[i + numberOfElements2];
        }

        //adding back the elements at the end of the list
        int counter = 0;
        for (int i = arr2.length - numberOfElements2; i < arr2.length; i++)
        {
            arr2[i] = temp2[counter];
            counter ++;
        }
        System.out.println(Arrays.toString(arr2));
    }
}
