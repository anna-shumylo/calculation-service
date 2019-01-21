package com.calculationservice.controller;

import com.calculationservice.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    private CalculationService calculationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    private Double validator(String param) {
        String number = param.replaceAll(",", ".");
        Double doub = Double.parseDouble(number);
        return doub;
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public ModelAndView calculator(@RequestParam(value = "left_param", required = false) String leftParam,
                                   @RequestParam(value = "right_param", required = false) String rightParam,
                                   @RequestParam(value = "result", required = false) String result,
                                   @RequestParam(value = "action") String action) {
        ModelAndView model = new ModelAndView();
        model.addObject("left_param", leftParam);
        model.addObject("right_param", rightParam);
        model.addObject("result", result);
        model.addObject("action",action);
        if ((leftParam != null) && (rightParam != null)) {
            try {
                Double leftParamDoub = validator(leftParam);
                Double rightParamDoub = validator(rightParam);
                Double resultDoub = calculationService.getResult(leftParamDoub,rightParamDoub,action);
                model.addObject("result", resultDoub.toString());
            } catch (NumberFormatException ex) {
                model.addObject("error","You need to fill in both cells with valid numbers");
            }

        }

        model.setViewName("calculator");
        return model;
    }
}
