package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public class SalaryInfo {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String REPORT = "Report for period ";
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        LocalDate from = LocalDate.parse(dateFrom, formatter);
        LocalDate to = LocalDate.parse(dateTo, formatter);
        LocalDate localDate;
        StringBuilder totalReport = new StringBuilder();
        String[] dataArray;
        Map<String, Integer> salaries = new LinkedHashMap<>();
        for (int i = 0; i < data.length; i++) {
            dataArray = data[i].split(" ");
            int salary = 0;
            salary = Integer.parseInt(dataArray[2]) * Integer.parseInt(dataArray[3]);
            String name = dataArray[1];
            localDate = LocalDate.parse(dataArray[0], formatter);
            if (!localDate.isBefore(from) && !localDate.isAfter(to)) {
                salaries.merge(name, salary, Integer::sum);
            }else  {
                salaries.merge(name, 0, Integer::sum);
            }
        }
        totalReport.append(REPORT).append(dateFrom).append(" - ").append(dateTo).append('\n');
        List<Map.Entry<String, Integer>> sortedSalaries = salaries.entrySet().stream().toList();
        for (int i = 0; i < sortedSalaries.size(); i++) {
            totalReport.append(sortedSalaries.get(i).getKey()).append(" - ")
                    .append(sortedSalaries.get(i).getValue());
            if (sortedSalaries.size() > i + 1) {
                totalReport.append('\n');
            }
        }
        return totalReport.toString();
    }
}
