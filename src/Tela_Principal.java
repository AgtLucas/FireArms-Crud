
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tela_Principal extends javax.swing.JFrame {

    private int option;
    private int selectd;
    private int last;
    private int next;
    private int row = 0;
    String[] Country = {"Brasil", "Japão", "Rússia", "França", "Estados Unidos", "UK", "Israel", "Alemanha"};

    public Tela_Principal() throws Exception {
        initComponents();
        mainInit();
    }

    public void clearTable() {
        DefaultTableModel tblRemove = (DefaultTableModel) Tabela.getModel();
        if (tblRemove.getRowCount() > 0) {
            int FinalTabela = tblRemove.getRowCount();
            for (int i = 0; i < FinalTabela; FinalTabela--) {
                tblRemove.removeRow(i);
            }
        }
    }

    // Método para buscar próxima Arma
    private Weapons nextWeapons() throws Exception {
        row++;
        Weapons o = new Weapons();
        WeaponsDAO dao = new WeaponsDAO();
        o = dao.nextWeapons(row);
        __Id.setText(o.getId() + "");
        __Marca.setText(o.getBrand() + "");
        __Modelo.setText(o.getModel() + "");
        __Calibre.setText(o.getCaliber() + "");
        __PaisOrigem.removeAllItems();
        __PaisOrigem.addItem(o.getCountry() + "");
        __Preco.setText(o.getPrice() + "");
        return o;
    }

    // Método para buscar Arma Anterior
    private Weapons previousWeapons() throws Exception {
        row--;
        Weapons o = new Weapons();
        WeaponsDAO dao = new WeaponsDAO();
        o = dao.nextWeapons(row);
        __Id.setText(o.getId() + "");
        __Marca.setText(o.getBrand() + "");
        __Modelo.setText(o.getModel() + "");
        __Calibre.setText(o.getCaliber() + "");
        __PaisOrigem.removeAllItems();
        __PaisOrigem.addItem(o.getCountry() + "");
        __Preco.setText(o.getPrice() + "");
        return o;
    }

    // Método para Buscar o Último Id
    private void nextIdWeapons() throws Exception {
        WeaponsDAO dao = new WeaponsDAO();
        ArrayList<Weapons> weapons = dao.findAll();
        for (Weapons o : weapons) {
            next = o.getId() + 1;
        }
    }

    // Método com meus Inicializadores
    private void mainInit() throws Exception {
        WeaponsDAO dao = new WeaponsDAO();

        last = dao.countAll();
        selectd = 1;

        print();
        notEnable();
        nextWeapons();
        nextIdWeapons();

        // Setando os Botões
        BSalvar.setEnabled(false);
        BLimpar.setEnabled(false);
        BExcluir.setEnabled(false);
        BPrimeiro.setEnabled(false);
        BAnterior.setEnabled(false);
        BProximo.setEnabled(true);
        BUltimo.setEnabled(true);
    }

    // Método para Impressão na Tela
    private void print() {
        __Impressao.setText("                     " + selectd + " de " + last);
    }

    // Método para Desativar os Campos
    private void notEnable() {
        __Id.setEnabled(false);
        __Marca.setEnabled(false);
        __Modelo.setEnabled(false);
        __Calibre.setEnabled(false);
        __PaisOrigem.setEnabled(false);
        __Preco.setEnabled(false);
    }

    // Método para Ativar os CAmpos
    private void isEnable() {
        __Marca.setEnabled(true);
        __Modelo.setEnabled(true);
        __Calibre.setEnabled(true);
        __PaisOrigem.setEnabled(true);
        __Preco.setEnabled(true);
    }

    // Método para Limpar os Campos
    private void clearFields() {
        __Marca.setText("");
        __Modelo.setText("");
        __Calibre.setText("");
        __Preco.setText("");
        addItensCoutry();
    }

    // Método para Adicionar Países no Combo
    private void addItensCoutry() {
        __PaisOrigem.removeAllItems();
        int contador;
        for (contador = 0; contador < Country.length; contador++) {
            __PaisOrigem.addItem(Country[contador]);
        }
    }

    // Método para Adicionar Países no Combo de Edição
    private void addItensCoutryEdit() {
        int contador;
        for (contador = 0; contador < Country.length; contador++) {
            String PaisSelecionado = __PaisOrigem.getSelectedItem().toString();
            String PaisAdicionar = Country[contador].toString();
            if (PaisSelecionado.equals(PaisAdicionar)) {
            } else {
                __PaisOrigem.addItem(Country[contador]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Novo = new javax.swing.JPanel();
        BPrimeiro = new javax.swing.JButton();
        BAnterior = new javax.swing.JButton();
        BProximo = new javax.swing.JButton();
        BUltimo = new javax.swing.JButton();
        __Impressao = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        BNovo = new javax.swing.JButton();
        BSalvar = new javax.swing.JButton();
        BExcluir = new javax.swing.JButton();
        BEditar = new javax.swing.JButton();
        BLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        __Modelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        __Calibre = new javax.swing.JTextField();
        __Preco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        __Marca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        __Id = new javax.swing.JTextField();
        __PaisOrigem = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        BPesquisar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venda Schroeder Facts");
        setResizable(false);

        Novo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BPrimeiro.setText("<<");
        BPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPrimeiroActionPerformed(evt);
            }
        });

        BAnterior.setText("<");
        BAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnteriorActionPerformed(evt);
            }
        });

        BProximo.setText(">");
        BProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BProximoActionPerformed(evt);
            }
        });

        BUltimo.setText(">>");
        BUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUltimoActionPerformed(evt);
            }
        });

        __Impressao.setEnabled(false);
        __Impressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                __ImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NovoLayout = new javax.swing.GroupLayout(Novo);
        Novo.setLayout(NovoLayout);
        NovoLayout.setHorizontalGroup(
            NovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BAnterior)
                .addGap(18, 18, 18)
                .addComponent(__Impressao)
                .addGap(18, 18, 18)
                .addComponent(BProximo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BUltimo)
                .addContainerGap())
        );

        NovoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BAnterior, BProximo, BUltimo});

        NovoLayout.setVerticalGroup(
            NovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BPrimeiro)
                    .addComponent(BAnterior)
                    .addComponent(BUltimo)
                    .addComponent(__Impressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BProximo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BNovo.setText("New");
        BNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNovoActionPerformed(evt);
            }
        });

        BSalvar.setText("Save");
        BSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalvarActionPerformed(evt);
            }
        });

        BExcluir.setText("Excluir");
        BExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExcluirActionPerformed(evt);
            }
        });

        BEditar.setText("Edit");
        BEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditarActionPerformed(evt);
            }
        });

        BLimpar.setText("Cancel");
        BLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BLimpar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BEditar, BExcluir, BLimpar, BNovo, BSalvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BExcluir)
                            .addComponent(BEditar)
                            .addComponent(BLimpar)
                            .addComponent(BSalvar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Preço");

        jLabel4.setText("Calibre");

        jLabel2.setText("Modelo");

        jLabel6.setText("País de Origem");

        jLabel7.setText("Marca");

        jLabel1.setText("Id");

        __Id.setEditable(false);

        __PaisOrigem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "teste" }));
        __PaisOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                __PaisOrigemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(__Calibre, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(__Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(__Modelo)
                            .addComponent(__Marca)
                            .addComponent(__Id, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(__PaisOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(__Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(__Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(__Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(__Calibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(__PaisOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(__Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Marca", "Modelo", "Calibre", "País", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela.getTableHeader().setResizingAllowed(false);
        Tabela.getTableHeader().setReorderingAllowed(false);
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);
        Tabela.getColumnModel().getColumn(0).setMinWidth(40);
        Tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        Tabela.getColumnModel().getColumn(0).setMaxWidth(40);
        Tabela.getColumnModel().getColumn(1).setResizable(false);
        Tabela.getColumnModel().getColumn(2).setResizable(false);
        Tabela.getColumnModel().getColumn(3).setResizable(false);
        Tabela.getColumnModel().getColumn(4).setResizable(false);
        Tabela.getColumnModel().getColumn(5).setResizable(false);

        BPesquisar.setText("Buscar Todos");
        BPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPesquisarActionPerformed(evt);
            }
        });

        jButton1.setText("Limpar Tabela");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BPesquisar, jButton1});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BPesquisar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditarActionPerformed
// Botão Editar

        Tabela.setEnabled(false);
        BSalvar.setEnabled(true);
        BLimpar.setEnabled(true);
        BNovo.setEnabled(false);
        BExcluir.setEnabled(true);
        BEditar.setEnabled(false);

        isEnable();
        addItensCoutryEdit();
        option = 2;
}//GEN-LAST:event_BEditarActionPerformed

    private void BNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNovoActionPerformed
// Botão Adicionar Novo

        Tabela.setEnabled(false);
        BLimpar.setEnabled(true);
        BSalvar.setEnabled(true);
        BNovo.setEnabled(false);
        BEditar.setEnabled(false);
        Tabela.setRowSelectionAllowed(false);

        isEnable();
        clearFields();
        addItensCoutry();
        option = 1;
        __Id.setText(next + "");

    }//GEN-LAST:event_BNovoActionPerformed
    private void BLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLimparActionPerformed
// Botão Cancelar

        if (option == 1) {
            __Id.setText("");
        }
        notEnable();

        BLimpar.setEnabled(false);
        BExcluir.setEnabled(false);
        BNovo.setEnabled(true);
        BEditar.setEnabled(false);
        BSalvar.setEnabled(false);
        Tabela.setEnabled(true);
        Tabela.setRowSelectionAllowed(true);
    }//GEN-LAST:event_BLimparActionPerformed

    private void BSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalvarActionPerformed
// Botão Salvar

        WeaponsDAO dao = new WeaponsDAO();
        Weapons o = new Weapons();
        try {
            if (option == 1) {

                last++;
                selectd = last;
                row = last;
                next++;
                BPrimeiro.setEnabled(true);
                BAnterior.setEnabled(true);
                BProximo.setEnabled(false);
                BUltimo.setEnabled(false);
                print();

            } else {
                o.setId(Integer.parseInt(__Id.getText()));
            }

            o.setBrand(__Marca.getText());
            o.setModel(__Modelo.getText());
            o.setCaliber(__Calibre.getText());
            o.setCountry(__PaisOrigem.getSelectedItem().toString());
            o.setPrice(__Preco.getText());
            dao.persist(o);

            if (option == 1) {
                JOptionPane.showMessageDialog(null, "Arma Inserido com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Arma Salva com Sucesso");
            }
            BSalvar.setEnabled(false);
            BNovo.setEnabled(true);
            BLimpar.setEnabled(false);
            BEditar.setEnabled(false);
            Tabela.setEnabled(true);
            BExcluir.setEnabled(false);
            Tabela.setRowSelectionAllowed(true);
            notEnable();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Arma");
        }
    }//GEN-LAST:event_BSalvarActionPerformed

    private void BExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExcluirActionPerformed
