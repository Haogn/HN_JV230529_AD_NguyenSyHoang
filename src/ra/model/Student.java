package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Student {
    private static int nextId = 1 ;
    private int studentId ;
    private String studentName;
    private String birthDay;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
        this.studentId = nextId++ ;
    }

    public Student(int studentId, String studentName, String birthDay, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String  getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String  birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void inputData(Scanner sc) {
        // studentName
        while (true){
            System.out.println("Nhập vào tên học sinh");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.err.println("Ten hoc sinh khong duoc de trong");
            } else {
                this.studentName = name ;
                break;
            }
        }

        // brithDay
        System.out.println("Nhap ngay thang nam sinh");
        this.birthDay= sc.nextLine();

        // address
        while (true) {
            System.out.println("Nhap vao dia chi");
            String location = sc.nextLine();
            if (location.isEmpty()) {
                System.err.println("Dia chi khong duoc de trong");
            } else {
                this.address = location;
                break;
            }
        }

        // gender
        while (true) {
            System.out.println("Nhap vao gioi tinh ( Nam / Nu ) ");
            String sex = sc.nextLine();
            if (sex.equalsIgnoreCase("nam")){
                this.gender = true ;
                break;
            } else if (sex.equalsIgnoreCase("nu")) {
                this.gender = false ;
            } else {
                System.err.println("Gioi tinh khong hop le , vui long nhap lai ❤");
            }
        }

        // phone
        while (true) {
            System.out.println("Nhap vao so dien thoai");
            String numberPhone = sc.nextLine();
            if (numberPhone.matches("^(\\\\+84|0084|0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")) {
                this.phone = numberPhone;
                break;
            } else {
                System.err.println("So dien thoai khong dung dinh dang , vui long nhap lai ❤");
            }
        }
    }

    public void displayData() {
        System.out.println("________ THONG TIN HOC SINH _________");
        System.out.println("Ma hoc sinh: " + studentId);
        System.out.println("Ten hoc sinh: " + studentName);
        System.out.println("Ngay sinh : " + birthDay);
        System.out.println("Gioi tinh: " + (gender?"Nam":"Nu"));
        System.out.println("Dia chi: " + address);
        System.out.println("So dien thoai: "+ phone);
    }
}

