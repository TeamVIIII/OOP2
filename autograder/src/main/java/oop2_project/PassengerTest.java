package main.java.oop2_project;

 
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Field;

public class PassengerTest {
    private Passenger passenger;
    private String passportNumber = "AB12345";
    private String firstName = "John";
    private String lastName = "Doe";
    private String flightNo = "AA123";

    @Before
    public void setup()
    {
        this.passenger = new Passenger(passportNumber, firstName, lastName, flightNo);
    }


    @Test
    public void testPassportNumber() 
    {
        try
        {
            Field field = passenger.getClass().getDeclaredField("passportNumber");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));
        
            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));   
        }
        catch(NoSuchFieldException e)
        {
            
        }
        
    }

    @Test
    public void testFlightNo()
    {
        try
        {
            Field field = passenger.getClass().getDeclaredField("flightNo");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));
        
            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));   
        }
        catch(NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testFirstName()
    {
        try
        {
            Field field = passenger.getClass().getDeclaredField("firstName");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));
        
            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));
        }
        catch(NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testLastName() 
    {
        try
        {
            Field field = passenger.getClass().getDeclaredField("lastName");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));
        
            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));
        }
        catch(NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testNumLuggage() 
    {
        try
        {
            Field field = passenger.getClass().getDeclaredField("numLuggage");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));
        
            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));
        }
        catch(NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testCabinClass()     
    {
        try
        {
            Field field = passenger.getClass().getDeclaredField("cabinClass");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()));
        
            int modifiers = field.getModifiers();
            assertTrue(!java.lang.reflect.Modifier.isStatic(modifiers));
        }
        catch(NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testConstructor() 
    {
        assertEquals(passportNumber, passenger.getPassportNumber());
        assertEquals(firstName, passenger.getFirstName());
        assertEquals(lastName, passenger.getLastName());
        assertEquals(flightNo, passenger.getFlightNo());
        
        assertTrue(passenger.getNumLuggage() >= 0 && passenger.getNumLuggage() < 4);

        // test for randomization of cabin class
        char cabinClass = passenger.getCabinClass();
        assertTrue(cabinClass == 'F' || cabinClass == 'B' || cabinClass == 'P' || cabinClass == 'E');
    }
    
}

