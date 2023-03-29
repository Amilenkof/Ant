public class AntGame {
    int start;

    public AntGame(int start) {
        this.start = start;
    }

    public void runGame() {
        Field field = new Field(50, 50);
        Ant ant = new Ant(20, 20, false);
        Ant ant1 = new Ant(10, 10, false);
        Ant ant2 = new Ant(39, 39, false);
        ant.checkAnt(field, ant.getUp());
        ant1.checkAnt(field, ant.getUp());
        ant2.checkAnt(field, ant.getUp());
        System.out.println();
        for (int i = 0; i < 3000; i++) {
            System.out.println("Итерация " + i);
            ant.moveAnt(field, ant);
            ant1.moveAnt(field, ant1);
            ant2.moveAnt(field, ant2);
            field.printField();
        }
    }

}
