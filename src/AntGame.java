public class AntGame {
    int start;

    public AntGame(int start) {
        this.start = start;
    }

    public void runGame() {
        Field field = new Field(10, 10);
        field.printField();
        System.out.println();
        Ant ant = new Ant(5, 5, false);
        for (int i = 0; i < 300; i++) {
            System.out.println("Итерация " + i);
            ant.moveAnt(field, ant);
            field.printField();
        }
    }

}
