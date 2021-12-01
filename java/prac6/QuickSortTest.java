import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class QuickSortTest {

    public static class AverageMarkComparator implements Comparator<Tests.Student> {

        @Override
        public int compare(Tests.Student o1, Tests.Student o2) {
            return Double.compare(o2.averageMark, o1.averageMark);
        }

        @Override
        public Comparator<Tests.Student> reversed() {
            return null;
        }

        @Override
        public Comparator<Tests.Student> thenComparing(Comparator<? super Tests.Student> other) {
            return null;
        }

        @Override
        public <U> Comparator<Tests.Student> thenComparing(Function<? super Tests.Student, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
            return null;
        }

        @Override
        public <U extends Comparable<? super U>> Comparator<Tests.Student> thenComparing(Function<? super Tests.Student, ? extends U> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<Tests.Student> thenComparingInt(ToIntFunction<? super Tests.Student> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<Tests.Student> thenComparingLong(ToLongFunction<? super Tests.Student> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<Tests.Student> thenComparingDouble(ToDoubleFunction<? super Tests.Student> keyExtractor) {
            return null;
        }
    }

    private static AverageMarkComparator comparator = new AverageMarkComparator();

    public static void quickSort(Tests.Student[] arr, int l, int r){
        if(l < r){
            int border = partition(arr, l, r);
            quickSort(arr, l , border - 1);
            quickSort(arr, border, r);
        }
    }

    private static int partition(Tests.Student[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        Tests.Student pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (comparator.compare(arr[leftIndex], pivot) < 0) {
                leftIndex++;
            }

            while (comparator.compare(arr[rightIndex], pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                Tests.Student.swapStudents(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        Tests.Student [] students = Tests.Student.initStudents();
        quickSort(students,0, students.length - 1);
        for(Tests.Student item : students)
            System.out.println(item);
    }
}
