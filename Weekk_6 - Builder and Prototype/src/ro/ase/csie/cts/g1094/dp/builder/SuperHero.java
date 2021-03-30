package ro.ase.csie.cts.g1094.dp.builder;

public class SuperHero {
	String name;
	int lifePoints;
	boolean isVillain;
	boolean isWounded;
	
	WeaponInterface leftWeapon;
	WeaponInterface rightWeapon;
	
	String superPower;
	String superSuperPower; 
	
	private SuperHero() {
		
	}

	public SuperHero(String name, int lifePoints, boolean isVillain, boolean isWounded, WeaponInterface leftWeapon,
			WeaponInterface rightWeapon, String superPower, String superSuperPower) {
		super();
		this.name = name;
		this.lifePoints = lifePoints;
		this.isVillain = isVillain;
		this.isWounded = isWounded;
		this.leftWeapon = leftWeapon;
		this.rightWeapon = rightWeapon;
		this.superPower = superPower;
		this.superSuperPower = superSuperPower;
	}
	
	public static class SuperHeroBuilder {
		private SuperHero superhero = null;
		
		public SuperHeroBuilder(String name, int lifePoints) {
			superhero = new SuperHero();
			superhero.name = name;
			superhero.lifePoints = lifePoints;
		}
		
		public SuperHeroBuilder isVillain() {
			superhero.isVillain = true;
			return this;
		}
		
		public SuperHeroBuilder isWounded() {
			superhero.isVillain = true;
			return this;
		}
	}
}
