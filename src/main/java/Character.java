abstract class Character implements Combatant {
    // 🗒️ PROPIEDADES
    protected String name;
    protected int health;
    protected Status status;

    // 🏗️ CONSTRUCTOR
    protected Character(String name, int health) {
        this.name = name;
        this.health = health;
        // el status inicial debe ser siempre REGULAR
        this.status = Status.REGULAR;
    }

    

    @Override
    public void receiveDamage(int damage) {
        this.health -= damage;
        if(this.health <= 0){
            this.health = 0;
            this.status = Status.DEAD;
        }
    }

    @Override
    public boolean isAlive() {
        if(this.health > 0){
            return true;
        }
        return false;
    }

    @Override
    public int getCurrentHealth() {
        return this.health;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getStatus() {
        if(this.isAlive() == false){
            return "DEAD";
        }
        return this.status.name();
    }
}