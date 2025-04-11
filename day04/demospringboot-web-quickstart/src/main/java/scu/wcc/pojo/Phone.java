package scu.wcc.pojo;

public class Phone {
    private String person;
    private String family;

    public Phone() {
    }

    public Phone(String person, String family) {
        this.person = person;
        this.family = family;
    }

    /**
     * 获取
     * @return person
     */
    public String getPerson() {
        return person;
    }

    /**
     * 设置
     * @param person
     */
    public void setPerson(String person) {
        this.person = person;
    }

    /**
     * 获取
     * @return family
     */
    public String getFamily() {
        return family;
    }

    /**
     * 设置
     * @param family
     */
    public void setFamily(String family) {
        this.family = family;
    }

    public String toString() {
        return "Phone{person = " + person + ", family = " + family + "}";
    }
}
