public class Echiquier {

    private Cellule[][] echiquier;
    private int taille;

    private int nbReine = 0;

    private char libre = '-';
    private char reine = 'R';
    private char menacee= '*';

    public Echiquier (int taille){

        this.taille = taille;
        echiquier = new Cellule[taille][taille];
        initialiserEchiquier();

    }

    public void initialiserEchiquier(){

        for (int x = 0; x < taille; x++){
            for (int y = 0; y < taille; y++){
                echiquier[x][y] = new Cellule(x, y, libre);
            }
        }
    }

    public void placerReine(int x, int y){
        if (echiquier[x][y].getTypeOccupation() == libre) {
            echiquier[x][y].setTypeOccupation(reine);
            nbReine++;
            for (int X = 0; X < taille; X++) {
                if (echiquier[X][y].getTypeOccupation() != reine) {
                    echiquier[X][y].setTypeOccupation(menacee);
                }
            }
            for (int Y = 0; Y < taille; Y++) {
                if (echiquier[x][Y].getTypeOccupation() != reine) {
                    echiquier[x][Y].setTypeOccupation(menacee);
                }
            }

            boolean a = false;
            boolean b = false;
            boolean c = false;
            boolean d = false;
            int X = x;
            int Y = y;
            while (a == false) {
                if (X < 0 || Y < 0) {
                    a = true;
                } else {
                    if (echiquier[X][Y].getTypeOccupation() != reine) {
                        echiquier[X][Y].setTypeOccupation(menacee);
                    }
                    X = X - 1;
                    Y = Y - 1;
                }
            }
            X = x;
            Y = y;
            while (b == false) {
                if (X < 0 || Y == taille) {
                    b = true;
                } else {
                    if (echiquier[X][Y].getTypeOccupation() != reine) {
                        echiquier[X][Y].setTypeOccupation(menacee);
                    }
                    X = X - 1;
                    Y = Y + 1;
                }
            }
            X = x;
            Y = y;
            while (c == false) {
                if (X == taille || Y < 0) {
                    c = true;
                } else {
                    if (echiquier[X][Y].getTypeOccupation() != reine) {
                        echiquier[X][Y].setTypeOccupation(menacee);
                    }
                    X = X + 1;
                    Y = Y - 1;
                }
            }
            X = x;
            Y = y;
            while (d == false) {
                if (X == taille || Y == taille) {
                    d = true;
                } else {
                    if (echiquier[X][Y].getTypeOccupation() != reine) {
                        echiquier[X][Y].setTypeOccupation(menacee);
                    }
                    X = X + 1;
                    Y = Y + 1;
                }
            }
        }
        else if (echiquier[x][y].getTypeOccupation() == reine) {
            System.out.println("Case déjà prise par une reine");
        }
        else if (echiquier[x][y].getTypeOccupation() == menacee){
            System.out.println("Case menacée par une reine");
        }
        else {
            System.out.println("Error placement");
        }
    }

    public void optimiserReine(){
        int memoryX = 0;
        int memoryY = 0;
        boolean stop = false;
        int compteur = 0;
        int memoryCompteur = taille*taille;
        int check = 0;
        //int debug = 0;
        while (stop == false) {
            for (int x = 0; x < taille; x++) {
                for (int y = 0; y < taille; y++) {
                    if (echiquier[x][y].getTypeOccupation() == libre) {
                        for (int X = 0; X < taille; X++) {
                            if (X != x) {
                                if (echiquier[X][y].getTypeOccupation() != menacee) {
                                    compteur++;
                                }
                            }
                        }
                        for (int Y = 0; Y < taille; Y++) {
                            if (Y != y) {
                                if (echiquier[x][Y].getTypeOccupation() != menacee) {
                                    compteur++;
                                }
                            }
                        }
                        boolean a = false;
                        boolean b = false;
                        boolean c = false;
                        boolean d = false;
                        int X = x;
                        int Y = y;
                        while (a == false) {
                            if (X < 0 || Y < 0) {
                                a = true;
                            } else {
                                if (X == x && Y == y) {
                                    if (echiquier[X][Y].getTypeOccupation() != menacee) {
                                        compteur++;
                                    }
                                }
                                X = X - 1;
                                Y = Y - 1;
                            }
                        }
                        X = x;
                        Y = y;
                        while (b == false) {
                            if (X < 0 || Y == taille) {
                                b = true;
                            } else {
                                if (X == x && Y == y) {
                                    if (echiquier[X][Y].getTypeOccupation() != menacee) {
                                        compteur++;
                                    }
                                }
                                X = X - 1;
                                Y = Y + 1;
                            }
                        }
                        X = x;
                        Y = y;
                        while (c == false) {
                            if (X == taille || Y < 0) {
                                c = true;
                            } else {
                                if (X == x && Y == y) {
                                    if (echiquier[X][Y].getTypeOccupation() != menacee) {
                                        compteur++;
                                    }
                                }
                                X = X + 1;
                                Y = Y - 1;
                            }
                        }
                        X = x;
                        Y = y;
                        while (d == false) {
                            if (X == taille || Y == taille) {
                                d = true;
                            } else {
                                if (X == x && Y == y) {
                                    if (echiquier[X][Y].getTypeOccupation() != menacee) {
                                        compteur++;
                                        //System.out.println(compteur);
                                    }
                                }
                                X = X + 1;
                                Y = Y + 1;
                            }
                        }
                        if (compteur < memoryCompteur) {
                            memoryCompteur = compteur;
                            memoryX = x;
                            memoryY = y;
                        }
                        //System.out.println(compteur);
                        compteur = 0;
                    }
                }
            }
            //System.out.println("Coordonnées choisie");
            //System.out.println(memoryX);
            //System.out.println(memoryY);
            placerReine(memoryX, memoryY);
            memoryCompteur = taille*taille;

            for (int x = 0; x < taille; x++){
                for (int y = 0; y < taille; y++){
                    if (echiquier[x][y].getTypeOccupation() == libre){
                        check++;
                    }
                }
            }
            if (check == 0){
                stop = true;
            }
            else {
                check = 0;
            }
            /*debug++;
            if (debug == 4){
                stop = true;
            }*/
        }
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < taille; i++){
            for (int j = 0; j < taille; j++){
                s = s + echiquier[j][i].getTypeOccupation();
            }
            s = s + "\n";
        }
        s = s + "Nombre de reine présente sur l'échiquier :" + nbReine + "\n";
        return s;
    }


}
