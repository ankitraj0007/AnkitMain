package dsAlgo.array;

public class SecondLargest {

    public static void main(String[] args) {
        int[] arr = {2,45,23,8,10};
        int secondLargest = findSecondLargest(arr);
        System.out.println(secondLargest);
    }

    private static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(largest < arr[i]){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(secondLargest < arr[i] && largest != arr[i]){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
