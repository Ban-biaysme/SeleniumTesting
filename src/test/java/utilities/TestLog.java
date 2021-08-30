/**
 * 
 */
package utilities;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog {
	
	public static Logger log= Logger.getLogger(TestLog.class.getName());
	public static void main(String[] args) {

		Date dt= new Date();
		System.out.println(dt.toString().replace(":", "_").replace(" ", "_"));
		System.setProperty("current.date",dt.toString().replace(":", "_").replace(" ", "_"));
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("This is the information log");
		log.error("This is the error log");
	}

}
