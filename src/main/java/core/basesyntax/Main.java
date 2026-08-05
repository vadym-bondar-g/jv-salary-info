package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String[] scriptArray = {
            "25.04.2019 John 60 50",
            "25.04.2019 Andrew 3 200",
            "25.04.2019 Kate 10 100",
            "26.04.2019 Andrew 3 200",
            "26.04.2019 Kate 9 100",
            "27.04.2019 John 7 100",
            "27.04.2019 Kate 3 80",
            "27.04.2019 Andrew 8 100",
            "29.04.2019 Kate 10 100",
    };

    public static void main(String[] args) {
       getData( scriptArray);
    }

    public static String getData(String[] data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate from = LocalDate.parse("25.04.2019", formatter);
        LocalDate to = LocalDate.parse("27.04.2019", formatter);

        LocalDate localDate;
        StringBuilder sb = new StringBuilder();
        String[] dataArray;
        Map <String, Integer> salaries = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            dataArray = data[i].split(" ");
            int salary =  Integer.parseInt(dataArray[2]) * Integer.parseInt(dataArray[3]);
            String name = dataArray[1];
            salaries.put(name, salaries.getOrDefault(name, 0) + salary);
            localDate = LocalDate.parse(dataArray[0], formatter);
            if (!localDate.isBefore(from) && !localDate.isAfter(to)) {
                for (String key : salaries.keySet()) {
                    int totalSalary = salaries.getOrDefault(name,0);
                }
                sb.append(salaries.get(name));
            }

        }
       System.out.println(sb);
        return sb.toString();
    }
}
