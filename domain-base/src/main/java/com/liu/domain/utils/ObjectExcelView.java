package com.liu.domain.utils;

/**
* 导入到EXCEL
* 类名称：ObjectExcelView.java
* 类描述： 
* @author FH
* 作者单位： 
* 联系方式：
* @version 1.0
 */
//public class ObjectExcelView extends AbstractExcelView{
//
//	@Override
//	protected void buildExcelDocument(Map<String, Object> model,
//			HSSFWorkbook workbook, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		Date date = new Date();
//		String filename = date.getTime()+"";
//		HSSFSheet sheet;
//		HSSFCell cell;
//		response.setContentType("application/octet-stream");
//		response.setHeader("Content-Disposition", "attachment;filename="+filename+".xls");
//		sheet = workbook.createSheet("sheet1");
//
//		List<String> titles = (List<String>) model.get("titles");
//		int len = titles.size();
//		HSSFCellStyle headerStyle = workbook.createCellStyle(); //标题样式
//		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//		HSSFFont headerFont = workbook.createFont();	//标题字体
//		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		headerFont.setFontHeightInPoints((short)11);
//		headerStyle.setFont(headerFont);
//		short width = 20,height=25*20;
//		sheet.setDefaultColumnWidth(width);
//		for(int i=0; i<len; i++){ //设置标题
//			String title = titles.get(i);
//			cell = getCell(sheet, 0, i);
//			cell.setCellStyle(headerStyle);
//			setText(cell,title);
//		}
//		sheet.getRow(0).setHeight(height);
//
//		HSSFCellStyle contentStyle = workbook.createCellStyle(); //内容样式
//		contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		List<Map<String,String>> varList = (List<Map<String,String>>) model.get("varList");
//		int varCount = varList.size();
//		for(int i=0; i<varCount; i++){
//			Map<String,String> vpd = varList.get(i);
//			for(int j=0;j<len;j++){
//				String varstr = vpd.get("var"+(j+1)).toString() != null ? vpd.get("var"+(j+1)).toString() : "";
//				cell = getCell(sheet, i+1, j);
//				cell.setCellStyle(contentStyle);
//				setText(cell,varstr);
//			}
//
//		}
//
//	}

//}
