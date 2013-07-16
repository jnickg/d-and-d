package net.jnickg.dnd;

/** Jonny's piece of the project for now
 * 	splitting this up by info
 * 	
 * 	This Class manages information about the 
 * 	players class.
 */
public class PlayerClass {
	
	//Members of a class
	private	static	int	hitdie;
	
	//Class specific info
	public enum pClass{
		
		BARBARIAN(12){
			
		},

		BARD(6){
			
		},
		
		CLERIC(8){
			
		},
		
		DRUID(8){
			
		},
		
		FIGHTER(10){
			
		},
		
		MONK(8){
			
		},
		
		PALADIN(10){
			
		},
		
		RANGER(8){
			
		},
		
		ROGUE(6){
			
		},
		
		SORCERER(4){
			
		},
		
		WIZARD(4){
			
			
		};
		
		private pClass(int hd){
			hitdie = hd;
		}
	}

	public pClass pclass;
	
	//Class Constructor
	PlayerClass(String pc){
		pc.toUpperCase();
		pClass pcl = pClass.valueOf(pc);
		this.pclass = pcl;
	}
	
	public int getDie(){
		return hitdie;
	}
	
	//level up functionality
	public void LevelUp(){
	}


}

