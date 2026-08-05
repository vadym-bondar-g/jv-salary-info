package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate from = LocalDate.parse(dateFrom, formatter);
        LocalDate to = LocalDate.parse(dateTo, formatter);
        for (String dataName : data) {
            dataName = dataName.trim();


        }
        StringBuilder sb = new StringBuilder();
        sb.append("Report for period "+dateFrom+" - "+dateTo+"\n");
        sb.append("Total salary for "+data[0]+"\n");

        return sb.toString();
    }
}
