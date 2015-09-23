package com.programmingfree.connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.programmingfree.springservice.domain.Person;
import com.programmingfree.springservice.domain.PodsAddress;

public class SpringDataMongoDBMain {

	public static final String DB_NAME = "pvamu";
	public static final String PERSON_COLLECTION = "users";
	public static final String ADDERESS_COLLECTION = "address";
	public static final String MONGO_HOST = "ds041643.mongolab.com";
	public static final int MONGO_PORT = 41643;

	public static void main(String[] args) throws Exception {
		MongoClientURI uri = new MongoClientURI("mongodb://root:admin@ds041643.mongolab.com:41643/?authSource=pvamu");
		
		MongoClient mongo = new MongoClient(uri);
		MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
		Person p = new Person("113", "PankajKr", "Bangalore, India");
		mongoOps.insert(p, PERSON_COLLECTION);

		Person p1 = mongoOps.findOne(
				new Query(Criteria.where("name").is("PankajKr")),
				Person.class, PERSON_COLLECTION);
		
		mongoOps.insert(fileReader(), ADDERESS_COLLECTION);
		//fileReader();
		
		System.out.println(p1);
		
		//mongoOps.dropCollection(PERSON_COLLECTION);
		mongo.close();
	}

	


	
	public  static List<PodsAddress> fileReader(){
	
		List<PodsAddress>  list_add = new ArrayList<PodsAddress>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\murugraj\\Desktop\\dataFeed.txt")))
		{

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] addLine = sCurrentLine.split(",");
				PodsAddress adderssLine = new PodsAddress();
				adderssLine.setRawaddr_id(addLine[0]);
				adderssLine.setRawaddr_hash_ky(addLine[1]);
				adderssLine.setLocation_nm(addLine[2]);
				adderssLine.setLocation_addr1_tx(addLine[3]);
				adderssLine.setLocation_addr2_tx(addLine[4]);
				adderssLine.setLocation_city_nm(addLine[5]);
				adderssLine.setLocation_state_cd(addLine[6]);
				adderssLine.setLocation_zip_cd(addLine[7]);
				adderssLine.setLocation_country_cd(addLine[8]);
				adderssLine.setLocation_state_cd(addLine[9]);
				//add.setRawaddr_id(addLine[10]);
				//add.setRawaddr_id(addLine[11]);
				list_add.add(adderssLine);
//				System.out.println("");
//				System.out.print(addLine[0] );
//				System.out.print(addLine[1] );
//				System.out.print(addLine[2] );
//				System.out.print(addLine[3] );
//				System.out.print(addLine[4] );
//				System.out.print(addLine[5] );
//				System.out.print(addLine[6] );
//				System.out.print(addLine[7] );
//				System.out.print(addLine[8] );
//				System.out.print(addLine[9] );
//				System.out.print(addLine[10] );
				//if(addLine.length > 11)
				//System.out.print(addLine[11] );
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 

		return list_add;
	   
	}
	
	
	
//	 private static List getStudentsListFromExcel() {
//	        List studentList = new ArrayList();
//	        FileInputStream fis = null;
//	        try {
//	            fis = new FileInputStream(FILE_PATH);
//
//	            // Using XSSF for xlsx format, for xls use HSSF
//	            Workbook workbook = new XSSFWorkbook(fis);
//
//	            int numberOfSheets = workbook.getNumberOfSheets();
//
//	            //looping over each workbook sheet
//	            for (int i = 0; i < numberOfSheets; i++) {
//	                Sheet sheet = workbook.getSheetAt(i);
//	                Iterator rowIterator = sheet.iterator();
//
//	                //iterating over each row
//	                while (rowIterator.hasNext()) {
//
//	                    Student student = new Student();
//	                    Row row = rowIterator.next();
//	                    Iterator cellIterator = row.cellIterator();
//
//	                    //Iterating over each cell (column wise)  in a particular row.
//	                    while (cellIterator.hasNext()) {
//
//	                        Cell cell = cellIterator.next();
//	                        //The Cell Containing String will is name.
//	                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
//	                            student.setName(cell.getStringCellValue());
//
//	                            //The Cell Containing numeric value will contain marks
//	                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
//
//	                            //Cell with index 1 contains marks in Maths
//	                            if (cell.getColumnIndex() == 1) {
//	                                student.setMaths(String.valueOf(cell.getNumericCellValue()));
//	                            }
//	                            //Cell with index 2 contains marks in Science
//	                            else if (cell.getColumnIndex() == 2) {
//	                                student.setScience(String.valueOf(cell.getNumericCellValue()));
//	                            }
//	                            //Cell with index 3 contains marks in English
//	                            else if (cell.getColumnIndex() == 3) {
//	                                student.setEnglish(String.valueOf(cell.getNumericCellValue()));
//	                            }
//	                        }
//	                    }
//	                    //end iterating a row, add all the elements of a row in list
//	                    studentList.add(student);
//	                }
//	            }
//
//	            fis.close();
//
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        return studentList;
//	    }
	
}
