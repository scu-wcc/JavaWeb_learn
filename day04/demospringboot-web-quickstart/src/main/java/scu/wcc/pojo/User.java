package scu.wcc.pojo;

public class User {

    private  String name;
    private Integer age;
    private Address address;

    private Phone phone;


    public User() {
    }



    public User(String name, Integer age, Address address, Phone phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }



    /**
     * 获取
     * @return phone
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String toString() {
        return "User{name = " + name + ", age = " + age + ", address = " + address + ", phone = " + phone + "}";
    }
}
