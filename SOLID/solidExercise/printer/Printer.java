package SOLID.solidExercise.printer;

import SOLID.solidExercise.calculators.Calculator;
import SOLID.solidExercise.products.Product;

import java.util.List;

public class Printer {

    private Calculator calculator;
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";


    void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
