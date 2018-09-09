/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import service.IPesquisaService;
import service.Pesquisa;

/**
 *
 * @author gabriel
 */
public class GUIPesquisa extends javax.swing.JInternalFrame {

    static IPesquisaService pesquisaService;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form GUIPesquisa
     */
    public GUIPesquisa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaCadastroPesquisa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        formCadProjetoDenominacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        formCadProjetoSigla = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        formCadProjetoFinanciador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        formCadProjetoCoordenador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        formCadProjetoPesq1 = new javax.swing.JTextField();
        formCadProjetoPesq2 = new javax.swing.JTextField();
        formCadProjetoPesq3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        formCadProjetoCodigo = new javax.swing.JTextField();

        TelaCadastroPesquisa.setPreferredSize(new java.awt.Dimension(700, 420));

        jLabel1.setText("Denominação");

        jLabel2.setText("Sigla");

        jLabel3.setText("Financiador");

        jLabel4.setText("Coordenador");

        jLabel5.setText("Pesquisadores");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Código");

        javax.swing.GroupLayout TelaCadastroPesquisaLayout = new javax.swing.GroupLayout(TelaCadastroPesquisa);
        TelaCadastroPesquisa.setLayout(TelaCadastroPesquisaLayout);
        TelaCadastroPesquisaLayout.setHorizontalGroup(
            TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                        .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formCadProjetoPesq3)
                            .addComponent(formCadProjetoPesq2)
                            .addComponent(formCadProjetoPesq1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaCadastroPesquisaLayout.createSequentialGroup()
                                .addComponent(formCadProjetoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formCadProjetoDenominacao))
                            .addComponent(formCadProjetoCoordenador)
                            .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(formCadProjetoSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 440, Short.MAX_VALUE))
                                    .addComponent(formCadProjetoFinanciador))))
                        .addContainerGap())))
        );
        TelaCadastroPesquisaLayout.setVerticalGroup(
            TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaCadastroPesquisaLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCadProjetoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formCadProjetoDenominacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaCadastroPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCadProjetoSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formCadProjetoFinanciador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formCadProjetoCoordenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formCadProjetoPesq1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formCadProjetoPesq2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formCadProjetoPesq3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCadastroPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCadastroPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String codigo = formCadProjetoCodigo.getText();
        String denominacao = formCadProjetoDenominacao.getText();
        String sigla = formCadProjetoSigla.getText();
        String financiador = formCadProjetoFinanciador.getText();
        String coordenador = formCadProjetoCoordenador.getText();
        
        //Pesquisadores
        String pesquisador1 = formCadProjetoPesq1.getText();
        String pesquisador2 = formCadProjetoPesq2.getText();
        String pesquisador3 = formCadProjetoPesq3.getText();
              
        ArrayList<String> pesquisador = new ArrayList<String>();
        pesquisador.add(pesquisador1);
        pesquisador.add(pesquisador2);
        pesquisador.add(pesquisador3);
                
        Pesquisa pesquisa = new Pesquisa(codigo, denominacao, sigla, financiador,
                                          coordenador, pesquisador);
        
        inserirPesquisa(pesquisa);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TelaCadastroPesquisa;
    private javax.swing.JTextField formCadProjetoCodigo;
    private javax.swing.JTextField formCadProjetoCoordenador;
    private javax.swing.JTextField formCadProjetoDenominacao;
    private javax.swing.JTextField formCadProjetoFinanciador;
    private javax.swing.JTextField formCadProjetoPesq1;
    private javax.swing.JTextField formCadProjetoPesq2;
    private javax.swing.JTextField formCadProjetoPesq3;
    private javax.swing.JTextField formCadProjetoSigla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    public void inserirPesquisa (Pesquisa pesquisa) {
        
    }
}
