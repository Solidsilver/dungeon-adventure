package dungeon.characters.monsters;

public class MonsterFactory {
    public Monster createMonster(String type) {
        Monster newMonster;
        type = type.toLowerCase();

        if (type.equals("gremlin")) {
            newMonster = new Gremlin();
        } else if (type.equals("ogre")) {
            newMonster = new Ogre();
        } else if (type.equals("skeleton")) {
            newMonster = new Skeleton();
        } else {
            throw new IllegalArgumentException("Type " + type + " not found");
        }
        return newMonster;
    }
}