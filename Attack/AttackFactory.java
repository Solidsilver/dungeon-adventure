package Attack;
import java.util.HashMap;

public class AttackFactory {

	private HashMap<String, IAttack> attackMap = new HashMap<String, IAttack>();
	
	public IAttack getAttack(String attackName) {
		
		IAttack attack = attackMap.get(attackName);
		if(!attackMap.containsValue(attack))
		{
			switch(attackName)
			{
			case "Attack":
				attack = new Attack();
			case "Crushing Blow": 
				attack = new CrushingBlow();
			case "Increase Hit Points":
				attack = new IncreaseHitPoints();
			case "Surprise Attack":
				attack = new SurpriseAttack();
			}
			
			attackMap.put(attackName, attack);
		}
		return attack;
	}
	
	
	
}
