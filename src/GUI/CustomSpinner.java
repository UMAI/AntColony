package GUI;

import javax.swing.*;
import java.awt.*;

public class CustomSpinner extends JSpinner {
    public CustomSpinner(SpinnerModel model) {
        super(model);
        setPreferredSize(new Dimension(80, 40));
        setFont(new Font("Verdana", Font.PLAIN, 30));
    }
}
