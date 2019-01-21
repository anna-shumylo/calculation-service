package com.calculationservice.services;

import com.calculationservice.models.Calculation;
import com.calculationservice.DAO.CalculationsDAO;
import com.calculationservice.DAO.CalculationsDAOImpl;

import java.util.ArrayList;

public class CalculationService {
    private CalculationsDAO calculationsDAO = new CalculationsDAOImpl();

    public CalculationService() {
    }

    public void addCalculation(Calculation calculation) {
        calculationsDAO.addCalculation(calculation);
    }

    public void updateCalculation(Calculation calculation) {
        calculationsDAO.updateCalculation(calculation);
    }

    public Calculation getCalculationById(int calculations_id) {
        return calculationsDAO.getCalculationById(calculations_id);
    }

    public ArrayList<Calculation> getAllCalculations() {
        return new ArrayList<>(calculationsDAO.getAllCalculations());
    }

    public ArrayList<Calculation> getAllCalculationsByUserId(int users_id) {
        return new ArrayList<>(calculationsDAO.getAllCalculationsByUserId(users_id));
    }

    public void deleteCalculation(Calculation calculation) {
        calculationsDAO.deleteCalculation(calculation);
    }

    public Double getResult(Double leftParam, Double rightParam, String operation) {
        Double result;
        switch (operation) {
            case "plus":
                result = leftParam + rightParam;
                break;
            case "minus":
                result = leftParam - rightParam;
                break;
            case "multiply":
                result = leftParam * rightParam;
                break;
            case "divide":
                result = leftParam / rightParam;
                break;
            default:
                throw new RuntimeException("Unrecognized argument");
        }
        return result;
    }
}
