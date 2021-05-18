//H.M.S.S.B.HERATH
//2019582
//W1790114
public class Main {

    public static void main(String[] args) {


        Console appSession = new Console();// Start the programme

        appSession.welcomeMessage();// displaying  welcome message

        String menuChoice = appSession.menuList();// loading main menu
        // Keep running the User selections until exit

        while (!menuChoice.equals("q")) {
            if ("1".equals(menuChoice)) {
                System.out.println("\n press 1 to Load flow network data from .txt file:\n-------------------------");
                appSession.loadFileOption();
            } else if ("2".equals(menuChoice)) {
                System.out.println("\npress 2 to Calculate the Maximum Flow:\n-------------------------");
                appSession.maxFlowOption();
            }
            else {
                System.out.println("\nInvalid input!");
            }
            menuChoice = appSession.menuList();

        }

        System.out.println("\nYour programme has ended. ");// programme exit massage
    }
}