// Botão Excluir

        WeaponsDAO dao = new WeaponsDAO();
        Weapons o = new Weapons();
        try {
            o.setId(Integer.parseInt(__Id.getText()));
            JOptionPane.showConfirmDialog(null, "Deseja Excluir?");
            dao.remove(o);

            last--;
            selectd = 1;

            print();
            clearFields();
            notEnable();

            __Id.setText("");
            BLimpar.setEnabled(false);
            BNovo.setEnabled(true);
            BEditar.setEnabled(false);
            BSalvar.setEnabled(false);
            Tabela.setEnabled(true);
            Tabela.setRowSelectionAllowed(true);
            BExcluir.setEnabled(false);
            BPrimeiro.setEnabled(false);
            BAnterior.setEnabled(false);
            BProximo.setEnabled(true);
            BUltimo.setEnabled(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Arma");
        }
    }//GEN-LAST:event_BExcluirActionPerformed

    private void BProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BProximoActionPerformed
// Botão Próximo

        selectd++;
        print();
        try {
            nextWeapons();
            if (selectd == last) {
                BPrimeiro.setEnabled(true);
                BAnterior.setEnabled(true);
                BProximo.setEnabled(false);
                BUltimo.setEnabled(false);
            } else {
                BPrimeiro.setEnabled(true);
                BAnterior.setEnabled(true);
                BProximo.setEnabled(true);
                BUltimo.setEnabled(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Arma");
        }
    }//GEN-LAST:event_BProximoActionPerformed

    private void BAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAnteriorActionPerformed
// Botão Anterior

        selectd--;
        print();
        try {
            previousWeapons();
            if (selectd != 1) {
                BPrimeiro.setEnabled(true);
                BAnterior.setEnabled(true);
                BProximo.setEnabled(true);
                BUltimo.setEnabled(true);
            } else {
                BPrimeiro.setEnabled(false);
                BAnterior.setEnabled(false);
                BProximo.setEnabled(true);
                BUltimo.setEnabled(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Arma");
        }

    }//GEN-LAST:event_BAnteriorActionPerformed

    private void BPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPrimeiroActionPerformed
// Botão Primeiro
        try {
            selectd = 1;
            print();

            BPrimeiro.setEnabled(false);
            BAnterior.setEnabled(false);
            BProximo.setEnabled(true);
            BUltimo.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Arma");
        }
    }//GEN-LAST:event_BPrimeiroActionPerformed

    private void BUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUltimoActionPerformed
// Botão Último

        selectd = last;
        print();
        row = last - 1;
        try {
            nextWeapons();
            BPrimeiro.setEnabled(true);
            BAnterior.setEnabled(true);
            BProximo.setEnabled(false);
            BUltimo.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Arma");
        }
    }//GEN-LAST:event_BUltimoActionPerformed

    private void __ImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event___ImpressaoActionPerformed
    }//GEN-LAST:event___ImpressaoActionPerformed

    private void BPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPesquisarActionPerformed
