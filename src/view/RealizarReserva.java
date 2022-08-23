/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import dal.ModulodeConexão;
import java.sql.*;
import view2.*;
import static view.FecharEstadia.*;

/**
 *
 * @author Ramiro Dantas
 */
public class RealizarReserva extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private void inserir(){
       String sql = "update quartos set disponibilidade = ? where idquarto = ?";      
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,cbQuarDis.getSelectedItem().toString());
                pst.setString(2,cbRes.getSelectedItem().toString());
                if(cbQuarDis.getSelectedItem().toString().equals("Disponibilidade")){
                    new Campos().setVisible(true);
                } else {
                     int add = pst.executeUpdate();
                    
                if (add> 0) {
                    cbQuarDis.setSelectedItem("Disponibilidade");
                    pst.close();
                }
                }
                
            } catch (Exception e) {
                new Erro().setVisible(true);
                        
            }
            
    }
    private void adicionar(){
        String sql = "insert into reservaquarto(idquarto,idclien,datasaida,valor) values (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,cbRes.getSelectedItem().toString());
            pst.setString(2,txtResID.getText());
            pst.setString(3,txtResDatasaida.getText());
            pst.setString(4,txtResValor.getText());
            if (txtResID.getText().isEmpty() || txtResDatasaida.getText().isEmpty() || txtResValor.getText().isEmpty() || cbRes.getSelectedItem().toString().equals("Selecione o quarto...")){
                new Campos().setVisible(true);
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new ReservaFeita().setVisible(true);
                    txtResID.setText("");
                    txtResValor.setText("");
                    txtResDatasaida.setText("");
                    cbRes.setSelectedItem("Quartos");
                    pst.close();
                }
            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }
    
    public void consultar(){
        String sql="select * from reservaquarto where idclien=?";
        try {
               pst = conexao.prepareStatement(sql);
               pst.setString(1,txtResIDPes.getText());
               rs = pst.executeQuery();
               if(rs.next()){
                   txtResIDReserva.setText(rs.getString(1));
                   cbResPes.setSelectedItem(rs.getString(2));
                   txtResDataReserva.setText(rs.getString(4));
                   txtResDataSaida.setText(rs.getString(5));
                   txtResValorPes.setText(rs.getString(6));
                   pst.close();
               } else {
                   new ReservaNCadastrada().setVisible(true);
                    txtResIDReserva.setText("");
                    cbResPes.setSelectedItem("Quartos");
                    txtResDataSaida.setText("");
                    txtResValorPes.setText("");
                    txtResDataReserva.setText("");
                    pst.close();
               }
           } catch (Exception e) {
               new Erro().setVisible(true);
           }
    }
    private void alterar(){
        String sql = "update reservaquarto set idreserva=?,idquarto=?,datasaida=?,valor=? where idclien=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtResIDReserva.getText());
            pst.setString(2, cbResPes.getSelectedItem().toString());
            pst.setString(3, txtResDataSaida.getText());
            pst.setString(4, txtResValorPes.getText());
            pst.setString(5, txtResIDPes.getText());
            if (txtResIDReserva.getText().isEmpty() || cbResPes.getSelectedItem().toString().isEmpty()|| txtResDataSaida.getText().isEmpty() || txtResValorPes.getText().isEmpty())  {
                new Campos().setVisible(true);
                pst.close();
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new ReservATT().setVisible(true);
                    txtResIDReserva.setText("");
                    cbResPes.setSelectedItem("Quartos");
                    txtResDataSaida.setText("");
                    txtResValorPes.setText("");
                    txtResDataReserva.setText("");
                    pst.close();
                }
            }

        } catch (Exception e) {
            new Erro().setVisible(true);
        }

    }
    
    private void remover(){
         if(txtResIDPes.getText().equals("Digite o ID do Hóspede")){
            new Reserva().setVisible(true);
        } else {
            new ExcluirReserva().setVisible(true);
        }
    }
    public RealizarReserva() {
        initComponents();
        conexao = ModulodeConexão.conector();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtResID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbRes = new javax.swing.JComboBox<>();
        btnReservar = new javax.swing.JButton();
        txtResDatasaida = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtResValor = new javax.swing.JTextField();
        cbQuarDis = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        Buscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtResIDReserva = new javax.swing.JTextField();
        txtResDataReserva = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Excluir = new javax.swing.JButton();
        FecharEstadia = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        AlterarDados = new javax.swing.JButton();
        txtResDataSaida = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtResIDPes = new javax.swing.JTextField();
        txtResValorPes = new javax.swing.JTextField();
        cbResPes = new javax.swing.JComboBox<>();

        setBorder(null);

        jPanel2.setBackground(new java.awt.Color(1, 0, 56));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reserva ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 148, 34), 1, true), "Realizar Reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        txtResID.setBackground(new java.awt.Color(229, 229, 229));
        txtResID.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtResID.setForeground(new java.awt.Color(0, 0, 0));
        txtResID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtResID.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Valor");

        cbRes.setBackground(new java.awt.Color(255, 255, 255));
        cbRes.setEditable(true);
        cbRes.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cbRes.setForeground(new java.awt.Color(0, 0, 0));
        cbRes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o quarto...", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310" }));
        cbRes.setToolTipText("");
        cbRes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbResActionPerformed(evt);
            }
        });

        btnReservar.setBackground(new java.awt.Color(25, 14, 79));
        btnReservar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnReservar.setForeground(new java.awt.Color(255, 255, 255));
        btnReservar.setText("Reservar");
        btnReservar.setAlignmentY(0.0F);
        btnReservar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        btnReservar.setBorderPainted(false);
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservar.setFocusPainted(false);
        btnReservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbtnReservarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbtnReservarMouseExited(evt);
            }
        });
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbtnReservarActionPerformed(evt);
            }
        });

        txtResDatasaida.setBackground(new java.awt.Color(229, 229, 229));
        txtResDatasaida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtResDatasaida.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtResDatasaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtResDatasaida.setPreferredSize(new java.awt.Dimension(103, 25));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Data de Saída");

        txtResValor.setBackground(new java.awt.Color(229, 229, 229));
        txtResValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtResValor.setForeground(new java.awt.Color(0, 0, 0));
        txtResValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtResValor.setPreferredSize(new java.awt.Dimension(55, 25));
        txtResValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtResValorMouseClicked(evt);
            }
        });
        txtResValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResValorActionPerformed(evt);
            }
        });

        cbQuarDis.setBackground(new java.awt.Color(255, 255, 255));
        cbQuarDis.setEditable(true);
        cbQuarDis.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cbQuarDis.setForeground(new java.awt.Color(0, 0, 0));
        cbQuarDis.setMaximumRowCount(9);
        cbQuarDis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponibilidade", "Ocupado" }));
        cbQuarDis.setToolTipText("");
        cbQuarDis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbQuarDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQuarDisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtResID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtResValor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(cbQuarDis, 0, 162, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(cbRes, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtResDatasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbQuarDis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResDatasaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 708, 210));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 148, 34), 1, true), "Excluir e Alterar Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

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

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID da Reserva");

        txtResIDReserva.setBackground(new java.awt.Color(229, 229, 229));
        txtResIDReserva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtResIDReserva.setForeground(new java.awt.Color(0, 0, 0));
        txtResIDReserva.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtResIDReserva.setPreferredSize(new java.awt.Dimension(55, 25));

        txtResDataReserva.setBackground(new java.awt.Color(229, 229, 229));
        txtResDataReserva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtResDataReserva.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtResDataReserva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-## ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtResDataReserva.setPreferredSize(new java.awt.Dimension(103, 25));
        txtResDataReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResDataReservaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Pesquisar Reserva");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Data da reserva");

        Excluir.setBackground(new java.awt.Color(255, 255, 255));
        Excluir.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Excluir.setForeground(new java.awt.Color(255, 255, 255));
        Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        Excluir.setAlignmentY(0.0F);
        Excluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        Excluir.setBorderPainted(false);
        Excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Excluir.setFocusPainted(false);
        Excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExcluirMouseExited(evt);
            }
        });
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        FecharEstadia.setBackground(new java.awt.Color(25, 14, 79));
        FecharEstadia.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        FecharEstadia.setForeground(new java.awt.Color(255, 255, 255));
        FecharEstadia.setText("Fechar Estadia");
        FecharEstadia.setAlignmentY(0.0F);
        FecharEstadia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        FecharEstadia.setBorderPainted(false);
        FecharEstadia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FecharEstadia.setFocusPainted(false);
        FecharEstadia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FecharEstadiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FecharEstadiaMouseExited(evt);
            }
        });
        FecharEstadia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharEstadiaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Valor");

        AlterarDados.setBackground(new java.awt.Color(255, 255, 255));
        AlterarDados.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        AlterarDados.setForeground(new java.awt.Color(255, 255, 255));
        AlterarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        AlterarDados.setAlignmentY(0.0F);
        AlterarDados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        AlterarDados.setBorderPainted(false);
        AlterarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AlterarDados.setFocusPainted(false);
        AlterarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AlterarDadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AlterarDadosMouseExited(evt);
            }
        });
        AlterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarDadosActionPerformed(evt);
            }
        });

        txtResDataSaida.setBackground(new java.awt.Color(229, 229, 229));
        txtResDataSaida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtResDataSaida.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtResDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtResDataSaida.setPreferredSize(new java.awt.Dimension(103, 25));
        txtResDataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResDataSaidaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Data de Saída");

        txtResIDPes.setBackground(new java.awt.Color(255, 255, 255));
        txtResIDPes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtResIDPes.setForeground(new java.awt.Color(0, 0, 0));
        txtResIDPes.setText("Digite o ID do Hóspede");
        txtResIDPes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtResIDPes.setPreferredSize(new java.awt.Dimension(55, 25));
        txtResIDPes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtResIDPesMouseClicked(evt);
            }
        });

        txtResValorPes.setBackground(new java.awt.Color(229, 229, 229));
        txtResValorPes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtResValorPes.setForeground(new java.awt.Color(0, 0, 0));
        txtResValorPes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtResValorPes.setPreferredSize(new java.awt.Dimension(55, 25));
        txtResValorPes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtResValorPesMouseClicked(evt);
            }
        });

        cbResPes.setBackground(new java.awt.Color(255, 255, 255));
        cbResPes.setEditable(true);
        cbResPes.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cbResPes.setForeground(new java.awt.Color(0, 0, 0));
        cbResPes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quartos", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310" }));
        cbResPes.setToolTipText("");
        cbResPes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbResPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbResPesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtResValorPes, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbResPes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(263, 263, 263))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtResDataReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(190, 190, 190)))
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtResIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(275, 275, 275)
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtResIDPes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299)
                        .addComponent(FecharEstadia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(218, 218, 218))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtResIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtResIDPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtResDataReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbResPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtResDataSaida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResValorPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(FecharEstadia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel7.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 228, 708, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved

    }//GEN-LAST:event_jPanel2MouseMoved

    private void cbResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResActionPerformed
        
    }//GEN-LAST:event_cbResActionPerformed

    private void btnbtnReservarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbtnReservarMouseEntered
        btnReservar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnbtnReservarMouseEntered

    private void btnbtnReservarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbtnReservarMouseExited
        btnReservar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnbtnReservarMouseExited

    private void btnbtnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbtnReservarActionPerformed
        inserir();
        adicionar();
    }//GEN-LAST:event_btnbtnReservarActionPerformed

    private void txtResValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResValorActionPerformed

    private void AlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarDadosActionPerformed
        alterar();
    }//GEN-LAST:event_AlterarDadosActionPerformed

    private void AlterarDadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarDadosMouseExited
        AlterarDados.setForeground(Color.WHITE);
    }//GEN-LAST:event_AlterarDadosMouseExited

    private void AlterarDadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarDadosMouseEntered
        AlterarDados.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_AlterarDadosMouseEntered

    private void FecharEstadiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharEstadiaActionPerformed

        String sql="select * from clien where idclien=?";
        try {
               pst = conexao.prepareStatement(sql);
               pst.setString(1,txtResIDPes.getText());
               rs = pst.executeQuery();
               if(rs.next()){
                   new FecharEstadia().setVisible(true);
                   txtEstNome.setText(rs.getString(2));
                   txtEstEmail.setText(rs.getString(3));
                   txtEstFone.setText(rs.getString(4));
                   txtEstCPF.setText(rs.getString(7));
                   
                   pst.close();
               } else {
                   new Reserva().setVisible(true);
               }
           } catch (Exception e) {
               new Erro().setVisible(true);
               System.out.println(e);
                       
           }
        
           String rsl = "select * from reservaquarto where idclien=?";
        try {
               pst = conexao.prepareStatement(rsl);
               pst.setString(1,txtResIDPes.getText());
               rs = pst.executeQuery();
               if(rs.next()){
                   txtEstEntrada.setText(rs.getString(4));
                   txtEstSaida.setText(rs.getString(5));
                   txtEstValor.setText(rs.getString(6));
                   pst.close();
               } else {
                  
               }
           } catch (Exception e) {
               new Erro().setVisible(true);
               System.out.println(e);
                       
           }
           
    }//GEN-LAST:event_FecharEstadiaActionPerformed

    private void FecharEstadiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FecharEstadiaMouseExited
        FecharEstadia.setForeground(Color.WHITE);
    }//GEN-LAST:event_FecharEstadiaMouseExited

    private void FecharEstadiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FecharEstadiaMouseEntered
        FecharEstadia.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_FecharEstadiaMouseEntered

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        remover();
    }//GEN-LAST:event_ExcluirActionPerformed

    private void ExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirMouseExited
        Excluir.setForeground(Color.WHITE);
    }//GEN-LAST:event_ExcluirMouseExited

    private void ExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirMouseEntered
        Excluir.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ExcluirMouseEntered

    private void txtResDataReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResDataReservaActionPerformed

    }//GEN-LAST:event_txtResDataReservaActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        consultar();
    }//GEN-LAST:event_BuscarActionPerformed

    private void BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseExited
        Buscar.setForeground(Color.WHITE);
    }//GEN-LAST:event_BuscarMouseExited

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Buscar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_BuscarMouseEntered

    private void cbResPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResPesActionPerformed

    }//GEN-LAST:event_cbResPesActionPerformed

    private void txtResDataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResDataSaidaActionPerformed

    }//GEN-LAST:event_txtResDataSaidaActionPerformed

    private void txtResValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResValorMouseClicked
        txtResValor.setText("R$");
    }//GEN-LAST:event_txtResValorMouseClicked

    private void cbQuarDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQuarDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbQuarDisActionPerformed

    private void txtResIDPesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResIDPesMouseClicked
        txtResIDPes.setText("");
    }//GEN-LAST:event_txtResIDPesMouseClicked

    private void txtResValorPesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResValorPesMouseClicked
       txtResValorPes.setText("R$");
    }//GEN-LAST:event_txtResValorPesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarDados;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton FecharEstadia;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cbQuarDis;
    private javax.swing.JComboBox<String> cbRes;
    public static javax.swing.JComboBox<String> cbResPes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public static javax.swing.JFormattedTextField txtResDataReserva;
    public static javax.swing.JFormattedTextField txtResDataSaida;
    private javax.swing.JFormattedTextField txtResDatasaida;
    private javax.swing.JTextField txtResID;
    public static javax.swing.JTextField txtResIDPes;
    public static javax.swing.JTextField txtResIDReserva;
    private javax.swing.JTextField txtResValor;
    public static javax.swing.JTextField txtResValorPes;
    // End of variables declaration//GEN-END:variables
}
