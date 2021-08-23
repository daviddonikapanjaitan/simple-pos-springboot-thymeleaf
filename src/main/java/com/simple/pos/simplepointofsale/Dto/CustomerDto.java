package com.simple.pos.simplepointofsale.Dto;
 
public class CustomerDto{

    private String paymentMethodCode;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String dateBecomeCustomer;
    private String paymentDetails;

    @Override
    public String toString() {
        return "CustomerDto [customerEmail=" + customerEmail + ", customerName=" + customerName + ", customerPhone="
                + customerPhone + ", dateBecomeCustomer=" + dateBecomeCustomer + ", otherCustomerDetails="
                + otherCustomerDetails + ", paymentDetails=" + paymentDetails + ", paymentMethodCode="
                + paymentMethodCode + "]";
    }

    public CustomerDto(){

    }

    public CustomerDto(String customerName, String customerPhone, String customerEmail, String dateBecomeCustomer,
            String paymentDetails, String otherCustomerDetails) {
        super();
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.dateBecomeCustomer = dateBecomeCustomer;
        this.paymentDetails = paymentDetails;
        this.otherCustomerDetails = otherCustomerDetails;
    }

    public String getDateBecomeCustomer() {
        return dateBecomeCustomer;
    }
    public void setDateBecomeCustomer(String dateBecomeCustomer) {
        this.dateBecomeCustomer = dateBecomeCustomer;
    }
    private String otherCustomerDetails;

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }
    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String getPaymentDetails() {
        return paymentDetails;
    }
    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
    public String getOtherCustomerDetails() {
        return otherCustomerDetails;
    }
    public void setOtherCustomerDetails(String otherCustomerDetails) {
        this.otherCustomerDetails = otherCustomerDetails;
    }
}