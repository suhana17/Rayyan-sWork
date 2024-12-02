import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayer {
    private Clip clip;
    private boolean isPlaying;

    String audioFilePath;

    public MusicPlayer(String audioFilePath) {
        this.audioFilePath = audioFilePath;
        try {
            File audioFile = new File(audioFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            isPlaying = false;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        clip.stop();
        clip.setFramePosition(0);
        isPlaying = false;
    }

    public void playMusic() {
        clip.start();
        if (!(Objects.equals(audioFilePath, "sounds/hurt.wav"))) {
            clip.loop(clip.LOOP_CONTINUOUSLY);
            isPlaying = true;
        } else {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clip.stop();
                }
            }, 1000);
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}