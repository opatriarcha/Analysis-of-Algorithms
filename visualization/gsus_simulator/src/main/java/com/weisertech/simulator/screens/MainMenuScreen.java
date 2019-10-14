package com.weisertech.simulator.screens;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.Dimension;

import com.weisertech.simulator.MainApp;
import com.weisertech.simulator.algorithms.*;


/**
 *
 * @author The NearZero
 */
public final class MainMenuScreen extends Screen {
    private static final Color BACKGROUND_COLOUR = Color.DARK_GRAY;
    private final ArrayList<AlgorithmCheckBox> checkBoxes;

    public MainMenuScreen(MainApp app) {
        super(app);
        checkBoxes = new ArrayList<>();
        setUpGUI();
    }

    private void addCheckBox(ISortAlgorithm algorithm, JPanel panel) {
        JCheckBox box = new JCheckBox("", true);
        box.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.setBackground(BACKGROUND_COLOUR);
        box.setForeground(Color.WHITE);
        checkBoxes.add(new AlgorithmCheckBox(algorithm, box));
        panel.add(box);
    }

    private void initContainer(JPanel p) {
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBackground(BACKGROUND_COLOUR);
        //p.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    public void setUpGUI() {
        JPanel sortAlgorithmContainer = new JPanel();
        JPanel optionsContainer = new JPanel();
        JPanel outerContainer = new JPanel();
        JPanel nContainer = new JPanel();
        initContainer(this);
        initContainer(optionsContainer);
        initContainer(sortAlgorithmContainer);
        initContainer(nContainer);


        outerContainer.setBackground(BACKGROUND_COLOUR);
        outerContainer.setLayout(new BoxLayout(outerContainer, BoxLayout.LINE_AXIS));

        try {
            ClassLoader loader = getClass().getClassLoader();
            BufferedImage image = ImageIO.read(new File(loader.getResource("logo.png").getFile()));
            JLabel label = new JLabel(new ImageIcon(image));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(label);
        } catch (IOException e) {
            System.out.println("Unable to load logo");
        }

        sortAlgorithmContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCheckBox(new BubbleSort(),       sortAlgorithmContainer);
        addCheckBox(new SelectionSort(),    sortAlgorithmContainer);
        addCheckBox(new CycleSort(),        sortAlgorithmContainer);
        addCheckBox(new StoogeSort(),       sortAlgorithmContainer);
        addCheckBox(new QuickSort(),        sortAlgorithmContainer);
        addCheckBox(new PancakeSort(),      sortAlgorithmContainer);
        addCheckBox(new MergeSort(),        sortAlgorithmContainer);
        addCheckBox(new InsertionSort(),    sortAlgorithmContainer);
        addCheckBox(new HeapSort(),         sortAlgorithmContainer);
        addCheckBox(new GnomeSort(),        sortAlgorithmContainer);
        addCheckBox(new CountingSort(),     sortAlgorithmContainer);
        addCheckBox(new RadixSort(),        sortAlgorithmContainer);
        addCheckBox(new IterativeMergeSort(), sortAlgorithmContainer);

        JCheckBox soundCheckBox = new JCheckBox("Play Sounds");
        soundCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        soundCheckBox.setBackground(BACKGROUND_COLOUR);
        soundCheckBox.setForeground(Color.WHITE);
        
//        JTextField nFactorInputText = new JTextField("Number of Entries (N)");
//        nFactorInputText.setAlignmentX(Component.LEFT_ALIGNMENT);
//        nFactorInputText.setBackground(BACKGROUND_COLOUR);
//        nFactorInputText.setForeground(Color.WHITE);
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        JComponent field = ((JSpinner.DefaultEditor) spinner.getEditor());
        Dimension prefSize = field.getPreferredSize();
        prefSize = new Dimension(5, 5);
        field.setPreferredSize(prefSize);
        
        nContainer.add(spinner);
        
        optionsContainer.add(soundCheckBox);        
         

        JButton startButton = new JButton("Start Visualization");
        startButton.addActionListener((ActionEvent e) -> {
            ArrayList<ISortAlgorithm> algorithms = new ArrayList<>();
            for (AlgorithmCheckBox cb : checkBoxes) {
                if (cb.isSelected()) {
                    algorithms.add(cb.getAlgorithm());
                }
            }
             app.pushScreen(
                new SortingVisualiserScreen(
                            algorithms,
                            soundCheckBox.isSelected(),
                            app
                        ));
        });
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        outerContainer.add(optionsContainer);
        outerContainer.add(Box.createRigidArea(new Dimension(5,0)));
        outerContainer.add(sortAlgorithmContainer);
        outerContainer.add(nContainer);

        int gap = 15;
        add(Box.createRigidArea(new Dimension(0, gap)));
        add(outerContainer);
        add(Box.createRigidArea(new Dimension(0, gap)));        
        add(startButton);
        add(Box.createRigidArea(new Dimension(0, gap)));
        add(nContainer);
        
    }

    @Override
    public void onOpen() {
        checkBoxes.forEach((box) -> {
            box.unselect();

        });

    }

    private class AlgorithmCheckBox {
        private final ISortAlgorithm algorithm;
        private final JCheckBox box;

        public AlgorithmCheckBox(ISortAlgorithm algorithm, JCheckBox box) {
            this.algorithm = algorithm;
            this.box = box;
            this.box.setText(algorithm.getName());
        }

        public void unselect() {
            box.setSelected(false);
        }


        public boolean isSelected() {
            return box.isSelected();
        }

        public ISortAlgorithm getAlgorithm() {
            return algorithm;
        }
    }

}