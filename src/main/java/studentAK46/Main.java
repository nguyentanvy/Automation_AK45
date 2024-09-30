package studentAK46;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Tạo 3 đối tượng Student với ID ngẫu nhiên riêng biệt
        Student st1 = new Student("Tan vy");
        Student st2 = new Student("Hoang dung");
        Student st3 = new Student("Quach tinh");

        // Thêm các sinh viên vào danh sách và hiển thị thông tin của họ
        List<Student> character = Arrays.asList(st1, st2, st3);
        character.forEach(Student::Show);

        character.stream().max(Comparator.comparing(Student::getMath)).ifPresent(student -> {
            System.out.println("Sinh viên có điểm Toán cao nhất: ");
            student.Show();
        });

        System.out.println("-------------------------------------");
    }

}
