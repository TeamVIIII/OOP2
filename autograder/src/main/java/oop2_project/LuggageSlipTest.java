package oop2_project;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class LuggageSlipTest {
    private LuggageSlip slip1;
    private LuggageSlip slip2;
    private Passenger owner;
    private Flight flight;
    private String label;
    private String passportNumber;

    @Before
    public void setup()
    {
        this.passportNumber = "AB12345";
        String firstName = "John";
        String lastName = "Doe";
        String flightNo = "AA123";
        this.owner = new Passenger(passportNumber, firstName, lastName, flightNo);

        String destination = "Tobago";
        String origin = "Greneda";
        String strDate = "1111-11-11T11:11:11";
        LocalDateTime flightDate = LocalDateTime.parse(strDate);
        this.flight = new Flight(flightNo, destination, origin, flightDate);

        this.label = "105";

        this.slip1 = new LuggageSlip(owner, flight);
        this.slip2 = new LuggageSlip(owner, flight, label);
    }

    @Test
    public void testOwner() 
    {
        try
        {
            // checks if student followed correct variable naming
            Field field = slip1.getClass().getDeclaredField("owner");
            
            // checks for correct variable type
            Class<?> fieldType = field.getType();
            assertEquals(Passenger.class, fieldType);
            
        }
        catch(NoSuchFieldException e)
        {
            
        }
    }
    
    @After
    public void tearDown() 
    {
        try {
            Field field = LuggageSlip.class.getDeclaredField("luggageSlipIDCounter");
            field.setAccessible(true);
            field.set(null, 1); // Reset the static variable to its original state (1).
        } catch (Exception e) {
            
        }
    }

    @Test
    public void testLuggageSlipIDCounter() 
    {
        try
        {
            // checks if student followed correct variable naming
            Field field = slip1.getClass().getDeclaredField("luggageSlipIDCounter");
            
            // checks for correct variable type
            Class<?> fieldType = field.getType();
            assertEquals(int.class, fieldType);

            int modifiers = field.getModifiers();
            assertTrue(java.lang.reflect.Modifier.isStatic(modifiers));

            int startCount = slip2.getLuggageSlipIDCounter();

            LuggageSlip slip3 = new LuggageSlip(owner, flight);
            LuggageSlip slip4 = new LuggageSlip(owner, flight);

            int finalCount = slip2.getLuggageSlipIDCounter();

            assertEquals(startCount + 2, finalCount);

        }
        catch(NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testLuggageSlipID()
    {
        try
        {
            // checks if student followed correct variable naming
            Field field = slip1.getClass().getDeclaredField("luggageSlipID");
            
            // checks for correct variable type
            Class<?> fieldType = field.getType();
            assertEquals(int.class, fieldType);

            String expected = owner.getFlightNo() + "_" + owner.getLastName() + "_" + 1;
            String s = slip1.getLuggageSlipID();
            
            assertNotNull(s);
            assertEquals(s, expected);
        }
        catch(NoSuchFieldException e)
        {
            
        }   
    }
       
    @Test
    public void testLabel()
    {
        try
        {
            Field field = slip1.getClass().getDeclaredField("label");
            
            // checks for correct variable type
            Class<?> fieldType = field.getType();
            assertEquals(String.class, fieldType);
        }
        catch (NoSuchFieldException e)
        {
            
        }
    }

    @Test
    public void testNoLabelConstructor()
    {
        assertEquals(owner, slip1.getOwner());
        assertEquals("", slip1.getLabel());
    }  
    
    @Test
    public void testLabelConstructor()
    {
        assertEquals(owner, slip2.getOwner());
        assertEquals(label, slip2.getLabel());
    } 
    
    @Test
    public void testHasOwner()
    {
        assertTrue(slip1.hasOwner(passportNumber));
    }

    @Test
    public void testToStringFormat()
    {
        String expectedNoSlip = slip1.getLuggageSlipID() + " " + owner.toString() + "";

        String expectedWithSlip = slip1.getLuggageSlipID() + " " + owner.toString() + "";
        

        assertEquals(expectedNoSlip, slip1.toString());
        assertEquals(expectedWithSlip, slip1.toString());
    }
}
