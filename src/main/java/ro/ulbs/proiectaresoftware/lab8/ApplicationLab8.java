package ro.ulbs.proiectaresoftware.lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

        citesteSiGenereazaOutput1(inputFile, "laborator8_output.xlsx");
        genereazaOutput2(inputFile, "laborator8_output2.xlsx");
        genereazaOutput3(inputFile, "laborator8_output3.xlsx");
    }

    public static void citesteSiGenereazaOutput1(String inputFile, String outputFile) {
        try (
                FileInputStream inputStream = new FileInputStream(inputFile);
                Workbook workbook = new XSSFWorkbook(inputStream)
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            System.out.println("=== Continut fisier Excel ===");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    afiseazaCelula(cell);
                    System.out.print("\t");
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

    public static void genereazaOutput2(String inputFile, String outputFile) {
        try (
                FileInputStream inputStream = new FileInputStream(inputFile);
                Workbook inputWorkbook = new XSSFWorkbook(inputStream);
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet(inputSheet.getSheetName());

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());

                int lastCellIndex = inputRow.getLastCellNum();

                for (int i = 0; i < lastCellIndex; i++) {
                    Cell inputCell = inputRow.getCell(i);
                    Cell outputCell = outputRow.createCell(i);

                    if (inputCell != null) {
                        copiazaCelula(inputCell, outputCell);
                    }
                }

                Cell mediaCell = outputRow.createCell(lastCellIndex);

                if (inputRow.getRowNum() == 0) {
                    mediaCell.setCellValue("Media");
                } else {
                    double suma = 0;
                    int count = 0;

                    for (int i = lastCellIndex - 3; i < lastCellIndex; i++) {
                        Cell cell = inputRow.getCell(i);

                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                            suma += cell.getNumericCellValue();
                            count++;
                        }
                    }

                    if (count > 0) {
                        mediaCell.setCellValue(suma / count);
                    } else {
                        mediaCell.setCellValue(0);
                    }
                }
            }

            if (inputSheet.getRow(0) != null) {
                int nrColoane = inputSheet.getRow(0).getLastCellNum() + 1;

                for (int i = 0; i < nrColoane; i++) {
                    outputSheet.autoSizeColumn(i);
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                outputWorkbook.write(outputStream);
            }

            System.out.println("Fisierul " + outputFile + " a fost creat.");

        } catch (IOException e) {
            System.out.println("Eroare la generarea fisierului " + outputFile);
            e.printStackTrace();
        }
    }
    public static void genereazaOutput3(String inputFile, String outputFile) {
        try (
                FileInputStream inputStream = new FileInputStream(inputFile);
                Workbook inputWorkbook = new XSSFWorkbook(inputStream);
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet(inputSheet.getSheetName());

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());

                int lastCellIndex = inputRow.getLastCellNum();

                for (int i = 0; i < lastCellIndex; i++) {
                    Cell inputCell = inputRow.getCell(i);
                    Cell outputCell = outputRow.createCell(i);

                    if (inputCell != null) {
                        copiazaCelula(inputCell, outputCell);
                    }
                }

                Cell mediaCell = outputRow.createCell(lastCellIndex);

                if (inputRow.getRowNum() == 0) {
                    mediaCell.setCellValue("Media formula");
                } else {
                    int excelRowNumber = inputRow.getRowNum() + 1;
                    mediaCell.setCellFormula("AVERAGE(D" + excelRowNumber + ":F" + excelRowNumber + ")");
                }
            }

            if (inputSheet.getRow(0) != null) {
                int nrColoane = inputSheet.getRow(0).getLastCellNum() + 1;

                for (int i = 0; i < nrColoane; i++) {
                    outputSheet.autoSizeColumn(i);
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                outputWorkbook.write(outputStream);
            }

            System.out.println("Fisierul " + outputFile + " a fost creat.");

        } catch (IOException e) {
            System.out.println("Eroare la generarea fisierului " + outputFile);
            e.printStackTrace();
        }
    }


    private static void afiseazaCelula(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue());
                break;

            case NUMERIC:
                System.out.print(cell.getNumericCellValue());
                break;

            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;

            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;

            default:
                System.out.print(" ");
                break;
        }
    }

    private static void copiazaCelula(Cell inputCell, Cell outputCell) {
        switch (inputCell.getCellType()) {
            case STRING:
                outputCell.setCellValue(inputCell.getStringCellValue());
                break;

            case NUMERIC:
                outputCell.setCellValue(inputCell.getNumericCellValue());
                break;

            case BOOLEAN:
                outputCell.setCellValue(inputCell.getBooleanCellValue());
                break;

            case FORMULA:
                outputCell.setCellFormula(inputCell.getCellFormula());
                break;

            default:
                outputCell.setBlank();
                break;
        }
    }
}