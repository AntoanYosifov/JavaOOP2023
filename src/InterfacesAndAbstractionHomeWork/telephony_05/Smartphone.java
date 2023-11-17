package InterfacesAndAbstractionHomeWork.telephony_05;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {

        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder resultBuilder = new StringBuilder();

        for (String number : numbers) {
            if (number.matches("\\d+")) {
                resultBuilder.append("Calling... " + number);
            } else {
                resultBuilder.append("Invalid number!");
            }
            resultBuilder.append(System.lineSeparator());
        }
        return resultBuilder.toString();
    }

    @Override
    public String browse() {
        StringBuilder resultBuilder = new StringBuilder();

        for (String url : urls) {
            if (url.matches("[^\\d]+")) {
                resultBuilder.append("Browsing: " + url + "!");
            } else {
                resultBuilder.append("Invalid URL!");
            }
            resultBuilder.append(System.lineSeparator());
        }
        return resultBuilder.toString();
    }
}
