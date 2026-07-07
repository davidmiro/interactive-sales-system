package david.dev.model;


import java.time.LocalTime;

public class Order {
    private int cementQuantity;
    private String companyName;
    private LocalTime localTime;

    public int getCementQuantity() {
        return cementQuantity;
    }

    public void setCementQuantity(int cementQuantity) {
        this.cementQuantity = cementQuantity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
