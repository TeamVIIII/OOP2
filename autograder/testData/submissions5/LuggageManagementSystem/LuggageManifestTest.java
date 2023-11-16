 

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.util.jar.Manifest;
import java.util.ArrayList;

public class LuggageManifestTest 
{
    public LuggageManifest luggageManifest;
    private Passenger passenger;
    private Flight flight;
    private String label;
    private String passportNumber;

    @Before
    public void setup()
    {
        passportNumber = "AB12345";
        String firstName = "John";
        String lastName = "Doe";
        String flightNo = "AA123";
        this.passenger = new Passenger(passportNumber, firstName, lastName, flightNo);

        String destination = "Tobago";
        String origin = "Greneda";
        String strDate = "1111-11-11T11:11:11";
        LocalDateTime flightDate = LocalDateTime.parse(strDate);
        this.flight = new Flight(flightNo, destination, origin, flightDate);

        this.label = "105";

        luggageManifest = new LuggageManifest();
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
    public void testSlips()
    {
        try 
        {
            Field field = luggageManifest.getClass().getDeclaredField("slips");
            //field.setAccessible(true);
            Class<?> fieldType = field.getType();
            
            // Check if the field type is ArrayList
            assertEquals(ArrayList.class, fieldType);

            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
            assertEquals(LuggageSlip.class, parameterizedType.getActualTypeArguments()[0]);
        } 
        catch(NoSuchFieldException e)
        {

        }
    }

    @Test
    public void testConstructor()
    {
        try 
        {
            Field field = LuggageManifest.class.getDeclaredField("slips");
            field.setAccessible(true);

            try
            {
                ArrayList<LuggageSlip> slips = (ArrayList<LuggageSlip>) field.get(luggageManifest);
                assertNotNull(slips);
                assertTrue(slips.isEmpty());
            }
            catch (IllegalAccessException iae)
            {
                iae.printStackTrace();
            }
        } 
        catch(NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testAddLuggage() throws IllegalAccessException
    {
        int allowedLuggage = getAllowedLuggage(passenger.getCabinClass(), flight);
        int numLuggage = passenger.getNumLuggage();
        int excessPieces = passenger.getNumLuggage() - allowedLuggage;
        String result = luggageManifest.addLuggage(passenger, flight);
        String expected = "a";
        
        try
        {
            Class<?> clas = luggageManifest.getClass();
            Method method = clas.getDeclaredMethod("getExcessLuggageCost", int.class, int.class);
            method.setAccessible(true);
            
            try
            {
                double excessCost = (double) method.invoke(luggageManifest, numLuggage, allowedLuggage);
                

                if(passenger.getNumLuggage() == 0)
                    expected = "No Luggage to add.\n";
                else if (excessPieces > 0)
                    expected = "Pieces Added: (" + passenger.getNumLuggage() + "). Excess Cost: $" + excessCost + "\n";
                else if (excessPieces <= 0)
                    expected = "Pieces Added: (" + passenger.getNumLuggage() + "). Excess Cost: $0\n";
        
                assertEquals(expected, result);
            }
            catch (InvocationTargetException ite){}
            
        }
        catch(NoSuchMethodException e){}
        

        /* try catch use to get slips attribute of this class and checks whether 
            the size of the arrayList slips equals to the number of luggages of one passenger
        */  
        try 
        {
            Field field = LuggageManifest.class.getDeclaredField("slips");
            field.setAccessible(true);

            ArrayList<LuggageSlip> slips = (ArrayList<LuggageSlip>) field.get(luggageManifest);
            assertEquals(passenger.getNumLuggage(), slips.size());
        }
        catch(NoSuchFieldException e){}
    }

    @Test
    public void testGetExcessLuggageCost() throws IllegalAccessException
    {
        int allowed = getAllowedLuggage(passenger.getCabinClass(), flight);
        int numPieces = passenger.getNumLuggage();
        int excessPieces = numPieces - allowed;

        double cost = 0;

        if (excessPieces > 0)
            cost = excessPieces * 35;
        
        try
        {
            Class<?> clas = luggageManifest.getClass();
            Method method = clas.getDeclaredMethod("getExcessLuggageCost", int.class, int.class);
            method.setAccessible(true);
            try
            {
                double excessCost = (double) method.invoke(luggageManifest, numPieces, allowed);
                double delta = 0.001; // sets the tolerance level
                
                assertEquals(cost, excessCost, delta);
            }
            catch (InvocationTargetException e){}
        }
        catch (NoSuchMethodException e){}
    }

    @Test
    public void testGetExcessLuggageCostByPassenger()
    {
        int allowed = getAllowedLuggage(passenger.getCabinClass(), flight);
        int numPieces = passenger.getNumLuggage();
        int excessPieces = numPieces - allowed;
        double cost = 0;
        String expected = "";

        if (excessPieces > 0)
        {
            cost = excessPieces * 35;
            expected = Double.toString(cost);
        }
            
        if(numPieces == 0)
            expected = "No Cost";
        
        String x = luggageManifest.addLuggage(passenger,flight);
        String result = luggageManifest.getExcessLuggageCostByPassenger(passenger.getPassportNumber());
    
        assertEquals(result, expected);
    }

    @Test
    public void testToString() throws IllegalAccessException
    {
        int numLuggages = passenger.getNumLuggage();
        String expected = "LUGGAGE MANIFEST:\n";
        String x = luggageManifest.addLuggage(passenger,flight);
        String result = luggageManifest.toString();
        
        try {
            Field field = LuggageSlip.class.getDeclaredField("luggageSlipIDCounter");
            field.setAccessible(true);
            field.set(null, 1); // Reset the static variable to its original state (1).
        } catch (Exception e) {}
        
        if(numLuggages > 0)
        {
            int allowed = getAllowedLuggage(passenger.getCabinClass(), flight);
            int excessPieces = numLuggages - allowed;
            
            
            double cost = 0;

            if (excessPieces > 0)
            {
                cost = excessPieces * 35;
                try
                {
                    Class<?> clas = luggageManifest.getClass();
                    Method method = clas.getDeclaredMethod("getExcessLuggageCost", int.class, int.class);
                    method.setAccessible(true);
                    try
                    {
                        double excessCost = (double) method.invoke(luggageManifest, numLuggages, allowed);
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
        assertEquals(expected, luggageManifest.toString());
    }    
    
    private int getAllowedLuggage(char cabinClass, Flight flightInstance) {
        try {
            // Attempt to get the method by its name (regardless of whether it's static or non-static)
            Method method = Flight.class.getMethod("getAllowedLuggage", char.class);
            if (Modifier.isStatic(method.getModifiers())) {
                // If the method is static, invoke it using the class
                return (int) method.invoke(null, cabinClass);
            } else {
                // If the method is non-static, invoke it using the instance
                return (int) method.invoke(flightInstance, cabinClass);
            }
        } catch (Exception e) {
            // Handle exceptions or return a default value as needed
            e.printStackTrace();
            return -1; // Or any other default value
        }
    }
}