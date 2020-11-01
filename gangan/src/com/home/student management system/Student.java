public class Student {
    private String name;
    private String number;
    private String classban;
    private long patriarchPhone;

    public Student() {
    }

    public Student(String name, String number, String classban, long patriarchPhone) {
        this.name = name;
        this.number = number;
        this.classban = classban;
        this.patriarchPhone = patriarchPhone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", classban='" + classban + '\'' +
                ", patriarchPhone=" + patriarchPhone +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClassban() {
        return classban;
    }

    public void setClassban(String classban) {
        this.classban = classban;
    }

    public long getPatriarchPhone() {
        return patriarchPhone;
    }

    public void setPatriarchPhone(long patriarchPhone) {
        this.patriarchPhone = patriarchPhone;
    }





}
