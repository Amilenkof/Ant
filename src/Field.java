public class Field {
    private final int lenght;
    private final int height;
    private char[][] field;

    public Field(int lenght, int height) {
        this.lenght = lenght;
        this.height = height;
        this.field = greateField();
    }

    public int getLenght() {
        return lenght;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getField() {
        return field;
    }

    public char[][] greateField() {

            char[][] field = new char[getHeight()][getLenght()];
        Ant ant = new Ant(1, 1, false);
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getLenght(); j++) {
                    field[i][j] =ant.getEmpty() ;
                }
            }return field;
        }


    public void printField () {
        for (int i = 0; i < getHeight(); i++) {

            for (int j = 0; j < getLenght(); j++) {
                if (j==getLenght()-1) {
                    System.out.print(this.field[i][j]);
                    System.out.println();
                    j = 0;
                    break;
                }
                System.out.print(this.field[i][j]);
            }


            }
            
        }
    }

