package org.academiadecodigo.codezillas.music;

import org.academiadecodigo.codezillas.Game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WinMusic {

        private boolean playing;

        public boolean isPlaying() {
            return playing;
        }

        public void setPlaying(boolean playing) {
            this.playing = playing;
        }

        public void startWinMusic() {
            setPlaying(true);
            String pathStr = "resources/winmusic.wav";
            URL soundURL;
            AudioInputStream audioInputStream = null;
            try {
                soundURL = Game.class.getResource(pathStr);
                if (soundURL == null) {
                    File file = new File(pathStr);
                    soundURL = file.toURI().toURL();
                }
                audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }