package Models;

public class DataItem  {
    public DataItem(int id, String title, String company, int salary, int duration) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.duration = duration;
    }

    private String title = "", company = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id = 0, salary = 0, duration = 0;


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
