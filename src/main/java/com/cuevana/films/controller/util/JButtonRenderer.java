package com.cuevana.films.controller.util;

import com.cuevana.films.util.OperationTypeEnum;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class JButtonRenderer extends AbstractCellEditor
        implements TableCellEditor, TableCellRenderer {

    private final OperationTypeEnum operationTypeEnum;
    private final String labelButton;
    
    public JButtonRenderer(OperationTypeEnum operationTypeEnum) {
        this.operationTypeEnum = operationTypeEnum;
        if (this.operationTypeEnum == OperationTypeEnum.UPDATE) {
            this.labelButton = "Editar";
        } else {
            this.labelButton = "Eliminar";
        }
    }
    
    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JButton b = new JButton(labelButton);
        
        b.addActionListener(action -> {
            if (operationTypeEnum == OperationTypeEnum.UPDATE) {
                System.out.println("Estoy actualizando");
            } else {
                System.out.println("Estoy eliminando");
            }
            
            String id = table.getValueAt(row, 0).toString();
            System.out.println("ID PELICULA " + id);
        });
        
        return b;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JButton b = new JButton(labelButton);
        return b;
    }
}
