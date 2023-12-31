 
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;
import java.time.LocalDateTime;

public class FlightTest 
{
    private String firstName = "John";
    private String lastName = "Doe";
    private String flightNo = "AA123";
    private String passportNumber = "AB12345";
    private String destination = "Tobago";
    private String origin = "Greneda";
    private String strDate = "1111-11-11T11:11:11";
    private LocalDateTime flightDate = LocalDateTime.parse(strDate);
    private Flight flight;
    private LuggageManifest manifest;
    private Passenger passenger;
    
    @Before
    public void setup()
    {
        this.flight = new Flight(flightNo, destination, origin, flightDate);
        this.passenger = new Passenger(passportNumber, firstName, lastName, flightNo);
    } 
    
    @After
    public void tearDown()
    {
        try {
            Field field = LuggageSlip.class.getDeclaredField("luggageSlipIDCounter");
            field.setAccessible(true);
            field.set(null, 1); // Reset the static variable to its original state (1).
        } catch (Exception e) {}
    }
    
    @Test
    public void testFlightNo() 
    {
        try
        {
            Field field = flight.getClass().getDeclaredField("flightNo");
            Class<?> fieldType = field.getType();

            assertEquals(String.class, fieldType);
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));

            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));   
        }
        catch(NoSuchFieldException e){}
    }

    @Test
    public void testDestination() 
    {
        try
        {
            Field field = flight.getClass().getDeclaredField("destination");
            Class<?> fieldType = field.getType();

            assertEquals(String.class, fieldType);
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));

            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));   
        }
        catch(NoSuchFieldException e){}
    }

    @Test
    public void testOrigin() 
    {
        try
        {
            Field field = flight.getClass().getDeclaredField("origin");
            Class<?> fieldType = field.getType();

            assertEquals(String.class, fieldType);
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));

            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));   
        }
        catch(NoSuchFieldException e){}
    }

    @Test
    public void testFlightDate() 
    {
        try
        {
            Field field = flight.getClass().getDeclaredField("flightDate");
            Class<?> fieldType = field.getType();

            assertEquals(LocalDateTime.class, fieldType);
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));

            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));   
        }
        catch(NoSuchFieldException e){}
    }

    @Test
    public void testManifest() 
    {
        try
        {
            Field field = flight.getClass().getDeclaredField("manifest");
            Class<?> fieldType = field.getType();

            assertEquals(LuggageManifest.class, fieldType);
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));

            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));   
        }
        catch(NoSuchFieldException e){}
    }

    @Test
    public void testConstructor()
    {
        assertEquals(flightNo, flight.getFlightNo());
        assertEquals(destination, flight.getDestination());
        assertEquals(origin, flight.getOrigin());
        assertEquals(flightDate, flight.getFlightDate());
        
        try
        {
            Field field = flight.getClass().getDeclaredField("manifest");
            field.setAccessible(true);

            assertNotNull(field);
        }
        catch(NoSuchFieldException e){
            System.out.println("manifest in flight class not found in testConstructor \n" + e);
        }
    }

    @Test
    public void testCheckInLuggage() throws IllegalArgumentException, IllegalAccessException
    {
        Passenger p = new Passenger(passportNumber, firstName, lastName, "BWA1234");
        String result = flight.checkInLuggage(p);
        assertEquals("Invalid flight", result);

        String expected = "";
        result = flight.checkInLuggage(passenger);
        
        int allowedLuggage = getAllowedLuggage(passenger.getCabinClass());
        int numLuggage = passenger.getNumLuggage();
        int excessPieces = passenger.getNumLuggage() - allowedLuggage;
        
        try
        {
            Field field = Flight.class.getDeclaredField("manifest");
            field.setAccessible(true);
            manifest = (LuggageManifest) field.get(flight);

        }
        catch(NoSuchFieldException e) 
        {
            System.out.println("manifest error in testcheckInLuggage \n" + e);
        }

        try
        {
            Class<?> clas = manifest.getClass();
            Method method = clas.getDeclaredMethod("getExcessLuggageCost", int.class, int.class);
            method.setAccessible(true);
            
            try
            {
                double excessCost = (double) method.invoke(manifest, numLuggage, allowedLuggage);

                if(passenger.getNumLuggage() == 0)
                    expected = "No Luggage to add.\n";
                else if (excessPieces > 0)
                    expected = "Pieces Added: (" + passenger.getNumLuggage() + "). Excess Cost: $" + excessCost + "\n";
                else if (excessPieces <= 0)
                    expected = "Pieces Added: (" + passenger.getNumLuggage() + "). Excess Cost: $0\n";
        
                
            }
            catch (InvocationTargetException ite){}
            
        }
        catch(NoSuchMethodException e){}

        assertEquals(expected, result);
    }

    @Test
    public void testPrintLuggageManifest() throws IllegalAccessException
    {
        int numLuggages = passenger.getNumLuggage();
        String expected = "LUGGAGE MANIFEST:\n";
        
        try
        {
            Field field = Flight.class.getDeclaredField("manifest");
            field.setAccessible(true);
            manifest = (LuggageManifest) field.get(flight);

        }
        catch(NoSuchFieldException e) 
        {
            System.out.println("manifest error in testcheckInLuggage \n" + e);
        }

        manifest.addLuggage(passenger,flight);
        
        try {
            Field field = LuggageSlip.class.getDeclaredField("luggageSlipIDCounter");
            field.setAccessible(true);
            field.set(null, 1); // Reset the static variable to its original state (1).
        } catch (Exception e) {}
        
        if(numLuggages > 0)
        {
            int allowed = getAllowedLuggage(passenger.getCabinClass());
            int excessPieces = numLuggages - allowed;
            
            

            if (excessPieces > 0)
            {
                try
                {
                    Class<?> clas = manifest.getClass();
                    Method method = clas.getDeclaredMethod("getExcessLuggageCost", int.class, int.class);
                    method.setAccessible(true);
                    try
                    {
                        double excessCost = (double) method.invoke(manifest, numLuggages, allowed);
                        for(int i = 0; i < numLuggages; i++)
                        {
                            LuggageSlip s = new LuggageSlip(passenger,flight, Double.toString(excessCost));
                            expected = expected + s.toString() + "\n";
                        }
                    }
                    catch (InvocationTargetException e){}
                }
                catch (NoSuchMethodException e){}
            }
            else if (excessPieces <= 0) 
            {
              for (int i = 1; i <= numLuggages; i++) 
              {
                LuggageSlip s = new LuggageSlip(passenger, flight);
                expected = expected + s.toString() + "\n";
              }
            }
        }
        
        assertEquals(expected, flight.printLuggageManifest());
    }    
    
    @Test
    public void testgetAllowedLuggage()
    {
        assertEquals(getAllowedLuggage('F'), 3);
        assertEquals(getAllowedLuggage('B'), 2);
        assertEquals(getAllowedLuggage('P'), 1);
        assertEquals(getAllowedLuggage('E'), 0);
        
        Boolean p = false;
        
        try
        {
            Class<?> clas = flight.getClass();
            Method method = clas.getDeclaredMethod("getAllowedLuggage", char.class);
            p = Modifier.isStatic(method.getModifiers());
        }
        catch (NoSuchMethodException e){}
        
        assertTrue(p);
    }

    @Test
    public void testToString()
    {
        String expected = flightNo + " DESTINATION: " + destination + " ORIGIN: " + origin + " "
        + flightDate;
        assertEquals(expected, flight.toString());
    }

    private int getAllowedLuggage(char cabinClass) 
    {
        try 
        {
            Method method = Flight.class.getMethod("getAllowedLuggage", char.class);
            if (Modifier.isStatic(method.getModifiers())) 
            {
                return (int) method.invoke(null, cabinClass);
            } else 
            {
                return (int) method.invoke(cabinClass);
            }
        } catch (Exception e) // method was not found
        {
            e.printStackTrace();
            return -1;
        }
    }
    
}
