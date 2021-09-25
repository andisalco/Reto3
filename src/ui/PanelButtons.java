package ui;

import javax.swing.*;
import java.awt.*;

public class PanelButtons extends JPanel {

    // Dimensión botones
    private final Dimension dButtons = new Dimension(120,30);
    private final JButton bDelete = new JButton("Borrar");
    private final JButton bUpdate = new JButton("Actualizar");
    private final JButton bReports = new JButton("Informes");


    public PanelButtons() {
        butonDelete();
        add(Box.createRigidArea(new Dimension(15,5)));
        butonUpdate();
        add(Box.createRigidArea(new Dimension(15,5)));
        butonReports();
    }

    public void butonDelete(){
        bDelete.setForeground(new InterfaceTools().getColorThree());
        bDelete.setPreferredSize(dButtons);
        add(bDelete);
    }

    public void butonUpdate(){
        bUpdate.setForeground(new InterfaceTools().getColorThree());
        bUpdate.setPreferredSize(dButtons);
        add(bUpdate);
    }

    public void butonReports(){
        bReports.setForeground(new InterfaceTools().getColorThree());
        bReports.setPreferredSize(dButtons);
        add(bReports);
    }

    public JButton getbDelete() {
        return bDelete;
    }

    public JButton getbUpdate() {
        return bUpdate;
    }

    public JButton getbReports() {
        return bReports;
    }

}
