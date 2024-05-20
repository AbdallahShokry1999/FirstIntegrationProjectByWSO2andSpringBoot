package com.demoo.demoo.entities;


import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status;

    private double bill;
    private double payment_amount;
    // Constructors, getters, and setters
    public User() {}

    public User(String name, String status, double bill, double payment_amount) {
        this.name = name;
        this.status = status;
        this.bill = bill;
        this.payment_amount = payment_amount;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(double payment_amoun) {
        this.payment_amount =payment_amoun+payment_amount;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

@PreUpdate
    public void updateStatus(){
        if (payment_amount-bill == 0) {
            setStatus("paid");
            }
        else if (payment_amount-bill>0) {
            double x=payment_amount-bill;
            setStatus("paid with extra"+String.valueOf(x));
            this.status = status;
        }else {
            double x=bill-payment_amount;

            setStatus("unpaid with"+String.valueOf(x));
        }
    }
}
