public class Student {
    private String name;
    private int id;
    private int totalHours;

    public Student(String name, int id, int totalHours) {
        this.name = name;
        this.id = id;
        this.totalHours = totalHours;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public int getTotalHours() { return totalHours; }
}