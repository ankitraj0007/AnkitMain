package dsAlgo.array;

public class InsertionSort {

    public static void main(String[] args){
        int[] intArray = new int[7];
        intArray[0]=20;
        intArray[1]=35;
        intArray[2]=-15;
        intArray[3]=7;
        intArray[4]=55;
        intArray[5]=1;
        intArray[6]=-22;

        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
        System.out.println("-------------");

        for(int sortedPartition=1; sortedPartition<intArray.length;sortedPartition++){
            int buffer;
            for(int b=sortedPartition; b>0;b--){
                if(intArray[b]<intArray[b-1]){
                    buffer=intArray[b-1];
                    intArray[b-1]=intArray[b];
                    intArray[b]=buffer;
                }
            }
        }



        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
}
