
package interfaz;

import controller.ClienteController;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.cliente.DatosRegistrarCliente;
import modelo.cliente.DatosRespuestaCliente;


public class FrameNuevoCliente extends javax.swing.JFrame {
    
    private int xMouse, yMouse;
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private final ClienteController clienteController;
    private boolean isEmailValid;
    
    public FrameNuevoCliente() {
        this.clienteController = new ClienteController();
        initComponents();
        this.setLocationRelativeTo(null);
        EmailValidation();
    }
    
    private void registrarCliente() {
        
        if (camposVacios()) {
            DialogMessageSuccess messageSuccess = new DialogMessageSuccess(this, true, "Ingrese todos los datos.", false);
            messageSuccess.setVisible(true);
            return;
        }
        
        if (!longitudCampos()) {
            DialogMessageSuccess messageSuccess = new DialogMessageSuccess(this, true, "Los campos Documeto son de 10 digitos y Celular 9 digitos.", false);
            messageSuccess.setVisible(true);
            return;
        }
        if (!isEmailValid) {
            return;
        }
        DatosRegistrarCliente datosCliente = new DatosRegistrarCliente(txtNombre.getText(), txtApellido.getText(), txtEmail.getText(), txtCelular.getText(),
                txtDocumento.getText());
        
        DatosRespuestaCliente respuesta = this.clienteController.registrar(datosCliente);
        
        if (!respuesta.isStatus()) {
            DialogMessageSuccess messageSuccess = new DialogMessageSuccess(this, true, respuesta.getMensaje(), respuesta.isStatus());
            messageSuccess.setVisible(true);
            return;
        }
        DialogMessageSuccess messageSuccess = new DialogMessageSuccess(this, true, respuesta.getMensaje(), respuesta.isStatus());
        messageSuccess.setVisible(true);
        limpiarInput();
        
    }
       
    private void limpiarInput() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtCelular.setText("");
        txtDocumento.setText("");
        lblMensaje.setText("");
    }
    
    private boolean longitudCampos() {
        return txtDocumento.getText().trim().length() == 10 && txtCelular.getText().trim().length() == 9;
    }
    
    private boolean camposVacios() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String email = txtEmail.getText().trim();
        String celular = txtCelular.getText().trim();
        String documento = txtDocumento.getText().trim();
        return nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || celular.isEmpty() || documento.isEmpty();
    }
    
    public void EmailValidation() {
        txtEmail.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                validationEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validationEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validationEmail();
            }
            
            private void validationEmail() {
                String emailText = txtEmail.getText();
                if (validate(emailText)) {
                    lblMensaje.setText("");
                    isEmailValid = true;
                } else {
                    lblMensaje.setText("Invalid email");
                    lblMensaje.setForeground(Color.RED);
                    isEmailValid = false;
                }
            }
        });
    }
    
    public static boolean validate(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private void inputBorderReset() {
        txtNombre.setBorder(new LineBorder(Color.decode("333333")));
        txtApellido.setBorder(new LineBorder(Color.decode("333333")));
        txtEmail.setBorder(new LineBorder(Color.decode("333333")));
        txtCelular.setBorder(new LineBorder(Color.decode("333333")));
        txtDocumento.setBorder(new LineBorder(Color.decode("333333")));
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
        btnExit = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        lblImagenLogin = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();

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

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(51, 51, 51));
        btnExit.setText("X");
        btnExit.setBorder(null);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.setFocusPainted(false);
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 620));

        lblImagenLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaper_new_client.png"))); // NOI18N
        lblImagenLogin.setAutoscrolls(true);
        lblImagenLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblImagenLogin)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblImagenLogin)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(51, 51, 51));
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreMouseEntered(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(231, 77, 137));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setFocusable(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(231, 77, 137));
        lblTitulo.setText("NUEVO CLIENTE");

        lblSubtitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(102, 102, 102));
        lblSubtitulo.setText("Bienvenido, por favor ingresa tus datos.");

        lblApellido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(51, 51, 51));
        lblApellido.setText("Apellido");

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidoMouseClicked(evt);
            }
        });
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(51, 51, 51));
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTelefono.setText("Celular");

        txtCelular.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtCelular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCelularMouseClicked(evt);
            }
        });
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        lblDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDocumento.setForeground(new java.awt.Color(51, 51, 51));
        lblDocumento.setText("Documento");
        lblDocumento.setFocusable(false);

        txtDocumento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDocumentoMouseClicked(evt);
            }
        });
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        lblMensaje.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSubtitulo)
                            .addComponent(lblTitulo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre)
                                    .addComponent(lblEmail))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellido)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addGap(139, 139, 139)
                                .addComponent(lblDocumento))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 106, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulo)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(lblDocumento))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );

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
        setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        headerMouseDragged(evt);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        headerMousePressed(evt);
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarCliente();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.white);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(Color.white);
        btnExit.setForeground(Color.black);
    }//GEN-LAST:event_btnExitMouseExited

    private void txtNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseEntered
        
    }//GEN-LAST:event_txtNombreMouseEntered

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        inputBorderReset();
        txtNombre.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMouseClicked
        inputBorderReset();
        txtApellido.setBorder(new LineBorder(Color.blue));
    }//GEN-LAST:event_txtApellidoMouseClicked

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        inputBorderReset();
        txtEmail.setBorder(new LineBorder(Color.blue));
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtCelularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCelularMouseClicked
        inputBorderReset();
        txtCelular.setBorder(new LineBorder(Color.blue));
    }//GEN-LAST:event_txtCelularMouseClicked

    private void txtDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDocumentoMouseClicked
        inputBorderReset();
        txtDocumento.setBorder(new LineBorder(Color.blue));
    }//GEN-LAST:event_txtDocumentoMouseClicked

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char key = evt.getKeyChar();
        
        if (!Character.isDigit(key)) {
            evt.consume();
            return;
        }  
        if (txtCelular.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        char key = evt.getKeyChar();
        
        if (!Character.isDigit(key)) {
            evt.consume();
            return;
        }  
        if (txtDocumento.getText().trim().length() == 10) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnExit;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImagenLogin;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
