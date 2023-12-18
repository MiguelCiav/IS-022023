import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    JPanel vistaDatos = new JPanel();
    JPanel vistaTipoReporte = new JPanel();
    CardLayout cardLayout = new CardLayout();
    JPanel panelPrincipal = new JPanel(cardLayout);
    JScrollPane scrollTabla = new JScrollPane();
    String datos[][] = new String[100][3];
    String columnas[] = { "C.I. Responsable", "Cantidad Equipos", "Monto total" };
    int cantidadResponsables = 0;

    // PANEL DATOS

    JLabel tituloDatos = new JLabel("Ingrese data del equipo: ");
    JTextField descripcion = new JTextField();
    JTextField cantidad = new JTextField();
    JTextField costoUnitario = new JTextField();
    JTextField fecha = new JTextField();
    JTextField numeroFactura = new JTextField();
    JTextField cedula = new JTextField();

    JLabel labelDescripcion = new JLabel();
    JLabel labelCantidad = new JLabel();
    JLabel labelCostoUnitario = new JLabel();
    JLabel labelFecha = new JLabel();
    JLabel labelFecha2 = new JLabel();
    JLabel labelNumeroFactura = new JLabel();
    JLabel labelCedula = new JLabel();

    JButton botonRegistrarData = new JButton("Registrar data");
    JButton botonGenerarReporte = new JButton("Generar Reporte");
    JButton botonSalir = new JButton("Salir");

    // PANEL REPORTE

    JLabel tituloReporte = new JLabel("Tipo reporte: ");
    JCheckBox checkIndividual = new JCheckBox("Individual");
    JCheckBox checkGeneral = new JCheckBox("General");
    JLabel labelCedulaResponsable = new JLabel("C.I. del responsable de equipos");
    JTextField cedulaResponsable = new JTextField();
    JButton botonTotalizar = new JButton("Totalizar");
    JLabel tituloTotalizacion = new JLabel("Totalización: ");
    JLabel equiposTotalizacion = new JLabel("___ equipos");
    JLabel costoTotalizacion = new JLabel("________ Bs");
    JButton botonContinuar = new JButton("Continuar");
    JTable tablaGeneral = new JTable(1, 3);

    Ventana() {
        this.setSize(430, 280);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Registro y Control de Equipos en Centro de Investigación");
        this.setLocationRelativeTo(null);

        // arreglo
        inicializarArreglo();

        // vista datos
        establecerTextoVistaDatos();
        setBoundsVistaDatos();
        anidarComponentesVistaDatos();

        // vista reporte
        setBoundsVistaReporte();
        anidarComponentesVistaReporte();

        // acciones
        setAcciones();

        // Panel principal
        panelPrincipal.add("datos", vistaDatos);
        panelPrincipal.add("tipoReporte", vistaTipoReporte);
        cardLayout.show(panelPrincipal, "datos");

        this.add(panelPrincipal);
        this.setVisible(true);
    }

    void inicializarArreglo() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 3; j++) {
                datos[i][j] = "";
            }
        }
    }

    void establecerTextoVistaDatos() {
        labelDescripcion.setText("Descripción: ");
        labelCantidad.setText("Cantidad: ");
        labelCostoUnitario.setText("Costo Unitario (Bs.): ");
        labelFecha.setText("Fecha de adquisición: ");
        labelFecha2.setText("dd/mm/aa");
        labelNumeroFactura.setText("Nro. de Factura: ");
        labelCedula.setText("C.I. del Responsable del equipo: ");
    }

    void setBoundsVistaDatos() {
        tituloDatos.setBounds(10, 10, 200, 20);

        labelDescripcion.setBounds(20, 40, 235, 20);
        descripcion.setBounds(100, 40, 295, 20);

        labelCantidad.setBounds(20, 70, 200, 20);
        cantidad.setBounds(100, 70, 45, 20);

        labelCostoUnitario.setBounds(200, 70, 200, 20);
        costoUnitario.setBounds(330, 70, 65, 20);

        labelFecha.setBounds(20, 100, 200, 20);
        labelFecha2.setBounds(20, 120, 200, 20);
        fecha.setBounds(150, 100, 65, 20);

        labelNumeroFactura.setBounds(230, 100, 200, 20);
        numeroFactura.setBounds(330, 100, 65, 20);

        labelCedula.setBounds(20, 150, 235, 20);
        cedula.setBounds(210, 150, 100, 20);

        botonRegistrarData.setBounds(70, 200, 120, 25);
        botonGenerarReporte.setBounds(200, 200, 130, 25);
        botonSalir.setBounds(340, 200, 60, 25);
    }

    void anidarComponentesVistaDatos() {
        vistaDatos.setLayout(null);

        vistaDatos.add(tituloDatos);
        vistaDatos.add(labelDescripcion);
        vistaDatos.add(descripcion);
        vistaDatos.add(labelCantidad);
        vistaDatos.add(cantidad);
        vistaDatos.add(labelCostoUnitario);
        vistaDatos.add(costoUnitario);
        vistaDatos.add(labelFecha);
        vistaDatos.add(labelFecha2);
        vistaDatos.add(fecha);
        vistaDatos.add(labelNumeroFactura);
        vistaDatos.add(numeroFactura);
        vistaDatos.add(labelCedula);
        vistaDatos.add(cedula);
        vistaDatos.add(botonRegistrarData);
        vistaDatos.add(botonGenerarReporte);
        vistaDatos.add(botonSalir);
    }

    void setBoundsVistaReporte() {
        tituloReporte.setBounds(10, 10, 100, 20);

        checkIndividual.setBounds(100, 10, 100, 20);
        checkIndividual.setSelected(true);
        checkGeneral.setBounds(200, 10, 100, 20);

        labelCedulaResponsable.setBounds(10, 40, 200, 20);
        cedulaResponsable.setBounds(200, 40, 80, 20);
        botonTotalizar.setBounds(290, 40, 100, 20);

        tituloTotalizacion.setBounds(10, 90, 200, 20);
        equiposTotalizacion.setBounds(10, 110, 200, 20);
        costoTotalizacion.setBounds(10, 125, 200, 20);
        botonContinuar.setBounds(300, 200, 100, 25);

        tablaGeneral.setSize(395, 100);
        scrollTabla.setBounds(10, 40, 395, 100);
        scrollTabla.setVisible(false);

    }

    void anidarComponentesVistaReporte() {
        vistaTipoReporte.setLayout(null);

        vistaTipoReporte.add(tituloReporte);
        vistaTipoReporte.add(checkIndividual);
        vistaTipoReporte.add(checkGeneral);
        vistaTipoReporte.add(labelCedulaResponsable);
        vistaTipoReporte.add(cedulaResponsable);
        vistaTipoReporte.add(botonTotalizar);
        vistaTipoReporte.add(tituloTotalizacion);
        vistaTipoReporte.add(equiposTotalizacion);
        vistaTipoReporte.add(costoTotalizacion);
        vistaTipoReporte.add(botonContinuar);

        scrollTabla.add(tablaGeneral);
        vistaTipoReporte.add(scrollTabla);

    }

    void setAcciones() {
        botonGenerarReporte.addActionListener(new accionGenerarReporte());
        botonContinuar.addActionListener(new accionContinuar());
        botonSalir.addActionListener(new accionSalir());
        checkIndividual.addActionListener(new accionReporteIndividual());
        checkGeneral.addActionListener(new accionReporteGeneral());
        botonRegistrarData.addActionListener(new accionRegistrar());
    }

    void datosAReporte() {
        tablaGeneral = new JTable(datos,columnas);
        tablaGeneral.setBounds(10, 40, 395, 100);
        vistaTipoReporte.add(tablaGeneral);
        tablaGeneral.setVisible(false);
        cardLayout.show(panelPrincipal, "tipoReporte");
    }

    void continuar() {
        cardLayout.show(panelPrincipal, "datos");
    }

    void finalizar() {
        this.dispose();
    }

    void reporteIndividual() {

        checkGeneral.setSelected(false);
        checkIndividual.setSelected(true);

        labelCedulaResponsable.setVisible(true);
        cedulaResponsable.setVisible(true);
        botonTotalizar.setVisible(true);
        tablaGeneral.setVisible(false);
        tituloTotalizacion.setBounds(10, 90, 200, 20);
        equiposTotalizacion.setBounds(10, 110, 200, 20);
        costoTotalizacion.setBounds(10, 125, 200, 20);

        repaint();

    }

    void reporteGeneral() {

        checkGeneral.setSelected(true);
        checkIndividual.setSelected(false);

        labelCedulaResponsable.setVisible(false);
        cedulaResponsable.setVisible(false);
        botonTotalizar.setVisible(false);
        tablaGeneral.setVisible(true);
        tituloTotalizacion.setBounds(10, 180, 200, 20);
        equiposTotalizacion.setBounds(10, 200, 200, 20);
        costoTotalizacion.setBounds(10, 215, 200, 20);

        repaint();

    }

    public class accionGenerarReporte implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            datosAReporte();

        }

    }

    public class accionContinuar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            continuar();

        }

    }

    public class accionSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            finalizar();

        }

    }

    public class accionReporteIndividual implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            reporteIndividual();

        }

    }

    public class accionReporteGeneral implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            reporteGeneral();

        }

    }

    public class accionRegistrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            boolean nuevaCedula = true;
            int cantidadEntera = 0;
            int costoEntero = 0;
            int costoActual = 0;
            int cantidadActual = 0;

            for (int i = 0; i < 100; i++) {
                System.out.println(datos[i][0].equals(cedula.getText()));
                if (datos[i][0].equals(cedula.getText())) {

                    nuevaCedula = false;

                    cantidadEntera = Integer.parseInt(cantidad.getText());
                    costoEntero = Integer.parseInt(costoUnitario.getText());
                    costoActual = Integer.parseInt(datos[i][2]);
                    cantidadActual = Integer.parseInt(datos[i][1]);

                    System.out.println(cantidadEntera + " " + costoEntero + " " + costoActual + " " + cantidadActual);

                    datos[i][1] = Integer.toString(cantidadActual + cantidadEntera);
                    datos[i][2] = Integer.toString(costoActual + (cantidadEntera * costoEntero));

                }
            }

            if (nuevaCedula) {

                cantidadEntera = Integer.parseInt(cantidad.getText());
                costoEntero = Integer.parseInt(costoUnitario.getText());

                datos[cantidadResponsables][0] = cedula.getText();
                datos[cantidadResponsables][1] = Integer.toString(cantidadEntera);
                datos[cantidadResponsables][2] = Integer.toString(cantidadEntera*costoEntero);

                System.out.println(cantidadEntera + " " + costoEntero);

                cantidadResponsables++;

            }

        }

    }

    public class accionTotalizar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
