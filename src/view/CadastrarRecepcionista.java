/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import view2.*;
import dal.ModulodeConexão;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ramiro Dantas
 */
public class CadastrarRecepcionista extends javax.swing.JInternalFrame {
    Connection conexao = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
    
    private void adiciona(){
        String sql = "insert into users3(usuario3,emeil3,fone3,login3,senha3,cpf3,rg3,hrdetrabalho3)values (?,?,?,?,?,?,?,?)";
           try {
              pst = conexao.prepareStatement(sql);
              pst.setString(1,txtRecNome.getText());
              pst.setString(2,txtRecEmail.getText());
              pst.setString(3,txtRecFone.getText());
              pst.setString(4,txtRecUsu.getText());
              pst.setString(5,txtRecSenha.getText());
              pst.setString(6,txtRecCPF.getText());
              pst.setString(7,txtRecRG.getText());
              pst.setString(8,txtRecHR.getText());
              
              if(txtRecNome.getText().isEmpty()|| txtRecEmail.getText().isEmpty()|| txtRecFone.getText().isEmpty() || txtRecUsu.getText().isEmpty()|| txtRecSenha.getText().isEmpty() || txtRecCPF.getText().isEmpty() || txtRecRG.getText().isEmpty() || txtRecHR.getText().isEmpty()){
                  new Campos().setVisible(true);
              } else {
              
              //a linha abaixo atualiza a tabela usuários
              int adicionado = pst.executeUpdate();
              if(adicionado>0){
                  new UserCadastrado().setVisible(true);
                  txtRecNome.setText("");
                  txtRecEmail.setText("");
                  txtRecFone.setText("");
                  txtRecUsu.setText("");
                  txtRecSenha.setText("");
                  txtRecCPF.setText("");
                  txtRecRG.setText("");
                  txtRecHR.setText("");
           
              }
              }
           } catch (Exception e) {
              new UserJCadastrado().setVisible(true);
           }
           
           
    }
    private void consultar(){
        String sql="select * from users3 where cpf3=?";
        try {
               pst = conexao.prepareStatement(sql);
               pst.setString(1,txtRecPes.getText());
               rs = pst.executeQuery();
               if(rs.next()){
                   txtRecNome.setText(rs.getString(2));
                   txtRecEmail.setText(rs.getString(3));
                   txtRecFone.setText(rs.getString(4));
                   txtRecUsu.setText(rs.getString(5));
                   txtRecSenha.setText(rs.getString(6));
                   txtRecCPF.setText(rs.getString(7));
                   txtRecRG.setText(rs.getString(8));
                   txtRecHR.setText(rs.getString(10));
               } else {
                   new UsuárioNCadastrado().setVisible(true);
                   txtRecNome.setText("");
                       txtRecEmail.setText("");
                       txtRecFone.setText("");
                       txtRecUsu.setText("");
                       txtRecSenha.setText("");
                       txtRecCPF.setText("");
                       txtRecRG.setText("");
                       txtRecHR.setText("");
                       pst.close();
               }
                } catch (Exception e) {
                new Erro().setVisible(true);
           }
        
    }
    
