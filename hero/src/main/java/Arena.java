import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    public int width;
    public int height;
    Hero hero = new Hero(10,10);
    private final List<Wall> walls;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
    }

    private boolean canHeroMove(Position position) {
        if((position.x >= 0 && position.x < width) && (position.y >= 0 && position.y < height)) {
            for(Wall wall : walls)
                if(wall.getPosition().equals(position)) return false;
            return true;
        }
        return false;
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
        if (key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
    }

    private void moveHero(Position position) {
        if(canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for(int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }
        for(int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#428385"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for(Wall wall : walls) wall.draw((graphics));

    }
}
