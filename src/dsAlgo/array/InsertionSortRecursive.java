package dsAlgo.array;

public class InsertionSortRecursive {

    public static void main(String[] args){
        int[] intArray = {20,35,-15,7,55,1,-22};
        sort(intArray , 1);
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void sort(int[] intArray, int sortedPartition){
        //base condition
        if(sortedPartition>=intArray.length-1){
            return;
        }

        //insert
        insert(intArray,sortedPartition+1);

        //sort
        sort(intArray,sortedPartition+1);


    }

    //{20,35,-15,7,55,1,-22}
    public static void insert(int[] intArray, int start){
        int temp;
        for(int i=start; i>0;i--){
            if(intArray[i]<intArray[i-1]){
                temp=intArray[i-1];
                intArray[i-1]=intArray[i];
                intArray[i]=temp;
            }
        }
    }
}
