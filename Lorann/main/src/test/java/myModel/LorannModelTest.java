package myModel;
/**
 * <h1>CollisionTest JUnit test</h1>
 *
 * @author Bastien Le Gall
 * @version 1.0
 */
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myModel.LorannModel;
/*testing the setLevel method in comparison of a String*/
public class LorannModelTest {
	@Test
	public void test()
	{
		LorannModel test = new LorannModel();  /**creating the LorannModel object which will store our level*/
		/**Storing our level in a String*/
		String stringTest = "AJJJJJJJJJJJJJJJJJAYXYYYYYYYYYYYYYYYYYYAXYAJJJJJJJJJJJJJAYYXXYYYYYYYYYYYYTYYYAYXXYAJJJJJJJJJJJAYYXYXXYXVYYYYYYYYYYYAYXYXXBXYYYYYYYYYYYYAYXYXXYAJJJJJJJJJJJAYYXYXXYWYYYSYYYYYYYYYYAYXXYAJJJJJJJJJJJJJAKYXAAYYYYYYYYYYYYYYYYYAYAJJJJJJJJJJJJJJJJAH";
		/**setting our level using the setLevel method on test object*/
		test.setLevel("AJJJJJJJJJJJJJJJJJAYXYYYYYYYYYYYYYYYYYYAXYAJJJJJJJJJJJJJAYYXXYYYYYYYYYYYYTYYYAYXXYAJJJJJJJJJJJAYYXYXXYXVYYYYYYYYYYYAYXYXXBXYYYYYYYYYYYYAYXYXXYAJJJJJJJJJJJAYYXYXXYWYYYSYYYYYYYYYYAYXXYAJJJJJJJJJJJJJAKYXAAYYYYYYYYYYYYYYYYYAYAJJJJJJJJJJJJJJJJAH");
		assertEquals("Les niveaux sont bien �gaux", stringTest, test.getLevel());/*testing if equal between both variable and object*/
	}
		

}