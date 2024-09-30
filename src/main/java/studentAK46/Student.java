package studentAK46;

import java.util.Random;

public class Student {
    private String id; // Biến thành viên cho ID
    private String name; // Biến thành viên cho tên
    private int Math; // Biến thành viên cho điểm Toán
    private int Physic; // Biến thành viên cho điểm Vật Lý
    private int Chemistry; // Biến thành viên cho điểm Hóa Học

    // Tạo đối tượng Random chỉ một lần cho toàn bộ lớp
    private static final Random random = new Random();

    public Student(String name) {
        this.name = name;
        this.id = generateRandomID(random); // Gán ID cho sinh viên
        this.Math = random.nextInt(10); // Điểm Toán
        this.Physic = random.nextInt(10); // Điểm Vật Lý
        this.Chemistry = random.nextInt(10); // Điểm Hóa Học
    }

    private static String generateRandomID(Random random) {
        int number = random.nextInt(1000); // Số ngẫu nhiên từ 0 đến 999
        String prefix = "tvn-"; // Tiền tố ID
        return prefix + number; // Trả về ID với tiền tố và số ngẫu nhiên
    }
    public void Show() {
        // Hiển thị thông tin sinh viên
        System.out.println(name + " " + id + " " + Math + " " + Physic + " " + Chemistry);
    }
    public int getMath(){
        return Math;
    }


}
