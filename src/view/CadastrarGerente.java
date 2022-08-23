/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view2.*;
import java.awt.Color;
import java.sql.*;
import dal.ModulodeConexão;

/**
 *
 * @author Ramiro Dantas
 */
public class CadastrarGerente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void consultar() {
        String sql = "select * from users2 where cpf2=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtGerPes.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtGerNome.setText(rs.getString(2));
                txtGerEmail.setText(rs.getString(3));
                txtGerFone.setText(rs.getString(4));
                txtGerUsu.setText(rs.getString(5));
                txtGerSenha.setText(rs.getString(6));
                txtGerCPF.setText(rs.getString(7));
                txtGerRG.setText(rs.getString(8));

                pst.close();
            } else {
                new UsuárioNCadastrado().setVisible(true);
                    txtGerNome.setText("");
                    txtGerEmail.setText("");
                    txtGerFone.setText("");
                    txtGerUsu.setText("");
                    txtGerSenha.setText("");
                    txtGerCPF.setText("");
                    txtGerRG.setText("");
                    pst.close();

            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }

    }

    private void alterar() {
        String sql = "update users2 set usuario2=?,emeil2=?,fone2=?,login2=?,senha2=?,cpf2=?,rg2=? where cpf2=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtGerNome.getText());
            pst.setString(2, txtGerEmail.getText());
            pst.setString(3, txtGerFone.getText());
            pst.setString(4, txtGerUsu.getText());
            pst.setString(5, txtGerSenha.getText());
            pst.setString(6, txtGerCPF.getText());
            pst.setString(7, txtGerRG.getText());
            pst.setString(8, txtGerPes.getText());
            if (txtGerNome.getText().isEmpty() || txtGerEmail.getText().isEmpty() || txtGerFone.getText().isEmpty() || txtGerUsu.getText().isEmpty() || txtGerSenha.getText().isEmpty() || txtGerCPF.getText().isEmpty()) {
                new Campos().setVisible(true);
                pst.close();
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new UsuárioATT().setVisible(true);
                    txtGerNome.setText("");
                    txtGerEmail.setText("");
                    txtGerFone.setText("");
                    txtGerUsu.setText("");
                    txtGerSenha.setText("");
                    txtGerCPF.setText("");
                    txtGerRG.setText("");
                    pst.close();
                }
            }

        } catch (Exception e) {
            new Erro().setVisible(true);
        }

    }

    private void adiciona() {
        String sql = "insert into users2(usuario2,emeil2,fone2,login2,senha2,cpf2,rg2)VALUES(?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtGerNome.getText());
            pst.setString(2, txtGerEmail.getText());
            pst.setString(3, txtGerFone.getText());
            pst.setString(4, txtGerUsu.getText());
            pst.setString(5, txtGerSenha.getText());
            pst.setString(6, txtGerCPF.getText());
            pst.setString(7, txtGerRG.getText());

            if (txtGerNome.getText().isEmpty() || txtGerEmail.getText().isEmpty() || txtGerFone.getText().isEmpty() || txtGerUsu.getText().isEmpty() || txtGerSenha.getText().isEmpty() || txtGerCPF.getText().isEmpty()) {
                new Campos().setVisible(true);
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new UserCadastrado().setVisible(true);
                    txtGerNome.setText("");
                    txtGerEmail.setText("");
                    txtGerFone.setText("");
                    txtGerUsu.setText("");
                    txtGerSenha.setText("");
                    txtGerCPF.setText("");
                    txtGerRG.setText("");
                    pst.close();
                }
            }
        } catch (Exception e) {
            new UserJCadastrado().setVisible(true);
        }

    }

    private void remover() {
        if (txtGerNome.getText().isEmpty()) {
            new UsuárioNãoEncontrado().setVisible(true);
        } else {
                new Excluirconta2().setVisible(true);
        }
    }
    public CadastrarGerente() {
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGerFone = new javax.swing.JFormattedTextField();
        txtGerEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGerCPF = new javax.swing.JFormattedTextField();
        txtGerSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        txtGerUsu = new javax.swing.JTextField();
        txtGerPes = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        AlterarDados = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGerNome = new javax.swing.JTextField();
        txtGerRG = new javax.swing.JTextField();

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
        jLabel1.setText("Gerente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(303, 303, 303))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(716, 488));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 148, 34), 1, true), "Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email");

        txtGerFone.setBackground(new java.awt.Color(229, 229, 229));
        txtGerFone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtGerFone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtGerFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtGerFone.setPreferredSize(new java.awt.Dimension(103, 25));
        txtGerFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGerFoneActionPerformed(evt);
            }
        });

        txtGerEmail.setBackground(new java.awt.Color(229, 229, 229));
        txtGerEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtGerEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtGerEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtGerEmail.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefone");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CPF");

        txtGerCPF.setBackground(new java.awt.Color(229, 229, 229));
        txtGerCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtGerCPF.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtGerCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtGerCPF.setPreferredSize(new java.awt.Dimension(103, 25));

        txtGerSenha.setBackground(new java.awt.Color(229, 229, 229));
        txtGerSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtGerSenha.setPreferredSize(new java.awt.Dimension(109, 25));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Usuário");

        btnCadastrar.setBackground(new java.awt.Color(25, 14, 79));
        btnCadastrar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setAlignmentY(0.0F);
        btnCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseExited(evt);
            }
        });
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txtGerUsu.setBackground(new java.awt.Color(229, 229, 229));
        txtGerUsu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtGerUsu.setForeground(new java.awt.Color(0, 0, 0));
        txtGerUsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtGerUsu.setPreferredSize(new java.awt.Dimension(55, 25));

        txtGerPes.setBackground(new java.awt.Color(255, 255, 255));
        txtGerPes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtGerPes.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtGerPes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtGerPes.setToolTipText("CPF");
        txtGerPes.setPreferredSize(new java.awt.Dimension(103, 25));
        txtGerPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGerPesActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("RG");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pesquisar Gerente");

        Buscar.setBackground(new java.awt.Color(25, 14, 79));
        Buscar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setText("Buscar");
        Buscar.setAlignmentY(0.0F);
        Buscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        Buscar.setBorderPainted(false);
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.setFocusPainted(false);
        Buscar.setPreferredSize(new java.awt.Dimension(32, 22));
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

        Excluir.setBackground(new java.awt.Color(255, 255, 255));
        Excluir.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Excluir.setForeground(new java.awt.Color(255, 255, 255));
        Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        Excluir.setToolTipText("Excluir conta");
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

        AlterarDados.setBackground(new java.awt.Color(255, 255, 255));
        AlterarDados.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        AlterarDados.setForeground(new java.awt.Color(255, 255, 255));
        AlterarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        AlterarDados.setToolTipText("Alterar Conta");
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clipboard.png"))); // NOI18N
        jLabel3.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Senha");

        txtGerNome.setBackground(new java.awt.Color(229, 229, 229));
        txtGerNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtGerNome.setForeground(new java.awt.Color(0, 0, 0));
        txtGerNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtGerNome.setPreferredSize(new java.awt.Dimension(55, 25));
        txtGerNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGerNomeActionPerformed(evt);
            }
        });

        txtGerRG.setBackground(new java.awt.Color(229, 229, 229));
        txtGerRG.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtGerRG.setForeground(new java.awt.Color(0, 0, 0));
        txtGerRG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtGerRG.setPreferredSize(new java.awt.Dimension(55, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(235, 235, 235)
                        .addComponent(jLabel4)
                        .addGap(233, 233, 233)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel10)
                        .addGap(8, 8, 8)
                        .addComponent(txtGerPes, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(AlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtGerNome, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGerFone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtGerCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(75, 75, 75)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(txtGerRG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(80, 80, 80)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtGerUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(txtGerSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(319, 319, 319))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(299, 299, 299)))
                                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGerNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtGerFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9))
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGerCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGerUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGerRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addComponent(txtGerSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGerPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlterarDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );

        setBounds(0, 0, 730, 631);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved

    }//GEN-LAST:event_jPanel2MouseMoved

    private void txtGerFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGerFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGerFoneActionPerformed

    private void btnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseEntered
        btnCadastrar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnCadastrarMouseEntered

    private void btnCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseExited
        btnCadastrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnCadastrarMouseExited

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        adiciona();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Buscar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_BuscarMouseEntered

    private void BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseExited
        Buscar.setForeground(Color.WHITE);
    }//GEN-LAST:event_BuscarMouseExited

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        consultar();
    }//GEN-LAST:event_BuscarActionPerformed

    private void ExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirMouseEntered
        Excluir.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ExcluirMouseEntered

    private void ExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirMouseExited
        Excluir.setForeground(Color.WHITE);
    }//GEN-LAST:event_ExcluirMouseExited

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        remover();
    }//GEN-LAST:event_ExcluirActionPerformed

    private void AlterarDadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarDadosMouseEntered
        AlterarDados.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_AlterarDadosMouseEntered

    private void AlterarDadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarDadosMouseExited
        AlterarDados.setForeground(Color.WHITE);
    }//GEN-LAST:event_AlterarDadosMouseExited

    private void AlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarDadosActionPerformed
        alterar();
    }//GEN-LAST:event_AlterarDadosActionPerformed

    private void txtGerNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGerNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGerNomeActionPerformed

    private void txtGerPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGerPesActionPerformed

    }//GEN-LAST:event_txtGerPesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarDados;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JFormattedTextField txtGerCPF;
    public static javax.swing.JTextField txtGerEmail;
    public static javax.swing.JFormattedTextField txtGerFone;
    public static javax.swing.JTextField txtGerNome;
    public static javax.swing.JFormattedTextField txtGerPes;
    public static javax.swing.JTextField txtGerRG;
    public static javax.swing.JPasswordField txtGerSenha;
    public static javax.swing.JTextField txtGerUsu;
    // End of variables declaration//GEN-END:variables
}
