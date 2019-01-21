package com.calculationservice.models;

import com.calculationservice.models.Calculation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int users_id;
    @Column(name = "first_name")
    private String first_name;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String last_name;
    private String login;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Calculation> calculationList;

    public User() {
    }

    public User(String first_name, String last_name, String login, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        calculationList = new ArrayList<>();
    }

    public void addCalculation(Calculation calculation) {
        calculation.setUser(this);
        calculationList.add(calculation);
    }

    public void removeCalculation(Calculation calculation) {
        calculationList.remove(calculation);
    }

    public int getUsers_id() {
        return users_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Calculation> getCalculationList() {
        return calculationList;
    }

    public void setCalculationList(List<Calculation> calculationList) {
        this.calculationList = calculationList;
    }

    @Override
    public String toString() {
        return "com.calculationservice.Usertionservice.models.User{" +
                "users_id=" + users_id +
                ", first_name= '" + first_name + '\'' +
                ", last_name= '" + last_name + '\'' +
                ", login= '" + login + '\'' +
                ", password= '" + password + '\'' +
                '}';
    }
}
