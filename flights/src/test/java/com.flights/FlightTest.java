package test.java.com.flights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RunWith(Parameterized.class)
public class FlightTest {

    private int flightID;
    private String departLocation;
    private String destinationLocation;
    private String departTime;
    private String destinationTime;
    private String departDay;
    private String destinationDay;
    private int numPassengers;

    public FlightTest(int flightID, String departLocation, String destinationLocation, String departTime,
            String destinationTime, String departDay, String destinationDay, int numPassengers) {
        this.flightID = flightID;
        this.departLocation = departLocation;
        this.destinationLocation = destinationLocation;
        this.departTime = departTime;
        this.destinationTime = destinationTime;
        this.departDay = departDay;
        this.destinationDay = destinationDay;
        this.numPassengers = numPassengers;
    }

    @Parameters
    public static List<Object[]> testData() throws IOException {
        List<Object[]> data = new ArrayList<>();

        FileInputStream file = new FileInputStream("path/to/your/excel/file.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // Skip header row
            }

            int flightID = (int) row.getCell(0).getNumericCellValue();
            String departLocation = row.getCell(1).getStringCellValue();
            String destinationLocation = row.getCell(2).getStringCellValue();
            String departTime = row.getCell(3).getStringCellValue();
            String destinationTime = row.getCell(4).getStringCellValue();
            String departDay = row.getCell(5).getStringCellValue();
            String destinationDay = row.getCell(6).getStringCellValue();
            int numPassengers = (int) row.getCell(7).getNumericCellValue();

            Object[] rowData = { flightID, departLocation, destinationLocation, departTime, destinationTime,
                    departDay, destinationDay, numPassengers };
            data.add(rowData);
        }

        workbook.close();
        file.close();

        return data;
    }

    @Test
    public void testFlight() {
        // Your test logic here
        // Use the test data fields (flightID, departLocation, etc.) to create test
        // cases
    }
}
