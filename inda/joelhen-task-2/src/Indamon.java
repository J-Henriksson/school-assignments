public class Indamon {

    
    private String name;
    private int hp;
    private int defense;
    private int attack;
    private boolean fainted;

    public Indamon(String name, int hp, int defense, int attack, boolean fainted) {
        this.name = name;
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
        this.fainted = fainted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getDefense() {
        return defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getAttack() {
        return attack;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }
    public boolean isFainted() {
        return fainted;
    }

    public void printInfo() {

        System.out.println("INFO");
        System.out.println("Name: " + getName());
        System.out.println("HP: " + getHp());
        System.out.println("Attack value: " + getAttack());
        System.out.println("Defense value: " + getDefense());
        System.out.println("Is fainted: " + isFainted());
    }

    public void attack(Indamon opponent) {
        int attack = getAttack() / opponent.getDefense();
        int opponentAttack = opponent.getAttack() / getDefense();

        while (isFainted() != true && opponent.isFainted() != true) {

            System.out.println("Indamon " +  getName() + " attacked indamon " + opponent.getName() + " for " + attack + " damage!");
            opponent.setHp(opponent.getHp() - attack);
            if (opponent.getHp() <= 0) {
                System.out.println("Indamon " + getName() + " has won!");
                opponent.setFainted(true);
                break;
            }
            System.out.println("Indamon " + opponent.getName() + " has " +  opponent.getHp() + " hp left!");

            System.out.println("Indamon " +  opponent.getName() + " attacked indamon " + getName() + " for " + opponentAttack + " damage!");
            setHp(getHp() - opponentAttack);
            if (getHp() <= 0) {
                System.out.println("Indamon " + opponent.getName() + " has won!");
                setFainted(true);
                break;
            }
            System.out.println("Indamon " + getName() + " has " +  getHp() + " hp left!");

        }
    }

    public static void main(String[] args) {
        Indamon glassey = new Indamon("Glassey", 10, 5, 5, false);
        Indamon gregory = new Indamon("Gregory", 5, 5, 9, false);
        Indamon steven = new Indamon("Steven", 20, 10, 1, false);

        glassey.printInfo();
        gregory.printInfo();        
        steven.printInfo();

        glassey.attack(gregory);
        
    }
}