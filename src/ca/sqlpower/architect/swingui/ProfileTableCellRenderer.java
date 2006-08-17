package ca.sqlpower.architect.swingui;

import java.awt.Component;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import ca.sqlpower.architect.SQLObject;

public class ProfileTableCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        String formattedValue = new String();
        
        DecimalFormat pctFormat = new DecimalFormat("0%");
        DecimalFormat aldf = new DecimalFormat("#,##0.0");
        aldf.setMaximumFractionDigits(1);
        aldf.setMinimumFractionDigits(0);
        
        if ( column < 5) {
            if (value == null) {
                formattedValue = "null";
            } else {
                formattedValue = ((SQLObject)value).getName();
            }
        }else if (column == 5) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            formattedValue =df.format(new Date((Long) value));
        }else if (column == 9 || column == 11) {
            if (value == null) {
                formattedValue = "N/A";
            } else {
                formattedValue = pctFormat.format(value);
            }
        } else if (column == 14 ) {
            if (value == null) {
                formattedValue = "null";
            } else {
                formattedValue = aldf.format(value);
            }
        } else {
            if (value == null) {
                formattedValue = "null";
            } else {
                formattedValue = value.toString();
            }
        }
        return super.getTableCellRendererComponent(table,formattedValue,isSelected,hasFocus,row,column);
       
    }

}
