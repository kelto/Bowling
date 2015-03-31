package dcll.kelt;

import dcll.kelt.model.Frame.FrameBuilder;
import dcll.kelt.model.Game;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        LinkedList<Character> game = new LinkedList<Character>();
        System.out.println("Enter game description, _ for zero, X for strike and / for spare");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char array[] = line.toCharArray();
        for (Character c : array) {
            game.add(c);
        }

        for (Character ca : game) {
            System.out.print(ca);
        }
        System.out.println();
        FrameBuilder builder = new FrameBuilder(game);

        try {
            Game g = new Game(builder.getFrames());
            System.out.println("Score : " + g.getScore());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
