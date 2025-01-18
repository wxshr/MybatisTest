package pojo;

public class Achievement {

    private String id; // 注意这里改为 String 类型
    private String courseName;
    private Integer score;
    private Integer stuid;

    @Override
    public String toString() {
        return "Achievement{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", score=" + score +
                ", stuid=" + stuid +
                '}';
    }

    // Getter 和 Setter 方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }
}
