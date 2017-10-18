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

package com.openbravo.pos.sales.restaurant;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import java.io.Serializable;
import com.openbravo.format.Formats;

/**
 *
 * @author JG uniCenta
 */
public class JCalendarItemRenderer extends javax.swing.JPanel implements ListCellRenderer, Serializable {

    /**
     *
     */
    protected static Border noFocusBorder;
    
    private boolean m_bDone = false;
    
    /** Creates new form JCalendarItemRenderer */
    public JCalendarItemRenderer() {
        
        super();
        if (noFocusBorder == null) {
            noFocusBorder = new EmptyBorder(1, 1, 1, 1);
        }
        
        initComponents();
        
        m_jTime.setFont(new Font("SansSerif", Font.BOLD, 14)); // HORA
        m_jTitle.setFont(new Font("SansSerif", Font.BOLD, 14)); // TITULO
        m_jDescription.setFont(new Font("SansSerif", Font.ITALIC, 14)); // TEXTO EXPLICATIVO

        setOpaque(true);
        setBorder(noFocusBorder);
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        
        applyComponentOrientation(list.getComponentOrientation());
        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            m_jTime.setForeground(list.getSelectionForeground());
            m_jTitle.setForeground(list.getSelectionForeground());
            m_jDescription.setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            m_jTime.setForeground(Color.BLUE);
            m_jTitle.setForeground(list.getForeground());
            m_jDescription.setForeground(list.getForeground());
        }

        if (value == null) {
            m_jTime.setText("");
            m_jTitle.setText("");
            m_jChairs.setText("");
            m_bDone = false;
            m_jDescription.setText("");
        } else {
            Object[] avalue = (Object []) value;
            m_jTime.setText(Formats.TIME.formatValue(avalue[2]));
            m_jTitle.setText(Formats.STRING.formatValue(avalue[6]));
            m_jChairs.setText(Formats.INT.formatValue(avalue[7]));
            m_bDone = ((Boolean) avalue[8]).booleanValue();
            m_jDescription.setText(Formats.STRING.formatValue(avalue[9]));
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setBorder((cellHasFocus) ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);

        return this;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (m_bDone) {
            Insets in = getInsets();
            g.drawLine(in.left, 10, getWidth() - in.right, 10);        
        }
    }
    
    
   /**
    * Overridden for performance reasons.
    */
    @Override
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}
    @Override
    public void firePropertyChange(String propertyName, byte oldValue, byte newValue) {}
    @Override
    public void firePropertyChange(String propertyName, char oldValue, char newValue) {}
    @Override
    public void firePropertyChange(String propertyName, short oldValue, short newValue) {}
    @Override    
    public void firePropertyChange(String propertyName, int oldValue, int newValue) {}
    @Override
    public void firePropertyChange(String propertyName, long oldValue, long newValue) {}
    @Override
    public void firePropertyChange(String propertyName, float oldValue, float newValue) {}
    @Override
    public void firePropertyChange(String propertyName, double oldValue, double newValue) {}
    @Override
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jDescription = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        m_jTime = new javax.swing.JLabel();
        m_jTitle = new javax.swing.JLabel();
        m_jChairs = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        m_jDescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jDescription.setText("<html>This is a test comment that shows how a long line is printed with this renderer.");
        m_jDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        m_jDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 20, 5, 20));
        add(m_jDescription, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        m_jTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jTime.setForeground(new java.awt.Color(0, 0, 255));
        m_jTime.setText("10:20");
        jPanel1.add(m_jTime, java.awt.BorderLayout.WEST);

        m_jTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jTitle.setText(" This is a test");
        m_jTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jPanel1.add(m_jTitle, java.awt.BorderLayout.CENTER);

        m_jChairs.setText("5");
        jPanel1.add(m_jChairs, java.awt.BorderLayout.EAST);

        add(jPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel jPanel1;
    javax.swing.JLabel m_jChairs;
    javax.swing.JLabel m_jDescription;
    javax.swing.JLabel m_jTime;
    javax.swing.JLabel m_jTitle;
    // End of variables declaration//GEN-END:variables
    
}
