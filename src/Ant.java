import java.util.concurrent.ScheduledExecutorService;

public class Ant {
    private final char darkUp = '↑';
    private final char darkDown = '↓';
    private final char darkLeft = '←';
    private final char darkRight = '→';
    private final char up = 'ᐃ';
    private final char down = 'ᐁ';
    private final char left = 'ᐊ';
    private final char right = 'ᐅ';
    private final char empty = '□';
    private final char dark = '■';
    private int x;
    private int y;
    char position;

    public Ant(int x, int y) {

        this.x = x;
        this.y = y;
        this.position = up;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void checkAnt(Field field, char up, int x, int y) {
        if (this.x < field.getLenght() || this.y < field.getHeight()) {
            System.out.println("Муравей размещен");
        } else {
            System.out.println("Разместить муравья не удалось измените положение");
        }
    }

    public void moveAnt(Field field, Ant ant) {
        if (this.position==up) {
            field.getField()[x][y] = dark;
            ant.position = darkRight;
            ant.setX(x+1);
        }
        if (this.position==darkRight) {

        }
    }

}
// □'\u25A1'
// ■  \u25a0
//ᐅ \u1405
//        ᐊ \u140a
//        ᐁ\u1401
//        ᐃ \u1403
//        ↑ ↓ → ←