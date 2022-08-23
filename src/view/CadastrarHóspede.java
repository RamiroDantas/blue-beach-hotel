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
/**
 *
 * @author Ramiro Dantas
 */
public class CadastrarHóspede extends javax.swing.JInternalFrame {
       Connection conexao = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
    
    private void adiciona(){
        String sql = "insert into clien(idclien,usuarioclien,emeilclien,foneclien,loginclien,senhaclien,cpfclien,rgclien)VALUES(?,?,?,?,?,?,?,?)";
           try {
              pst = conexao.prepareStatement(sql);
              pst.setString(1,txtHosID.getText());
              pst.setString(2,txtHosNome.getText());
              pst.setString(3,txtHosEmail.getText());
              pst.setString(4,txtHosFone.getText());
              pst.setString(5,txtHosUsu.getText());
              pst.setString(6,txtHosSenha.getText());
              pst.setString(7,txtHosCPF.getText());
              pst.setString(8,txtHosRG.getText());
              
              if(txtHosID.getText().isEmpty() || txtHosNome.getText().isEmpty()|| txtHosEmail.getText().isEmpty()|| txtHosFone.getText().isEmpty() || txtHosUsu.getText().isEmpty()|| txtHosSenha.getText().isEmpty() || txtHosCPF.getText().isEmpty() || txtHosRG.getText().isEmpty()){
                  new Campos().setVisible(true);
              } else {
              
              //a linha abaixo atualiza a tabela usuários
              int adicionado = pst.executeUpdate();
              if(adicionado>0){
                  new UserCadastrado().setVisible(true);
                txtHosID.setText("");
                txtHosNome.setText("");
                txtHosEmail.setText("");
                txtHosFone.setText("");
                txtHosUsu.setText("");
                txtHosSenha.setText("");
                txtHosCPF.setText("");
                txtHosRG.setText("");
              }
              }
           } catch (Exception e) {
                new UserJCadastrado().setVisible(true);
           }  
    }
    private void consultar(){
        String sql="select * from clien where idclien=?";
        try {
               pst = conexao.prepareStatement(sql);
               pst.setString(1,txtHosIDPes.getText());
               rs = pst.executeQuery();
               if(rs.next()){
                   txtHosID.setText(rs.getString(1));
                   txtHosNome.setText(rs.getString(2));
                   txtHosEmail.setText(rs.getString(3));
                   txtHosFone.setText(rs.getString(4));
                   txtHosUsu.setText(rs.getString(5));
                   txtHosSenha.setText(rs.getString(6));
                   txtHosCPF.setText(rs.getString(7));
                   txtHosRG.setText(rs.getString(8));
               } else {
                   new UsuárioNCadastrado().setVisible(true);
                    txtHosID.setText("");
                    txtHosNome.setText("");
                    txtHosEmail.setText("");
                    txtHosFone.setText("");
                    txtHosUsu.setText("");
                    txtHosSenha.setText("");
                    txtHosCPF.setText("");
                    txtHosRG.setText("");
                    pst.close();
               }
           } catch (Exception e) {
           }
    }
    
