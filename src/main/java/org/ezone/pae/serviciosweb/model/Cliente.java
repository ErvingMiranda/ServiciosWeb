package org.ezone.pae.serviciosweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String country;
    private String city;
    private String address;
    private BigDecimal annualIncome;
    private Integer creditScore;
    private Boolean hasUnpaidDebt;
    private BigDecimal unpaidDebtAmount;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Cliente() {
    }

    public String getNombreCompleto() {
        String nombre = firstName == null ? "" : firstName;
        String apellido = lastName == null ? "" : lastName;

        return (nombre + " " + apellido).trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Boolean getHasUnpaidDebt() {
        return hasUnpaidDebt;
    }

    public void setHasUnpaidDebt(Boolean hasUnpaidDebt) {
        this.hasUnpaidDebt = hasUnpaidDebt;
    }

    public BigDecimal getUnpaidDebtAmount() {
        return unpaidDebtAmount;
    }

    public void setUnpaidDebtAmount(BigDecimal unpaidDebtAmount) {
        this.unpaidDebtAmount = unpaidDebtAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}