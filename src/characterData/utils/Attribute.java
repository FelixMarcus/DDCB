package characterData.utils;

public enum Attribute {

	STR,
	DEX,
	CON,
	WIS,
	INT,
	CHA;

	public static int bonus(int attrValue){
		int bonus = (int) Math.floor((attrValue/2)-5);
		return bonus;
	}
}
