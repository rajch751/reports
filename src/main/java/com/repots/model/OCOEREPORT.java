package com.repots.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

public class OCOEREPORT {

	public static void main(String[] args) throws JRException, FileNotFoundException {
		// TODO Auto-generated method stub

		String filePath = "C:\\Users\\rajch\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\reports\\src\\main\\resources\\OCOEReport1.jrxml";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("startdate", "02/02/2022");
		parameters.put("enddate", "03/03/2022");
		parameters.put("exercisecode", "02-02-2022-2-3)");
		
		ToCOeExcercise toCOeExcercise=new ToCOeExcercise("1","individual","submission","80","80","80");
		ToCOeExcercise toCOeExcercise1=new ToCOeExcercise("2","individual","Revison","80.00","80.00","80");
		ToCOeExcercise toCOeExcercise2=new ToCOeExcercise("3","individual","Fee Charge","80","80","80");
		ToCOeExcercise toCOeExcercis3=new ToCOeExcercise("4","Co-orpoarate","Revison","80","80","80");
		ToCOeExcercise toCOeExcercise4=new ToCOeExcercise("5","Co-orpoarate","Fee Charge","80","80","80");
		List<ToCOeExcercise> list = new ArrayList<ToCOeExcercise>();
		list.add(toCOeExcercise);
		list.add(toCOeExcercise1);
		list.add(toCOeExcercise2);
		list.add(toCOeExcercis3);
		list.add(toCOeExcercise4);
		

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperReport report = JasperCompileManager.compileReport(filePath);

		JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

		JasperExportManager.exportReportToPdfFile(print,
				"C:\\Users\\rajch\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\reports\\src\\main\\resources\\OCOEREPORTCOLLECTIONAFTERDBCALL.pdf");

		System.out.println("Report Created...");

		// JasperPrint print = JasperFillManager.fillReport(report, parameters,
		// dataSource);

		JasperExportManager.exportReportToHtmlFile(print,
				"C:\\Users\\rajch\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\reports\\src\\main\\resources\\OCOEREPORTCOLLECTIONAFTERDBCALL.html");

		System.out.println("Report Created html...");

		/*
		 * JRXlsxExporter exporter1 = new JRXlsxExporter();
		 * exporter1.setExporterInput(new SimpleExporterInput(print));
		 * exporter1.setExporterOutput(new SimpleOutputStreamExporterOutput(new
		 * FileOutputStream(new File(
		 * "C:\\\\Users\\\\rajch\\\\Documents\\\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\\\reports\\\\src\\\\main\\\\resources\\\\OCOEREPORTCOLLECTIONAFTERDBCALL.xlsx"
		 * ))));
		 */
		JRTextExporter exporter = new JRTextExporter();
		exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 110);
	    exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
	    exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
	    exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\\\\\\\Users\\\\\\\\rajch\\\\\\\\Documents\\\\\\\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\\\\\\\reports\\\\\\\\src\\\\\\\\main\\\\\\\\resources\\\\\\\\OCOEREPORTCOLLECTIONAFTERDBCALL.txt");
	    exporter.exportReport();
		// exporter.setExporterInput(new SimpleExporterInput(print));
		// exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new
		// FileOutputStream(new
		// File("C:\\\\Users\\\\rajch\\\\Documents\\\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\\\reports\\\\src\\\\main\\\\resources\\\\OCOEREPORTCOLLECTIONAFTERDBCALL.txt"))));

	}

}
