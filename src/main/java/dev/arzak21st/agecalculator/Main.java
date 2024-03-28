package dev.arzak21st.agecalculator;

import dev.arzak21st.agecalculator.utils.LookAndFeelUtil;
import dev.arzak21st.agecalculator.views.InputView;

public class Main {

    public static void main(String[] args) {

        new LookAndFeelUtil().setLookAndFeel();
        new InputView().setVisible(true);
    }
}
