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
    public void checkAnt(Field field, char up) {
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
                    Ant.makeStep(field, ant, 1, 0, dark, right);
                    break;
                } else {
                    Ant.makeStep(field, ant, -1, 0, empty, left);
                    break;
                }
            }
            case (down): {
                if (!isDark) {
                    Ant.makeStep(field, ant, -1, 0, dark, left);
                    break;
                } else {
                    Ant.makeStep(field, ant, 1, 0, empty, right);
                    break;
                }
            }
            case (left): {
                if (!isDark) {
                    Ant.makeStep(field, ant, 0, -1, dark, up);
                    break;
                } else {
                    Ant.makeStep(field, ant, 0, 1, empty, down);
                    break;
                }
            }
            case (right): {
                if (!isDark) {
                    Ant.makeStep(field, ant, 0, 1, dark, down);
                    break;
                } else {
                    Ant.makeStep(field, ant, 0, -1, empty, up);
                    break;
                }

            }
        }
    }

    public Boolean checkIsDark(char i) {

        return (i == this.getDark());
    }
    public boolean checkLimit(Field field) {

        if (y == 0) {
            y = field.getHeight() - 1;
            return true;
        } else if (x == 0) {
            x = field.getLenght() - 1;
            return true;
        } else if (x == field.getLenght() - 1) {
            x = 0;
            return true;
        } else if (y == field.getHeight() - 1) {
            y = 0;
            return true;
        }
        return false;
    }
    public void changePosition(char position, Field field) {
        field.getField()[y][x] = position;
        this.position = position;
    }
    public static void makeStep(Field field, Ant ant, int changeX, int changeY, char newCharOnPosition, char newCharOnAnt) {
        field.getField()[ant.getY()][ant.getX()] = newCharOnPosition;//или empty
        if (!ant.checkLimit(field)) {
            ant.isDark = ant.checkIsDark(field.getField()[ant.getY() + changeY][ant.getX() + changeX]);
            ant.setX(ant.getX() + changeX);// или -1
            ant.setY(ant.getY() + changeY);
        }
        ant.changePosition(newCharOnAnt, field);//или лефт
    }
}
