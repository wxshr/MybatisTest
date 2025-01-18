package pojo;

public class Person {
    private int id;
    private String name;
    private String grade;
    private int schoolCardId;
    private IdCard card;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", schoolCardId=" + schoolCardId +
                ", money=" + (card != null ? card.getMoney() : "null") +
                '}';
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

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSchoolCardId() {
        return schoolCardId;
    }

    public void setSchoolCardId(int schoolCardId) {
        this.schoolCardId = schoolCardId;
    }

    public IdCard getCard() {
        return card;
    }

    public void setCard(IdCard card) {
        this.card = card;
    }
}
