package Attack;
import java.io.Serializable;
import java.util.HashMap;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public class AttackFactory implements Serializable {

	private HashMap<String, IAttack> attackMap = new HashMap<String, IAttack>();
	
	public IAttack getAttack(String attackName) {
		
		IAttack attack = attackMap.get(attackName);
		if(!attackMap.containsValue(attack))
		{
			switch(attackName)
			{
			case "Attack":
				attack = new Attack();
				break;
			case "Crushing Blow": 
				attack = new CrushingBlow();
				break;
			case "Increase Hit Points":
				attack = new IncreaseHitPoints();
				break;
			case "Surprise Attack":
				attack = new SurpriseAttack();
				break;
			}
			
			attackMap.put(attackName, attack);
		}
		return attack;
	}
	
	
	
}
