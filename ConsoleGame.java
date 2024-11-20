import java.util.Scanner;

interface Player {
    void setName(String name);
    String getName();
}

interface GameMode {
    void selectMode(int mode);
    String getMode();
}

interface Startable {
    void startGame();
}

public class ConsoleGame implements Player, GameMode, Startable {
    private String name;
    private String mode;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void selectMode(int mode) {
        this.mode = (mode == 1) ? "Story" : "Survival";
    }

    @Override
    public String getMode() {
        return mode;
    }

    @Override
    public void startGame() {
        System.out.println("Starting the game, " + name + "...");
    }

    public static void main(String[] args) {
        ConsoleGame game = new ConsoleGame();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        game.setName(scanner.nextLine());

        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
        int mode = scanner.nextInt();
        game.selectMode(mode);

        System.out.println("You selected " + game.getMode() + " mode.");
        System.out.println("Press P to start playing, " + game.getName() + ".");

        scanner.nextLine();
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("P")) {
                game.startGame();
                break;
            } else {
                System.out.println("Invalid input. Press P to start.");
            }
        }
    }
}
