package main;
/**
 * <h1>main JUnit test</h1>
 *	WHEN THE GAME STARTS, ENTER LEVEL "6" (LEVEL iS NOT PRESENT IN THE DATABASE) SO AS
 * TO THROW EXCEPTION
 * @author Bastien Le Gall
 * @version 1.0
 */
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.BeforeClass;
import org.junit.Test;

import myModel.LorannModel;
import myModel.MOVABLEITEM_Ennemy;
import myModel.MOVABLEITEM_Me;
import myModel.levelCheck;
import myView.MainFrame;
import model.Example;
import model.dao.LorannDAO;
import myController.LorannController;

public class MainTest 
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String level;
	}

	

	@Test
	public void mainTest() 
	{
		
		try
		{

				levelCheck levelTester = new levelCheck();
				boolean levelChecker;
				JFrame frame3 = new JFrame("Lorann");
				frame3.setTitle("Lorann");
				String userLevelInput = JOptionPane.showInputDialog(frame3, "Please enter the level number you wish to be loaded (enter 6 to throw Exception as required for this test) : ", "Lorann - Enter the desired level number", JOptionPane.PLAIN_MESSAGE);
				
				if (userLevelInput.equals(null)) 		/** If users closes Input Window, kill the process.*/
				{
					System.out.println("User closed the input window !");

				}
				
		
				int userIntInput = Integer.parseInt(userLevelInput); 		/** Cast user input (String) to Integer*/
				System.out.println("User chose the level number : " + userIntInput);
		
				Example daoReturn;		/** New object of type Example*/
				
				daoReturn=LorannDAO.getLevelMapById(userIntInput);	/** Store answer from MySQL server to daoReturn object*/
				System.out.println("Map String Answer from MySQL server : " + daoReturn);
				
				LorannModel lorannmodel = new LorannModel();		/** Instantiate LorannModel*/
				
				levelChecker = levelTester.check(String.valueOf(daoReturn));
				
				if(levelChecker == true)
				{
					lorannmodel.setLevel(String.valueOf(daoReturn));		/** Assign Answer from Server to level string*/
					lorannmodel.mapCreator(lorannmodel.getLevel());
		
					LorannController loranncontroller = new LorannController(lorannmodel);
					MainFrame lorannview = new MainFrame(loranncontroller,lorannmodel, lorannmodel); /** creating a new MainFrame*/
				

				loranncontroller.setViewSystem(lorannview);
				loranncontroller.play();


					loranncontroller.setViewSystem(lorannview);
					loranncontroller.play();
				}
				else
				{
					/**display error popup when the String received by the database contain invalid characters*/
					JOptionPane.showMessageDialog(null, "Invalid String for DataBase");
					System.out.println("Invalid string"); 
				}

		}
		
		catch (StringIndexOutOfBoundsException e) /**catching error from database's String*/
		{
			e.printStackTrace();
		}
		catch (SQLException e2) /**catching error for the SQL server*/
		{
			e2.printStackTrace();
		}
	}

}
