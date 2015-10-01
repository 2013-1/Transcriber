/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entity.Segment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * Segmento visual com tamanho definido pelo tempo do video.
 * @author Yan Kaic
 * @author Carlos Hatus
 */
public class VisualSegment extends JTextField {

  private final Segment segment;
  private Updater updater; 

  /**
   * 
   * @param segment
   */
  public VisualSegment(Segment segment) {
    super();
    this.setEditable(false);
    this.segment = segment;
    this.updater = new Updater();
    this.addFocusListener(new Focus());
    this.setHorizontalAlignment(CENTER);
    int x = (int) (segment.getInitialTime().toMillis()/50);
    this.setLocation(x, 0);
    this.setBackground(Color.lightGray);
    this.setSize(0, 26);
  }
  
  /**
   *
   */
  public void start(){
   if(!updater.isAlive()){
     updater = new Updater();
     updater.start();
   }
  }

  /**
   *
   */
  public void stop() {
    updater.stopUpdate();
  }

  private class Focus implements FocusListener {

    public Focus() {
      super();
    }

    @Override
    public void focusGained(FocusEvent e) {
      setBackground(Color.blue);
      setEditable(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
      setBackground(Color.lightGray);   
      setEditable(false);
    }
  }

  /**
   *
   */
  public class Updater extends Thread {

    private boolean valid;

    /**
     *
     */
    public Updater() {
      valid= true;
    }

    @Override
    public void run() {
      try {
        while (valid) {
          update();
        }
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }

    private void update() throws InterruptedException {
      int width = (int) (segment.getDuration().toMillis() / 50);
      System.out.println(width);
      Dimension size = getSize();
      size.width = width;
      setSize(size);
      sleep(100);
    }

    /**
     *
     */
    public void stopUpdate(){
    valid = false;
  }

  }
}
