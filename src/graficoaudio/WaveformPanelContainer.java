package graficoaudio;

import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA. User: Jonathan Simon Date: Mar 20, 2005 Time:
 * 5:08:57 PM To change this template use File | Settings | File Templates.
 */
public class WaveformPanelContainer extends JPanel { // herda de JPanel

    private ArrayList singleChannelWaveformPanels = new ArrayList(); // ArrayList para guardar os paineis, um para cada canal de audio
    private AudioInfo audioInfo = null;

    public WaveformPanelContainer() {
        setLayout(new GridLayout(0, 1)); // seleciona o layout do JPanel
    }

    public void setAudioToDisplay(AudioInputStream audioInputStream) {
        singleChannelWaveformPanels = new ArrayList(); // cria o ArrayList
        audioInfo = new AudioInfo(audioInputStream); // cria um novo AudioInfo
        for (int t = 0; t < audioInfo.getNumberOfChannels(); t++) { // para t de 0 ate o numero de canais do audio faca
            SingleWaveformPanel waveformPanel = new SingleWaveformPanel(audioInfo, t);  // cria o painel do canal t
            singleChannelWaveformPanels.add(waveformPanel); // adiciona o painel ao ArrayList
            add(createChannelDisplay(waveformPanel, t)); // adiciona o painel ao conteiner
        }
    }

    private JComponent createChannelDisplay(SingleWaveformPanel waveformPanel, int index) {
        JPanel panel = new JPanel(new BorderLayout()); // cria um painel
        panel.add(waveformPanel, BorderLayout.CENTER); // adiciona o painel do grafico a este painel

        JLabel label = new JLabel("Channel " + ++index); // cria o rotulo do canal
        panel.add(label, BorderLayout.NORTH); // adiciona ao painel

        return panel; // retorna o painel criado
    }

}
