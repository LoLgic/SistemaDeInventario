
package interfaz;

import controller.ClienteController;
import controller.ProductoController;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modelo.cliente.DatosListadoCliente;
import modelo.producto.DatosListadoProducto;


public class FrameHome extends javax.swing.JFrame {
    
    private int xMouse, yMouse;
    private DefaultTableModel model;
    private final ProductoController productoController;
    private final ClienteController clienteController;
   

    public FrameHome() {
        
        this.productoController = new ProductoController();
        this.clienteController = new ClienteController();
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    public void cargarTablaCliente() {
        tbTabla.setVisible(false);
        model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Email");
        model.addColumn("Celular");
        model.addColumn("Documento");
        
        List<DatosListadoCliente> datosClientes = this.clienteController.obtenerCliente();
        
        for (DatosListadoCliente datosCliente : datosClientes) {
            Object[] row = new Object[6];
            row[0] = datosCliente.getId();
            row[1] = datosCliente.getNombre();
            row[2] = datosCliente.getApellido();
            row[3] =  datosCliente.getEmail();
            row[4] = datosCliente.getCelular();
            row[5] = datosCliente.getDocumento();
            model.addRow(row);
        }
        tbTabla.setModel(model);
        tbTabla.setVisible(true);
         ajustarTamañoColumnas();
        
    }
    
    public void cargarTablaProducto() {
        tbTabla.setVisible(false);
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Iva");
        model.addColumn("Descripción");
        model.addColumn("Categoría");

        List<DatosListadoProducto> datosProductos = this.productoController.obtenerProductos();
        
        for (DatosListadoProducto datosProducto : datosProductos) {
            Object[] row = new Object[7];
            row[0] = datosProducto.getId();
            row[1] = datosProducto.getNombre();
            row[2] = datosProducto.getPrecio();
            row[3] = datosProducto.getCantidad();
            row[4] = datosProducto.getIva();
            row[5] = datosProducto.getDescripcion();
            row[6] = datosProducto.getCategoria();
            model.addRow(row);
        }
        tbTabla.setModel(model);
        tbTabla.setVisible(true);
        ajustarTamañoColumnas();
    }
    
    
    private void ajustarTamañoColumnas() {
        
         for (int i = 0; i < tbTabla.getColumnCount(); i++) {
            packColumn(tbTabla, i, 2);
        }   
    }
    
    private void packColumn(JTable table, int vColIndex, int margin) {
        TableColumn col = table.getColumnModel().getColumn(vColIndex);
        int width;
        
        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
        
        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, vColIndex);
            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, vColIndex), false, false, r, vColIndex);
            width = Math.max(width, comp.getPreferredSize().width);
        }
        
        width += 2 * margin;
        col.setPreferredWidth(width);
    }
    private void headerMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    
    private void headerMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnExit = new javax.swing.JToggleButton();
        btnMini = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        lblUserInfo = new javax.swing.JLabel();
        panelCliente = new javax.swing.JPanel();
        btnNuevoCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        panelProducto = new javax.swing.JPanel();
        btnNuevoProd = new javax.swing.JButton();
        btnEliminarProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabla = new javax.swing.JTable();
        lblNombreTabla = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 670));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setFocusable(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 50));
        jPanel3.setLayout(null);

        btnExit.setBackground(new java.awt.Color(51, 51, 51));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("X");
        btnExit.setBorder(null);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.setFocusPainted(false);
        btnExit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnExit.setPreferredSize(new java.awt.Dimension(60, 50));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel3.add(btnExit);
        btnExit.setBounds(940, 1, 60, 50);

        btnMini.setBackground(new java.awt.Color(51, 51, 51));
        btnMini.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btnMini.setForeground(new java.awt.Color(255, 255, 255));
        btnMini.setText("-");
        btnMini.setBorder(null);
        btnMini.setFocusable(false);
        btnMini.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMini.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMiniMouseExited(evt);
            }
        });
        btnMini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniActionPerformed(evt);
            }
        });
        jPanel3.add(btnMini);
        btnMini.setBounds(890, 0, 50, 50);

        btnCliente.setBackground(new java.awt.Color(51, 51, 51));
        btnCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setBorder(null);
        btnCliente.setFocusable(false);
        btnCliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
        });
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnCliente);
        btnCliente.setBounds(0, 0, 180, 50);

        btnProducto.setBackground(new java.awt.Color(51, 51, 51));
        btnProducto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/package.png"))); // NOI18N
        btnProducto.setText("Producto");
        btnProducto.setBorder(null);
        btnProducto.setFocusable(false);
        btnProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductoMouseExited(evt);
            }
        });
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        jPanel3.add(btnProducto);
        btnProducto.setBounds(180, 0, 180, 50);

        lblUserInfo.setBackground(new java.awt.Color(0, 0, 0));
        lblUserInfo.setForeground(new java.awt.Color(51, 51, 51));
        lblUserInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user-circle-white.png"))); // NOI18N
        lblUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUserInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUserInfoMouseExited(evt);
            }
        });
        jPanel3.add(lblUserInfo);
        lblUserInfo.setBounds(840, 0, 50, 50);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1000, 50);

        panelCliente.setBackground(new java.awt.Color(51, 51, 51));
        panelCliente.setFocusable(false);
        panelCliente.setPreferredSize(new java.awt.Dimension(100, 60));
        panelCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelClienteMouseExited(evt);
            }
        });
        panelCliente.setLayout(null);

        btnNuevoCliente.setBackground(new java.awt.Color(51, 51, 51));
        btnNuevoCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoCliente.setText("Nuevo Cliente");
        btnNuevoCliente.setBorder(null);
        btnNuevoCliente.setFocusable(false);
        btnNuevoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoClienteMouseExited(evt);
            }
        });
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });
        panelCliente.add(btnNuevoCliente);
        btnNuevoCliente.setBounds(0, 0, 180, 30);

        btnEliminarCliente.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setText("Eliminar Cliente");
        btnEliminarCliente.setBorder(null);
        btnEliminarCliente.setFocusable(false);
        btnEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseExited(evt);
            }
        });
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });
        panelCliente.add(btnEliminarCliente);
        btnEliminarCliente.setBounds(0, 30, 180, 30);

        jPanel1.add(panelCliente);
        panelCliente.setBounds(0, 50, 180, 0);

        panelProducto.setBackground(new java.awt.Color(51, 51, 51));
        panelProducto.setFocusable(false);
        panelProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelProductoMouseExited(evt);
            }
        });
        panelProducto.setLayout(null);

        btnNuevoProd.setBackground(new java.awt.Color(51, 51, 51));
        btnNuevoProd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoProd.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProd.setText("Nuevo Producto");
        btnNuevoProd.setBorder(null);
        btnNuevoProd.setFocusable(false);
        btnNuevoProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoProdMouseExited(evt);
            }
        });
        btnNuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProdActionPerformed(evt);
            }
        });
        panelProducto.add(btnNuevoProd);
        btnNuevoProd.setBounds(0, 0, 180, 30);

        btnEliminarProd.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarProd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProd.setText("Eliminar Producto");
        btnEliminarProd.setBorder(null);
        btnEliminarProd.setFocusable(false);
        btnEliminarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarProdMouseExited(evt);
            }
        });
        btnEliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProdActionPerformed(evt);
            }
        });
        panelProducto.add(btnEliminarProd);
        btnEliminarProd.setBounds(0, 30, 180, 30);

        jPanel1.add(panelProducto);
        panelProducto.setBounds(180, 50, 180, 0);

        tbTabla.setBackground(new java.awt.Color(242, 242, 242));
        tbTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbTabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 210, 1000, 404);

        lblNombreTabla.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblNombreTabla.setForeground(new java.awt.Color(51, 51, 51));
        lblNombreTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblNombreTabla);
        lblNombreTabla.setBounds(430, 120, 350, 50);

        separator.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(separator);
        separator.setBounds(430, 180, 350, 2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        headerMouseDragged(evt);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        headerMousePressed(evt);
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.white);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(Color.decode("#333333"));
        btnExit.setForeground(Color.white);
    }//GEN-LAST:event_btnExitMouseExited

    private void btnMiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMiniActionPerformed

    private void btnMiniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiniMouseExited
        btnMini.setBackground(Color.decode("#333333"));
    }//GEN-LAST:event_btnMiniMouseExited

    private void btnMiniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiniMouseEntered
        btnMini.setBackground(Color.decode("#666666"));
    }//GEN-LAST:event_btnMiniMouseEntered

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        //btnCliente.setBackground(Color.decode("#666666"));
        //panelCliente.setSize(180, 60);
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        //btnCliente.setBackground(Color.decode("#333333"));
        //panelCliente.setSize(0, 95);
    }//GEN-LAST:event_btnClienteMouseExited

    private void panelClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelClienteMouseEntered
        panelCliente.setSize(180, 60);
    }//GEN-LAST:event_panelClienteMouseEntered

    private void panelClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelClienteMouseExited
        panelCliente.setSize(0, 95);
    }//GEN-LAST:event_panelClienteMouseExited

    private void panelProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductoMouseEntered
        panelProducto.setSize(180, 60);
    }//GEN-LAST:event_panelProductoMouseEntered

    private void panelProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductoMouseExited
        panelProducto.setSize(0, 109);
    }//GEN-LAST:event_panelProductoMouseExited

    private void btnEliminarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseEntered
        panelCliente.setSize(180, 60);
        btnEliminarCliente.setBackground(Color.decode("#666666"));
    }//GEN-LAST:event_btnEliminarClienteMouseEntered

    private void btnEliminarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseExited
        panelCliente.setSize(0, 95);
        btnEliminarCliente.setBackground(Color.decode("#333333"));
    }//GEN-LAST:event_btnEliminarClienteMouseExited

    private void btnEliminarProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProdMouseEntered
        panelProducto.setSize(180, 60);
        btnEliminarProd.setBackground(Color.decode("#666666"));
    }//GEN-LAST:event_btnEliminarProdMouseEntered

    private void btnEliminarProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProdMouseExited
        panelProducto.setSize(0, 109);
        btnEliminarProd.setBackground(Color.decode("#333333"));
    }//GEN-LAST:event_btnEliminarProdMouseExited

    private void btnNuevoProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProdMouseEntered
        panelProducto.setSize(180, 60);
        btnNuevoProd.setBackground(Color.decode("#666666"));
    }//GEN-LAST:event_btnNuevoProdMouseEntered

    private void btnNuevoProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProdMouseExited
        panelProducto.setSize(0, 109);
        btnNuevoProd.setBackground(Color.decode("#333333"));
    }//GEN-LAST:event_btnNuevoProdMouseExited

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        //btnCliente.setBackground(Color.decode("#666666"));
        panelCliente.setSize(180, 60);
        panelProducto.setSize(0, 109);
        lblNombreTabla.setText("TABLA CLIENTE");
        separator.setBackground(Color.black);
        //btnProducto.setBackground(Color.decode("#333333"));
        cargarTablaCliente();
    }//GEN-LAST:event_btnClienteMouseClicked

    private void btnProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseEntered
        //panelProducto.setSize(180, 60);
        //btnProducto.setBackground(Color.decode("#6666666"));
        
    }//GEN-LAST:event_btnProductoMouseEntered

    private void btnProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseExited
        //panelProducto.setSize(0, 109);
        //btnProducto.setBackground(Color.decode("#333333"));
    }//GEN-LAST:event_btnProductoMouseExited

    private void btnNuevoClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoClienteMouseEntered
        panelCliente.setSize(180, 60);
        btnNuevoCliente.setBackground(Color.decode("#666666"));
    }//GEN-LAST:event_btnNuevoClienteMouseEntered

    private void btnNuevoClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoClienteMouseExited
        panelCliente.setSize(0, 95);
        btnNuevoCliente.setBackground(Color.decode("#3333333"));
    }//GEN-LAST:event_btnNuevoClienteMouseExited

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        FrameEliminarCliente frameEliminarCliente = new FrameEliminarCliente();
        frameEliminarCliente.setVisible(true);
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        FrameNuevoCliente nuevoCliente = new FrameNuevoCliente();
        nuevoCliente.setVisible(true);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnEliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdActionPerformed
        FrameEliminarProducto eliminarProducto = new FrameEliminarProducto();
        eliminarProducto.setVisible(true);
    }//GEN-LAST:event_btnEliminarProdActionPerformed

    private void btnNuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProdActionPerformed
        FrameNuevoProducto nuevoProducto = new FrameNuevoProducto();
        nuevoProducto.setVisible(true);
    }//GEN-LAST:event_btnNuevoProdActionPerformed

    private void btnProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseClicked
        panelProducto.setSize(180, 60);
        panelCliente.setSize(0, 95);
        lblNombreTabla.setText("TABLA PRODUCTO");
        separator.setBackground(Color.black);
        //btnProducto.setBackground(Color.decode("#6666666"));
        //btnCliente.setBackground(Color.decode("#333333"));
        cargarTablaProducto();
    }//GEN-LAST:event_btnProductoMouseClicked

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClienteActionPerformed

    private void lblUserInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserInfoMouseClicked
        setVisible(false);
        FrameLogin frameLogin = new FrameLogin();
        frameLogin.setVisible(true);
    }//GEN-LAST:event_lblUserInfoMouseClicked

    private void lblUserInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserInfoMouseEntered
        lblUserInfo.setIcon(new ImageIcon(getClass().getResource("/img/user-circle-blue.png")));
    }//GEN-LAST:event_lblUserInfoMouseEntered

    private void lblUserInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserInfoMouseExited
        lblUserInfo.setIcon(new ImageIcon(getClass().getResource("/img/user-circle-white.png")));
    }//GEN-LAST:event_lblUserInfoMouseExited

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProd;
    private javax.swing.JToggleButton btnExit;
    private javax.swing.JButton btnMini;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoProd;
    private javax.swing.JButton btnProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreTabla;
    private javax.swing.JLabel lblUserInfo;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable tbTabla;
    // End of variables declaration//GEN-END:variables
}
