package enhanced_switch;

import org.junit.jupiter.api.Test;

/**
 * @author : Lex Yu
 * @date : 05/05/2023
 */
public class TestSwitch {

    @Test
    public void runSwitchExample(){
        String str = "D";
        runSwitch(str);
    }

    @Test
    public void superSwitchExample(){
        String str = "D";
        superSwitch(str);
    }

    // Enhanced
    private void superSwitch(String str){
        switch (str) {
            case "A", "B", "C" -> System.out.println("superSwitch => This is A,B, and C");
            case "D", "E" -> System.out.println("superSwitch => This is D and E");
            default -> System.out.println("superSwitch => This is default.");
        }
    }

    // Original
    private void runSwitch(String str){
        switch (str){
            case "A":
            case "B":
            case "C":
                System.out.println("runSwitch => This is A,B, and C");
//                break;
            case "D":
            case "E":
                System.out.println("runSwitch => This is D and E");
//                break;
            default:
                System.out.println("runSwitch => This is default.");
        }
    }
}
