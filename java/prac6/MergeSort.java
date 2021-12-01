public class MergeSort {
    public static void merge(Tests.Student[] src1, int src1Start, Tests.Student [] src2,
                             int src2Start , Tests.Student [] dest, int destStart, int size){
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            if (src1End - src1Start >= 0) System.arraycopy(src1, src1Start, dest, src1Start, src1End - src1Start);
            return;
        }

        int iterCount = src1End - src1Start + src2End - src2Start;

        for(int i = destStart; i < destStart + iterCount; i++){
            if(index1 < src1End && (index2 >= src2End || src1[index1].compareTo(src2[index2]) < 0)){
                dest[i] = src1[index1];
                index1++;
            }
            else{
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    public static void mergeSort(Tests.Student[] arr) {
        Tests.Student [] tmp;
        Tests.Student [] currentSrc = arr;
        Tests.Student [] currentDest = new Tests.Student[arr.length];

        int size = 1;
        while (size < arr.length) {
            for (int i = 0; i < arr.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;
        }

    }

    public static Tests.Student[] combineArrays(Tests.Student[] arr1, Tests.Student[] arr2){
        Tests.Student[] toReturn = new Tests.Student[arr1.length + arr2.length];
        int count = 0;
        for (Tests.Student value : arr1) {
            toReturn[count] = value;
            count++;
        }

        for (Tests.Student student : arr2) {
            toReturn[count] = student;
            count++;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        Tests.Student [] students = combineArrays(Tests.Student.initStudents(),
                Tests.Student.initStudents2());
        mergeSort(students);
        for(Tests.Student item : students)
            System.out.println(item);
    }
}