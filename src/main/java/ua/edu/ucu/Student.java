package ua.edu.ucu;


class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname +
                ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object o) {
        if ((! (o instanceof Student)) || o == null) {
            return false;
        }
        if (this.hashCode() == o.hashCode()) {
            return Math.abs(this.GPA - ((Student) o).getGPA()) < 0.001
                    && this.year == ((Student) o).getYear()
                    && this.name.equals(((Student) o).getName())
                    && this.surname.equals(((Student) o).getSurname());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int res = (int) (this.GPA + this.year + this.name.hashCode() + this.surname.hashCode());
        return res;
    }

}
