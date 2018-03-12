package codingchallenge3;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class VehicleTest {
	public class VM extends Vehicle{
		String next = "";

		public VM(String model){
			super(model);
		}
		
		public VM(VM c) {
			super(c);
		}
		
		public String getCategory(){
			return next;
		}
	}

	public static final String CLASSNAME = "Vehicle";
	public static final String FILENAME = CLASSNAME + ".java";	
	
	private void testClassDefinition(){
		String[] instanceVars = {"String model"};
		assertTrue("Instance variables should be private with correct name and type.", instanceVariablesArePrivate(instanceVars));

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
		
		String[] abstractMethods = {"String getCategory()"};
		assertTrue("Class should have abstract method getCategory that returns a String.", hasRequiredAbstractMethods(abstractMethods));
		

	}
	
	// Testing constructors
		@Test
		public void test_Constructor_EmptyString() {
			testClassDefinition();
			
			VM c = new VM("");
			assertEquals("Created Vehicle with empty model - testing model", "", c.getModel());
		}

		@Test
		public void test_Constructor_AllLowerCase() {
			testClassDefinition();
			
			VM c = new VM("City");
			assertEquals("Created vehicle with 'City' model - testing model", "CITY", c.getModel());
		}

		@Test
		public void test_Constructor_AllUpperCase() {
			testClassDefinition();
			VM c = new VM("COROLLA");
			assertEquals("Created vehicle with 'COROLLA' model - testing model", "COROLLA", c.getModel());
		}

		@Test
		public void test_Constructor_MixedCase() {
			testClassDefinition();
			VM c = new VM("Civic");
			assertEquals("Created vehicle with 'Civic' model - testing model", "CIVIC", c.getModel());
		}
		
		@Test 
		public void test_CopyConstructor() {
			testClassDefinition();
			VM c = new VM("TEST1");
			VM c2 = new VM(c);
			assertEquals("Testing Copy Constructor, copying 'TEST1' model - testing model", "TEST1", c2.getModel());
		}

		
	// Testing setter and getters
	
		@Test
		public void test_setter_and_getter_model_emptyString(){
			testClassDefinition();
			VM c = new VM("TestEmptyString");
			c.setModel("");
			assertEquals("Set model to empty string", "", c.getModel());
		}
		
		@Test
		public void test_setter_and_getter_model_allLowerCase(){
			testClassDefinition();
			VM c = new VM("TestAllLowerCase");
			c.setModel("panther");
			assertEquals("Set model to 'panther'", "PANTHER", c.getModel());
		}
		
		@Test
		public void test_setter_and_getter_model_allUpperCase(){
			testClassDefinition();
			VM c = new VM("TestAllUpperCase");
			c.setModel("CAMRY");
			assertEquals("Set model to 'CAMRY'", "CAMRY", c.getModel());
		}
		
		@Test
		public void test_setter_and_getter_model_MixedCase(){
			testClassDefinition();
			VM c = new VM("TestMixedCase");
			c.setModel("Dungfeng");
			assertEquals("Set model to 'Dungfeng'", "DUNGFENG", c.getModel());
		}
		
		@Test
		public void test_isMidRange_MEDIUM(){
			testClassDefinition();
			VM v = new VM("test");
			v.next="MEDIUM";
			assertTrue("Category MEDIUM should be mid range.", v.isMidRange());
			
		}
		
		@Test
		public void test_isMidRange_medium(){
			testClassDefinition();
			VM v = new VM("test");
			v.next="medium";
			assertFalse("Category medium should NOT be mid range.", v.isMidRange());
			
		}
		
		@Test
		public void test_isMidRange_other(){
			testClassDefinition();
			VM v = new VM("test");
			v.next="SMALL";
			assertFalse("Category SMALL should NOT be mid range.", v.isMidRange());
			
		}
		
		@Test
		public void test_toString() {
			testClassDefinition();
			VM c = new VM("TESTING_TO_STRING");
			assertEquals("model: TESTING_TO_STRING", "Model: TESTING_TO_STRING Category: ", c.toString());
		}


////////////// End of test methods /////////////////////////////

	private boolean hasRequiredAbstractMethods(String[] abstractMethods) {
		boolean[] methodsAbstract = new boolean[abstractMethods.length];
		for (int index = 0; index < abstractMethods.length; index++){
			methodsAbstract[index] = false;
		}
		boolean classIsAbstract = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("public abstract class " + CLASSNAME)){
					classIsAbstract = true;
				} else {
					for (int index = 0; index < abstractMethods.length; index++) {
						String stmt = "public abstract " + abstractMethods[index];
						if (line.contains(stmt)) {
							methodsAbstract[index] = true;
						}
					}
				}					
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			classIsAbstract = false;
		} catch (IOException e) {
			classIsAbstract = false;
		}
		
		boolean allAbstract = classIsAbstract;
		for (boolean b : methodsAbstract) {
			allAbstract = allAbstract && b;
		}
		return allAbstract;
	
	}

	private boolean instanceVariablesArePrivate(String[] instanceVars){
		boolean[] varsPrivate = new boolean[instanceVars.length];
		for (int index = 0; index < instanceVars.length; index++){
			varsPrivate[index] = false;
		}
		boolean allPrivate = true;

		
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("private")) {
					line = line.trim();
					for (int index = 0; index < instanceVars.length; index++){
						String stmt = "private " + instanceVars[index];
						if (line.length() >= stmt.length()){
							line = line.substring(0,stmt.length());
							if (line.equals(stmt)){
								varsPrivate[index] = true;
							}
						}
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			allPrivate = false;
		} catch (IOException e) {
			allPrivate =  false;
		}

		for (boolean b : varsPrivate) {
			allPrivate = allPrivate && b;
		}
		return allPrivate;
	}	
	
	
	private boolean noDefaultConstructor(){
		boolean noDefault = true;
		String[] versions = new String[2];
		versions[0] = "public " + CLASSNAME + "()";
		versions[1] = CLASSNAME + "()";
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				for (String stmt : versions) {
					if (line.contains(stmt)) {
						noDefault = false;
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			noDefault = false;
		} catch (IOException e) {
			noDefault =  false;
		}
		return noDefault;
	}
}