public class Person {

    private String name = "";
    private String address = "";

    public String getName() {
        return name;
    }

    public int getLength(){return  name.length();}

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
