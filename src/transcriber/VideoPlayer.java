/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transcriber;

import java.awt.BorderLayout;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.JApplet;

/**
 * Modulo onde o player de video e inicializado, ferramenta visual feita em
 * JavaFX, integrada com o Swing, que permite visualizar um video.
 *
 * @author Yan Kaic
 * @author Carlos Hatus
 */
public class VideoPlayer extends JApplet {

    private JFXPanel panel;
    private String url;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;

    /**
     * Construtor sem parametros, inicia o player com um video default.
     */
    public VideoPlayer() {
        this.url = getClass().getResource("/video/video.mp4").toString();
    }

    /**
     * Construtor com parametro, inicia o player com um video indicado
     * externamente.
     *
     * @param url String contendo o endereco url do video.
     */
    public VideoPlayer(String url) {
        this.url = url;
    }

    /**
     * Reescreve o metodo init da classe Applet, responsavel por iniciar o
     * painel do video player.
     */
    @Override
    public void init() {
        panel = new JFXPanel();
        add(panel, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(() -> {
            createScene();
        });
    }

    /**
     * Inicia o mediaView atraves de um video indicado externamente.
     *
     * @param url String contendo o endereco url do video.
     */
    public void setSourceMedia(String url) {
        media = new Media(url);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    /**
     * Cria o cenario necessario para organizar os componentes do JavaFX.
     */
    private void createScene() {
        media = new Media(url); // 1
        mediaPlayer = new MediaPlayer(media); // 2
        mediaView = new MediaView(mediaPlayer); // 3
        mediaView.setFitHeight(250);
        mediaView.setPreserveRatio(true);
        mediaView.autosize();

        StackPane raiz = new StackPane();
        raiz.getChildren().add(mediaView); // 4
        Scene cena = new Scene(raiz);
        panel.setScene(cena);
    }

    /**
     * Retorna uma referencia ao proprio objeto MediaPlayer.
     *
     * @return A propria instancia da classe.
     */
    public MediaPlayer getPlayer() {
        return this.mediaPlayer;
    }

    /**
     * Retorna o painel onde o player de video esta alocado.
     *
     * @return Painel de video.
     */
    public JFXPanel getPanel() {
        return panel;
    }

    /**
     * Retorna a MediaView, componente que exibe o video na tela.
     *
     * @return MediaView do VideoPlayer.
     */
    public MediaView getMediaView() {
        return mediaView;
    }

}
