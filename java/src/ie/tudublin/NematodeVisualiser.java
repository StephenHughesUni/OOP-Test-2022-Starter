package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	int choice = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();		
		
		loadNematodes();
		displayNematode();
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for (TableRow r:table.rows())
		{
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}
	}


	// I had capital name in Nematode.java so was not printing csv file
	public void displayNematode()
	{
		for (Nematode n:nematodes)
		{
			System.out.println(n);
		}
	}

	public void drawNematode(int index, float t)
	{
		nematodes.get(choice).render(this, t); // gets the current choice of nematode and renders
	}

	public void draw()
	{	
		//drawArrowRight(30, 50, 50, 50); ignore for now
		drawNematode(choice, map(choice, 0, nematodes.size(),0, 220)); 
	}


	// Arrows for later to change nematoad
	void drawArrowRight(int x, int y, int len, float angle){
		translate(x, y);
		line(0,0,len, 0);
		line(len, 0, len - 8, -8);
		line(len, 0, len - 8, 8);
	  }
}
