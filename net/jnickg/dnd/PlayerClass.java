package net.jnickg.dnd;

public class PlayerClass {
	
	
	//Class specific info
	public enum pClass{
		BARBARIAN{
			
			//Dice used for hit points
			Integer hitDie = 12;
			
		},

		BARD{
			//Dice used for hit points
			Integer hitDie = 6;
			
		},
		
		CLERIC{
			//Dice used for hit points
			Integer hitDie = 8;
			
		},
		
		DRUID{
			//Dice used for hit points
			Integer hitDie = 8;
			
		},
		
		FIGHTER{
			//Dice used for hit points
			Integer hitDie = 10;
		},
		
		MONK{
			//Dice used for hit points
			Integer hitDie = 8;
			
		},
		
		PALADIN{
			//Dice used for hit points
			Integer hitDie = 10;
			
		},
		
		RANGER{
			//Dice used for hit points
			Integer hitDie = 8;
			
		},
		
		ROGUE{
			//Dice used for hit points
			Integer hitDie = 6;
			
		},
		
		SORCERER{
			//Dice used for hit points
			Integer hitDie = 4;
			
		},
		
		WIZARD{
			//Dice used for hit points
			Integer hitDie = 4;
			
		};
	}
	
	public pClass pclass;
	
	//Constructor
	PlayerClass(String pc){
		pc.toUpperCase();
		pClass pcl = pClass.valueOf(pc);
		this.pclass = pcl;
	}
	
	
	//level up functionality
	public void LevelUp(){
	}


}

