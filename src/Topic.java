public class Topic {
    private Integer id;
    private String name;
    private String des;
    private Boolean status;

    public Topic() {
    }

    public Topic(Integer id, String name, String des, Boolean status) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", status=" + status +
                '}';
    }
}
