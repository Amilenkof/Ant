public class Main {
 public static void main(String[] args) {
     Field field = new Field(20, 20);
     field.printField();
     Ant ant = new Ant(10, 8);
     ant.addAnt(field,'ᐃ');
     ant.moveAnt(field,ant);
     field.printField();
 }
    }
