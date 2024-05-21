package devandroid.arthursilvio.appgaseta.apoio;

public class UtilGasEta {
    public static String calculateBestOption(double gas, double etanol) {

        double bestPrice = gas * 0.70;
        String returnMessage;

        if (etanol <= bestPrice) {
            returnMessage = "Abastecer com Etanol";
        } else {
            returnMessage = "Abastecer com Gasolina";
        }

        return returnMessage;
    }
}
