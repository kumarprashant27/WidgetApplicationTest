package Models;

public class DataItem  {

    public DataItem(String title, String company) {
        this.title = title;
        this.company = company;
    }

    private String title = "", company = "";

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
