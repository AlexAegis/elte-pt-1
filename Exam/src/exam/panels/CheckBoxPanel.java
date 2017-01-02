package exam.panels;

import exam.logic.Directions;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckBoxPanel extends JPanel {

    public CheckBoxPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Arrays.stream(Directions.values()).forEach(directions -> add(new JCheckBox(directions.toString())));
    }

    public List<Directions> getSelectedDirections() {
        return Arrays.stream(getComponents())
                .map(component -> (JCheckBox) component)
                .filter(AbstractButton::isSelected)
                .map(jCheckBox -> Directions.valueOf(jCheckBox.getText()))
                .collect(Collectors.toList());
    }
}