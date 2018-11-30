package Ihm.Client;

import javax.swing.*;
import java.awt.*;

public class Paris extends JPanel {

    private JLabel title;
    private Box box;
    private Box box2;

    public Paris() {
        super();

        this.box = Box.createVerticalBox();
        this.box2 = Box.createHorizontalBox();
        this.title = new JLabel("Paris");
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);

        ButtonGroup group = new ButtonGroup();
        JRadioButton br1 = new JRadioButton("1", false);
        JRadioButton br2 = new JRadioButton("N", false);
        JRadioButton br3 = new JRadioButton("2", false);

        group.add(br1);
        group.add(br2);
        group.add(br3);

        this.box2.add(br1);
        this.box2.add(br2);
        this.box2.add(br3);
        this.box.add(this.title);
        this.add(this.box);

    }
}
