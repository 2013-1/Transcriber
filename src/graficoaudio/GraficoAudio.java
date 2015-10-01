package graficoaudio;

import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 *
 * @author Carlos
 */
public class GraficoAudio extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Midia");
        // Indica um filtro de extensão de arquivos
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio wav", "*.wav"),
                new FileChooser.ExtensionFilter("Todos os arquivos", "*.*")
        );
        // Abre o seletor de arquivos
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                //Media media = new Media(file.toURI().toURL().toString());
                //MediaPlayer mediaPlayer = new MediaPlayer(media);
                //mediaPlayer.setAutoPlay(true);
                JFrame frame = new JFrame("Waveform Display Simulator"); // cria um JFrame
                frame.setBounds(200, 200, 500, 350); // define tamanho
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file))); // cria um objeto AudioInputStream
                WaveformPanelContainer container = new WaveformPanelContainer(); // cria um objeto WaveformPanelContainer
                container.setAudioToDisplay(audioInputStream); // passa o AudioInputStream como parametro para o setAudioToDisplay de WaveformPanelContainer
                frame.getContentPane().setLayout(new BorderLayout());
                frame.getContentPane().add(container, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.show();
                frame.validate();
                frame.repaint();
            } catch (MalformedURLException ex) {
                ex.printStackTrace(System.out);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (UnsupportedAudioFileException | IOException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
