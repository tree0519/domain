package com.liu.domain.utils.easyExcelPage;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.liu.domain.listener.ExcelListener;
import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author liuxinghong
 * @Description: easyexcel工具类
 * @date 2018/11/5/00514:00
 */
public class EasyExcelUtils {

    /**
     * 导出根据实体模板
     *
     * @param response
     * @param list
     * @param name
     * @param clazz
     */
    public static void generateExcel(HttpServletResponse response, List<? extends BaseRowModel> list, String name, Class<? extends BaseRowModel> clazz) {
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        try {

            String fileName = new String((name + "" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString())
                    .getBytes(), "UTF-8");
            Sheet sheet1 = new Sheet(1, 0, clazz);
            sheet1.setSheetName("第一个sheet");
            //writer.write0(list, sheet1);
            writer.write(list, sheet1);
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.finish();
            try {
                out.close();
            } catch (IOException e) {
               // e.printStackTrace();
            }
        }
    }

    /**
     * 读取 Excel(多个 sheet)
     *
     * @param excel  文件
     * @param clazz 实体类映射，继承 BaseRowModel 类
     * @return Excel 数据 list
     */
    public static List<List<String>> readExcel(MultipartFile excel,Class<? extends BaseRowModel> clazz) {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        for (Sheet sheet : reader.getSheets()) {
            if (clazz != null) {
                sheet.setClazz(clazz);
            }
            reader.read(sheet);
        }
        return excelListener.getDatas();
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel   文件
     * @param clazz  实体类映射，继承 BaseRowModel 类
     * @param sheetNo sheet 的序号
     *                当前版本中：
     *                XLS 类型文件 sheet 序号为顺序，第一个 sheet 序号为 1
     *                XLSX 类型 sheet 序号顺序为倒序，即最后一个 sheet 序号为 1
     * @return Excel 数据 list
     */
    public static List<List<String>> readExcel(MultipartFile excel, Class<? extends BaseRowModel> clazz, int sheetNo) {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        Sheet sheet = new Sheet(sheetNo);
        sheet.setClazz(clazz);
        reader.read(sheet);
        return excelListener.getDatas();
    }

    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param clazz    映射实体类，Excel 模型
     */
    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                  String fileName, String sheetName, Class<? extends BaseRowModel> clazz) throws IOException {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        if (!dbfFile.exists() || dbfFile.isDirectory()) {
            dbfFile.createNewFile();
        }
        fileName = new String(filePath.getBytes(), "ISO-8859-1");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        OutputStream out = response.getOutputStream();
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);
            Sheet sheet = new Sheet(1, 0, clazz);
            sheet.setSheetName(sheetName);
            writer.write(list, sheet);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }

    /**
     * 导出 Excel ：多个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param clazz    映射实体类，Excel 模型
     */
    public static ExcelWriterFactroy writeExcelWithSheets(HttpServletResponse response, List<? extends BaseRowModel> list,
                                                          String fileName, String sheetName, Class<? extends BaseRowModel> clazz) throws IOException {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        if (!dbfFile.exists() || dbfFile.isDirectory()) {
            dbfFile.createNewFile();
        }
        fileName = new String(filePath.getBytes(), "ISO-8859-1");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        OutputStream out = response.getOutputStream();
        ExcelWriterFactroy writer = new ExcelWriterFactroy(out, ExcelTypeEnum.XLSX
        );
        try {
            Sheet sheet = new Sheet(1, 0,clazz);
            sheet.setSheetName(sheetName);
            writer.write(list, sheet);
            return writer;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                out.close();
            } catch (IOException ex) {
               // ex.printStackTrace();
            }
        }
        return writer;
    }

    /**
     * 返回 ExcelReader
     *
     * @param excel         需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     */
    public static ExcelReader getReader(MultipartFile excel,
                                        ExcelListener excelListener) {
        String filename = excel.getOriginalFilename();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            throw new RuntimeException("文件格式错误！");
        }
        ExcelTypeEnum excelTypeEnum = ExcelTypeEnum.XLSX;
        if (filename.toLowerCase().endsWith(".xls")) {
            excelTypeEnum = ExcelTypeEnum.XLS;
        }
        InputStream inputStream;
        try {
            inputStream = excel.getInputStream();
            return new ExcelReader(inputStream, excelTypeEnum,
                    null, excelListener);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param in            文件输入流
     * @param customContent 自定义模型可以在
     *                      {@link AnalysisEventListener#invoke(Object, AnalysisContext) }
     *                      AnalysisContext中获取用于监听者回调使用
     * @param eventListener 用户监听
     * @throws IOException
     * @throws EmptyFileException
     * @throws InvalidFormatException
     */
    public static ExcelReader getExcelReader(InputStream in, Object customContent,
                                             AnalysisEventListener<?> eventListener) throws Exception {
        // 如果输入流不支持mark/reset，需要对其进行包裹
        if (!in.markSupported()) {
            in = new PushbackInputStream(in, 8);
        }

        // 确保至少有一些数据
        byte[] header8 = IOUtils.peekFirst8Bytes(in);
        ExcelTypeEnum excelTypeEnum = null;
        if (NPOIFSFileSystem.hasPOIFSHeader(header8)) {
            excelTypeEnum = ExcelTypeEnum.XLS;
        }
        if (DocumentFactoryHelper.hasOOXMLHeader(in)) {
            excelTypeEnum = ExcelTypeEnum.XLSX;
        }
        if (excelTypeEnum != null) {
            return new ExcelReader(in, excelTypeEnum, customContent, eventListener);
        }
        throw new InvalidFormatException("文件流读取错误！");

    }

    /**
     * @param in            文件输入流
     * @param customContent 自定义模型可以在
     *                      {@link AnalysisEventListener#invoke(Object, AnalysisContext) }
     *                      AnalysisContext中获取用于监听者回调使用
     * @param eventListener 用户监听
     * @param trim          是否对解析的String做trim()默认true,用于防止 excel中空格引起的装换报错。
     * @throws IOException
     * @throws EmptyFileException
     * @throws InvalidFormatException
     */
    public static ExcelReader getExcelReader(InputStream in, Object customContent,
                                             AnalysisEventListener<?> eventListener, boolean trim)
            throws EmptyFileException, IOException, InvalidFormatException {
        // 如果输入流不支持mark/reset，需要对其进行包裹
        if (!in.markSupported()) {
            in = new PushbackInputStream(in, 8);
        }
        // 确保至少有一些数据
        byte[] header8 = IOUtils.peekFirst8Bytes(in);
        ExcelTypeEnum excelTypeEnum = null;
        if (NPOIFSFileSystem.hasPOIFSHeader(header8)) {
            excelTypeEnum = ExcelTypeEnum.XLS;
        }
        if (DocumentFactoryHelper.hasOOXMLHeader(in)) {
            excelTypeEnum = ExcelTypeEnum.XLSX;
        }
        if (excelTypeEnum != null) {
            return new ExcelReader(in, excelTypeEnum, customContent, eventListener, trim);
        }
        throw new InvalidFormatException("文件流读取错误！");
    }



}