    private void alterar(){
       String sql = "update users3 set usuario3=?,emeil3=?,fone3=?,login3=?,senha3=?,cpf3=?,rg3=?,hrdetrabalho3=? where cpf3=?";
       try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtRecNome.getText());
            pst.setString(2,txtRecEmail.getText());
            pst.setString(3,txtRecFone.getText());
            pst.setString(4,txtRecUsu.getText());
            pst.setString(5,txtRecSenha.getText());
            pst.setString(6,txtRecCPF.getText());
            pst.setString(7,txtRecRG.getText());
            pst.setString(8,txtRecHR.getText());
            pst.setString(9,txtRecPes.getText());
            if (txtRecNome.getText().isEmpty() || txtRecEmail.getText().isEmpty() || txtRecFone.getText().isEmpty() || txtRecUsu.getText().isEmpty() || txtRecSenha.getText().isEmpty() || txtRecCPF.getText().isEmpty() || txtRecHR.getText().isEmpty()) {
                   new Campos().setVisible(true);
                   pst.close();
               } else {

                   //a linha abaixo atualiza a tabela usuários
                   int adicionado = pst.executeUpdate();
                   if (adicionado > 0) {
                       new UsuárioATT().setVisible(true);
                       txtRecNome.setText("");
                       txtRecEmail.setText("");
                       txtRecFone.setText("");
                       txtRecUsu.setText("");
                       txtRecSenha.setText("");
                       txtRecCPF.setText("");
                       txtRecRG.setText("");
                       txtRecHR.setText("");
                       pst.close();

                   }
               }
            
        } catch (Exception e) {
            new Erro().setVisible(true);
        }
       
    }
    
    private void remover(){
        if(txtRecNome.getText().isEmpty()){
            new UsuárioNãoEncontrado().setVisible(true);
        } else { 
            new Excluirconta().setVisible(true);
        }

    }

    public CadastrarRecepcionista() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtRecHR = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRecFone = new javax.swing.JFormattedTextField();
        txtRecEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRecCPF = new javax.swing.JFormattedTextField();
        txtRecSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtRecUsu = new javax.swing.JTextField();
        txtRecPes = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        AlterarDados = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtRecNome = new javax.swing.JTextField();
        txtRecRG = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(1, 0, 56));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recepcionista");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jLabel1)
                .addGap(255, 255, 255))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 148, 34), 1, true), "Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        txtRecHR.setBackground(new java.awt.Color(229, 229, 229));
        txtRecHR.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRecHR.setForeground(new java.awt.Color(0, 0, 0));
        txtRecHR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtRecHR.setPreferredSize(new java.awt.Dimension(55, 25));
        txtRecHR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecHRActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email");

        txtRecFone.setBackground(new java.awt.Color(229, 229, 229));
        txtRecFone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRecFone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtRecFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRecFone.setPreferredSize(new java.awt.Dimension(103, 25));
        txtRecFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecFoneActionPerformed(evt);
            }
        });

        txtRecEmail.setBackground(new java.awt.Color(229, 229, 229));
        txtRecEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRecEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtRecEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtRecEmail.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefone");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CPF");

        txtRecCPF.setBackground(new java.awt.Color(229, 229, 229));
        txtRecCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRecCPF.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtRecCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRecCPF.setPreferredSize(new java.awt.Dimension(103, 25));

        txtRecSenha.setBackground(new java.awt.Color(229, 229, 229));
        txtRecSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtRecSenha.setPreferredSize(new java.awt.Dimension(109, 25));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Usuário");

        Cadastrar.setBackground(new java.awt.Color(25, 14, 79));
        Cadastrar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        Cadastrar.setText("Cadastrar");
        Cadastrar.setAlignmentY(0.0F);
        Cadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 0, 56), 2, true));
        Cadastrar.setBorderPainted(false);
        Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cadastrar.setFocusPainted(false);
        Cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CadastrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CadastrarMouseExited(evt);
            }
        });
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Horário de trabalho");

        txtRecUsu.setBackground(new java.awt.Color(229, 229, 229));
        txtRecUsu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRecUsu.setForeground(new java.awt.Color(0, 0, 0));
        txtRecUsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtRecUsu.setPreferredSize(new java.awt.Dimension(55, 25));

        txtRecPes.setBackground(new java.awt.Color(255, 255, 255));
        txtRecPes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRecPes.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtRecPes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRecPes.setToolTipText("CPF");
        txtRecPes.setPreferredSize(new java.awt.Dimension(103, 25));
        txtRecPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecPesActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("RG");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pesquisar Recepcionista");

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

        txtRecNome.setBackground(new java.awt.Color(229, 229, 229));
        txtRecNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRecNome.setForeground(new java.awt.Color(0, 0, 0));
        txtRecNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtRecNome.setPreferredSize(new java.awt.Dimension(55, 25));
        txtRecNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecNomeActionPerformed(evt);
            }
        });

        txtRecRG.setBackground(new java.awt.Color(229, 229, 229));
        txtRecRG.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRecRG.setForeground(new java.awt.Color(0, 0, 0));
        txtRecRG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtRecRG.setPreferredSize(new java.awt.Dimension(55, 25));

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
                        .addComponent(txtRecPes, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
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
                                    .addComponent(txtRecNome, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRecEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtRecFone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRecCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(75, 75, 75)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(txtRecRG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(80, 80, 80)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtRecUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(txtRecSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(36, 36, 36)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtRecHR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                            .addGap(138, 138, 138))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(299, 299, 299)))
                                    .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                        .addComponent(txtRecEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRecNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtRecFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9))
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRecCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRecUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRecRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel13)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRecSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRecHR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRecPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AlterarDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved

    }//GEN-LAST:event_jPanel1MouseMoved

    private void txtRecHRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecHRActionPerformed
        // TODO add your handling code here: ew
    }//GEN-LAST:event_txtRecHRActionPerformed

    private void txtRecFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecFoneActionPerformed

    private void CadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastrarMouseEntered
        Cadastrar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CadastrarMouseEntered

    private void CadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastrarMouseExited
        Cadastrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_CadastrarMouseExited

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        adiciona();
    }//GEN-LAST:event_CadastrarActionPerformed

    private void txtRecPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecPesActionPerformed

    }//GEN-LAST:event_txtRecPesActionPerformed

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

    private void txtRecNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarDados;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton Excluir;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JFormattedTextField txtRecCPF;
    public static javax.swing.JTextField txtRecEmail;
    public static javax.swing.JFormattedTextField txtRecFone;
    public static javax.swing.JTextField txtRecHR;
    public static javax.swing.JTextField txtRecNome;
    public static javax.swing.JFormattedTextField txtRecPes;
    public static javax.swing.JTextField txtRecRG;
    public static javax.swing.JPasswordField txtRecSenha;
    public static javax.swing.JTextField txtRecUsu;
    // End of variables declaration//GEN-END:variables
}
