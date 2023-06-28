package Inheritance.P03_RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        randomArrayList.add(20);
        randomArrayList.add(10);
        randomArrayList.add(30);
        randomArrayList.add(50);
        randomArrayList.add(60);
        randomArrayList.add(70);
        randomArrayList.add(80);

        System.out.println(randomArrayList.getRandomElement());
    }
}
