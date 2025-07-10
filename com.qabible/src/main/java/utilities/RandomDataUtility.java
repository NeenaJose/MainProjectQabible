package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	static Faker faker;
	
	public static String getPromotionTitle() {
		faker=new Faker();
		return faker.company().profession();
		
	}
	
	public static String getBugTitle() {
		faker=new Faker();
		String action = faker.hacker().verb();         
        String component = faker.hacker().noun();     
        String module = faker.app().name();           

        return "Bug in " + module + ": Unable to " + action + " " + component;
		
	}

}
