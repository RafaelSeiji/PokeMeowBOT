import java.awt.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This is a Discord AutoTyper
 *
 * @author Jonathan Wiggins
 * @version 10/10/2019
 */
public class TypeAPhrase {
    /**
     * An example of how to use this bot
     * Creates a new Typer with some settings and runs it
     */
    public static void main(String[] args) {
        String[] phrases = new String[]{";p",";s b 1 100",";s b 2 50",";s b 3 20",";s b 4 1",";events buy 2 10",";r d"};
        long timesToRun = Long.MAX_VALUE;
        long timeOut = 3000;
        long startTimeout = 5000;
        boolean printStatus = true;
        boolean randomOrder = true;


        Typer typer = new Typer(phrases, timesToRun, timeOut, startTimeout, printStatus, randomOrder);

        try {
            typer.run();
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Typer {
    private String[] phrases;
    private long startTimeout;
    private long timesToRun;
    private long sleepTimeout;
    private boolean printStatus;
    private boolean randomOrder;
    private Random rng;


    /**
     * Creates a new Typer
     *
     * @param phrase a single phrase to type
     * @param timesToRun The number of times to type a phrase (0 or Long.MAX_Value for infinity)
     * @param sleepTimeout The number of milliseconds to sleep between phrases
     * @param startTimeout The number of milliseconds to sleep after running
     * @param printStatus Prints status after each printing and when completed if true
     */
    public Typer(String phrase, long timesToRun, long sleepTimeout, long startTimeout, boolean printStatus) {
        this.phrases = new String[]{phrase};
        this.timesToRun = timesToRun;
        this.printStatus = printStatus;
        this.sleepTimeout = sleepTimeout;
        this.randomOrder = false;
        this.startTimeout = startTimeout;

        formatPhrases();
    }

    /**
     * Creates a new Typer
     *
     * @param phrases a single phrase to type
     * @param timesToRun The number of times to type a phrase (0 or Long.MAX_Value for infinity)
     * @param sleepTimeout The number of milliseconds to sleep between phrases
     * @param startTimeout The number of milliseconds to sleep after running
     * @param printStatus Prints status after each printing and when completed if true
     * @param randomOrder Types the phrases iteratively if false, randomly if false
     */
    public Typer(String[] phrases, long timesToRun, long sleepTimeout, long startTimeout, boolean printStatus, boolean randomOrder) {
        this.phrases = phrases;
        this.sleepTimeout = sleepTimeout;
        this.timesToRun = timesToRun;
        this.printStatus = printStatus;
        this.randomOrder = randomOrder;
        this.startTimeout = startTimeout;

        if (this.randomOrder)
            this.rng = new Random();

        formatPhrases();
    }

    /**
     * Ensures that each phrase in this.phrases ends with "\n"
     */
    private void formatPhrases(){
        for (int index = 0; index < this.phrases.length; index++){
            if (!this.phrases[index].endsWith("\n"))
                this.phrases[index] = this.phrases[index] + "\n";
        }
    }
    public int[] scan(Scanner sc, int[] pb)throws AWTException, InterruptedException{
        System.out.println("POKEBOLAS: ");
        try {
            //sc.next();
            sc.next();
            pb[0] = sc.nextInt();//poke
            sc.next();
            sc.next();
            pb[2] = sc.nextInt();//ultra
            sc.next();
            pb[1] = sc.nextInt();//great
            sc.next();
            sc.next();
            pb[4] = sc.nextInt();//master
            sc.next();
            pb[3] = sc.nextInt();//premier
        }catch(InputMismatchException e){}
        int i;
        for(i=0;i<5;i++){
            System.out.println(pb[i]);
        }
        return pb;
    }

    /***
     * Runs this typer
     *
     * @throws AWTException if a keyboard typer cannot be created
     * @throws InterruptedException if the thread cannot sleep
     */
    public void run() throws AWTException, InterruptedException {
        int timesRun = 0;
        Keyboard keyboard = new Keyboard();
        Mouse mouse = new Mouse();
        Scanner sc = new Scanner(System.in);
        int aux = 1;
        int[] pb = new int[5];
        scan(sc,pb);
        Thread.sleep(this.startTimeout);

        while (this.timesToRun == 0 || this.timesToRun == Long.MAX_VALUE || timesRun < this.timesToRun) {
            String nextPhrase = this.phrases[0];
           keyboard.type(nextPhrase);
           try{
               Thread.sleep(2000);
           }catch(InterruptedException e){}
           mouse.wheel();
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}
            aux = Cor.setClick(Cor.cor(385,600));
            System.out.println(aux);

            if (aux == 1) {//common/uncommon
                mouse.click(395, 725);
                pb[0]--;
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
                if(pb[0] < 2){
                    keyboard.type(this.phrases[1]);
                    pb[0]+=100;
                }
            } else if (aux == 2) {//rare
                mouse.click(440, 725);
                pb[1]--;
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
                if(pb[1] < 2){
                    keyboard.type(this.phrases[2]);
                    pb[1]+=50;
                }
            } else if (aux == 3) {//super rare
                mouse.click(485, 725);
                pb[2]--;
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
                if(pb[2] < 2){
                    keyboard.type(this.phrases[3]);
                    pb[2]+=20;
                }
            } else if (aux == 4) {//legendary
                pb[3]--;
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
                mouse.click(530, 725);
            } else if (aux == 5) {//shiny/mythic
                pb[4]--;
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
                mouse.click(575, 725);
                if(pb[4] < 2){
                    keyboard.type(this.phrases[4]);
                    pb[4]++;
                }
            }else{//captcha
                String s = sc.nextLine();
                if(s.equals("stop")||s.equals(("exit"))) return;
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){}
            }
            if(timesRun%100==0&&timesRun>0){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
                keyboard.type(this.phrases[6]);
            }
            Random r = new Random();
            int haha = r.nextInt(1342);
            try{
                Thread.sleep(haha);
            }catch(InterruptedException e){}

            if (printStatus)
                System.out.println("Count: " + timesRun + "\tTyped: " + nextPhrase);
            timesRun++;
            Thread.sleep(this.sleepTimeout);
        }
        if (printStatus)
            System.out.println("Completed");
    }
}
