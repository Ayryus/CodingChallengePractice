package codingchallenge3;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

public class TruckTest {
	
	
	public static final String CLASSNAME = "Truck";
	public static final String FILENAME = CLASSNAME + ".java";
	
	
	// checks if cargo capacity is the only private thing in the class.
	private boolean instanceVariablesArePrivate(){
		boolean cargoCapacityIsOnlyPrivate = true;
		boolean cargoCapacityIsPrivate = false;
		
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("private")) {
					line = line.trim();
					if (line.length() >= 25) {
						line = line.substring(0,25);
						if (line.equals("private int cargoCapacity")){
							cargoCapacityIsPrivate = true;
						} else {
							cargoCapacityIsOnlyPrivate = false;
						}
					} else {
						cargoCapacityIsOnlyPrivate = false;
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			cargoCapacityIsPrivate = false;
		} catch (IOException e) {
			cargoCapacityIsPrivate =  false;
		}
		return cargoCapacityIsPrivate && cargoCapacityIsOnlyPrivate;
	}
		
	private boolean hasMethod(String signature) {
        boolean contains = false;
         
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILENAME));
            String line = in.readLine();
            while (line != null) {
                if (line.contains(signature)) {
                    contains = true;
                }
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            contains = false;
        } catch (IOException e) {
            contains =  false;
        }
        return contains;
     
    }   
	private boolean toStrInvokesParentToStr(){
		boolean callsGetter = false;
		boolean callsParent = false;
		
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("toString")) {
					// This should be start of toString method
					while (!line.contains("}")) {
						line = in.readLine();
						if (line.contains("getModel") ){
							callsGetter = true;
						}
						if (line.contains("super.toString()")) {
							callsParent = true;
						}
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			callsParent = false;
		} catch (IOException e) {
			callsParent =  false;
		}
		return callsParent && !callsGetter;
	}
	
	private void testInterface() {
		assertTrue("Should only have one instance variable (cargoCapacity).",instanceVariablesArePrivate());
		assertFalse("Should not override (or call) getModel.", hasMethod("getModel"));
		assertFalse("Should not override (or call) setModel.", hasMethod("setModel"));
		assertFalse("Should not override (or call) isMidRange.", hasMethod("isMidRange"));
	}
	
	
	// Testing constructors
		@Test
		public void test_Constructor_CargoCapacityMin0() {
			testInterface();
			Truck t = new Truck("", 0);
			assertEquals("Created Truck with empty model, cargo capacity 0 - testing model", "", t.getModel());
			assertEquals("Created Truck with empty model, cargo capacity 0 - testing cargo capacity", 0, t.getCargoCapacity());
		}

		
		@Test
		public void test_Constructor_NegativeCargoCapacity() {
			testInterface();
			Truck t = new Truck("Panther", -1000);
			assertEquals("Created Truck with 'Panther' Model, cargo capacity -1000 - testing Model", "PANTHER", t.getModel());
			assertEquals("Created Truck with 'Panther' Model, cargo capacity -1000 - testing Cargo Capacity", 0, t.getCargoCapacity());
		}

		@Test 
		public void test_CopyConstructor() {
			testInterface();
			Truck t = new Truck("TEST1", 4500);
			Truck t2 = new Truck(t);
			assertEquals("Testing Copy Constructor, copying 'TEST1' Model, cargo capacity 4500 - testing Model", "TEST1", t2.getModel());
			assertEquals("Testing Copy Constructor, copying 'TEST1' Model, cargo capacity 4500 - testing cargo capacity", 4500, t2.getCargoCapacity());
		}

		
	// Testing setter and getters
	
		
		@Test
		public void test_setter_and_getter_cargocapacity_zero() {
			testInterface();
			Truck t = new Truck("TestZeroCargoCapacity", 4500);
			t.setCargoCapacity(0);
			assertEquals("Set cargo capacity to zero.", 0, t.getCargoCapacity());
		}

		
		@Test
		public void test_setter_and_getter_cargocapacity_negative() {
			testInterface();
			Truck t = new Truck("TestNegativeRating", 4500);
			t.setCargoCapacity(-1);
			assertEquals("Set cargo capacity to a negative number that was initialized to 4500.", 4500, t.getCargoCapacity());
		}
		
		@Test
		public void test_getCategory_LightWeight() {
            testInterface();
            Truck t = new Truck("TestingCategory",2000);
            assertEquals("Set cargo capacity 2000", "LIGHT WEIGHT", t.getCategory());
            t.setCargoCapacity(1500);
            assertEquals("Set cargo capacity 1500", "LIGHT WEIGHT", t.getCategory());
            t.setCargoCapacity(3000);
            assertEquals("Set cargo capacity 3000", "LIGHT WEIGHT", t.getCategory());
        }
		
		@Test
		public void test_getCategory_Medium() {
            testInterface();
            Truck t = new Truck("TestingCategory",5000);
            assertEquals("Set cargo capacity 5000", "MEDIUM", t.getCategory());
            t.setCargoCapacity(5500);
            assertEquals("Set cargo capacity 5500", "MEDIUM", t.getCategory());
            t.setCargoCapacity(5800);
            assertEquals("Set cargo capacity 5800", "MEDIUM", t.getCategory());
        }
		
		@Test
		public void test_getCategory_HeavyDuty() {
            testInterface();
            Truck t = new Truck("TestingCategory",6500);
            assertEquals("Set cargo capacity 6500", "HEAVY DUTY", t.getCategory());
            t.setCargoCapacity(7000);
            assertEquals("Set cargo capacity 7000", "HEAVY DUTY", t.getCategory());
            t.setCargoCapacity(6600);
            assertEquals("Set cargo capacity 6600", "HEAVY DUTY", t.getCategory());
        }
		
		
		@Test
		public void test_toString() {
			testInterface();
			assertTrue("Should override toString and it should invoke parent toString (not getter methods in parent).", toStrInvokesParentToStr());
			
			Truck t = new Truck("TESTING_TO_STRING", 3300);
			assertEquals("Model: TESTING_TO_STRING, Category LIGHT WEIGHT Cargo Capacity 3300", "Model: TESTING_TO_STRING Category: LIGHT WEIGHT Cargo Capacity: 3300", t.toString());
		}
		
}
