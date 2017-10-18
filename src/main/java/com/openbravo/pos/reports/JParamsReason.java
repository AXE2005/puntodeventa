//    SmartPos - Smart Touch Point of Sale
//    Copyright (c) 2017 Alejandro Camargo & previous Openbravo POS works
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.reports;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.data.loader.SerializerWrite;
import com.openbravo.data.loader.SerializerWriteBasic;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.inventory.MovementReason;
import java.awt.Component;

/**
 *
 * @author JG uniCenta
 */
public class JParamsReason extends javax.swing.JPanel implements ReportEditorCreator {
    
    private ComboBoxValModel m_ReasonModel;
    
    /** Creates new form JParamsReason */
    public JParamsReason() {
        initComponents();
        
        m_ReasonModel = new ComboBoxValModel();
        m_ReasonModel.add(null);
        m_ReasonModel.add(MovementReason.IN_PURCHASE);                          //Supplier Purchase
        m_ReasonModel.add(MovementReason.OUT_SALE);                             //Sale
        m_ReasonModel.add(MovementReason.IN_REFUND);                            //Customer Refund
        m_ReasonModel.add(MovementReason.OUT_REFUND);                           //Supplier Return
        m_ReasonModel.add(MovementReason.IN_MOVEMENT);                          //Adjust Add
        m_ReasonModel.add(MovementReason.OUT_MOVEMENT);                         //Adjust Subtract
        m_ReasonModel.add(MovementReason.OUT_SUBTRACT);                         //Rectify error per JM requirement        
        m_ReasonModel.add(MovementReason.OUT_BREAK);                            //Breakage
        m_ReasonModel.add(MovementReason.OUT_FREE);                             //Given Free   
        m_ReasonModel.add(MovementReason.OUT_SAMPLE);                           //Given Sample
        m_ReasonModel.add(MovementReason.OUT_USED);                             //Used item   
        m_ReasonModel.add(MovementReason.OUT_CROSSING);                         //Inter-Location move      
        
        m_jreason.setModel(m_ReasonModel);
        // m_jreason.setSelectedItem(null);
    }
    
    /**
     *
     * @param app
     */
    @Override
    public void init(AppView app) {
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
    }

    /**
     *
     * @return
     */
    @Override
    public SerializerWrite getSerializerWrite() {
        return new SerializerWriteBasic(new Datas[] {Datas.OBJECT, Datas.INT});
    }

    /**
     *
     * @return
     */
    @Override
    public Component getComponent() {
        return this;
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {
        
        return new Object[] {
            m_ReasonModel.getSelectedItem() == null ? QBFCompareEnum.COMP_NONE : QBFCompareEnum.COMP_EQUALS, m_ReasonModel.getSelectedKey()
        };
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        m_jreason = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText(AppLocal.getIntString("label.stockreason")); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));

        m_jreason.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jreason.setMaximumRowCount(12);
        m_jreason.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jreason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m_jreason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox m_jreason;
    // End of variables declaration//GEN-END:variables
    
}