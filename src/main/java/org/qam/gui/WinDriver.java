package org.qam.gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class WinDriver {
    private static final Logger logger = Logger.getLogger(WinDriver.class.getName());

    public static void start() {
        try {
            var desktop = Desktop.getDesktop();
            var file = new File("D:/_src/QAMaster/src/main/resources/windows_application_driver/WinAppDriver.exe");
            /* Check if there is support for Desktop or not */
            if (!Desktop.isDesktopSupported()) {
                logger.warning("not supported");
                return;
            }

            if (file.exists()) {
                logger.warning("Open WinAppDriver.exe");
                desktop.open(file);
            }
        } catch (IOException e) {
            logger.warning("Encountered Exception");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void stop() {
        try {
            var processBuilder = new ProcessBuilder("taskkill ", "/f", "/IM", "WinAppDriver.exe");
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
