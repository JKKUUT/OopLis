public class Päivämäärä {
    private int päivä;
    private int kuukausi;
    private int vuosi;

    public Päivämäärä(String päivämäärä) throws LaitonPaivaPoikkeus, LaitonKuukausiPoikkeus, LaitonVuosiPoikkeus {
        String[] osat = päivämäärä.split("\\.");

        if (osat.length != 3) {
            throw new LaitonPaivaPoikkeus("Virheellinen päivämäärä: " + päivämäärä);
        }

        try {
            päivä = Integer.parseInt(osat[0]);
            kuukausi = Integer.parseInt(osat[1]);
            vuosi = Integer.parseInt(osat[2]);
        } catch (NumberFormatException e) {
            throw new LaitonPaivaPoikkeus("Virheellinen päivämäärä: " + päivämäärä);
        }

        if (päivä < 1 || päivä > 31) {
            throw new LaitonPaivaPoikkeus("Virheellinen päivä: " + päivä);
        }

        if (kuukausi < 1 || kuukausi > 12) {
            throw new LaitonKuukausiPoikkeus("Virheellinen kuukausi: " + kuukausi);
        }

        if (vuosi < 0) {
            throw new LaitonVuosiPoikkeus("Virheellinen vuosi: " + vuosi);
        }
    }

    public int getPäivä() {
        return päivä;
    }

    public int getKuukausi() {
        return kuukausi;
    }

    public int getVuosi() {
        return vuosi;
    }
}

public class LaitonPaivaPoikkeus extends Exception {
    public LaitonPaivaPoikkeus(String viesti) {
        super(viesti);
    }
}

public class LaitonKuukausiPoikkeus extends Exception {
    public LaitonKuukausiPoikkeus(String viesti) {
        super(viesti);
    }
}

public class LaitonVuosiPoikkeus extends Exception {
    public LaitonVuosiPoikkeus(String viesti) {
        super(viesti);
    }
}