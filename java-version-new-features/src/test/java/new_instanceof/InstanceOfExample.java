package new_instanceof;

import org.junit.jupiter.api.Test;

/**
 * @author : Lex Yu
 * @date : 05/05/2023
 */
public class InstanceOfExample {

    @Test
    public void instanceOfExample1(){
        AbstractFile abstractFile = new MusicFile();
        useInstanceOfOlder(abstractFile);
    }

    @Test
    public void instanceOfExample2(){
        AbstractFile abstractFile = new MusicFile();
        useInstanceOfBetter(abstractFile);
    }

    // New
    private void useInstanceOfBetter(AbstractFile abstractFile){
        if (abstractFile instanceof MusicFile m) {
            m.playMusic();
        }
    }

    // Old
    private void useInstanceOfOlder(AbstractFile abstractFile){
        if (abstractFile instanceof MusicFile) {
            ((MusicFile) abstractFile).playMusic();
        }
    }

}
