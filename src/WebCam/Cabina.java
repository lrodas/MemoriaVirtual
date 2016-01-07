/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebCam;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author angel
 */
public final class Cabina extends javax.swing.JFrame implements Runnable, WebcamListener, WindowListener, Thread.UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {

    private Webcam webcam = null;
    private WebcamPanel plWebCam = null;
    private Timer Reloj;
    private int Contador = 5, FotosTomadas = 6;
    int delay = 1000;
    private WebcamPicker picker = null;
    private File Marcos = new File(System.getProperty("user.home")+"\\Documents\\Cabina_Fotografica\\Marcos");
    private String PathFotos = System.getProperty("user.home")+"\\Documents\\Cabina_Fotografica\\Fotografias";
    
    Galeria Mi_Galeria = new Galeria(Marcos);
    private int a = 1;
    private int b = 2;
    private int c = 3;
    private int d = 4;
    
    public Cabina() {
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Recursos/Fondo3.jpg"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
        Marcos.mkdirs();
        this.setExtendedState(MAXIMIZED_BOTH);
        FOTO_A.setIcon(Mi_Galeria.getPreview(a));
        FOTO_B.setIcon(Mi_Galeria.getPreview(b));
        FOTO_C.setIcon(Mi_Galeria.getPreview(c));
        FOTO_D.setIcon(Mi_Galeria.getPreview(d));
        run();
    }

    public void VistaPrevia(String Path, int lugar){
        File imagen = new File(Path);
        ImageIcon Vista = new ImageIcon(imagen.toString());
        Icon icono = new ImageIcon(Vista.getImage().getScaledInstance(lbl1.getWidth(), lbl1.getHeight(), Image.SCALE_DEFAULT));
        switch(lugar){
            case 1:
                lbl1.setIcon(icono);
                break;
            case 2:
                lbl2.setIcon(icono);
                break;
            case 3:
                lbl3.setIcon(icono);
                break;
            case 4:
                lbl4.setIcon(icono);
                break;
            case 5:
                lbl5.setIcon(icono);
                break;
            case 6:
                lbl6.setIcon(icono);
                break;
        }
    }
    
