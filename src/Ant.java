import java.util.concurrent.ScheduledExecutorService;

public class Ant {

    private final char up = 'ᐃ';
    private final char down = 'ᐁ';
    private final char left = 'ᐊ';
    private final char right = 'ᐅ';
    private final char empty = '□';
    private final char dark = '■';
    private int x;
    private int y;
    char position;
    private boolean isDark;

    public Ant(int x, int y, boolean isDark) {

        this.x = x;
        this.y = y;
        this.position = up;
        this.isDark = isDark;
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

    public char getUp() {
        return up;
    }

    public char getDark() {
        return dark;
    }

    public char getEmpty() {
        return empty;
    }

    public void checkAnt(Field field, char up, int x, int y) {
        if (this.x < field.getLenght() || this.y < field.getHeight()) {
            field.getField()[y][x] = up;
            System.out.println("Муравей размещен");
        } else {
            System.out.println("Разместить муравья не удалось измените положение");
        }
    }

    public void moveAnt(Field field, Ant ant) {

        switch (ant.position) {
            case (up): {
                if (!isDark) {
                    field.getField()[y][x] = dark;
                    ant.checkOverLimitX(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y][x+1]);
                    ant.setX(x + 1);
                    field.getField()[y][x] = right;
                    ant.position = right;
                    break;
                } else {
                    field.getField()[y][x] = empty;
                    ant.checkLowLimitX(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y][x-1]);
                    ant.setX(x - 1);
                    field.getField()[y][x] = left;
                    ant.position = left;
                    break;
                }
            }
            case (down): {
                if (!isDark) {
                    field.getField()[y][x] = dark;
                    ant.checkLowLimitX(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y][x-1]);
                    ant.setX(x - 1);
                    field.getField()[y][x] = left;
                    ant.position = left;
                    break;
                } else {
                    field.getField()[y][x] = empty;
                    ant.checkOverLimitX(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y][x+1]);
                    ant.setX(x + 1);
                    field.getField()[y][x] = right;
                    ant.position = right;
                    break;
                }
            }
            case (left): {
                if (!isDark) {
                    field.getField()[y][x] = dark;
                    ant.checkLowLimitY(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y-1][x]);
                    ant.setY(y - 1);
                    field.getField()[y][x] = up;
                    ant.position = up;
                    break;
                } else {
                    field.getField()[y][x] = empty;
                    ant.checkOverLimitY(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y+1][x]);
                    ant.setY(y + 1);
                    field.getField()[y][x] = down;
                    ant.position = down;
                    break;
                }
            }
            case (right): {
                if (!isDark) {
                    field.getField()[y][x] = dark;
                    ant.checkOverLimitY(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y+1][x]);
                    ant.setY(y + 1);
                    field.getField()[y][x] = down;
                    ant.position = down;
                    break;
                } else {
                    field.getField()[y][x] = empty;
                    ant.checkLowLimitY(field);
                    ant.isDark = ant.checkIsDark(field.getField()[y-1][x]);
                    ant.setY(y - 1);
                    field.getField()[y][x] = up;
                    ant.position = up;
                    break;
                }

            }
        }
    }
    public Boolean checkIsDark ( char i) {
        Ant ant = new Ant(1, 1, false);
        return (i == ant.getDark());}

    public  void checkOverLimitX (Field field) {
        if (x==field.getLenght()-1){
            x = 0;}
    }
    public  void checkOverLimitY (Field field) {
        if (y==field.getHeight()-1){
            y = 0;}
    }
    public  void checkLowLimitY (Field field) {
        if (y==0){
            y = field.getHeight()-1;}
    }

    public  void checkLowLimitX (Field field) {
        if (x==0){
            x = field.getLenght()-1;}
    }
    }



// □'\u25A1'
// ■  \u25a0
//ᐅ \u1405
//        ᐊ \u140a
//        ᐁ\u1401
//        ᐃ \u1403
//        ↑ ↓ → ←