import java.awt.*;
import java.awt.event.InputEvent;

public class Mouse {
    public static void click(int x, int y) throws AWTException {
        Robot bot = new Robot();
        try{Thread.sleep(3000);}catch (InterruptedException e){}
        bot.mouseMove(x, y);
        try{
            Thread.sleep(300);
        }catch(InterruptedException e){}
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public static void wheel() throws AWTException{
        Robot bot = new Robot();
        try{
            Thread.sleep(1500);
        }catch(InterruptedException e){}
        bot.mouseWheel(5);
    }
}
