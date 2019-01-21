package com.calculationservice;

import com.calculationservice.services.CalculationService;
import com.calculationservice.services.UserService;

import java.sql.SQLException;

public class Main {

        public static void main(String[] args) throws SQLException {

            UserService userService = new UserService();
            CalculationService calculationService = new CalculationService();
            System.out.println(calculationService.getAllCalculations());
        }
}
