import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        Methodd methodd = new Methodd();
        Scanner sc = new Scanner(System.in);

        while (true) {
        menu();
        int choose = sc.nextInt();
        sc.nextLine();

        switch (choose) {
            case 1 -> methodd.m1();
            case 2 -> methodd.m2();
            case 3 -> methodd.m3();
            case 4 -> methodd.m4();
            case 5 -> methodd.m5a();
            case 6 -> methodd.m5b();
            case 7 -> methodd.m6();
            case 8 -> methodd.m7();
            case 9 -> methodd.m8();
            case 0 -> System.exit(0);
            }
        }
    }

    public static void menu() {
        System.out.println("1. Tính số người nhập cảnh trong ngày");
        System.out.println("2. Tính số người xuất cảnh trong ngày");
        System.out.println("3. Liệt kê số người xuất cảnh dùng hộ chiếu");
        System.out.println("4. Liệt kê số người nhập cảnh dùng visa");
        System.out.println("5. Đếm số người sử dụng XNC theo Visa");
        System.out.println("6. Đếm số người sử dụng XNC theo Passport");
        System.out.println("7. Đếm số người sử dụng XNC theo các loại thông tin giấy tờ cho phép xuất cảnh hoặc nhập cảnh");
        System.out.println("8. Liệt kê những người nhập cảnh và quốc tịch VN");
        System.out.println("9. Liệt kê những người là nam, xuất cảnh với mục đích du lịch");
        System.out.print("Choose: ");
    }
}
