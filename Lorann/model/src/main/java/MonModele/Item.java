package MonModele;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Item {
	
	protected int x, y;
	protected Icon image;
	protected ImageIcon source;
	protected String name;
	
	public void setImage(String image)
	{
		this.source = new ImageIcon(image);
		this.image = new ImageIcon(this.source.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));
	}
	
	
	public Icon getImage()
	{
		return this.image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
