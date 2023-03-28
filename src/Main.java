public class Main {
    public static void main(String[] args) {
        Field field = new Field(5, 5);
        field.printField();
        System.out.println();
        Ant ant = new Ant(2, 2, false);
        for (int i = 0; i < 10; i++) {
            System.out.println("Итерация " + i);
            ant.moveAnt(field, ant);
            field.printField();
        }

    }
}

