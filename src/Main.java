public class Main {
    public static void main(String[] args) {


        Echiquier ech1 = new Echiquier(8);
        //ech1.placerReine(7,6);
        ech1.optimiserReine();
        System.out.println(ech1);

    }
}