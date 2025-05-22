package utils;

public class ZipUtils {

    public static String gjejQytetinNgaZip(String zip) {
        return switch (zip) {
            case "10000" -> "Prishtinë";
            case "40000" -> "Mitrovicë";
            case "30000" -> "Pejë";
            case "50000" -> "Gjakovë";
            case "20000" -> "Prizren";
            case "70000" -> "Ferizaj";
            case "60000" -> "Gjilan";
            case "42000" -> "Vushtrri";
            case "11000" -> "Podujevë";
            case "23000" -> "Suharekë";
            case "21000" -> "Rahovec";
            case "24000" -> "Malishevë";
            case "13000" -> "Drenas (Gllogoc)";
            case "72000" -> "Shtime";
            case "12000" -> "Fushë Kosovë";
            case "60500" -> "Kamenicë";
            case "51000" -> "Deçan";
            case "31000" -> "Istog";
            case "22000" -> "Dragash";
            case "41000" -> "Skenderaj";
            case "71000" -> "Kaçanik";
            case "32000" -> "Klina";
            case "14000" -> "Obiliq";
            case "15000" -> "Lipjan";
            case "61000" -> "Viti";
            default -> null;
        };
    }

}
