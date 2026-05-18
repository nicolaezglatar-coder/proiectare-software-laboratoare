package ro.ulbs.proiectaresoftware.lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApplicationLab8 {
    public static void main(String[] args) {
        String inputFile = "laborator8_input.xlsx";
        String outputFile = "laborator8_output.xlsx";

        try (
                FileInputStream inputStream = new FileInputStream(inputFile);
                Workbook workbook = new XSSFWorkbook(inputStream)
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            System.out.println("=== Continut fisier Excel ===");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;

                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;

                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;

                        default:
                            System.out.print(" \t");
                            break;
                    }
                }
                System.out.println();
            }

            Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);
            newRow.createCell(0).setCellValue("Rand adaugat din Java");
            newRow.createCell(1).setCellValue(100);
            newRow.createCell(2).setCellValue(true);

            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                workbook.write(outputStream);
            }

            System.out.println();
            System.out.println("Fisierul " + outputFile + " a fost creat.");

        } catch (IOException e) {
            System.out.println("Eroare la citirea/scrierea fisierului Excel.");
            e.printStackTrace();
        }
    }
}