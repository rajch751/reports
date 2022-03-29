package com.repots.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class FirstReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//InputStream inputStream =FirstReport.class.getResourceAsStream("/file.txt");
			String filePath = "C:\\Users\\rajch\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\reports\\src\\main\\resources\\FirstReport.jrxml";

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("studentName", "John");

			Student student1 = new Student(1L, "Raj", "Joshi", "Happy Street", "Delhi");

			Student student2 = new Student(1L, "Peter", "Smith", "Any Street", "Mumbai");
			
			Student student3 = new Student(1L, "Raj", "Joshi", "Happy Street", "Delhi");

			Student student4 = new Student(1L, "Peter", "Smith", "Any Street", "Mumbai");

			Student student5 = new Student(1L, "Raj", "Joshi", "Happy Street", "Delhi");

			Student student6 = new Student(1L, "Peter", "Smith", "Any Street", "Mumbai");


			List<Student> list = new ArrayList<Student>();
			list.add(student1);
			list.add(student2);
			list.add(student3);
			list.add(student4);
			list.add(student5);
			list.add(student6);

			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
			JasperReport report = JasperCompileManager.compileReport(filePath);

			JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

			JasperExportManager.exportReportToPdfFile(print,
					"C:\\Users\\rajch\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\reports\\src\\main\\resources\\FirstReport.pdf");

			System.out.println("Report Created...");
			
		//	JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

			JasperExportManager.exportReportToHtmlFile(print,
					"C:\\Users\\rajch\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\reports\\src\\main\\resources\\FirstReport.html");

			System.out.println("Report Created html...");
			
			
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(new File("C:\\\\Users\\\\rajch\\\\Documents\\\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\\\reports\\\\src\\\\main\\\\resources\\\\FirstReport.xlsx"))));


		} catch (Exception e) {
			System.out.println("Exception while creating report");
		}
	}

}
