package com.calculationservice.DAO;

import com.calculationservice.models.Calculation;

import java.util.Collection;


public interface CalculationsDAO {
    void addCalculation(Calculation calculation);
    void updateCalculation(Calculation calculation);
    Calculation getCalculationById(int calculations_id);
    Collection<Calculation> getAllCalculations();
    Collection<Calculation> getAllCalculationsByUserId(int users_id);
    void deleteCalculation(Calculation calculation);
}
