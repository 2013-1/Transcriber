/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Duration;

/**
 * Faixa, conjunto de segmentos, com tempo definido pelo video
 *
 * @author Yan Kaic
 * @author Carlos Hatus
 */
public class Track {

    private final List<Segment> segments;
    private Duration time;
    private String name;
    private String annotator;

    /**
     * Construtor que recebe como parametro a duracao total do video
     *
     * @param totalTime tempo total do video
     */
    public Track(Duration totalTime) {
        this.time = totalTime;
        this.annotator = null;
        this.name = null;
        this.segments = new ArrayList<>();
    }

    /**
     * Para a animacao do seguimento.
     */
    public void stopSegments() {
        for (Segment segment : segments) {
            segment.stopCount();
        }
    }

    /**
     * Adiciona novos seguimentos a faixa.
     *
     * @param segment Novo seguimento.
     */
    public void add(Segment segment) {
        segments.add(segment);
    }

    /**
     * Remove um seguimento da faixa.
     *
     * @param segment Seguimento a ser removido.
     */
    public void remove(Segment segment) {
        segments.remove(segment);
    }

    /**
     * Devolve a quantidade total de seguimentos na faixa.
     *
     * @return Quantidade de seguimentos
     */
    public int size() {
        return segments.size();
    }

    /**
     * Devolve a duração total da faixa.
     *
     * @return Tempo total da faixa
     */
    public Duration getDuration() {
        return time;
    }

    /**
     * Modifica o tempo total da faixa.
     *
     * @param time Novo tempo total.
     */
    public void setDuration(Duration time) {
        this.time = time;
    }

    /**
     * Retorna o nome da faixa
     *
     * @return Nome da faixa.
     */
    public String getName() {
        return name;
    }

    /**
     * Altera o nome da faixa
     *
     * @param name Novo nome da faixa.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna que transcreveu a faixa
     *
     * @return nome de que transcreveu
     */
    public String getAnnotator() {
        return annotator;
    }

    /**
     * Altera o nome do trancritor da faixa.
     *
     * @param annotator novo nome do transcritor
     */
    public void setAnnotator(String annotator) {
        this.annotator = annotator;
    }

    /**
     * Retorna uma lista com todos os seguimentos pertencentes a faixa
     *
     * @return Lista de seguimentos
     */
    public List<Segment> getSegments() {
        return segments;
    }

}
