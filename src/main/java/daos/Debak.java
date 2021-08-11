package daos;

public class Debak {
    public static void main(String[] args) {
        int[] array = {2,3,44,2,3,4,56,56,32,9,8,8};
        Debak wow = new Debak();
        int[] arancar =wow.takeDuplicates(array);
        System.out.println(arancar);
    }

    public int[] takeDuplicates(int[] array){
        int x=array.length-1;
        int[] newArray = new int [0];
        int[] finalArray = new int[0];
        for(int i=0; i < x; i++) {
            if (array[i] == array[i + 1]) {
                finalArray = addingToArray(array[i], array);
            }continue;

        }return finalArray;
    }

    static boolean contains(int num, int[] array){
        int j = array.length;
        for(int i =0; i<j; i++){
            if(num==array[i]){
                return true;
            }
        }return false;
    }

    static int[] addingToArray(int num, int[] array){
        int j = array.length;
        if(contains(num,array)){
            return array;
        } else {
            int[] anotherArray = new int[j + 1];
            for (int i = 0; i < j; i++) {
                anotherArray[i]= array[i];
            } anotherArray[j]=num;
            return anotherArray;
        }
    }

}
