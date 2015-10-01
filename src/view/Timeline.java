/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Yan
 */
public class Timeline extends javax.swing.JPanel {

  private VisualTrack selectedTrack;

  /**
   * Creates new form VisualPanel
   */
  public Timeline() {
    initComponents();
    timeSlider.addChangeListener((ChangeEvent e) -> {
      setPointerLocation();
    });
    setPointerLocation();
    System.out.println("passamos aqui");
  }

  private void setPointerLocation() {
    int porcent = timeSlider.getValue();
    int x = porcent * (downPanel.getWidth() - 14) / timeSlider.getMaximum();
    pointer.setLocation(x + 5, pointer.getY());
  }

  public void addTrack(VisualTrack track) {
//    panel23.add(track);
    selectedTrack = track;
    track.select();
    track.addFocusListener(clearFocus(track));

  }

  public FocusListener clearFocus(VisualTrack track) {
    return new FocusListener() {

      @Override
      public void focusGained(FocusEvent e) {
        selectedTrack.unselect();
        track.select();
        selectedTrack = track;
      }

      @Override
      public void focusLost(FocusEvent e) {

      }
    };
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    downPanel = new javax.swing.JPanel();
    timeSlider = new javax.swing.JSlider();
    jScrollPane1 = new javax.swing.JScrollPane();
    overlayPanel = new javax.swing.JPanel();
    pointer = new javax.swing.JLabel(){
      @Override
      public void paintComponent(Graphics graphic) {

        super.paintComponent(graphic);
        pointer.setOpaque(false);

        for(int y = 0; y < pointer.getHeight(); y += 15){
          graphic.drawLine(0, y, 0, y + 10);
        }

      }
    };
    trackPanel = new javax.swing.JPanel();

    setBackground(new java.awt.Color(204, 204, 204));
    setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    timeSlider.setMaximum(1000);
    timeSlider.setMinorTickSpacing(10);
    timeSlider.setPaintLabels(true);
    timeSlider.setPaintTicks(true);
    timeSlider.setToolTipText("");

    jScrollPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
    jScrollPane1.setBorder(null);
    jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

    overlayPanel.setPreferredSize(new java.awt.Dimension(200, 100));
    overlayPanel.setLayout(new javax.swing.OverlayLayout(overlayPanel));

    pointer.setBackground(new java.awt.Color(153, 153, 153));
    pointer.setForeground(new java.awt.Color(153, 153, 153));
    pointer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    pointer.setMaximumSize(new java.awt.Dimension(1, 999));
    pointer.setMinimumSize(new java.awt.Dimension(1, 20));
    pointer.setOpaque(true);
    pointer.setPreferredSize(new java.awt.Dimension(1, 20));
    overlayPanel.add(pointer);

    trackPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledShadow"));

    javax.swing.GroupLayout trackPanelLayout = new javax.swing.GroupLayout(trackPanel);
    trackPanel.setLayout(trackPanelLayout);
    trackPanelLayout.setHorizontalGroup(
      trackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 639, Short.MAX_VALUE)
    );
    trackPanelLayout.setVerticalGroup(
      trackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 105, Short.MAX_VALUE)
    );

    overlayPanel.add(trackPanel);

    jScrollPane1.setViewportView(overlayPanel);

    javax.swing.GroupLayout downPanelLayout = new javax.swing.GroupLayout(downPanel);
    downPanel.setLayout(downPanelLayout);
    downPanelLayout.setHorizontalGroup(
      downPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
      .addComponent(timeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    downPanelLayout.setVerticalGroup(
      downPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downPanelLayout.createSequentialGroup()
        .addComponent(timeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(downPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(downPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel downPanel;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JPanel overlayPanel;
  private javax.swing.JLabel pointer;
  private javax.swing.JSlider timeSlider;
  private javax.swing.JPanel trackPanel;
  // End of variables declaration//GEN-END:variables
}
