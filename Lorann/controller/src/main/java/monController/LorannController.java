package monController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import MonModele.INTERFACE_Mobile;
import MonModele.INTERFACE_Model;
import MonModele.Item;
import MonModele.Position;
import MonModele.UserDied;
import maVue.iView;

//A class called LorannController
public class LorannController implements iOrderPerformer
{
	private int TIME_SLEEP = 30;
	private final INTERFACE_Model LorannModel;
	private boolean isGameOver = false;
	private iView viewSystem;
	private int width =20, height = 12;
	private Item hero;
	private char[][] map;
	private MonModele.Direction direction = null;
	
	private MonModele.SPRITE_MeSprite heroSprite = null; 
	
	
	public LorannController(final INTERFACE_Model LorannModel) 
	{
		this.LorannModel = LorannModel;
		this.hero = this.LorannModel.getLorann();
		this.map = this.LorannModel.getMap();
	}
	
	@Override
	public void orderPerform(iKeyOrder keyOrder) 
	{
		
		int posX = this.hero.getPosition().getX();
		int posY = this.hero.getPosition().getY();
		
			
			switch (keyOrder.getOrder())
			{
			case UP:
				
				if (this.map[posY-1][posX] == 'Y')
				{
					this.direction = MonModele.Direction.UP;
					this.hero.setImage("lorann_u.png");
					this.hero.setPosition(
							new Position(
									posX, 
									posY - 1));
				}
				else if (this.map[posY-1][posX] == 'S' || this.map[posY-1][posX] == 'T' || this.map[posY-1][posX] == 'U' || this.map[posY-1][posX] == 'V' || this.map[posY-1][posX] == 'H')
				{
					UserDied dead = new UserDied();
					try {
						dead.UserDiedPopup();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			
			case DOWN:
				if(this.map[posY+1][posX] == 'Y')
				{
				this.direction = MonModele.Direction.DOWN;
				this.hero.setImage("lorann_b.png");
				this.hero.setPosition(
						new Position(
								posX, 
								posY+1));
				}
				else if (this.map[posY+1][posX] == 'S' || this.map[posY+1][posX] == 'T' || this.map[posY+1][posX] == 'U' || this.map[posY+1][posX] == 'V' || this.map[posY+1][posX] == 'H')
				{
					UserDied dead = new UserDied();
					try {
						dead.UserDiedPopup();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			
			case RIGHT:
				if(this.map[posY][posX+1] == 'Y')
				{
				this.direction = MonModele.Direction.RIGHT;
				this.hero.setImage("lorann_r.png");
				this.hero.setPosition(
						new Position(
								posX+1, 
								posY));
				}
				else if (this.map[posY][posX+1] == 'S' || this.map[posY][posX+1] == 'T' || this.map[posY][posX+1] == 'U' || this.map[posY][posX+1] == 'V' || this.map[posY][posX+1] == 'H')
				{
					UserDied dead = new UserDied();
					try {
						dead.UserDiedPopup();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			
			case LEFT:
				if(this.map[posY][posX-1] == 'Y')
				{
				this.direction = MonModele.Direction.LEFT;
				this.hero.setImage("lorann_l.png");
				this.hero.setPosition(
						new Position(
								posX -1, 
								posY));
				}
				else if (this.map[posY][posX-1] == 'S' || this.map[posY][posX-1] == 'T' || this.map[posY][posX-1] == 'U' || this.map[posY][posX-1] == 'V' || this.map[posY][posX-1] == 'H')
				{
					UserDied dead = new UserDied();
					try {
						dead.UserDiedPopup();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case SHOOT:
				try
				{
					this.launchSpell();
				}
				
				catch (final IOException e)
				{
					e.printStackTrace();
				}
				
			case STATIC:
				default:
					this.hero.setImage("crystal_ball.png");
					break;
				
		}
	}
	
	
	public void play()
	{
		this.gameLoop();
		iView.displayMessage("Game Over!");
		iView.exit();
	}
	
	public void setViewSystem(final iView viewSystem)
	{
		this.viewSystem = viewSystem;
	}
	
	public iView getViewSystem()
	{
		return this.viewSystem;
	}
	
	private void launchSpell() throws IOException
	{
		/*if (hero != null)
			
		{
			final Position position = new Position(this.hero.getPosition().getX() + ((this.width - this.spell.getWidthWithADirection(this.hero.getDirection())) / 2),
					hero.getPosition().getY() + ((this.height - this.spell.getHeightWithADirection(this.hero.getDirection())) / 2));
					this.LorannModel.addMobile(new MOVABLEITEM_Spell(this.hero.getDirection(), position));
					switch (hero.getDirection()) 
					{
						case UP:
							position.setY(position.getY() - 48 - this.hero.getSpeed());
							break;
							
						case RIGHT:
							position.setX(position.getX() + 48 + this.hero.getSpeed());
							break;
							
						case DOWN:
							position.setY(position.getY() + 48 + this.hero.getSpeed());
							break;
							
						case LEFT:
							position.setX(position.getX() - 48 - this.hero.getSpeed());
							break;
							
						default:
							break;

					}
		}*/
	}

	private void gameLoop()
	{
		while (!this.isGameOver)
		{
			try 
			{
				Thread.sleep(TIME_SLEEP);
			}
			
			catch (final InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			
			final ArrayList<INTERFACE_Mobile> initialMobiles = new ArrayList<INTERFACE_Mobile>();
			for (final INTERFACE_Mobile mobile : this.LorannModel.getMobiles())
			{
				initialMobiles.add(mobile);
			}
			
			
			this.LorannModel.setMobilesHavedMove();
		}
	}

}
