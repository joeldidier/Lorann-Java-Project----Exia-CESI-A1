package MonModele;
/**
 * <h1>The Class WALL_Void</h1>
 *
 * @author Nicolas DRAPIER
 * @version 0.1
 * @see WALL_Wall
 */
public class WALL_Void extends WALL_Wall {

	//IMAGE gate-closed
	private String image = "void.png";
	private int collider = 3;
	public WALL_Void()
	{
		this.setName("void");
		this.setImage(image);
		this.setColliderPermission(this.collider);
	}
}
