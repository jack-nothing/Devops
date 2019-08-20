package com.kechun.util.excle;

import com.kechun.conf.Contants;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Excel工具类
 */
public class ExcelUtils {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static ExcelUtils eu = new ExcelUtils();

    private ExcelUtils() {
    }

    public static ExcelUtils getInstance() {
        return eu;
    }

    /**
     * 获得path的后缀名
     *
     * @param path
     * @return
     */
    public static String getPostfix(String path) {
        if (path == null || Contants.EMPTY.equals(path.trim())) {
            return Contants.EMPTY;
        }
        if (path.contains(Contants.POINT)) {
            return path.substring(path.lastIndexOf(Contants.POINT) + 1, path.length());
        }
        return Contants.EMPTY;
    }

    /**
     * 单元格格式
     *
     * @param hssfCell
     * @return
     */
    @SuppressWarnings("static-access")
    public static String getHValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            String cellValue = "";
            if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {
                Date date = HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue());
                cellValue = sdf.format(date);
            } else {
                DecimalFormat df = new DecimalFormat("#.##");
                cellValue = df.format(hssfCell.getNumericCellValue());
                String strArr = cellValue.substring(cellValue.lastIndexOf(Contants.POINT) + 1, cellValue.length());
                if (strArr.equals("00")) {
                    cellValue = cellValue.substring(0, cellValue.lastIndexOf(Contants.POINT));
                }
            }
            return cellValue;
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    /**
     * 单元格格式
     *
     * @param xssfCell
     * @return
     */
    public static String getXValue(XSSFCell xssfCell) {
        if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            String cellValue = "";
            if (XSSFDateUtils.isCellDateFormatted(xssfCell)) {
                Date date = XSSFDateUtils.getJavaDate(xssfCell.getNumericCellValue());
                cellValue = sdf.format(date);
            } else {
                DecimalFormat df = new DecimalFormat("#.##");
                cellValue = df.format(xssfCell.getNumericCellValue());
                String strArr = cellValue.substring(cellValue.lastIndexOf(Contants.POINT) + 1, cellValue.length());
                if (strArr.equals("00")) {
                    cellValue = cellValue.substring(0, cellValue.lastIndexOf(Contants.POINT));
                }
            }
            return cellValue;
        } else {
            xssfCell.setCellType(Cell.CELL_TYPE_STRING);
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }


    private String getCellValue(Cell c) {
        String o = null;
        switch (c.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                o = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                o = String.valueOf(c.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                o = String.valueOf(c.getCellFormula());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                o = String.valueOf(c.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                o = c.getStringCellValue();
                break;
            default:
                o = null;
                break;
        }
        return o;
    }



    public static void printExcel(File file) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int rowcount1 = sheet.getPhysicalNumberOfRows();
        System.out.println(rowcount1);
        System.out.println("该excle的总行数为：" + (rowcount + 1) + "行 ！");

        for (int i = 0; i < rowcount + 1; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    XSSFCell cell = (XSSFCell) row.getCell(j);
                    if (cell != null) {
                        ExcelUtils.checkRowCell(cell, i, j);
                    }
                }
            }
        }
    }

    public static void checkRowCell(XSSFCell cell, int i, int j) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                System.out.println(cell.getRichStringCellValue().getString() + "=" + i + ":" + j);
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.println(String.valueOf(cell.getDateCellValue()) + "=" + i + ":" + j);
                } else {
                    System.out.println(cell.getNumericCellValue() + "=" + i + ":" + j);
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.println(cell.getBooleanCellValue() + "=" + i + ":" + j);
                break;
            default:
        }
    }

    /**
     * 写入excel模板，对单个sheet页
     *
     * @param
     * @return
     * @author gl
     * @date 2018/6/14/014
     */
    public static Workbook writeExcelBySingletSheet(String templatePath, ExcelNode excelNode) {
        String end = templatePath.substring(templatePath.lastIndexOf("."), templatePath.length());
        if (end.equalsIgnoreCase("xls")) {
            return writeToExcelBySingletSheetEndXls(templatePath, excelNode);
        } else {
            return writeToExcelBySingletSheetEndXlsx(templatePath, excelNode);
        }
    }

    /**
     * 写入excel模板，对多个sheet页
     *
     * @param
     * @return
     * @author gl
     * @date 2018/6/14/014
     */
    public static Workbook writeExcelByMoreSheet(String templatePath, ExcelNode excelNode) {
        String end = templatePath.substring(templatePath.lastIndexOf("."), templatePath.length());
        if (end.equalsIgnoreCase("xls")) {
            return writeToExcelByMoreSheetEndXls(templatePath, excelNode);
        } else {
            return writeToExcelByMoreSheetEndXlsx(templatePath, excelNode);
        }
    }

    public static XSSFWorkbook writeToExcelByMoreSheetEndXlsx(File file, ExcelNode excelNode) {
        try {
            InputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            excelNode.getSetSheets().forEach((k, v) -> {
                XSSFSheet sheet = workbook.getSheetAt(k);
                System.out.println(sheet.getSheetName());
                v.forEach((k1, v1) -> {
                    XSSFRow row = sheet.getRow(k1);
                    v1.forEach((k2, v2) -> {
                        row.getCell(k2).setCellValue(v2);
                    });
                });
            });
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 写入excel模板，对单个sheet页写入,主要在使用之前一定要，使用printExcel方法，（在最下面）
     * 检查一下你要替换的内容在那个部位;该方法只能用于 .xlsx 结尾的
     *
     * @param templatePath:是文件模板路径，excelNode 数据对象
     */
    public static XSSFWorkbook writeToExcelBySingletSheetEndXlsx(String templatePath, ExcelNode excelNode) {
        try {
            InputStream in = new FileInputStream(new File(templatePath));
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(excelNode.getSheet());
            excelNode.getValue().forEach((k, v) -> {
                XSSFRow row = sheet.getRow(k);
                v.forEach((k1, v1) -> {
                    row.getCell(k1).setCellValue(v1);
                });
            });
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入excel模板，对多个sheet页写入,该方法只能用于 .xlsx 结尾的
     *
     * @param
     * @return
     * @author gl
     * @date 2018/6/14/014
     */
    public static XSSFWorkbook writeToExcelByMoreSheetEndXlsx(String templatePath, ExcelNode excelNode) {
        try {
            InputStream in = new FileInputStream(new File(templatePath));
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            excelNode.getSetSheets().forEach((k, v) -> {
                XSSFSheet sheet = workbook.getSheetAt(k);
                v.forEach((k1, v1) -> {
                    XSSFRow row = sheet.getRow(k1);
                    v1.forEach((k2, v2) -> {
                        row.getCell(k2).setCellValue(v2);
                    });
                });
            });
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 该方法只能用于 .xls 结尾的
     *
     * @param templatePath:是文件模板路径，excelNode 数据对象
     * @return
     * @author gl
     * @date 2018/6/14/014
     */
    public static HSSFWorkbook writeToExcelBySingletSheetEndXls(String templatePath, ExcelNode excelNode) {
        try {
            InputStream in = new FileInputStream(new File(templatePath));
            HSSFWorkbook workbook = new HSSFWorkbook(in);
            HSSFSheet sheet = workbook.getSheetAt(excelNode.getSheet());
            excelNode.getValue().forEach((k, v) -> {
                HSSFRow row = sheet.getRow(k);
                v.forEach((k1, v1) -> {
                    row.getCell(k1).setCellValue(v1);
                });
            });
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入excel模板，对多个sheet页写入,该方法只能用于 .xls 结尾的
     *
     * @param
     * @return
     * @author gl
     * @date 2018/6/14/014
     */
    public static HSSFWorkbook writeToExcelByMoreSheetEndXls(String templatePath, ExcelNode excelNode) {
        try {
            InputStream in = new FileInputStream(new File(templatePath));
            HSSFWorkbook workbook = new HSSFWorkbook(in);
            excelNode.getSetSheets().forEach((k, v) -> {
                HSSFSheet sheet = workbook.getSheetAt(k);
                v.forEach((k1, v1) -> {
                    HSSFRow row = sheet.getRow(k1);
                    v1.forEach((k2, v2) -> {
                        row.getCell(k2).setCellValue(v2);
                    });
                });
            });
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}