// Botão Buscar Todos

        WeaponsDAO dao = new WeaponsDAO();
        clearTable();
        javax.swing.table.DefaultTableModel dtm =
                (javax.swing.table.DefaultTableModel) Tabela.getModel();
        try {
            ArrayList<Weapons> weapons = dao.findAll();
            for (Weapons o : weapons) {
                dtm.addRow(new Object[]{o.getId(), o.getBrand(), o.getModel(), o.getCaliber(), o.getCountry(), o.getPrice()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Armas");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Armas");
        }
    }//GEN-LAST:event_BPesquisarActionPerformed
    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
// Eventro Mouse Cliked da Tabela

        WeaponsDAO dao = new WeaponsDAO();
        __Id.setText(Tabela.getValueAt(Tabela.getSelectedRow(), 0).toString());
        __PaisOrigem.removeAllItems();

        selectd = Tabela.getSelectedRow() + 1;
        row = selectd;
        print();

        if (row == 1) {
            BPrimeiro.setEnabled(false);
            BAnterior.setEnabled(false);
            BProximo.setEnabled(true);
            BUltimo.setEnabled(true);
        } else if (row == last) {
            BPrimeiro.setEnabled(true);
            BAnterior.setEnabled(true);
            BProximo.setEnabled(false);
            BUltimo.setEnabled(false);
        } else {
            BPrimeiro.setEnabled(true);
            BAnterior.setEnabled(true);
            BProximo.setEnabled(true);
            BUltimo.setEnabled(true);
        }
       
        try {
            Weapons o = dao.find(__Id.getText().toString());
        __Marca.setText(o.getBrand());
        __Modelo.setText(o.getModel());
        __Calibre.setText(o.getCaliber());
        __PaisOrigem.addItem(o.getCountry());
        __Preco.setText(o.getPrice());
        BEditar.setEnabled(true);

        print();

    }
    catch (SQLException e

    
        ) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Armas");
    }
    catch (Exception ex

    
        ) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Armas");
    }
    }//GEN-LAST:event_TabelaMouseClicked
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// Botão Limpar Tabela

        clearTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void __PaisOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event___PaisOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event___PaisOrigemActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Principal().setVisible(true);
                

} catch (Exception ex) {
                    Logger.getLogger(Tela_Principal.class  

.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAnterior;
    private javax.swing.JButton BEditar;
    private javax.swing.JButton BExcluir;
    private javax.swing.JButton BLimpar;
    private javax.swing.JButton BNovo;
    private javax.swing.JButton BPesquisar;
    private javax.swing.JButton BPrimeiro;
    private javax.swing.JButton BProximo;
    private javax.swing.JButton BSalvar;
    private javax.swing.JButton BUltimo;
    private javax.swing.JPanel Novo;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField __Calibre;
    private javax.swing.JTextField __Id;
    private javax.swing.JTextField __Impressao;
    private javax.swing.JTextField __Marca;
    private javax.swing.JTextField __Modelo;
    private javax.swing.JComboBox __PaisOrigem;
    private javax.swing.JTextField __Preco;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
