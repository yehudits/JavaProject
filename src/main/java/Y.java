public class Y {


    public boolean search(int[] array, int val){
        int i = 0;
//        @maintaining !(\exist int j; 0 <= j && j < i; array[j] == val)
//        @maintaining 0 <= i && i <= array.length
//        @decreasidng array.length - i;

        while (i < array.length) {
            if (array[i] == val){
                return true;
            }
            i++;
        }
        return false;
    }

}


