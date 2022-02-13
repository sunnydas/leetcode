public class Trial {

    public static void main(String[] args) {
        double oldSubPrice = 823.0d;
        double oldSubDays = 480d;
        double newSubPrice = 699d;
        double newSubDays = 30d;
        double remainingDays = 480d;

        double val = Math.ceil( (oldSubPrice / oldSubDays) / (newSubPrice / newSubDays)  * remainingDays );
        System.out.println(val);

    }


}
