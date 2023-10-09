package dsAlgo.array;

public class QuickSort {

    public static void main(String[] args){
        int[] intArray = {20,35,-15,7,55,1,-22};
        sort(intArray,0,intArray.length);
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void sort(int[] intArray, int start, int end){

        if(end-start<2){
            return;
        }

        int pivot = findPivot(intArray,start,end);
        sort(intArray,start,pivot);
        sort(intArray,pivot+1,end);

    }
    //{20,35,-15,7,55,1,-22}
    public static int findPivot(int[] intArray, int start, int end){

        int pivot=intArray[start];
        int i= start;
        int j= end;

        while(i<j){
            //empty loop to traverse to desired position from end
            while (i<j && intArray[--j]>=pivot);
            if(i<j){
                intArray[i]=intArray[j];
            }
            //empty loop to traverse to desired position from front
            while (i<j && intArray[++i]<=pivot);
            if(i<j){
                intArray[j]=intArray[i];
            }
        }
        intArray[j]=pivot;
        return j;
    }
}
