package InterfacesAndAbstraction.Exercise.P05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        boolean isNumber = false;
        for (String url : urls) {

            String current = url;
            isNumber = false;
            for (int i = 0; i < current.length(); i++) {
                if (Character.isDigit(current.charAt(i))) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    isNumber = true;
                    break;
                }
            }
            if (!isNumber) {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        boolean isNumber = false;
        for (String number : numbers) {
            String current = number;
            for (int i = 0; i < current.length(); i++) {
                if (!Character.isDigit(current.charAt(i))) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    isNumber = true;
                    break;
                }
            }
            if (!isNumber) {
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
