/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javafx.util.Duration;

/**
 * Seguimento de texto delimitado pelo tempo inicial e pelo tempo final
 *
 * @author Yan Kaic
 * @author Carlos Hatus
 */
public class Segment {

    private Duration initialTime;
    private Duration finalTime;
    private String text;
    private Timer timer;

    /**
     * Inicia um seguimento de texto a partir do tempo inicial referenciado.
     *
     * @param initTime tempo inicial
     */
    public Segment(Duration initTime) {
        this.timer = new Timer();
        this.initialTime = initTime;
        this.finalTime = initTime;
        this.text = "";
    }

    /**
     * Retorna a duracao total do seguimento de texto.
     *
     * @return Duracao do segmento
     */
    public Duration getDuration() {
        return finalTime.subtract(initialTime);
    }

    /**
     * Retorna o tempo inicial do seguimento.
     *
     * @return Tempo inicial do seguimento.
     */
    public Duration getInitialTime() {
        return initialTime;
    }

    /**
     * Altera o valor do tempo inicial do seguimento.
     *
     * @param initialTime Novo tempo inicial.
     */
    public void setInitialTime(Duration initialTime) {
        this.initialTime = initialTime;
    }

    /**
     * Retorna o tempo final do seguimento.
     *
     * @return Tempo final
     */
    public Duration getFinalTime() {
        return finalTime;
    }

    /**
     * Altera o tempo final do seguimento.
     *
     * @param finalTime Novo tempo final
     */
    public void setFinalTime(Duration finalTime) {
        this.finalTime = finalTime;
    }

    /**
     * Retorna o texto contido no seguimento.
     *
     * @return texto contido no seguimento
     */
    public String getText() {
        return text;
    }

    /**
     * Altera o texto do seguimento.
     *
     * @param text Novo texto
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Inicializa o Timer, que e responsavel pela animacao do seguimento na
     * tela.
     */
    public void contTime() {
        if (!timer.isAlive()) {
            timer = new Timer();
            timer.start();
        }
    }

    /**
     * Para a atualizacao o Timer, que e responsavel pela animacao do seguimento
     * na tela.
     */
    public void stopCount() {
        timer.stopCounter();
    }

    /**
     * Casse responssavel pela animacao do seguimento na tela,
     * atualizaindependente do restante do programa, herda atributos da classe
     * Thread.
     */
    public class Timer extends Thread {

        private boolean valid;

        /**
         * Construtor da sub-classe Timer
         */
        public Timer() {
            super();
            this.valid = true;
        }

        /**
         * Reescreve o método run da classe Thread.
         */
        @Override
        public void run() {
            try {
                while (valid) {
                    counter();
                }
            } catch (InterruptedException ex) {
            }
        }

        /**
         * aguarda determinado tempo para verificar o estado do seguimento.
         */
        private void counter() throws InterruptedException {
            long mili = 100;
            sleep(mili);
            finalTime = finalTime.add(new Duration(mili));
        }

        /**
         * Para de verificar o estado do seguimento
         */
        private void stopCounter() {
            valid = false;
        }
    }

}
