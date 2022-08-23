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
public class AlugarSalão extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void consultar_servico() {
        String sql = "Select * from alugarsalao where idclien like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSalaoPesHos.getText() + "%");
            rs = pst.executeQuery();

            tblSalao.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }

    private void Consultar() {
        String sql = "Select * from alugarsalao where idclien=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSalaoPesHos.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtSalaoHos.setText(rs.getString(1));
                cbCaixaDeR.setSelectedItem(rs.getString(2));
                cbCaixaTurno.setSelectedItem(rs.getString(3));
                cbCaixaDeDias.setSelectedItem(rs.getString(4));
                txtSalaoValor.setText(rs.getString(5));
                txtSalaoDataAluguel.setText(rs.getString(5));
                pst.close();
            } else {
                new CadastraNEncon().setVisible(true);
                txtSalaoHos.setText("");
                txtSalaoValor.setText("");
                cbCaixaDeR.setSelectedItem("Selecione...");
                cbCaixaTurno.setSelectedItem("Turno...");
                cbCaixaDeDias.setSelectedItem("Quantidade de dias...");
                txtSalaoDataAluguel.setText("");
                pst.close();
            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }

    private void adicionar() {
        String sql = "insert into alugarsalao (idclien,reservar,turno,quatidadededias,datadealuguel,valor) values (?,?,?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSalaoHos.getText());
            pst.setString(2, cbCaixaDeR.getSelectedItem().toString());
            pst.setString(3, cbCaixaTurno.getSelectedItem().toString());
            pst.setString(4, cbCaixaDeDias.getSelectedItem().toString());
            pst.setString(5, txtSalaoDataAluguel.getText());
            pst.setString(6, txtSalaoValor.getText());
            if (txtSalaoHos.getText().isEmpty() || txtSalaoValor.getText().isEmpty() || txtSalaoDataAluguel.getText().isEmpty() || cbCaixaTurno.getSelectedItem().toString().equals("Turno...") || cbCaixaDeDias.getSelectedItem().toString().equals("Quantidade de dias...") || cbCaixaDeR.getSelectedItem().toString().equals("Selecione...")) {
                new Campos().setVisible(true);
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new ReservaSalao().setVisible(true);
                    txtSalaoHos.setText("");
                    txtSalaoValor.setText("");
                    txtSalaoDataAluguel.setText("");
                    cbCaixaDeR.setSelectedItem("Selecione...");
                    cbCaixaDeDias.setSelectedItem("Quantidade de dias...");
                    cbCaixaTurno.setSelectedItem("Turno...");
                    pst.close();
                }
            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }

    }

    private void excluir() {
        if (txtSalaoPesHos.getText().equals("Digite o ID")) {
            new SalaoRes().setVisible(true);
        } else {
            new ExcluirSalão().setVisible(true);
        }
    }
    
    private void alterar(){
        String sql = "update alugarsalao set idclien=?,reservar =?, turno =?, quatidadededias=?,datadealuguel = ? , valor = ? where idclien=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSalaoHos.getText());
            pst.setString(2,cbCaixaDeR.getSelectedItem().toString());
            pst.setString(3,cbCaixaTurno.getSelectedItem().toString());
            pst.setString(4,cbCaixaDeDias.getSelectedItem().toString());
            pst.setString(5, txtSalaoDataAluguel.getText());
            pst.setString(6, txtSalaoValor.getText());
            pst.setString(7, txtSalaoPesHos.getText());
            if (txtSalaoHos.getText().isEmpty() || cbCaixaDeR.getSelectedItem().equals("Selecione...") || cbCaixaTurno.getSelectedItem().equals("Turno...") || cbCaixaDeDias.getSelectedItem().equals("Quantidade de dias") || txtSalaoDataAluguel.getText().equals("  /  /    ") || txtSalaoValor.getText().isEmpty()) {
                new Campos().setVisible(true);
               pst.close();
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new SalaoATT().setVisible(true);
                    txtSalaoHos.setText("");
                    cbCaixaDeR.setSelectedItem("Selecione...");
                    cbCaixaTurno.setSelectedItem("Turno...");
                    cbCaixaDeDias.setSelectedItem("Quantidade de dias...");
                    txtSalaoValor.setText("");
                    txtSalaoDataAluguel.setText("");
                    pst.close();
                }
            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }

    public AlugarSalão() {
        initComponents();
        conexao = ModulodeConexão.conector();
        JTableHeader header = tblSalao.getTableHeader();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbCaixaDeR = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        cbCaixaDeDias = new javax.swing.JComboBox<>();
        txtSalaoPesHos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSalaoValor = new javax.swing.JFormattedTextField();
        btnAlugar = new javax.swing.JButton();
        cbCaixaTurno = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSalao = new javax.swing.JTable();
        Buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAlterarDados = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSalaoHos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSalaoDataAluguel = new javax.swing.JFormattedTextField();

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
        jLabel1.setText("Alugar Salão");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(266, 266, 266)
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Data de Aluguel");

        cbCaixaDeR.setBackground(new java.awt.Color(255, 255, 255));
        cbCaixaDeR.setEditable(true);
        cbCaixaDeR.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cbCaixaDeR.setForeground(new java.awt.Color(0, 0, 0));
        cbCaixaDeR.setMaximumRowCount(3);
        cbCaixaDeR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Reserva", "Aluguel" }));
        cbCaixaDeR.setToolTipText("");
        cbCaixaDeR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbCaixaDeR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaixaDeRActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Pesquisar Responsável");

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnExcluir.setAlignmentY(0.0F);
        btnExcluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        btnExcluir.setBorderPainted(false);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setFocusPainted(false);
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirMouseExited(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        cbCaixaDeDias.setBackground(new java.awt.Color(255, 255, 255));
        cbCaixaDeDias.setEditable(true);
        cbCaixaDeDias.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cbCaixaDeDias.setForeground(new java.awt.Color(0, 0, 0));
        cbCaixaDeDias.setMaximumRowCount(9);
        cbCaixaDeDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quantidade de dias...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbCaixaDeDias.setToolTipText("");
        cbCaixaDeDias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbCaixaDeDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaixaDeDiasActionPerformed(evt);
            }
        });

        txtSalaoPesHos.setBackground(new java.awt.Color(255, 255, 255));
        txtSalaoPesHos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSalaoPesHos.setForeground(new java.awt.Color(0, 0, 0));
        txtSalaoPesHos.setText("Digite o ID");
        txtSalaoPesHos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtSalaoPesHos.setPreferredSize(new java.awt.Dimension(55, 25));
        txtSalaoPesHos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSalaoPesHosMouseClicked(evt);
            }
        });
        txtSalaoPesHos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaoPesHosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Valor");

        txtSalaoValor.setBackground(new java.awt.Color(255, 255, 255));
        txtSalaoValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSalaoValor.setForeground(new java.awt.Color(0, 0, 0));
        txtSalaoValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtSalaoValor.setPreferredSize(new java.awt.Dimension(103, 25));
        txtSalaoValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSalaoValorMouseClicked(evt);
            }
        });
        txtSalaoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaoValorActionPerformed(evt);
            }
        });

        btnAlugar.setBackground(new java.awt.Color(25, 14, 79));
        btnAlugar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnAlugar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlugar.setText("Alugar");
        btnAlugar.setAlignmentY(0.0F);
        btnAlugar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        btnAlugar.setBorderPainted(false);
        btnAlugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlugar.setFocusPainted(false);
        btnAlugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlugarMouseExited(evt);
            }
        });
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        cbCaixaTurno.setBackground(new java.awt.Color(255, 255, 255));
        cbCaixaTurno.setEditable(true);
        cbCaixaTurno.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cbCaixaTurno.setForeground(new java.awt.Color(0, 0, 0));
        cbCaixaTurno.setMaximumRowCount(4);
        cbCaixaTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turno...", "Manhã", "Tarde", "Noite" }));
        cbCaixaTurno.setToolTipText("");
        cbCaixaTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbCaixaTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaixaTurnoActionPerformed(evt);
            }
        });

        tblSalao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idclien", "reservar", "turno", "quantidadededias", "datadealuguel", "Valor"
            }
        ));
        tblSalao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSalaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSalao);
        if (tblSalao.getColumnModel().getColumnCount() > 0) {
            tblSalao.getColumnModel().getColumn(0).setResizable(false);
            tblSalao.getColumnModel().getColumn(1).setResizable(false);
            tblSalao.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblSalao.getColumnModel().getColumn(2).setResizable(false);
            tblSalao.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblSalao.getColumnModel().getColumn(3).setResizable(false);
            tblSalao.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cocktail.png"))); // NOI18N

        btnAlterarDados.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterarDados.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnAlterarDados.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        btnAlterarDados.setAlignmentY(0.0F);
        btnAlterarDados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        btnAlterarDados.setBorderPainted(false);
        btnAlterarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterarDados.setFocusPainted(false);
        btnAlterarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlterarDadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlterarDadosMouseExited(evt);
            }
        });
        btnAlterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDadosActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N

        txtSalaoHos.setBackground(new java.awt.Color(229, 229, 229));
        txtSalaoHos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSalaoHos.setForeground(new java.awt.Color(0, 0, 0));
        txtSalaoHos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtSalaoHos.setPreferredSize(new java.awt.Dimension(55, 25));
        txtSalaoHos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaoHosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID do Hóspede");

        txtSalaoDataAluguel.setBackground(new java.awt.Color(229, 229, 229));
        txtSalaoDataAluguel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSalaoDataAluguel.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtSalaoDataAluguel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtSalaoDataAluguel.setPreferredSize(new java.awt.Dimension(103, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbCaixaDeR, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCaixaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSalaoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnAlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSalaoPesHos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtSalaoHos, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtSalaoDataAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCaixaDeDias, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbCaixaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSalaoHos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSalaoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalaoDataAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCaixaDeR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbCaixaDeDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSalaoPesHos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlterarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved

    }//GEN-LAST:event_jPanel2MouseMoved

    private void cbCaixaDeDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaixaDeDiasActionPerformed

    }//GEN-LAST:event_cbCaixaDeDiasActionPerformed

    private void txtSalaoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaoValorActionPerformed

    }//GEN-LAST:event_txtSalaoValorActionPerformed

    private void btnAlugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlugarMouseEntered
        btnAlugar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnAlugarMouseEntered

    private void btnAlugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlugarMouseExited
        btnAlugar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnAlugarMouseExited

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAlugarActionPerformed

    private void cbCaixaTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaixaTurnoActionPerformed

    }//GEN-LAST:event_cbCaixaTurnoActionPerformed

    private void cbCaixaDeRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaixaDeRActionPerformed

    }//GEN-LAST:event_cbCaixaDeRActionPerformed

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

    private void btnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseEntered
        btnExcluir.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnExcluirMouseEntered

    private void btnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseExited
        btnExcluir.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnExcluirMouseExited

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarDadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarDadosMouseEntered
        btnAlterarDados.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnAlterarDadosMouseEntered

    private void btnAlterarDadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarDadosMouseExited
        btnAlterarDados.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnAlterarDadosMouseExited

    private void btnAlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDadosActionPerformed
        alterar();
        consultar_servico();
    }//GEN-LAST:event_btnAlterarDadosActionPerformed

    private void txtSalaoPesHosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaoPesHosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaoPesHosActionPerformed

    private void txtSalaoPesHosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalaoPesHosMouseClicked
        txtSalaoPesHos.setText("");
    }//GEN-LAST:event_txtSalaoPesHosMouseClicked

    private void txtSalaoHosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaoHosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaoHosActionPerformed

    private void txtSalaoValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalaoValorMouseClicked
        txtSalaoValor.setText("R$");
    }//GEN-LAST:event_txtSalaoValorMouseClicked

    private void tblSalaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSalaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton btnAlterarDados;
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnExcluir;
    public static javax.swing.JComboBox<String> cbCaixaDeDias;
    public static javax.swing.JComboBox<String> cbCaixaDeR;
    public static javax.swing.JComboBox<String> cbCaixaTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblSalao;
    public static javax.swing.JFormattedTextField txtSalaoDataAluguel;
    public static javax.swing.JTextField txtSalaoHos;
    public static javax.swing.JTextField txtSalaoPesHos;
    public static javax.swing.JFormattedTextField txtSalaoValor;
    // End of variables declaration//GEN-END:variables
}
