package setlist;

/**
 * Pretty much just loads MainGUI
 */

public class Main {

    public static void main(String[] args) {
        ConfigManager config = new ConfigManager();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                config.writeConfig();
            }
        }));
        //System.out.println(System.getProperty("user.home") + "dddddd");

        //config.setDefaultBreakCount(0);
        //config.setDefaultBreakLength(600);
        //config.setDefaultSetLength(900);
        //config.setLastCatalog("/home/stephen/Music/openmic.setlist");

        System.out.println(config.toString());


        MainGUI.createAndShowGUI(config);
    }
}


