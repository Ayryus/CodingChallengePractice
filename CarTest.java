package codingchallenge3;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

public class CarTest {
	
	
	public static final String CLASSNAME = "Car";
	public static final String FILENAME = CLASSNAME + ".java";
	
	
	// checks if noOfSeats is the only private thing in the class.
	private boolean instanceVariablesArePrivate(){
		boolean noOfSeatsIsOnlyPrivate = true;
		boolean noOfSeatsIsPrivate = false;
		
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("private")) {
					line = line.trim();
					if (line.length() >= 21) {
						line = line.substring(0,21);
						if (line.equals("private int noOfSeats")){
							noOfSeatsIsPrivate = true;
						} else {
							noOfSeatsIsOnlyPrivate = false;
						}
					} else {
						noOfSeatsIsOnlyPrivate = false;
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			noOfSeatsIsPrivate = false;
		} catch (IOException e) {
			noOfSeatsIsPrivate =  false;
		}
		return noOfSeatsIsPrivate && noOfSeatsIsOnlyPrivate;
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
		assertTrue("Should only have one instance variable (noOfSeats).",instanceVariablesArePrivate());
		assertFalse("Should not override (or call) getModel.", hasMethod("getModel"));
		assertFalse("Should not override (or call) setModel.", hasMethod("setModel"));
	}
	
	
	
	// Testing constructors
		@Test
		public void test_Constructor_NoOFSeatsMin1() {
			testInterface();
			Car c = new Car("", 1);
			assertEquals("Created Car with empty model, no of seats 1 - testing model", "", c.getModel());
			assertEquals("Created Car with empty model, no of seats 1 - testing no of seats", 1, c.getNoOfSeats());
		}

		
		@Test
		public void test_Constructor_NegativeNoOFSeats() {
			testInterface();
			Car c = new Car("Honda", -1);
			assertEquals("Created Car with 'Honda' Model, no of seats -1 - testing Model", "HONDA", c.getModel());
			assertEquals("Created Car with 'Honda' Model, no of seats -1 - testing no of seats", 1, c.getNoOfSeats());
		}

		@Test
		public void test_Constructor_GreaterNoOfSeats() {
			testInterface();
			Car c = new Car("Honda", 11);
			assertEquals("Created Car with 'Honda' Model, no of seats 11 - testing Model", "HONDA", c.getModel());
			assertEquals("Created Car with 'Honda' Model, no of seats 11 - testing no of seats", 1, c.getNoOfSeats());
		}
		
		@Test
		public void test_Constructor_MaxSeats() {
			testInterface();
			Car c = new Car("Honda", 8);
			assertEquals("Created Car with 'Honda' Model, no of seats 8 - testing Model", "HONDA", c.getModel());
			assertEquals("Created Car with 'Honda' Model, no of seats 8 - testing no of seats", 8, c.getNoOfSeats());
		}
		
		@Test 
		public void test_CopyConstructor() {
			testInterface();
			Car c = new Car("TEST1", 7);
			Car c2 = new Car(c);
			assertEquals("Testing Copy Constructor, copying 'TEST1' Model, no of seats 7 - testing Model", "TEST1", c2.getModel());
			assertEquals("Testing Copy Constructor, copying 'TEST1' Model, no of seats 7 - testing no of seats", 7, c2.getNoOfSeats());
		}

		
	// Testing setter and getters
	
		
		@Test
		public void test_setter_and_getter_noofseats_zero() {
			testInterface();
			Car c = new Car("TestNoOfSeats", 3);
			c.setNoOfSeats(0);
			assertEquals("Set no of seats to 0 initialized to 3.", 3, c.getNoOfSeats());
		}

		@Test
		public void test_setter_and_getter_noofseats_negative() {
			testInterface();
			Car c = new Car("TestNegativeNoOfSeats", 5);
			c.setNoOfSeats(-1);
			assertEquals("Set no of seats to a negative number that was initialized to 5.", 5, c.getNoOfSeats());
		}
		
		@Test
		public void test_setter_and_getter_noofseats_Max() {
			testInterface();
			Car c = new Car("TestMaxNoOfSeats", 8);
			c.setNoOfSeats(11);
			assertEquals("Set no of seats to a 11 that was initialized to 8.", 8, c.getNoOfSeats());
		}
		
		
		@Test
		public void test_getCategory_Small() {
            testInterface();
            Car c = new Car("TestingCategory",2);
            assertEquals("Set no of seats 2", "SMALL", c.getCategory());
            c.setNoOfSeats(1);
            assertEquals("Set no of seats 1", "SMALL", c.getCategory());
           }
		
		@Test
		public void test_getCategory_Medium() {
            testInterface();
            Car c = new Car("TestingCategory",4);
            assertEquals("Set no of seats 4", "MEDIUM", c.getCategory());
            c.setNoOfSeats(5);
            assertEquals("Set no of seats 5", "MEDIUM", c.getCategory());  
        }
		
		@Test
		public void test_getCategory_Family() {
            testInterface();
            Car c = new Car("TestingCategory",6);
            assertEquals("Set no of seats 6", "FAMILY", c.getCategory());
            c.setNoOfSeats(7);
            assertEquals("Set no of seats 7", "FAMILY", c.getCategory());
            c.setNoOfSeats(8);
            assertEquals("Set no of seats 8", "FAMILY", c.getCategory());
        }
		
		@Test
		public void test_toString() {
			testInterface();
			assertTrue("Should override toString and it should invoke parent toString (not getter methods in parent).", toStrInvokesParentToStr());

			Car c = new Car("TESTING_TO_STRING", 2);
			assertEquals("Model: TESTING_TO_STRING, Category SMALL noOfSeats: 2", "Model: TESTING_TO_STRING Category: SMALL noOfSeats: 2", c.toString());
		}
		
}
