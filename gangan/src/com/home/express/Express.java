public class Express {


    private String company;
    private String  number;
    private  String phoneNumber;
    private  int  ItemCode;
      Express(){}
    public int  getItemCode() {
        return ItemCode;
    }
    public void setItemCode(int  itemCode) {
        ItemCode = itemCode;
    }
    public Express(String company, String number, String phoneNumber) {
        this.company = company;
        this.number = number;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Express{" +
                "company='" + company + '\'' +
                ", number=" + number +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

