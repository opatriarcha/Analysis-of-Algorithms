package com.weisertech.simulator.screens;

import static com.weisertech.simulator.MainApp.WIN_HEIGHT;
import static com.weisertech.simulator.MainApp.WIN_WIDTH;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.weisertech.simulator.MainApp;

/**
 *
 * @author The NearZero
 */
public abstract class Screen extends JPanel {
    protected MainApp app;

    public Screen(MainApp app) {
        this.app = app;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }

    public abstract void onOpen();
}
