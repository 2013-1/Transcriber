/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Yan
 */
public class Pointer extends JLabel {

  public Pointer() {
    
  }

  @Override
  public void paintComponents(Graphics graphic) {
    graphic.drawLine(10, 0, 10, 20);
  }
}
