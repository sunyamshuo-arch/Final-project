/**
 * Program Description: This program starts the Bank Account Management application.
 * The application allows users to create, edit, remove, deposit, withdraw,
 * and generate statements for multiple bank accounts.
 *
 * Name: Yanshuo Sun
 * Date: December 5, 2026
 */

import javax.swing.SwingUtilities;

/**
 * The App class contains the main method that starts the GUI application.
 */
public class App {

    /**
     * Starts the Bank Account Management application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /**
             * Runs the GUI program.
             */
            public void run() {
                BankGUI gui = new BankGUI();
                gui.setVisible(true);
            }
        });
    }
}