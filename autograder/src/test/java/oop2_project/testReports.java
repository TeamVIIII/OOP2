package oop2_project;


import org.junit.runner.Result;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class testReports
{
   private RunTest executer;
   private Copier copier;
   private Compiler compiler;
   List <Result> results;
   private Report passenger;
   private Report flight;
   private Report luggageSlip;
   private Report luggageManifest;

   @Before
   public void setup()
   {
      executer = new RunAllTests();
      copier = new CopyAll();
      compiler = new Compiler();
      String failing = "testData/FailingSubmission";

      copier.copyAll(failing);
      compiler.compileTest();
      results = executer.runAll();

      passenger = new PassengerReport(results.get(0));
      luggageSlip = new LuggageSlipReport(results.get(1));
      luggageManifest = new LuggageManifestReport(results.get(2));
      flight = new FlightReport(results.get(3));
   }

   @AfterClass
   public static void tearDown()
   {
      Facade grader = new AutoGradeFacade();
      grader.delete();
      grader.resetState();
   }

   @Test
   public void testPassengerReport()
   {
      assertEquals(16, passenger.getTotalMark());
      assertEquals(6, passenger.getAcquiredMark());
      
      String s1 = "Ensure the Passenger constructor uses the 4 input parameters correctly, sets the numLuggage variable randomly and sets the cabinClass variable randomly";

      String s2 = "Passenger to String wasn't in this form 'PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: 3 CLASS: E'";

      String expected = s2 + "\n" + s1 + "\n";

      assertEquals(expected, passenger.recommendationsToString());
   }

   @Test
   public void testLuggageSlipReport()
   {
      assertEquals(14, luggageSlip.getTotalMark());
      assertEquals(4, luggageSlip.getAcquiredMark());

      String s1 = "Ensure variable name is luggageSlipID, a String and private in the LuggageSlip Class. Also it is set to a combination of the flightNo, passenger last name and the luggageSlipIDCounter\n";

      String s2 = "This constructor should initialise the variables of the class with the parameters parsed in and set label to an empty String\n";

      String s3 = "This method should check if the if owner of this LuggageSlip passportNumber equals to one parsed in. If it natches return true else return false\n";

      String s4 = "Ensure variable name is luggageSlipIDCounter,static, of type int, and private in the LuggageSlip class\n";

      String s5 = "This constructor should include String label as a parameter and  initialise the variables of the class with the parameters parsed in\n";

      String expected = s4 + s5 + s2 + s3 + s1;
      assertEquals(expected, luggageSlip.recommendationsToString());
   }

   @Test
   public void testLuggageManifestReport()
   {
      assertEquals(20, luggageManifest.getTotalMark());
      // assertEquals(20, luggageManifest.getAcquiredMark());
      assertEquals(12, luggageManifest.getAcquiredMark());

      String s1 = "This method should've iterated through the slips collection calling the toString method of the LuggageSlip class\n";
      String s2 = "This method suppose to taken in a passportNumber and return the excess cost this passenger is required to pay by iterating through the slips collection and checking to see if the passportNumber parsed in equals to the owner's passportNumber of that slip. The method should've then returned label attached to that slip if any, otherwise returned 'No Cost'\n";

      String expected = s2 + s1;
      // String expected = "";

      assertEquals(expected, luggageManifest.recommendationsToString());
   }
   
   @Test
   public void testFlightReport()
   {
      assertEquals(16, flight.getTotalMark());
      assertEquals(5, flight.getAcquiredMark());

      String s1 = "Ensure Flight's toString method returns the string in this format: BW817 DESTINATION: TOBAGO ORIGIN: TRINIDAD 2017-01-13T17:09:42.411\n";
      String s2 = "This method return the string from the call of manifest.toString()\n";
      String s3 = "Ensure this method returns the correct integer based on the char parsed in and is a static method. Eg. if 'F' is parsed it should return 3. This method should also be static.\n";
      String s4 = "Check if a passenger.flightNo matches flight.flighNo. If it does return the string which is returened from the call of addLuggage of LuggageSlip class else return Invalid flight\n";
      String s5 = "Ensure the constructor creates a new LuggageManifest object and initializes the class variables\n";

      String expected = s3 + s1 + s4 + s2 + s5;
      assertEquals(expected, flight.recommendationsToString());
   }
}
