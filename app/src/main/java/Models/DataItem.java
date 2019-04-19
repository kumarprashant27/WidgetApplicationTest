package Models;

public class DataItem  {
    public DataItem(int id, String title, String company, int salary, int duration, String location, Boolean isApplied) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.duration = duration;
        this.location = location;
        this.isApplied = isApplied;
    }

    private String title = "", company = "", location = "";
    private int id = 0, salary = 0, duration = 0;
    private  Boolean isApplied;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getApplied() {
        return isApplied;
    }

    public void setApplied(Boolean applied) {
        isApplied = applied;
    }
}