    public void Imprimir(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        plDispositivos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pl1 = new javax.swing.JPanel();
        btnFoto = new javax.swing.JButton();
        lbl6 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        CMD_PREVIEW = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        FOTO_A = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        FOTO_B = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        FOTO_C = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        FOTO_D = new javax.swing.JLabel();
        CMD_NEXT = new javax.swing.JButton();
        lblContador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        plDispositivos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        plDispositivos.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de Dispositivos Disponibles:");

        javax.swing.GroupLayout plDispositivosLayout = new javax.swing.GroupLayout(plDispositivos);
        plDispositivos.setLayout(plDispositivosLayout);
        plDispositivosLayout.setHorizontalGroup(
            plDispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDispositivosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plDispositivosLayout.setVerticalGroup(
            plDispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plDispositivosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pl1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pl1Layout = new javax.swing.GroupLayout(pl1);
        pl1.setLayout(pl1Layout);
        pl1Layout.setHorizontalGroup(
            pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        pl1Layout.setVerticalGroup(
            pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/foto.png"))); // NOI18N
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        lbl6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        CMD_PREVIEW.setText("<");
        CMD_PREVIEW.setPreferredSize(new java.awt.Dimension(44, 120));
        CMD_PREVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMD_PREVIEWActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel3.add(CMD_PREVIEW, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        FOTO_A.setText("foto");
        FOTO_A.setPreferredSize(new java.awt.Dimension(100, 100));
        FOTO_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FOTO_AMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(FOTO_A, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jPanel2, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        FOTO_B.setText("foto");
        FOTO_B.setPreferredSize(new java.awt.Dimension(100, 100));
        FOTO_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FOTO_BMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(FOTO_B, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jPanel4, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        FOTO_C.setText("foto");
        FOTO_C.setPreferredSize(new java.awt.Dimension(100, 100));
        FOTO_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FOTO_CMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel5.add(FOTO_C, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jPanel5, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        FOTO_D.setText("foto");
        FOTO_D.setPreferredSize(new java.awt.Dimension(100, 100));
        FOTO_D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FOTO_DMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(FOTO_D, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jPanel6, gridBagConstraints);

        CMD_NEXT.setText(">");
        CMD_NEXT.setPreferredSize(new java.awt.Dimension(44, 120));
        CMD_NEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMD_NEXTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(CMD_NEXT, gridBagConstraints);

        lblContador.setFont(new java.awt.Font("Forte", 2, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plDispositivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(lblContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CMD_PREVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMD_PREVIEWActionPerformed
        a-=1;b-=1;c-=1;d-=1;
        FOTO_A.setIcon(Mi_Galeria.getPreview(a));
        FOTO_B.setIcon(Mi_Galeria.getPreview(b));
        FOTO_C.setIcon(Mi_Galeria.getPreview(c));
        FOTO_D.setIcon(Mi_Galeria.getPreview(d));
    }//GEN-LAST:event_CMD_PREVIEWActionPerformed

    private void FOTO_AMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FOTO_AMouseClicked
       // FOTO_GRANDE.setIcon(Mi_Galeria.getFoto(a,FOTO_GRANDE.getSize()));
    }//GEN-LAST:event_FOTO_AMouseClicked

    private void FOTO_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FOTO_BMouseClicked
        //FOTO_GRANDE.setIcon(Mi_Galeria.getFoto(b,FOTO_GRANDE.getSize()));
    }//GEN-LAST:event_FOTO_BMouseClicked

    private void FOTO_CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FOTO_CMouseClicked
        //FOTO_GRANDE.setIcon(Mi_Galeria.getFoto(c,FOTO_GRANDE.getSize()));
    }//GEN-LAST:event_FOTO_CMouseClicked

    private void FOTO_DMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FOTO_DMouseClicked
        //FOTO_GRANDE.setIcon(Mi_Galeria.getFoto(d,FOTO_GRANDE.getSize()));
    }//GEN-LAST:event_FOTO_DMouseClicked

    private void CMD_NEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMD_NEXTActionPerformed
        a+=1;b+=1;c+=1;d+=1;
        FOTO_A.setIcon(Mi_Galeria.getPreview(a));
        FOTO_B.setIcon(Mi_Galeria.getPreview(b));
        FOTO_C.setIcon(Mi_Galeria.getPreview(c));
        FOTO_D.setIcon(Mi_Galeria.getPreview(d));
    }//GEN-LAST:event_CMD_NEXTActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        String Nombre = "";
        Calendar Sistema = new GregorianCalendar();
        String hora = Sistema.get(Calendar.HOUR_OF_DAY) + "_" + Sistema.get(Calendar.MINUTE);
        Date fecha = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("dd-MM-yyyy");
        PathFotos += "\\" + Format.format(fecha) + "\\" + hora;
        File CrearPath = new File(PathFotos);
        CrearPath.mkdirs();       
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Muestra en pantalla los segundos restantes:
                lblContador.setText("Quedan " + String.valueOf(Contador) + " segundos..."); 
                // Comprueba si segundos es igual a cero para detener el Timer.
                if(Contador<=1 && FotosTomadas <= 1) 
                {
                    String PathFotosTomadas = PathFotos +"\\" + FotosTomadas +".jpg";
                    lblContador.setText("Sonria!!!!");
                    try{
                        BufferedImage image = webcam.getImage();
                        ImageIO.write(image, "jpg", new File(PathFotosTomadas));
                        VistaPrevia(PathFotosTomadas, FotosTomadas);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    Toolkit.getDefaultToolkit().beep(); // Emite sonido.
                    Reloj.stop(); // Detiene el timer y se deja de ejecutar ésto.
                }else if(Contador <= 1){
                    lblContador.setText("Sonria!!!!");
                    String PathFotosTomadas = PathFotos +"\\" + FotosTomadas +".jpg";
                    try{
                        BufferedImage image = webcam.getImage();
                        ImageIO.write(image, "jpg", new File(PathFotosTomadas));
                        VistaPrevia(PathFotosTomadas, FotosTomadas);
                        Contador = 5;
                        FotosTomadas--;
                    }catch(Exception e){
                        Reloj.stop();
                        System.out.println(e.getMessage());
                    }
                    Toolkit.getDefaultToolkit().beep();
                    
                }
                Contador--; // Reduce la cantidad de segundos.
            }
        }; // Fin de la declaración del ActionListener.

        Reloj = new Timer(delay, taskPerformer);
        Reloj.start(); // Empieza la ejecución del timer.
        
    }//GEN-LAST:event_btnFotoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cabina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cabina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cabina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cabina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cabina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CMD_NEXT;
    private javax.swing.JButton CMD_PREVIEW;
    private javax.swing.JLabel FOTO_A;
    private javax.swing.JLabel FOTO_B;
    private javax.swing.JLabel FOTO_C;
    private javax.swing.JLabel FOTO_D;
    private javax.swing.JButton btnFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lblContador;
    private javax.swing.JPanel pl1;
    private javax.swing.JPanel plDispositivos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Webcam.addDiscoveryListener(this);

        picker = new WebcamPicker();
        picker.addItemListener(this);

        webcam = picker.getSelectedWebcam();

        if (webcam == null) {
                System.out.println("No webcams found...");
                System.exit(1);
        }

        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.addWebcamListener(Cabina.this);

        plWebCam = new WebcamPanel(webcam, false);
        plWebCam.setFPSDisplayed(true);


        picker.setBounds(300, 8, 300, 30);
        plWebCam.setBounds(0, 0, 660, 560);

        plDispositivos.add(picker);
        pl1.add(plWebCam);

        Thread t = new Thread() {

                @Override
                public void run() {
                        plWebCam.start();
                }
        };
        t.setName("example-starter");
        t.setDaemon(true);
        t.setUncaughtExceptionHandler(this);
        t.start();
    }

    @Override
    public void webcamOpen(WebcamEvent we) {
            System.out.println("webcam open");
    }

    @Override
    public void webcamClosed(WebcamEvent we) {
            System.out.println("webcam closed");
    }

    @Override
    public void webcamDisposed(WebcamEvent we) {
            System.out.println("webcam disposed");
    }

    @Override
    public void webcamImageObtained(WebcamEvent we) {
            // do nothing
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
            webcam.close();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
            System.out.println("webcam viewer resumed");
            plWebCam.resume();
    }

    @Override
    public void windowIconified(WindowEvent e) {
            System.out.println("webcam viewer paused");
            plWebCam.pause();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
            System.err.println(String.format("Exception in thread %s", t.getName()));
            e.printStackTrace();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
            if (e.getItem() != webcam) {
                    if (webcam != null) {

                            plWebCam.stop();

                            remove(plWebCam);

                            webcam.removeWebcamListener(this);
                            webcam.close();

                            webcam = (Webcam) e.getItem();
                            webcam.setViewSize(WebcamResolution.VGA.getSize());
                            webcam.addWebcamListener(this);

                            System.out.println("selected " + webcam.getName());

                            plWebCam = new WebcamPanel(webcam, false);
                            plWebCam.setFPSDisplayed(true);

                            add(plWebCam, BorderLayout.CENTER);
                            pack();

                            Thread t = new Thread() {

                                    @Override
                                    public void run() {
                                            plWebCam.start();
                                    }
                            };
                            t.setName("example-stoper");
                            t.setDaemon(true);
                            t.setUncaughtExceptionHandler(this);
                            t.start();
                    }
            }
    }

    @Override
    public void webcamFound(WebcamDiscoveryEvent event) {
            if (picker != null) {
                    picker.addItem(event.getWebcam());
            }
    }

    @Override
    public void webcamGone(WebcamDiscoveryEvent event) {
            if (picker != null) {
                    picker.removeItem(event.getWebcam());
            }
    }
}
