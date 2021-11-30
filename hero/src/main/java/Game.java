import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private boolean end_game = false;
    Arena arena;
    TextGraphics graphics;

    Game() {
        try {
            arena = new Arena(50, 20);
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            graphics = screen.newTextGraphics();
            //System.out.println("here executed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') { end_game = true; }
        else if(key.getKeyType() == KeyType.EOF) { end_game = true; }
        else {
            //System.out.println("game class entered");
            arena.processKey(key);
        }
    }

    private void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run(){
        try {
            draw();
            while (!end_game) {
                KeyStroke key = screen.readInput();
                processKey(key);
                draw();
            }
            screen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
