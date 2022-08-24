package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {

    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {

        JMenuItem newMenuItem = new JMenuItem(text);
        newMenuItem.addActionListener(actionListener);
        parent.add(newMenuItem);
        return newMenuItem;

    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {

        JMenuItem newMenuItem = new JMenuItem(action);
        parent.add(newMenuItem);
        return newMenuItem;

    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {

        JMenuItem newMenuItem = addMenuItem(parent, action);
        newMenuItem.setText(text);
        return newMenuItem;

    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {

    }

    public static void initFontMenu(View view, JMenuBar menuBar) {

    }

    public static void initColorMenu(View view, JMenuBar menuBar) {

    }

    public static void initAlignMenu(View view, JMenuBar menuBar) {

    }

    public static void initStyleMenu(View view, JMenuBar menuBar) {

    }

    public static void initEditMenu(View view, JMenuBar menuBar) {

    }

    public static void initFileMenu(View view, JMenuBar menuBar) {

    }
}
