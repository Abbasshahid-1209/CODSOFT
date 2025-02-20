import java.util.*;

class Course {
    String code, title;
    int capacity;

    Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return code + " - " + title + " (Seats: " + capacity + ")";
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void registerCourse(Course course) {
        if (course.capacity > 0) {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println("Registered for " + course.title);
        } else System.out.println("Course full!");
    }

    void removeCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.capacity++;
            System.out.println("Dropped " + course.title);
        } else System.out.println("Not registered in " + course.title);
    }

    void displayCourses() {
        System.out.println("Registered Courses: " + (registeredCourses.isEmpty() ? "None" : registeredCourses));
    }
}

public class CourseRegistration{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Course> courses = Arrays.asList(
            new Course("CSE101", "Java", 2),
            new Course("CSE102", "DSA", 3),
            new Course("CSE103", "DBMS", 2)
        );

        System.out.print("Enter ID: ");
        Student student = new Student(sc.nextLine(), sc.nextLine());

        while (true) {
            System.out.println("\n1. View Courses  2. Register  3. Drop  4. View Registered  5. Exit");
            switch (sc.nextInt()) {
                case 1 -> courses.forEach(System.out::println);
                case 2 -> student.registerCourse(findCourse(sc, courses));
                case 3 -> student.removeCourse(findCourse(sc, student.registeredCourses));
                case 4 -> student.displayCourses();
                case 5 -> { sc.close(); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static Course findCourse(Scanner sc, List<Course> courses) {
        System.out.print("Enter Course Code: ");
        String code = sc.next();
        return courses.stream().filter(c -> c.code.equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}