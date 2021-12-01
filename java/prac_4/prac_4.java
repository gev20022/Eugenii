public class prac_4 {

    public static boolean isPalindrome(String word){
        if(word.length() == 1){
            return true;
        }
        if(word.length() == 2){
            return word.charAt(0) == word.charAt(1);
        }
        else{
            if(word.charAt(0) == word.charAt(word.length() - 1))
                return isPalindrome(word.substring(1, word.length() - 1));
            else return false;
        }
    }

    static class LongWrapper{
        public long value = 0;

        public void inc(){
            value++;
        }

        public void add(int value){
            this.value += value;
        }
    }

    public static long withoutTwoZeros(int a, int b){
        LongWrapper count = new LongWrapper();
        if(a > 0) {
            count.inc();
            withoutTwoZerosRec(a - 1, b ,"0", count);
        }
        if(b > 0) {
            count.inc();
            withoutTwoZerosRec(a, b - 1, "1", count);
        }

        return count.value;
    }

    private static void withoutTwoZerosRec(int a, int b, String currentWord, LongWrapper count){
        if(a > 0 && currentWord.charAt(currentWord.length() - 1) != '0') {
            count.inc();
            withoutTwoZerosRec(a - 1, b ,currentWord + '0', count);
        }
        if(b > 0) {
            count.inc();
            withoutTwoZerosRec(a, b - 1, currentWord + '1', count);
        }
    }

    public static long expandNum(int num){
        LongWrapper res = new LongWrapper();
        expandNumRec(num,1, res);
        return res.value;
    }

    public static int getNumOfRanks(int num){
        return(num == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(num) + 0.5));
    }

    public static void expandNumRec(int num, int rank, LongWrapper buff){
        if(rank <= getNumOfRanks(num)) {
            int rankToSum = getNumOfRanks(num) - rank;
            int numToRank = (int) ((int) (num % Math.pow(10, rank)) / Math.pow(10, rank - 1));
            buff.add((int) (numToRank * Math.pow(10, rankToSum)));
            expandNumRec(num, rank + 1, buff);
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ssss"));
        System.out.println(isPalindrome("saf"));
        System.out.println(isPalindrome("fsf"));
        System.out.println(withoutTwoZeros(5, 4));
        System.out.println(expandNum(6776788));
    }

}