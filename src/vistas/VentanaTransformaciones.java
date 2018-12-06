/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

import java.awt.event.ActionListener;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VentanaTransformaciones extends javax.swing.JFrame {

    /** Creates new form VentanaTransformaciones */
    public VentanaTransformaciones() {
        initComponents();
    }
    
    public void addEventos(ActionListener oyente){
        this.opcionSimetriaCentral.addActionListener(oyente);
        this.opcionSimetriaAxial.addActionListener(oyente);
        this.opcionTranslacion.addActionListener(oyente);
        this.opcionRotacion.addActionListener(oyente);
        this.opcionEscalado.addActionListener(oyente);
        this.opcionSalir.addActionListener(oyente);
        this.opcionCuadrado.addActionListener(oyente);
        this.opcionTriangulo.addActionListener(oyente);
        this.opcionRectangulo.addActionListener(oyente);
        this.opcionExtra.addActionListener(oyente);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        opcionSimetriaCentral = new javax.swing.JMenuItem();
        opcionSimetriaAxial = new javax.swing.JMenuItem();
        opcionTranslacion = new javax.swing.JMenuItem();
        opcionRotacion = new javax.swing.JMenuItem();
        opcionEscalado = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        opcionSalir = new javax.swing.JMenuItem();
        menuFiguras = new javax.swing.JMenu();
        opcionCuadrado = new javax.swing.JMenuItem();
        opcionTriangulo = new javax.swing.JMenuItem();
        opcionRectangulo = new javax.swing.JMenuItem();
        opcionExtra = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transformaciones Bidimencionales");

        menuArchivo.setText("Transformaciones");

        opcionSimetriaCentral.setText("Simetria Central");
        opcionSimetriaCentral.setName("sCentral"); // NOI18N
        menuArchivo.add(opcionSimetriaCentral);

        opcionSimetriaAxial.setText("Simetria Axial");
        opcionSimetriaAxial.setName("sAxial"); // NOI18N
        menuArchivo.add(opcionSimetriaAxial);

        opcionTranslacion.setText("Translación");
        opcionTranslacion.setName("translacion"); // NOI18N
        menuArchivo.add(opcionTranslacion);

        opcionRotacion.setText("Rotación");
        opcionRotacion.setName("rotacion"); // NOI18N
        menuArchivo.add(opcionRotacion);

        opcionEscalado.setText("Escalado");
        opcionEscalado.setName("escalado"); // NOI18N
        menuArchivo.add(opcionEscalado);
        menuArchivo.add(separador);

        opcionSalir.setText("Salir");
        opcionSalir.setName("salir"); // NOI18N
        menuArchivo.add(opcionSalir);

        barraMenu.add(menuArchivo);

        menuFiguras.setText("Figuras");

        opcionCuadrado.setText("Cuadrado");
        opcionCuadrado.setName("cuadrado"); // NOI18N
        menuFiguras.add(opcionCuadrado);

        opcionTriangulo.setText("Triángulo");
        opcionTriangulo.setName("triangulo"); // NOI18N
        menuFiguras.add(opcionTriangulo);

        opcionRectangulo.setText("Rectángulo");
        opcionRectangulo.setName("rectangulo"); // NOI18N
        menuFiguras.add(opcionRectangulo);

        opcionExtra.setText("Extra");
        opcionExtra.setName("extra"); // NOI18N
        menuFiguras.add(opcionExtra);

        barraMenu.add(menuFiguras);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuFiguras;
    private javax.swing.JMenuItem opcionCuadrado;
    private javax.swing.JMenuItem opcionEscalado;
    private javax.swing.JMenuItem opcionExtra;
    private javax.swing.JMenuItem opcionRectangulo;
    private javax.swing.JMenuItem opcionRotacion;
    private javax.swing.JMenuItem opcionSalir;
    private javax.swing.JMenuItem opcionSimetriaAxial;
    private javax.swing.JMenuItem opcionSimetriaCentral;
    private javax.swing.JMenuItem opcionTranslacion;
    private javax.swing.JMenuItem opcionTriangulo;
    private javax.swing.JPopupMenu.Separator separador;
    // End of variables declaration//GEN-END:variables

}