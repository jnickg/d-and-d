package net.jnickg.dnd;

/** Jonny's piece of the project for now
 * 	splitting this up by info
 * 	
 * 	This Class manages information about the 
 * 	players class.
 */
public class PlayerClass {
	
	
	
	//Class specific info
	private enum pClass{
		
		BARBARIAN(12, "barbarian"){
			
		},

		BARD(6, "bard"){
			
		},
		
		CLERIC(8, "cleric"){
			
		},
		
		DRUID(8, "druid"){
			
		},
		
		FIGHTER(10, "fighter"){
			
		},
		
		MONK(8, "monk"){
			
		},
		
		PALADIN(10, "paladin"){
			
		},
		
		RANGER(8, "ranger"){
			
		},
		
		ROGUE(6, "rogue"){
			
		},
		
		SORCERER(4, "sorcerer"){
			
		},
		
		WIZARD(4, "wizard"){
			
			
		};
		
		//vars 
		private int hd;
		private String name;
		private int xp = 0;
		
		//constructor for class enum
		private pClass(int hd, String name){ //hitdie, name
			this.hd = hd;
			this.name=name;
		}
		
		public int getHD() {
			return hd;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getXP(){
			return this.xp;
		}
	}

	//Members of a class
	public pClass pclass;
	
	//Class Constructor
	PlayerClass(String pc){
		pc.toUpperCase();
		pClass pcl = pClass.valueOf(pc);
		this.pclass = pcl;
	}
	
	public int getDie(){
		return pclass.getHD();
	}
	
	//level up functionality
	public void LevelUp(){
	}
	
	public String getName(){
		return pclass.getName();
	}
	
	public int getXP(){
		return pclass.getXP();
	}
	
	public void addXP(int amnt){
		pclass.xp +=amnt;
	}


}

