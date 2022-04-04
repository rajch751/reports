package com.repots.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class OCOEReportDBConnection {
	
	
	public static void main(String[] args) throws JRException, FileNotFoundException {
		// TODO Auto-generated method stub

		String fileNameJrxml = "C:\\Users\\rajch\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\reports\\src\\main\\resources\\OCOEReportDB.jrxml";
		String hostName = "localhost";
        String dbName = "springboot";
        String userName = "OCOE_DB";
        String password = "ocoe";
        
        //Jasper file location
      //  String fileNameJrxml = "E:/Jasper/jasperv1.jrxml";
        String fileNamePdf = "C:\\\\Users\\\\rajch\\\\Documents\\\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\\\reports\\\\src\\\\main\\\\resources\\\\OCOEReportDB.pdf";
 
        try {
        	Map<String, Object> parameters = new HashMap<String, Object>();
    		parameters.put("startdate", "02/02/2022");
    		parameters.put("enddate", "03/03/2022");
    		parameters.put("exercisecode", "02-02-2022-2-3)");
        	//JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
    		JasperReport report = JasperCompileManager.compileReport(fileNameJrxml);
            //Getting a connection instance
            Connection connInstance = getDbaseConnection(hostName,dbName,userName,password);                   
            System.out.println("Loading the .JRMXML file ....");
          //  JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
            System.out.println("Compiling the .JRMXML file to .JASPER file....");
          //  JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            System.out.println("filling parameters to .JASPER file....");
            JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(report, parameters,connInstance);
            System.out.println("exporting the JASPER file to PDF file....");
            JasperExportManager.exportReportToPdfFile(jprint, fileNamePdf);
            System.out.println("Successfully completed the export");

        } catch (Exception e) {
            System.out.print("Exception:" + e);
        }

		
	}
	
	
	
	 public static Connection getDbaseConnection(String HOST_NAME, String DBASE_NAME,
		        String USER_NAME, String USR_PASS) throws SQLException,
		        ClassNotFoundException {
		        Class.forName("oracle.jdbc.driver.OracleDriver");
		        //String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		        String CNTION_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		        Connection conn = DriverManager.getConnection(CNTION_URL, USER_NAME,USR_PASS);
		        return conn;
		    }

}
