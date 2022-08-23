/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.table.JTableHeader;
import java.sql.*;
import dal.ModulodeConexão;
import net.proteanit.sql.DbUtils;
import view2.*;

/**
 *
 * @author Ramiro Dantas
 */
public class RealizarPedidos extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void consultar_servico() {
        String sql = "Select * from pedidos where idquarto like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cbPedPes.getSelectedItem().toString() + "%");
            rs = pst.executeQuery();

            tblPedido.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }

    private void Consultar() {
        String sql = "Select * from pedidos where idquarto=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cbPedPes.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtPedQuarto.setSelectedItem(rs.getString(2));
                txtPedID.setText(rs.getString(3));
                txtPedPedido.setText(rs.getString(5));
                txtPedValor.setText(rs.getString(6));
                pst.close();
            } else {
                new PedNEncontrado().setVisible(true);
                txtPedID.setText("");
                txtPedQuarto.setSelectedItem("Quartos");
                txtPedValor.setText("");
                txtPedPedido.setText("");
                cbPedPes.setSelectedItem("Selecione o quarto...");
                pst.close();
            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }

    private void alterar() {
        String sql = "update pedidos set idquarto=?,idclien=?,pedido=?,valorpedido =? where idquarto=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPedQuarto.getSelectedItem().toString());
            pst.setString(2, txtPedID.getText());
            pst.setString(3, txtPedPedido.getText());
            pst.setString(4, txtPedValor.getText());
            pst.setString(5, cbPedPes.getSelectedItem().toString());
            if (txtPedQuarto.getSelectedItem().equals("Quartos") || txtPedID.getText().isEmpty() || txtPedPedido.getText().isEmpty() || txtPedValor.getText().isEmpty()) {
                new Campos().setVisible(true);
                pst.close();
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new PedidoATT().setVisible(true);
                    txtPedID.setText("");
                    txtPedQuarto.setSelectedItem("Quartos");
                    txtPedValor.setText("");
                    txtPedPedido.setText("");
                    pst.close();
                }
            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }

    private void remover(){
        if(txtPedID.getText().isEmpty()){
        new PedidoNEncontrado().setVisible(true);
        } else {
            new ApagarPedido().setVisible(true);
        }
    }
    
    private void confirmar(){
        String sql = "delete from pedidos where idquarto=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, cbPedPes.getSelectedItem().toString());
                int apagar = pst.executeUpdate();
                if(apagar > 0){
                       new PedidoConfirmado().setVisible(true);
                       txtPedID.setText("");
                       txtPedPedido.setText("");
                       txtPedValor.setText("");
                       cbPedPes.setSelectedItem("Selecione o quarto...");
                       txtPedQuarto.setSelectedItem("Quartos");
                       tblPedido.setValueAt("",0,0);
                       tblPedido.setValueAt("",0,1);
                       tblPedido.setValueAt("",0,2);
                       tblPedido.setValueAt("",0,3);
                       tblPedido.setValueAt("",0,4);
                       tblPedido.setValueAt("",0,5);
                       pst.close();
                }
            } catch (Exception e) {
                new Erro().setVisible(true);
            }
    }
    
    public RealizarPedidos() {
        initComponents();
        conexao = ModulodeConexão.conector();
        JTableHeader header = tblPedido.getTableHeader();
        header.setBackground(new Color(83, 126, 197));
        header.setForeground(Color.BLACK);
        this.setFont(new Font("Sogoe Print 11 Simples", Font.BOLD, 12));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        txtPedID = new javax.swing.JTextField();
        cbPedPes = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        CancelarPedido = new javax.swing.JButton();
        ConfirmarPedido = new javax.swing.JButton();
        txtPedPedido = new javax.swing.JTextField();
        txtPedValor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPedQuarto = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        AlterarPedido = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(1, 0, 56));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pedidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idpedido", "Idquarto", "idclien", "Datapedido", "Pedido", "Valorpedido"
            }
        ));
        jScrollPane2.setViewportView(tblPedido);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 709, 219));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ID do Hóspede");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 249, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Serviço");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 249, -1, -1));

        Buscar.setBackground(new java.awt.Color(25, 14, 79));
        Buscar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setText("Buscar");
        Buscar.setAlignmentY(0.0F);
        Buscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        Buscar.setBorderPainted(false);
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.setFocusPainted(false);
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarMouseExited(evt);
            }
        });
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jPanel4.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 320, 63, 33));

        txtPedID.setBackground(new java.awt.Color(229, 229, 229));
        txtPedID.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPedID.setForeground(new java.awt.Color(0, 0, 0));
        txtPedID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPedID.setPreferredSize(new java.awt.Dimension(55, 25));
        txtPedID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedIDActionPerformed(evt);
            }
        });
        jPanel4.add(txtPedID, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 273, 150, -1));

        cbPedPes.setBackground(new java.awt.Color(255, 255, 255));
        cbPedPes.setEditable(true);
        cbPedPes.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cbPedPes.setForeground(new java.awt.Color(0, 0, 0));
        cbPedPes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o quarto...", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310" }));
        cbPedPes.setToolTipText("");
        cbPedPes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbPedPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPedPesActionPerformed(evt);
            }
        });
        cbPedPes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbPedPesKeyReleased(evt);
            }
        });
        jPanel4.add(cbPedPes, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 273, 222, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bar-service.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 392, -1, -1));

        CancelarPedido.setBackground(new java.awt.Color(255, 255, 255));
        CancelarPedido.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        CancelarPedido.setForeground(new java.awt.Color(255, 255, 255));
        CancelarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        CancelarPedido.setToolTipText("Cancelar Pedido");
        CancelarPedido.setAlignmentY(0.0F);
        CancelarPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        CancelarPedido.setBorderPainted(false);
        CancelarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelarPedido.setFocusPainted(false);
        CancelarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelarPedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelarPedidoMouseExited(evt);
            }
        });
        CancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarPedidoActionPerformed(evt);
            }
        });
        jPanel4.add(CancelarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 440, 115, 80));

        ConfirmarPedido.setBackground(new java.awt.Color(255, 255, 255));
        ConfirmarPedido.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        ConfirmarPedido.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmation.png"))); // NOI18N
        ConfirmarPedido.setToolTipText("Confirmar Pedido");
        ConfirmarPedido.setAlignmentY(0.0F);
        ConfirmarPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        ConfirmarPedido.setBorderPainted(false);
        ConfirmarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfirmarPedido.setFocusPainted(false);
        ConfirmarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConfirmarPedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConfirmarPedidoMouseExited(evt);
            }
        });
        ConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarPedidoActionPerformed(evt);
            }
        });
        jPanel4.add(ConfirmarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 114, 80));

        txtPedPedido.setBackground(new java.awt.Color(229, 229, 229));
        txtPedPedido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPedPedido.setForeground(new java.awt.Color(0, 0, 0));
        txtPedPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPedPedido.setPreferredSize(new java.awt.Dimension(55, 25));
        txtPedPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedPedidoActionPerformed(evt);
            }
        });
        jPanel4.add(txtPedPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 273, 240, -1));

        txtPedValor.setBackground(new java.awt.Color(229, 229, 229));
        txtPedValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPedValor.setForeground(new java.awt.Color(0, 0, 0));
        txtPedValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPedValor.setPreferredSize(new java.awt.Dimension(55, 25));
        txtPedValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPedValorMouseClicked(evt);
            }
        });
        txtPedValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedValorActionPerformed(evt);
            }
        });
        jPanel4.add(txtPedValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 334, 240, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Valor");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 311, -1, -1));

        txtPedQuarto.setBackground(new java.awt.Color(255, 255, 255));
        txtPedQuarto.setEditable(true);
        txtPedQuarto.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        txtPedQuarto.setForeground(new java.awt.Color(0, 0, 0));
        txtPedQuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quartos", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310" }));
        txtPedQuarto.setToolTipText("");
        txtPedQuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPedQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedQuartoActionPerformed(evt);
            }
        });
        jPanel4.add(txtPedQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 334, 150, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(0, 12));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 733, -1));

        AlterarPedido.setBackground(new java.awt.Color(255, 255, 255));
        AlterarPedido.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        AlterarPedido.setForeground(new java.awt.Color(255, 255, 255));
        AlterarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        AlterarPedido.setToolTipText("Alterar Pedido");
        AlterarPedido.setAlignmentY(0.0F);
        AlterarPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        AlterarPedido.setBorderPainted(false);
        AlterarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AlterarPedido.setFocusPainted(false);
        AlterarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AlterarPedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AlterarPedidoMouseExited(evt);
            }
        });
        AlterarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarPedidoActionPerformed(evt);
            }
        });
        jPanel4.add(AlterarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 440, 114, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved

    }//GEN-LAST:event_jPanel1MouseMoved

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Buscar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_BuscarMouseEntered

    private void BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseExited
        Buscar.setForeground(Color.WHITE);
    }//GEN-LAST:event_BuscarMouseExited

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        consultar_servico();
        Consultar();
    }//GEN-LAST:event_BuscarActionPerformed

    private void txtPedIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPedIDActionPerformed

    private void cbPedPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPedPesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPedPesActionPerformed

    private void cbPedPesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbPedPesKeyReleased

    }//GEN-LAST:event_cbPedPesKeyReleased

    private void CancelarPedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarPedidoMouseEntered
        CancelarPedido.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CancelarPedidoMouseEntered

    private void CancelarPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarPedidoMouseExited
        CancelarPedido.setForeground(Color.WHITE);
    }//GEN-LAST:event_CancelarPedidoMouseExited

    private void CancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarPedidoActionPerformed
        remover();
    }//GEN-LAST:event_CancelarPedidoActionPerformed

    private void ConfirmarPedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarPedidoMouseEntered
        ConfirmarPedido.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ConfirmarPedidoMouseEntered

    private void ConfirmarPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarPedidoMouseExited
        ConfirmarPedido.setForeground(Color.WHITE);
    }//GEN-LAST:event_ConfirmarPedidoMouseExited

    private void ConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarPedidoActionPerformed
        confirmar();
    }//GEN-LAST:event_ConfirmarPedidoActionPerformed

    private void txtPedPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPedPedidoActionPerformed

    private void txtPedValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPedValorMouseClicked
        txtPedValor.setText("R$");
    }//GEN-LAST:event_txtPedValorMouseClicked

    private void txtPedValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPedValorActionPerformed

    private void txtPedQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedQuartoActionPerformed

    }//GEN-LAST:event_txtPedQuartoActionPerformed

    private void AlterarPedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarPedidoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AlterarPedidoMouseEntered

    private void AlterarPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarPedidoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AlterarPedidoMouseExited

    private void AlterarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarPedidoActionPerformed
       alterar();
       consultar_servico();
    }//GEN-LAST:event_AlterarPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarPedido;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton CancelarPedido;
    private javax.swing.JButton ConfirmarPedido;
    public static javax.swing.JComboBox<String> cbPedPes;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblPedido;
    public static javax.swing.JTextField txtPedID;
    public static javax.swing.JTextField txtPedPedido;
    public static javax.swing.JComboBox<String> txtPedQuarto;
    public static javax.swing.JTextField txtPedValor;
    // End of variables declaration//GEN-END:variables
}