    private void remover(){
        if(txtHosNome.getText().isEmpty()){
            new UsuárioNãoEncontrado().setVisible(true);
        } else {
            new Excluirconta3().setVisible(true);
        }
    }
    private void alterar(){
        String sql = "update clien set usuarioclien=?,emeilclien=?,foneclien=?,loginclien=?,senhaclien=?,cpfclien=?,rgclien=? where idclien=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtHosNome.getText());
            pst.setString(2, txtHosEmail.getText());
            pst.setString(3, txtHosFone.getText());
            pst.setString(4, txtHosUsu.getText());
            pst.setString(5, txtHosSenha.getText());
            pst.setString(6, txtHosCPF.getText());
            pst.setString(7, txtHosRG.getText());
            pst.setString(8, txtHosIDPes.getText());
            if (txtHosIDPes.getText().isEmpty() || txtHosNome.getText().isEmpty() || txtHosEmail.getText().isEmpty() || txtHosFone.getText().isEmpty() || txtHosUsu.getText().isEmpty() || txtHosSenha.getText().isEmpty() || txtHosCPF.getText().isEmpty())  {
                new Campos().setVisible(true);
                pst.close();
            } else {

                //a linha abaixo atualiza a tabela usuários
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    new UsuárioATT().setVisible(true);
                    txtHosNome.setText("");
                    txtHosEmail.setText("");
                    txtHosFone.setText("");
                    txtHosUsu.setText("");
                    txtHosSenha.setText("");
                    txtHosCPF.setText("");
                    txtHosRG.setText("");
                    pst.close();
                }
            }

        } catch (Exception e) {
            new Erro().setVisible(true);
        }

    }
    
    public CadastrarHóspede() {
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
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHosFone = new javax.swing.JFormattedTextField();
        txtHosEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHosCPF = new javax.swing.JFormattedTextField();
        txtHosSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JButton();
        txtHosUsu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        AlterarDados = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHosNome = new javax.swing.JTextField();
        txtHosRG = new javax.swing.JTextField();
        txtHosID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHosIDPes = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(730, 631));

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
        jLabel1.setText("Hóspede ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(284, 284, 284)
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 148, 34), 1, true), "Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email");

        txtHosFone.setBackground(new java.awt.Color(229, 229, 229));
        txtHosFone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtHosFone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtHosFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHosFone.setPreferredSize(new java.awt.Dimension(103, 25));
        txtHosFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHosFoneActionPerformed(evt);
            }
        });

        txtHosEmail.setBackground(new java.awt.Color(229, 229, 229));
        txtHosEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtHosEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtHosEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHosEmail.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefone");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CPF");

        txtHosCPF.setBackground(new java.awt.Color(229, 229, 229));
        txtHosCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtHosCPF.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtHosCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHosCPF.setPreferredSize(new java.awt.Dimension(103, 25));

        txtHosSenha.setBackground(new java.awt.Color(229, 229, 229));
        txtHosSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHosSenha.setPreferredSize(new java.awt.Dimension(109, 25));

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

        txtHosUsu.setBackground(new java.awt.Color(229, 229, 229));
        txtHosUsu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtHosUsu.setForeground(new java.awt.Color(0, 0, 0));
        txtHosUsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHosUsu.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("RG");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pesquisar Hóspede");

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

        txtHosNome.setBackground(new java.awt.Color(229, 229, 229));
        txtHosNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtHosNome.setForeground(new java.awt.Color(0, 0, 0));
        txtHosNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHosNome.setPreferredSize(new java.awt.Dimension(55, 25));
        txtHosNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHosNomeActionPerformed(evt);
            }
        });

        txtHosRG.setBackground(new java.awt.Color(229, 229, 229));
        txtHosRG.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtHosRG.setForeground(new java.awt.Color(0, 0, 0));
        txtHosRG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHosRG.setPreferredSize(new java.awt.Dimension(55, 25));

        txtHosID.setBackground(new java.awt.Color(229, 229, 229));
        txtHosID.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtHosID.setForeground(new java.awt.Color(0, 0, 0));
        txtHosID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHosID.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ID");

        txtHosIDPes.setBackground(new java.awt.Color(255, 255, 255));
        txtHosIDPes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtHosIDPes.setForeground(new java.awt.Color(0, 0, 0));
        txtHosIDPes.setText("Digite o seu ID");
        txtHosIDPes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHosIDPes.setPreferredSize(new java.awt.Dimension(55, 25));
        txtHosIDPes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHosIDPesMouseClicked(evt);
            }
        });
        txtHosIDPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHosIDPesActionPerformed(evt);
            }
        });

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
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(AlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtHosNome, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHosEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtHosFone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHosCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(75, 75, 75)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(txtHosRG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(80, 80, 80)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtHosUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                    .addComponent(txtHosSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(319, 319, 319))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(299, 299, 299))))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addGap(255, 255, 255)
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtHosID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8)))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(jLabel10)
                                                    .addGap(8, 8, 8)
                                                    .addComponent(txtHosIDPes, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addComponent(txtHosEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHosNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHosFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9))
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHosCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHosUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHosRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHosSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHosID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHosIDPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlterarDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 730, 631);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved

    }//GEN-LAST:event_jPanel2MouseMoved

    private void txtHosFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHosFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHosFoneActionPerformed

    private void CadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastrarMouseEntered
        Cadastrar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CadastrarMouseEntered

    private void CadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastrarMouseExited
        Cadastrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_CadastrarMouseExited

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        adiciona();
    }//GEN-LAST:event_CadastrarActionPerformed

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

    private void txtHosNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHosNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHosNomeActionPerformed

    private void txtHosIDPesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHosIDPesMouseClicked
       txtHosIDPes.setText("");
    }//GEN-LAST:event_txtHosIDPesMouseClicked

    private void txtHosIDPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHosIDPesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHosIDPesActionPerformed


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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JFormattedTextField txtHosCPF;
    public static javax.swing.JTextField txtHosEmail;
    public static javax.swing.JFormattedTextField txtHosFone;
    public static javax.swing.JTextField txtHosID;
    public static javax.swing.JTextField txtHosIDPes;
    public static javax.swing.JTextField txtHosNome;
    public static javax.swing.JTextField txtHosRG;
    public static javax.swing.JPasswordField txtHosSenha;
    public static javax.swing.JTextField txtHosUsu;
    // End of variables declaration//GEN-END:variables
}
