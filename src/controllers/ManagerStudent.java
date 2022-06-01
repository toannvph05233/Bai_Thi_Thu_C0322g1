package controllers;

import io.ReaderAndWriteStudent;
import models.Student;
import sort.SortByScore;
import validate.ValidateStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    ValidateStudent validateStudent = new ValidateStudent();
    ReaderAndWriteStudent readerAndWriteStudent = new ReaderAndWriteStudent();

    public void menu() {
        System.out.println("Chương trình quản lý sinh viên");
        System.out.println("1. hiển thị");
        System.out.println("2. thêm mới");
        System.out.println("3. chỉnh sửa");
        System.out.println("4. xóa");
        System.out.println("5. sắp xếp");
        System.out.println("6. đọc file");
        System.out.println("7. ghi file");
        System.out.println("8. thoát");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                show();
                break;
            case 2:
                addStudent(createStudent());
                break;
            case 3:
                editStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                sortByScore();
                break;
            case 6:
                students = readerAndWriteStudent.reader();
                System.out.println("đọc thành công");
                break;
            case 7:
                readerAndWriteStudent.Write(students);
                System.out.println("Ghi thành công");
                break;
            case 8:
        }
    }

    public void show() {
        for (int i = 0; i < students.size(); i++) {
            if ((i+1) % 3 == 0) {
                System.out.println(students.get(i));
                scanner.nextLine();
            } else {
                System.out.println(students.get(i));
            }
        }
    }

    public Student createStudent() {
        int id = validateStudent.validateID(students);
        String name = validateStudent.validateString("name :");
        int age = validateStudent.validateAge();
        String gender = validateStudent.validateString("gender :");
        String address = validateStudent.validateString("address :");
        double agvScore = validateStudent.validateScore();
        return new Student(id, name, age, gender, address, agvScore);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent() {
        System.out.println("Nhập id cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateStudent.getIndexId(id,students);
        if (index != -1){
            students.set(index, createStudent());
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void deleteStudent() {
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateStudent.getIndexId(id,students);
        if (index != -1){
            students.remove(index);
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void sortByScore(){
        students.sort(new SortByScore());
        System.out.println("sắp xếp thành công");
    }

}
