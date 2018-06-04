package maVue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import monController.KeyOrder;
import monController.Order;
import monController.iKeyOrder;

public class EventTest {

	 	@BeforeClass
	    public static void setUpBeforeClass() throws Exception 
	 	{
		 
	 	}
	    

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception 
	    {
	    	
	    }

	    @Before
	    public void setUp() throws Exception 
	    {
	    	
	    }

	    @After
	    public void tearDown() throws Exception 
	    {
	    	
	    }

	    @Test public void getKeyCodeUp()
	    {
	    	// Z key
	    	int keyCode = 90;
			iKeyOrder userOrder;
			iKeyOrder testOrder = new KeyOrder(Order.UP);
			switch(keyCode) 
			{
			case KeyEvent.VK_Z :
				userOrder = new KeyOrder(Order.UP);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder.getOrder());
				break;
			}
			
			// Up Arrow
			keyCode = 38; 
			iKeyOrder testOrder2 = new KeyOrder(Order.UP);
			switch(keyCode) 
			{
			case KeyEvent.VK_UP :
				userOrder = new KeyOrder(Order.UP);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder2.getOrder());
				break;
			}
	    }
	    
	    @Test public void getKeyCodeDown()
	    {
	    	// S key
	    	int keyCode = 83; 
			iKeyOrder userOrder;
			iKeyOrder testOrder = new KeyOrder(Order.DOWN);
			switch(keyCode) 
			{
			case KeyEvent.VK_S :
				userOrder = new KeyOrder(Order.DOWN);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder.getOrder());
				break;
			}
			
			// Down Arrow
			keyCode = 40; 
			iKeyOrder testOrder2 = new KeyOrder(Order.DOWN);
			switch(keyCode) 
			{
			case KeyEvent.VK_DOWN :
				userOrder = new KeyOrder(Order.DOWN);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder2.getOrder());
				break;
			}
	    }
	    
	    @Test public void getKeyCodeRight()
	    {
	    	// D key
	    	int keyCode = 68; 
			iKeyOrder userOrder;
			iKeyOrder testOrder = new KeyOrder(Order.RIGHT);
			switch(keyCode) 
			{
			case KeyEvent.VK_D :
				userOrder = new KeyOrder(Order.RIGHT);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder.getOrder());
				break;	
			}
			
			// Right Arrow
			keyCode = 39; 
			iKeyOrder testOrder2 = new KeyOrder(Order.RIGHT);
			switch(keyCode) 
			{
			case KeyEvent.VK_RIGHT :
				userOrder = new KeyOrder(Order.RIGHT);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder2.getOrder());
				break;
			}
	    }
	    
	    @Test public void getKeyCodeLeft()
	    {
	    	// Q key
	    	int keyCode = 81; 
			iKeyOrder userOrder;
			iKeyOrder testOrder = new KeyOrder(Order.LEFT);
			switch(keyCode) 
			{
			case KeyEvent.VK_Q :
				userOrder = new KeyOrder(Order.LEFT);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder.getOrder());
				break;
			}
			
			// Left Arrow
			keyCode = 37; 
			iKeyOrder testOrder2 = new KeyOrder(Order.LEFT);
			switch(keyCode) 
			{
			case KeyEvent.VK_LEFT :
				userOrder = new KeyOrder(Order.LEFT);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder2.getOrder());
				break;
			}
	    }
	    
	    @Test public void getKeyCodeShoot()
	    {
	    	// Space key
	    	int keyCode = 32; 
			iKeyOrder userOrder;
			iKeyOrder testOrder = new KeyOrder(Order.SHOOT);
			switch(keyCode) 
			{
			case KeyEvent.VK_SPACE :
				userOrder = new KeyOrder(Order.SHOOT);
				assertEquals("The Key is functionnal", userOrder.getOrder(),testOrder.getOrder());
				break;
			}
	    }
}