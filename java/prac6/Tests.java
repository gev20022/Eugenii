public class Tests {

    static class Student implements Comparable<Student>{
        String name;
        int id;
        double averageMark;

        public Student(String name, int id, double averageMark) {
            this.name = name;
            this.id = id;
            this.averageMark = averageMark;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static Student [] initStudents(){
            return new Student[]{
                    new Student("fdfd", 5, 5.55),
                    new Student("dsgsdg", 33, 3.66),
                    new Student("sgdggddsg", 0, 4.66),
                    new Student("sgdggddsg", 3, 5.67),
                    new Student("sgdggddsg", 555, 7.55),
                    new Student("sgdggddsg", 824, 1.55),
                    new Student("sgdggddsg", 5532, 5.66),
                    new Student("sgdggddsg", 536463, 5.23),
                    new Student("sgdggddsg", 737, 3.55),
                    new Student("sgdggddsg", 475, 9.99),
                    new Student("sgdggddsg", 346, 4.66)
            };
        }

        static Student [] initStudents2(){
            return new Student[]{
                    new Student("fdfd", 66, 5.55),
                    new Student("dsgsdg", 33, 3.66),
                    new Student("sgdggddsg", 60, 4.66),
                    new Student("sgdggddsg", 34, 5.67),
                    new Student("sgdggddsg", 565, 7.55),
            };
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.id, o.id);
        }

        public static void swapStudents(Student [] students, int i, int j){
            if(i != j) {
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", averageMark=" + averageMark +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student [] students = Student.initStudents();

        int pointer = 0;
        while(pointer < students.length){
            Student min = students[pointer];
            int minPos = pointer;
            for(int i = pointer + 1; i < students.length; i++){
                if(students[i].compareTo(min) < 0) {
                    min = students[i];
                    minPos = i;
                }
            }
            Student.swapStudents(students, pointer, minPos);
            pointer++;
        }
        for(Student item : students)
            System.out.println(item);
    }
}