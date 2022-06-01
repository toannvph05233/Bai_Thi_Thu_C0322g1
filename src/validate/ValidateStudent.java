package validate;

import models.Student;

import java.util.List;
import java.util.Scanner;

public class ValidateStudent {
    Scanner scanner = new Scanner(System.in);

    public int validateID(List<Student> students) {
        while (true) {
            try {
                System.out.println("Nhập id:");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, students) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai id rồi");
            }
        }
    }

    public int getIndexId(int id, List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public String validateString(String name) {
        while (true) {
            System.out.println("Nhập " + name);
            String str = scanner.nextLine();
            if (str.equals("")) {
                System.err.println("không để trống");
                continue;
            } else {
                return str;
            }
        }
    }

    public int validateAge() {
        while (true) {
            try {
                System.out.println("Nhập age:");
                int age = Integer.parseInt(scanner.nextLine());
                return age;
            } catch (Exception e) {
                System.err.println("Nhập sai age rồi");
            }
        }
    }

    public double validateScore() {
        while (true) {
            try {
                System.out.println("Nhập score:");
                double score = Integer.parseInt(scanner.nextLine());
                return score;
            } catch (Exception e) {
                System.err.println("Nhập sai score rồi");
            }
        }
    }

}

