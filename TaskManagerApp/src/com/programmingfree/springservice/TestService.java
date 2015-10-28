package com.programmingfree.springservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.programmingfree.springservice.domain.TestHelper;

public class TestService {
	
	public List<TestHelper> getValues(){
	
		List<TestHelper> testHelpers = new ArrayList<TestHelper>();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Random r = new Random();
		int Low = 200;
		int High = 1000;
		for(int i =1 ; i <= 12 ; i++){			
			
			int R = r.nextInt(High-Low) + Low;
			int S = r.nextInt(High-Low) + Low;
			try {
							
				Date startDate = formatter.parse(i+"-10-2010");
				TestHelper helper = new TestHelper();	
				helper.setDate(startDate);
				helper.setCurrentYearVal(""+R);
				helper.setLastYearVal(""+S);
				testHelpers.add(helper);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		return testHelpers;
	}
	

}
