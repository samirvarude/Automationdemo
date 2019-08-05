package keywordriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class RunManager {
	//To Read Rows from Run Manager File
		public static Row RunManagerRows=null;
		//To Read Rows from DataSheet file
		public static Row DataSheetRow=null;
		//To Read ColumnName from Current Row
		public static Row DataSheetRow_DatqValue=null;
		public static File ReadDataSheet=null;
		public static FileInputStream FIS_DS=null;
		public static FileInputStream RM_FIS=null;
		public static Workbook W_DataSheet=null;
		public static Sheet S_DataSheet=null;
		public static Sheet S_RunManager=null;
		//Set HashMap to enter DataSheet Data
		public static HashMap <String,String> HashMap_DataSheet=null;
		//Result File Variables
		public static Workbook ResultFileTest=null;
		public static FileOutputStream fileOut=null;
		public static Sheet ResultSheet=null;
		public static Row PreResult=null;
		//Global Variables
		public static Cell Result_Status=null;
		public static Cell Resultcomment=null;
		public static Cell HouseNumber1=null;
		public static Cell PostalCode1=null;
		public static Cell Portfolio1=null;
		public static Cell OrderNumber1=null;
		public static Cell OrderStatus1=null;
		public static Cell Agent1=null;
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		//Creating Result File
				Date date = new Date();
				String ResultFile;
				SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
		        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM-dd-yyyy hh-mm-ss");
		        String TodaysDate = dateFormat.format(date);
		        String TodaysDate2 = dateFormat2.format(date);
		        File directory = new File(GeneralSetting.ResultSheet);
		        String path;
		        path = directory.getCanonicalPath();
		        File makeDirectory = new File(path + File.separator + TodaysDate);
		        ResultFile = makeDirectory+"\\Result "+TodaysDate2+".xls";
		        makeDirectory.mkdir();
		        ResultFileTest = new XSSFWorkbook();
		        fileOut = new FileOutputStream(ResultFile);
		        ResultSheet=ResultFileTest.createSheet("ResultSheet");
		        PreResult = ResultSheet.createRow(0);
		        //Set Global Variables
		        Cell FirstRow_TCID = PreResult.createCell(0);
		        FirstRow_TCID.setCellValue("TC ID");
		        Cell FirstRow_Status = PreResult.createCell(1);
		        FirstRow_Status.setCellValue("Status");
		        Cell FirstRow_Comments = PreResult.createCell(2);
		        FirstRow_Comments.setCellValue("Comments");
		        Cell OrderNumber = PreResult.createCell(3);
		        OrderNumber.setCellValue("OrderNumber");
		        Cell PostalCode = PreResult.createCell(4);
		        PostalCode.setCellValue("PostalCode");
		        Cell HouseNumber = PreResult.createCell(5);
		        HouseNumber.setCellValue("HouseNumber");
		        Cell Portfolio = PreResult.createCell(6);
		        Portfolio.setCellValue("Portfolio");
		        Cell OrderStatus = PreResult.createCell(7);
		        OrderStatus.setCellValue("Order Status");
		        Cell Agent = PreResult.createCell(8);
		        Agent.setCellValue("Agent");
		      //End Result File
				//Setting Variables for RunManager Path
				String MyRunManagerFilePath=GeneralSetting.RunManager;
				//Setting Variables for DataSheet Path
				String MyTestDataFilePath=GeneralSetting.Datasheet;
				//Create Object of Function Lib to call Method using Reflection concept
				FuntionalLibrary CallFunction=new FuntionalLibrary();
				//Start to Read Data From Excel Sheetl
				File ReadFileManager=new File(MyRunManagerFilePath);
				ReadDataSheet=new File(MyTestDataFilePath);
				RM_FIS=new FileInputStream(ReadFileManager);
				FIS_DS=new FileInputStream(ReadDataSheet);
				//Create Object of WorkBook
				Workbook W_RunManager=null;
				Workbook W_DataSheet=null;
				//XSSFWorkbook is for xlsx format
				W_RunManager=new XSSFWorkbook(RM_FIS);
				W_DataSheet=new XSSFWorkbook(FIS_DS);
				//Provide name of sheet
				S_RunManager=W_RunManager.getSheet("RunManager");
				S_DataSheet=W_DataSheet.getSheet("TestData");
				//Find Total Number of Row Count in RunManager
				int RowCount_RunManager=S_RunManager.getLastRowNum()-S_RunManager.getFirstRowNum();
				HashMap_DataSheet=new HashMap<String, String>();
				for(int i=0;i<RowCount_RunManager;i++)
				{
					//To Get Total Number of Row
					RunManagerRows=S_RunManager.getRow(i+1);
					DataSheetRow=S_DataSheet.getRow(i+1);
					DataSheetRow_DatqValue=S_DataSheet.getRow(0);
					int ColumnCount=RunManagerRows.getLastCellNum();
					//Now Read RunFlagValue
					Cell RunFlagValue=RunManagerRows.getCell(2);
					//Set TC ID in Result File
					Cell TCID=RunManagerRows.getCell(0);
					String TC_ID_FromRunManager=TCID.getStringCellValue();
					PreResult = ResultSheet.createRow(i+1);
					Cell TC_ID = PreResult.createCell(0);
					TC_ID.setCellValue(TC_ID_FromRunManager);
					//End TC ID Set
					//Set Test Case Status Value in Result File
					
					//End Test Case Status in Result File
					 //Set Comments Field in Result File
					 Result_Status = PreResult.createCell(1);
					 Resultcomment = PreResult.createCell(2);
					 OrderNumber1 = PreResult.createCell(3);
					 PostalCode1 = PreResult.createCell(4);
					 HouseNumber1 = PreResult.createCell(5);
					 Portfolio1 = PreResult.createCell(6);
					 OrderStatus1 = PreResult.createCell(7);
					 Agent1 = PreResult.createCell(8);
					 //Comments Field Setting
					if(RunFlagValue.getStringCellValue().equalsIgnoreCase("Yes"))
					{
						for (int j=3;j<RunManagerRows.getLastCellNum();j++)
						{	
							System.out.println("-----------Test---------------------------------" + j);
							//Get ColumnCount of DataSheet for Yes Row
							int ColumnCount_CurrentRow_DataSheet=DataSheetRow.getLastCellNum();
							for (int m=0;m<ColumnCount_CurrentRow_DataSheet;m++)
							{	
								String ColumnValuesDataSheet="ABC";
								Cell ColumnName=DataSheetRow_DatqValue.getCell(m);
								Cell ColumnValue=DataSheetRow.getCell(m);
								
								if(ColumnValue==null)
								{
									ColumnValuesDataSheet="ABC";
								}
								else
								{
									ColumnValuesDataSheet=ColumnValue.getStringCellValue();
								}

								HashMap_DataSheet.put(ColumnName.getStringCellValue(), ColumnValuesDataSheet);	
							}
							//Get Function Name
							Cell BC_Name=RunManagerRows.getCell(j);
							String FunctionName=BC_Name.getStringCellValue();
							//User Reflection to call BC mentioned in Run Manager
							try {
							Method method=FuntionalLibrary.class.getMethod(FunctionName, null);
							method.invoke(CallFunction,null);
							if  (FuntionalLibrary.Result.matches("Pass"))
							{
								System.out.println("Pass");
							}
							if  (FuntionalLibrary.Result.matches("Failed"))
							{
								System.out.println("Failed");
								break;
								
							}
							}catch(InvocationTargetException IT)
							{
								System.out.println("IT means :-"+IT.getStackTrace());
							}
						}
						System.out.println("----------End---------------------------------");
					}
					if(RunFlagValue.getStringCellValue().equalsIgnoreCase("No"))
					{
						Result_Status.setCellValue("No Run");
					}
						
				}
				ResultFileTest.write(fileOut);
				//Close WorkBook
				W_RunManager.close();
				W_DataSheet.close();
				fileOut.close();

	}

}
