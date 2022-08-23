/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import javax.swing.JFrame;
import view2.*;
import java.sql.*;
import dal.ModulodeConexão;
/**
 *
 * @author Ramiro Dantas
 */
public class CadastrarADM extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private void adiciona(){
        String sql = "insert into users (usuario,emeil,fone,login,senha,cpf,rg)VALUES(?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtAdmNome.getText());
            pst.setString(2, txtAdmEmail.getText());
            pst.setString(3, txtAdmFone.getText());
            pst.setString(4, txtAdmUsu.getText());
            pst.setString(5, txtAdmSenha.getText());
            pst.setString(6, txtAdmCPF.getText());
            pst.setString(7, txtAdmRG.getText());

            if (txtAdmNome.getText().isEmpty() || txtAdmEmail.getText().isEmpty() || txtAdmFone.getText().isEmpty() || txtAdmUsu.getText().isEmpty() || txtAdmSenha.getText().isEmpty() || txtAdmCPF.getText().isEmpty()) {
                new Campos().setVisible(true);
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new UserJCadastrado().setVisible(true);
                    txtAdmNome.setText("");
                    txtAdmEmail.setText("");
                    txtAdmFone.setText("");
                    txtAdmUsu.setText("");
                    txtAdmSenha.setText("");
                    txtAdmCPF.setText("");
                    txtAdmRG.setText("");
                    pst.close();
                }
            }
        } catch (Exception e) {
           new UserJCadastrado().setVisible(true);
        }
    }
    
    private void consultar(){
        String sql = "select * from users where cpf=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtAdmPes.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtAdmNome.setText(rs.getString(2));
                txtAdmEmail.setText(rs.getString(3));
                txtAdmFone.setText(rs.getString(4));
                txtAdmUsu.setText(rs.getString(5));
                txtAdmSenha.setText(rs.getString(6));
                txtAdmCPF.setText(rs.getString(7));
                txtAdmRG.setText(rs.getString(8));

                pst.close();
            } else {
                new UsuárioNCadastrado().setVisible(true);
                    txtAdmNome.setText("");
                    txtAdmEmail.setText("");
                    txtAdmFone.setText("");
                    txtAdmUsu.setText("");
                    txtAdmSenha.setText("");
                    txtAdmCPF.setText("");
                    txtAdmRG.setText("");
                    pst.close();

            }
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }
    
    private void remover(){
        if (txtAdmNome.getText().isEmpty()) {
            new UsuárioNãoEncontrado().setVisible(true);
        } else {
                new Excluirconta1().setVisible(true);
        }
    }
    
    private void alterar(){
        String sql = "update users set usuario=?,emeil=?,fone=?,login=?,senha=?,cpf=?,rg=? where cpf=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtAdmNome.getText());
            pst.setString(2, txtAdmEmail.getText());
            pst.setString(3, txtAdmFone.getText());
            pst.setString(4, txtAdmUsu.getText());
            pst.setString(5, txtAdmSenha.getText());
            pst.setString(6, txtAdmCPF.getText());
            pst.setString(7, txtAdmRG.getText());
            pst.setString(8, txtAdmPes.getText());
            if (txtAdmNome.getText().isEmpty() || txtAdmEmail.getText().isEmpty() || txtAdmFone.getText().isEmpty() || txtAdmUsu.getText().isEmpty() || txtAdmSenha.getText().isEmpty() || txtAdmCPF.getText().isEmpty()) {
                new Campos().setVisible(true);
                pst.close();
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new UsuárioATT().setVisible(true);
                    txtAdmNome.setText("");
                    txtAdmEmail.setText("");
                    txtAdmFone.setText("");
                    txtAdmUsu.setText("");
                    txtAdmSenha.setText("");
                    txtAdmCPF.setText("");
                    txtAdmRG.setText("");
                    pst.close();
                }
            }

        } catch (Exception e) {
            new Erro().setVisible(true);
        }
    }
    
    public CadastrarADM() {
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
        minimizar = new javax.swing.JLabel();
        fechar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtAdmFone = new javax.swing.JFormattedTextField();
        txtAdmEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtAdmCPF = new javax.swing.JFormattedTextField();
        txtAdmSenha = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        btnCadastrar1 = new javax.swing.JButton();
        txtAdmUsu = new javax.swing.JTextField();
        txtAdmPes = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Buscar1 = new javax.swing.JButton();
        Excluir1 = new javax.swing.JButton();
        AlterarDados1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtAdmNome = new javax.swing.JTextField();
        txtAdmRG = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(1, 0, 56));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizar.setFont(new java.awt.Font("Rubik", 1, 36)); // NOI18N
        minimizar.setForeground(new java.awt.Color(255, 255, 255));
        minimizar.setText("_");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizarMouseExited(evt);
            }
        });
        jPanel2.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, -1, -1));

        fechar.setFont(new java.awt.Font("SF Sports Night NS Upright", 1, 36)); // NOI18N
        fechar.setForeground(new java.awt.Color(255, 255, 255));
        fechar.setText("X");
        fechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fecharMouseExited(evt);
            }
        });
        jPanel2.add(fechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrador");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 27, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 148, 34), 1, true), "Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nome");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Email");

        txtAdmFone.setBackground(new java.awt.Color(229, 229, 229));
        txtAdmFone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAdmFone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtAdmFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAdmFone.setPreferredSize(new java.awt.Dimension(103, 25));
        txtAdmFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdmFoneActionPerformed(evt);
            }
        });

        txtAdmEmail.setBackground(new java.awt.Color(229, 229, 229));
        txtAdmEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAdmEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtAdmEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAdmEmail.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Telefone");

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("CPF");

        txtAdmCPF.setBackground(new java.awt.Color(229, 229, 229));
        txtAdmCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAdmCPF.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtAdmCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAdmCPF.setPreferredSize(new java.awt.Dimension(103, 25));

        txtAdmSenha.setBackground(new java.awt.Color(229, 229, 229));
        txtAdmSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAdmSenha.setPreferredSize(new java.awt.Dimension(109, 25));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Usuário");

        btnCadastrar1.setBackground(new java.awt.Color(25, 14, 79));
        btnCadastrar1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnCadastrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar1.setText("Cadastrar");
        btnCadastrar1.setAlignmentY(0.0F);
        btnCadastrar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        btnCadastrar1.setBorderPainted(false);
        btnCadastrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar1.setFocusPainted(false);
        btnCadastrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastrar1MouseExited(evt);
            }
        });
        btnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar1ActionPerformed(evt);
            }
        });

        txtAdmUsu.setBackground(new java.awt.Color(229, 229, 229));
        txtAdmUsu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAdmUsu.setForeground(new java.awt.Color(0, 0, 0));
        txtAdmUsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAdmUsu.setPreferredSize(new java.awt.Dimension(55, 25));

        txtAdmPes.setBackground(new java.awt.Color(255, 255, 255));
        txtAdmPes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAdmPes.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtAdmPes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAdmPes.setToolTipText("CPF");
        txtAdmPes.setPreferredSize(new java.awt.Dimension(103, 25));
        txtAdmPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdmPesActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("RG");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N
        jLabel18.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Pesquisar Administrador");

        Buscar1.setBackground(new java.awt.Color(25, 14, 79));
        Buscar1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Buscar1.setForeground(new java.awt.Color(255, 255, 255));
        Buscar1.setText("Buscar");
        Buscar1.setAlignmentY(0.0F);
        Buscar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        Buscar1.setBorderPainted(false);
        Buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar1.setFocusPainted(false);
        Buscar1.setPreferredSize(new java.awt.Dimension(32, 22));
        Buscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Buscar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Buscar1MouseExited(evt);
            }
        });
        Buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar1ActionPerformed(evt);
            }
        });

        Excluir1.setBackground(new java.awt.Color(255, 255, 255));
        Excluir1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Excluir1.setForeground(new java.awt.Color(255, 255, 255));
        Excluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        Excluir1.setToolTipText("Excluir conta");
        Excluir1.setAlignmentY(0.0F);
        Excluir1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        Excluir1.setBorderPainted(false);
        Excluir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Excluir1.setFocusPainted(false);
        Excluir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Excluir1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Excluir1MouseExited(evt);
            }
        });
        Excluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excluir1ActionPerformed(evt);
            }
        });

        AlterarDados1.setBackground(new java.awt.Color(255, 255, 255));
        AlterarDados1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        AlterarDados1.setForeground(new java.awt.Color(255, 255, 255));
        AlterarDados1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        AlterarDados1.setToolTipText("Alterar Conta");
        AlterarDados1.setAlignmentY(0.0F);
        AlterarDados1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        AlterarDados1.setBorderPainted(false);
        AlterarDados1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AlterarDados1.setFocusPainted(false);
        AlterarDados1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AlterarDados1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AlterarDados1MouseExited(evt);
            }
        });
        AlterarDados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarDados1ActionPerformed(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clipboard.png"))); // NOI18N
        jLabel20.setToolTipText("");

        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Senha");

        txtAdmNome.setBackground(new java.awt.Color(229, 229, 229));
        txtAdmNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAdmNome.setForeground(new java.awt.Color(0, 0, 0));
        txtAdmNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAdmNome.setPreferredSize(new java.awt.Dimension(55, 25));
        txtAdmNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdmNomeActionPerformed(evt);
            }
        });

        txtAdmRG.setBackground(new java.awt.Color(229, 229, 229));
        txtAdmRG.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAdmRG.setForeground(new java.awt.Color(0, 0, 0));
        txtAdmRG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAdmRG.setPreferredSize(new java.awt.Dimension(55, 25));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(235, 235, 235)
                        .addComponent(jLabel12)
                        .addGap(233, 233, 233)
                        .addComponent(jLabel14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel18)
                        .addGap(8, 8, 8)
                        .addComponent(txtAdmPes, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(Excluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(AlterarDados1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(txtAdmNome, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAdmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAdmFone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtAdmCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))
                                    .addGap(75, 75, 75)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(txtAdmRG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(80, 80, 80)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(txtAdmUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel21)
                                                .addComponent(txtAdmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(319, 319, 319))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(288, 288, 288)))
                                    .addComponent(btnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAdmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAdmNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAdmFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel17))
                    .addComponent(jLabel16))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAdmCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdmUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdmRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addGap(6, 6, 6)
                        .addComponent(txtAdmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel19))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAdmPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlterarDados1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Excluir1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jLabel20)))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved

    }//GEN-LAST:event_jPanel2MouseMoved

    private void txtAdmFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdmFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdmFoneActionPerformed

    private void btnCadastrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrar1MouseEntered
        btnCadastrar1.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnCadastrar1MouseEntered

    private void btnCadastrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrar1MouseExited
        btnCadastrar1.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnCadastrar1MouseExited

    private void btnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar1ActionPerformed
        adiciona();
    }//GEN-LAST:event_btnCadastrar1ActionPerformed

    private void txtAdmPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdmPesActionPerformed

    }//GEN-LAST:event_txtAdmPesActionPerformed

    private void Buscar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buscar1MouseEntered
        Buscar1.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_Buscar1MouseEntered

    private void Buscar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buscar1MouseExited
        Buscar1.setForeground(Color.WHITE);
    }//GEN-LAST:event_Buscar1MouseExited

    private void Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar1ActionPerformed
        consultar();
    }//GEN-LAST:event_Buscar1ActionPerformed

    private void Excluir1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Excluir1MouseEntered
        Excluir1.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_Excluir1MouseEntered

    private void Excluir1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Excluir1MouseExited
        Excluir1.setForeground(Color.WHITE);
    }//GEN-LAST:event_Excluir1MouseExited

    private void Excluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excluir1ActionPerformed
        remover();
    }//GEN-LAST:event_Excluir1ActionPerformed

    private void AlterarDados1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarDados1MouseEntered
        AlterarDados1.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_AlterarDados1MouseEntered

    private void AlterarDados1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarDados1MouseExited
        AlterarDados1.setForeground(Color.WHITE);
    }//GEN-LAST:event_AlterarDados1MouseExited

    private void AlterarDados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarDados1ActionPerformed
        alterar();
    }//GEN-LAST:event_AlterarDados1ActionPerformed

    private void txtAdmNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdmNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdmNomeActionPerformed

    private void fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseClicked

       this.dispose();
    }//GEN-LAST:event_fecharMouseClicked

    private void fecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseEntered
        fechar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_fecharMouseEntered

    private void fecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseExited
        fechar.setForeground(Color.WHITE);
    }//GEN-LAST:event_fecharMouseExited

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked

        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseEntered

        minimizar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_minimizarMouseEntered

    private void minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseExited

        minimizar.setForeground(Color.WHITE);
    }//GEN-LAST:event_minimizarMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarDados1;
    private javax.swing.JButton Buscar1;
    private javax.swing.JButton Excluir1;
    private javax.swing.JButton btnCadastrar1;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel minimizar;
    public static javax.swing.JFormattedTextField txtAdmCPF;
    public static javax.swing.JTextField txtAdmEmail;
    public static javax.swing.JFormattedTextField txtAdmFone;
    public static javax.swing.JTextField txtAdmNome;
    public static javax.swing.JFormattedTextField txtAdmPes;
    public static javax.swing.JTextField txtAdmRG;
    public static javax.swing.JPasswordField txtAdmSenha;
    public static javax.swing.JTextField txtAdmUsu;
    // End of variables declaration//GEN-END:variables
}
