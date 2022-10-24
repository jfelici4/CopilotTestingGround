import javax.swing.*;

public class Main {
    static int level = 1;
    static int globalXP = 0;
    public static void main(String[] args) {
        createCharacter();
    }

    public static void levelup(int xp) {
        globalXP += xp;
        while (globalXP >= 100) {
            globalXP -= 100;
            level++;
        }
        System.out.println("You are level " + level + " with " + globalXP + " xp left over.");
    }

    public static void encounter() {
        fight();
    }

    public static void createCharacter() {
        String name = JOptionPane.showInputDialog("What is your name?");
        System.out.println("Hello " + name + "!");
        int xp = Integer.parseInt(JOptionPane.showInputDialog("How much xp do you have?"));
        levelup(xp);
        explore();
    }
    public static void explore() {
        int chance = (int) (Math.random() * 100);
        if (chance < 50) {
            System.out.println("You found nothing.");
            levelup(10);
            explore();
        } else {
            encounter();
        }
    }

    public static void fight() {
        int chance = (int) (Math.random() * 100);
        if (chance < 75) {
            System.out.println("You have defeated the " + generateName() + "!");
            levelup((int) (Math.random() * 100));
            encounter();
        } else {
            System.out.println("You have been defeated by the " + generateName() + "!");
            System.out.println("Level: " + level);
            System.out.println("Xp: " + (((level-1) * 100) + globalXP));
        }
    }

    public static String generateName(){
        String[] names = {"Ooze", "Skeleton", "Evil Villager", "Goblin", "Orc", "Troll", "Giant", "Dragon", "Demon", "Dark God"};
        String[] adjectives = {"Evil", "Angry", "Hungry", "Scary", "Crazy", "Furious", "Ferocious", "Frightening", "Terrifying", "Deadly"};
        return adjectives[(int) (Math.random() * 10)] + " " + names[(int) (Math.random() * 10)];
    }
}