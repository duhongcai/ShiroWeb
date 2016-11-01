package com.dhc.utils.excle;

import com.dhc.dto.ColumnBean;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by DuHongcai on 2016/10/31.
 */
public class ExportUtil {

    /**
     * @param request     请求参数
     * @param response    返回参数
     * @param fileName    文件名--sheet名字
     * @param tableHeader 表头数据
     * @param tableBody   表体数据
     * @return 输出Excle
     * @author dhc
     */
    public static SXSSFWorkbook disposeExportExcle(HttpServletRequest request, HttpServletResponse response, String fileName,
                                                   List<ColumnBean> tableHeader, Collection<?> tableBody) throws InvocationTargetException, IllegalAccessException {
        /**
         * 1：对比tableHeader和tableBody
         * 2：生成一个sheet
         * 3：根据tableHeader生成表头
         * 4：根据tableBody生成表体内容
         * 5：输出Excle表格
         */
        SXSSFWorkbook workbook = null;
        if (tableHeader == null || tableHeader.size() == 0) throw new RuntimeException("读取表头字段失败");
        workbook = new SXSSFWorkbook(10000);
        Sheet sheet = workbook.createSheet(fileName == null ? "" : fileName);
        Map<String, CellStyle> cellStyleMap = new HashMap<String, CellStyle>();
        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex);
        headerRow.setHeight((short) 450);
        CellStyle titleStyle = getTitleStyle(workbook);
        // 表头
        for (int i = 0; i < tableHeader.size(); i++) {
            ColumnBean bean = tableHeader.get(i);
            Cell cell = headerRow.createCell(i);
            cell.setCellStyle(titleStyle);
            sheet.setColumnWidth(i, 30 * bean.getWidth());
            cellStyleMap.put(bean.getFiled(), getCellStyle(workbook, bean));

        }
        //表体
        Object curObj = null;
        Object value = null;
        Method method = null;
        Method[] methods = null;
        Iterator<?> itData = tableBody.iterator();
        while (itData.hasNext()) {
            rowIndex++;
            Row row = sheet.createRow(rowIndex);
            curObj = itData.next();
            methods = curObj.getClass().getMethods();
            for (int i = 0; i < tableHeader.size(); i++) {
                ColumnBean bean = tableHeader.get(i);
                String field = bean.getFiled();
                for (int fmidx = methods.length - 1; fmidx >= 0; fmidx--) {
                    if (("get" + field).equalsIgnoreCase(methods[fmidx].getName())) {
                        method = methods[fmidx];
                        value = method.invoke(curObj);
                        break;
                    }
                }
                Cell cell = row.createCell(i);
                cell.setCellStyle(cellStyleMap.get(field));

                String fileType = bean.getFieldType();

                if (fileType.equalsIgnoreCase("String")) {
                    cell.setCellValue(value == null ? "" : String.valueOf(value));
                } else if (fileType.equalsIgnoreCase("Double")) {
                    cell.setCellValue(value == null ? "" : String.valueOf(value));
                } else if (fileType.equalsIgnoreCase("Long")) {
                    cell.setCellValue(value == null ? "" : String.valueOf(value));
                } else if (fileType.equalsIgnoreCase("Integer")) {
                    cell.setCellValue(value == null ? "" : String.valueOf(value));
                }
            }
        }
        return workbook;
    }

    private static CellStyle getTitleStyle(SXSSFWorkbook workbook) {
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        titleStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        titleStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        return titleStyle;
    }

    private static CellStyle getCellStyle(SXSSFWorkbook workbook, ColumnBean bean) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderLeft((short) 1);
        cellStyle.setBorderRight((short) 1);
        cellStyle.setBorderBottom((short) 1);
        cellStyle.setBorderTop((short) 1);
        String align = bean.getAlign();
        if ("left".equalsIgnoreCase(align)) cellStyle.setAlignment(XSSFCellStyle.ALIGN_FILL);
        else if ("center".equalsIgnoreCase(align)) cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        else if ("right".equalsIgnoreCase(align)) cellStyle.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        else {
            cellStyle.setAlignment(XSSFCellStyle.VERTICAL_CENTER);
        }
        return cellStyle;
    }
}
