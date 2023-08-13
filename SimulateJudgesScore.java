package Q1;
public class SimulateJudgesScore {
    
    public static void main(String[] args)
    {

        //declare a double array and instantiate it with length 5
        double [] scores = new double[5];

        System.out.println("Here are the scores from 5 judges:");

        //calls on the populateArray method
        populateArray(scores);

        //calls on the displayArray method
        displayArray(scores);

        //calls on the final score method
        System.out.printf("\n%-2sThe average score excluding the min and max values is: %.2f", " ", finalScore(scores));


    }

    //method to populate the array
    public static void populateArray(double [] anyName)
    {
        for (int i = 0; i < anyName.length; i++)
        {
            anyName[i] = Math.random()*3+7;//produces a number in the range 7 and 10
        }
    }

    //method to display the array
    public static void displayArray(double [] anyName){
        System.out.print("[");
        for (int i = 0; i < anyName.length; i++)
        {
            System.out.printf("%.2f, ", anyName[i]);//uses printf to format the output of anyName
        }
        System.out.print("\b\b]");//removes the extra space and comma after the final element
    }

    //method to calculate the average score with the min and max values being set to zero
    public static double finalScore(double[] anyName)
    {
        double [] arr = new double [anyName.length];//declare and instantiate new array with the same length as anyName

        //use the arraycopy method to copy elements from anyName to arr
        System.arraycopy(anyName,0,arr,0,arr.length);

        //initialize the max and min values with 0
        int max = 0, min = 0;


        for (int i =0; i < anyName.length; i++)
        {
            //checks if the value at each index is greater than the other
            if (anyName[max] < anyName[i]){
                max = i;
            }
            //checks if the value at each index is lower than the other
            if (anyName[min] > anyName[i])
            {
                min = i;
            }
        }

        //outputs the highest and lowest scores using printf and a field width of 2
        System.out.printf("\n%-2sHighest Score: %.2f", " ", anyName[max]);
        System.out.printf("\n%-2sLowest Score: %.2f", " ", anyName[min]);

        //assigns the highest and lowest scores to zero
        arr[max] = 0; arr[min] = 0;

        //output the scores after the highest and lowest scores were assigned to zero
        System.out.println("\nHere are the scores after discarding the highest and lowest scores:");
        displayArray(arr);//calls on the displayArray method

        //initialize the sum to 0 since it is a series sum
        double sum = 0;

        //loop to add all the scores together
        for (int i =0; i < anyName.length; i++)
        {
            sum += arr[i];
        }
        //return the average by dividing the sum by the length of the array
        return sum/(arr.length-2);
    }
}
