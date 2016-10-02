package example;

import example.ConstantList_KP_4_1;

import pp.PP;
import pp.Unit;

import java.awt.geom.Point2D;

public class Example {

	public static void main(String[] args) {
		// define target position
		Point2D.Float p = new Point2D.Float (100, 100);
		try {
			// create an instance of the Prog&Play API
			PP pp = new PP();
			pp.open(); // open the Prog&Play API
			// iterate all units
			for (int i = 0 ; i < pp.getNumUnits (PP.Coalition.MY_COALITION) ; i++){
				// get current unit
				Unit u = pp.getUnitAt(PP.Coalition.MY_COALITION, i);
				// give a Move order
				u.command(ConstantList_KP_4_1.MOVE, p);
			}
			// close the Prog&Play API
			pp.close();
		} catch (Exception e){
			System.out.println (e.getMessage());
		}
	}

}
