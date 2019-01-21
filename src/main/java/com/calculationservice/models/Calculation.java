package com.calculationservice.models;

import javax.persistence.*;

@Entity
@Table(name = "calculations")

public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calculations_id;

    @Column(name = "result_calculations")
    private double result_calculations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_users_id")
    private User user;

    public Calculation() {
    }

    public int getId() {
        return calculations_id;
    }

    public double getResult_calculations() {
        return result_calculations;
    }

    public void setResult_calculations(double result_calculations) {
        this.result_calculations = result_calculations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return Double.toString((result_calculations));
    }
}
