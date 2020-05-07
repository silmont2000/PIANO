package code;
//import java.io.File;
//import java.io.IOException;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.event.KeyEvent;
import java.io.File;

public class music_player {

    String name;

    music_player(KeyEvent e) {
        int num = num_convert(e);
        name = "src/music_piece/music (" + num + ").mp3";
        player_action();
    }

    private void player_action() {
        final JFXPanel fxPanel = new JFXPanel();
        Media media = new Media(new File(name).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

    private int num_convert(KeyEvent e) {
        int num = e.getKeyCode();
        if (num >= 48 && num <= 57) num -= 47;
        else if (num >= 65 && num <= 90) num -= 54;
        else if (num >= 96 && num <= 126) num -= 59;
        else if (num >= 186 && num <= 192) num -= 118;
        else if (num >= 219 && num <= 222) num -= 144;
        else num = 79;

        return num;
    }
}
