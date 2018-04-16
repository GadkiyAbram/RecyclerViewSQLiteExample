package aleksandrabramovski.personsqlite;


import java.util.Objects;

public class PersonDetails {
    private int id;
    private String name;
    private String year;

    public PersonDetails(int id, String name, String year){
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDetails)) return false;
        PersonDetails details = (PersonDetails) o;
        return getId() == details.getId() &&
                Objects.equals(getName(), details.getName()) &&
                Objects.equals(getYear(), details.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getYear());
    }
}
