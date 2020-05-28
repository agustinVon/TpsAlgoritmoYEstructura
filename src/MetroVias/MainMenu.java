package MetroVias;

import java.util.Random;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Random rand=new Random();
        Scanner scn=new Scanner(System.in);

        Finances globalFinances=new Finances(1);
        Clock clock=new Clock();
        TimeCounter globalTimeCounter=new TimeCounter();
        StationStack stationStack= new StationStack();

        System.out.println("Set amount of windows: ");
        int amountOfWindows = scn.nextInt(); //can get in trouble with nextint check later
        if(amountOfWindows>25||amountOfWindows<5){
            throw new RuntimeException("Amount of windows isn't available");
        }
        WindowPost[] windows=new WindowPost[amountOfWindows];
        for (int i = 0; i < windows.length; i++) {
            windows[i]=new WindowPost(new TimeCounter(),new Finances(1));
        }

        while(true){
            System.out.println("Menu: ");
            System.out.println("1. Pass 30 seconds");
            System.out.println("2. End program");
            System.out.println("3. Give report");

            int option = scn.nextInt();
            switch (option){
                case 1:
                    for (int i = 0; i < windows.length; i++) {
                        windows[i].process(globalTimeCounter,globalFinances,stationStack,clock);
                    }
                    for (int i = 0; i < 5; i++) {
                        Person person= new Person(clock);
                        windows[rand.nextInt(windows.length)].addPpl(person);
                    }
                    clock.advanceTime();
                    break;
                case 2:
                    showStack(stationStack);
                    System.out.println("Global information: ");
                    System.out.println("Total people processed: "+ stationStack.getSize());
                    System.out.println("Mean of global time: "+ globalTimeCounter.getMeanOfTime());
                    System.out.println("Total earnings: "+globalFinances.getEarnings());
                    System.out.println("Information of each window");
                    for (int i = 0; i < amountOfWindows; i++) {
                        System.out.println("\n");
                        int toShow=i+1;
                        System.out.println("Window number: "+ toShow);
                        System.out.println("Mean of time: " + windows[i].getMeanTime());
                        System.out.println("Earnings: "+windows[i].getEarnings());
                    }
                    System.exit(0);
                    break;
                case 3:
                    System.out.println("Global information: ");
                    System.out.println("Total people processed: "+ stationStack.getSize());
                    System.out.println("Mean of global time: "+ globalTimeCounter.getMeanOfTime());
                    System.out.println("Total earnings: "+globalFinances.getEarnings());
                    System.out.println("\n Information of each window");
                    System.out.println("Choose window to inspect");
                    int selection = scn.nextInt();
                    System.out.println("Mean of time: " + windows[selection-1].getMeanTime());
                    System.out.println("Earnings: "+windows[selection-1].getEarnings());
            }
        }
    }

    private static void showStack(StationStack stationStack) {
    }
}
