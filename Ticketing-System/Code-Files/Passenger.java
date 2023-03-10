
public class Passenger extends Stations{
    
    private String fullName;
    private String dob;
    private Integer age;
    private String contact;
    private String passengerType;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
    

    @Override
    public String toString() {
        return "Passenger{" + "fullName=" + fullName + ", dob=" + dob + ", age=" + age + ", contact=" + contact + '}';
    }
    
    
}
