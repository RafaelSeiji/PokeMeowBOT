import java.awt.*;
public class Cor {
    private static Color common = new Color(8,85,251);
    private static Color uncommon = new Color(19,180,231);
    private static Color rare = new Color(251,137,8);
    private static Color sr = new Color(248,244,7);
    private static Color legendary = new Color(160,7,248);
    private static Color shiny = new Color(255,153,204);
    private static Color shaymin = new Color(124,252,0);
    private static Color arceus = new Color(255,255,250);
    private static Color darkrai = new Color(0,0,0);
    private static Color bg1 = new Color(54,57,63);
    private static Color bg2 = new Color(50,53,59);
    public static Color cor(int x, int y) throws AWTException {
        Robot bot = new Robot();
        Color c = bot.getPixelColor(x,y);
        System.out.println(c);
        return c;
    }
    public static int setClick(Color c){
        if(c.getRGB() == common.getRGB() || c.getRGB() == uncommon.getRGB()){
            return 1;//poke
        }else if(c.getRGB() == rare.getRGB()){
            return 2;//great
        }else if(c.getRGB() == sr.getRGB()){
            return 3;//ultra
        }else if(c.getRGB() == legendary.getRGB()){
            return 4;//premier
        }else if(c.getRGB() == shiny.getRGB() || c.getRGB() == shaymin.getRGB() || c.getRGB() == arceus.getRGB()
            || c.getRGB() == darkrai.getRGB()){
            return 5;//master
        }else if(c.getRGB() == bg1.getRGB() || c.getRGB() == bg2.getRGB()){
            return 0;//deu ruim
        }
        return 0;
    }
}
