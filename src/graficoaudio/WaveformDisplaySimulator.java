package graficoaudio;

import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WaveformDisplaySimulator {

    public static void main(String[] args) {
        try {

            JFrame frame = new JFrame("Waveform Display Simulator"); // cria um JFrame
            frame.setBounds(200, 200, 500, 350); // define 

            File file = new File(args[0]); // abre um arquivo passado como parametro
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
            // cria um objeto AudioInputStream

            WaveformPanelContainer container = new WaveformPanelContainer(); // cria um objeto WaveformPanelContainer
            container.setAudioToDisplay(audioInputStream); // passa o AudioInputStream como parametro para o setAudioToDisplay de WaveformPanelContainer

            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(container, BorderLayout.CENTER);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.show();
            frame.validate();
            frame.repaint();

        } catch (HeadlessException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

}
