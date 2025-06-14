package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}
	
	

	public static <T> Object[][] readJsonDataProvider(String filePath,
			TypeReference<List<T>> typeReference) {
		ObjectMapper mapper = new ObjectMapper();
		List<T> dataList;
		
		try {
			dataList = mapper.readValue(new File(filePath), typeReference);
			Object[][] result = new Object[dataList.size()][1];
			for(int i=0;i<dataList.size();i++) {
				result[i][0]=dataList.get(i);
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new Object[0][0];
	}
	
	
}
