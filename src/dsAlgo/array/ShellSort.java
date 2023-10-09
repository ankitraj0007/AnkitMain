package dsAlgo.array;

public class ShellSort {

    public static void main(String[] args){
        int[] intArray = new int[7];
        intArray[0]=20;
        intArray[1]=35;
        intArray[2]=-15;
        intArray[3]=7;
        intArray[4]=55;
        intArray[5]=1;
        intArray[6]=-22;


        for(int gap= intArray.length/2; gap>0;gap/=2){
            for(int i=gap; i<intArray.length;i++){
                int buffer;
                for(int b=i; b>=gap;b-=gap){
                    if(intArray[b]<intArray[b-gap]){
                        buffer=intArray[b-gap];
                        intArray[b-gap]=intArray[b];
                        intArray[b]=buffer;
                    }
                }
            }

        }



        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
}
