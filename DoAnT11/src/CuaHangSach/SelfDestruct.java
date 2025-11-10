
package CuaHangSach;
import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.util.Scanner;

public class SelfDestruct {

    // Typing effect function
    public static void typeOut(String text, int delay) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            Thread.sleep(delay);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = System.getProperty("user.name");
        String hostname = "unknown-host";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception ignored) {
            // fallback stays "unknown-host"
        }

        try {
            System.out.println("=== SelfDestruct Mode ===");
            System.out.println("Detected user: " + user + " @ " + hostname);
            System.out.println("Choose OS:");
            System.out.println("1. Windows (Alt+F4 will be sent)");
            System.out.println("2. macOS (Command+Q will be sent)");
            System.out.print("Enter (1 or 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Are you sure (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Canceled.");
                return;
            }

            System.out.print("Last warning ! (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Canceled.");
                return;
            }

            System.out.println("Countdown...");
            for (int i = 3; i >= 1; i--) {
                System.out.println(i + "...");
                Thread.sleep(1000);
            }

            // ---------- TYPING-EFFECT SIMULATION TEXT ----------
            typeOut("Starting system mode for user: " + user + " @ " + hostname + "...", 10);
            typeOut("Checking permissions: Verified  only).", 10);
            typeOut("Target directory detected: C:\\Windows\\System32  only).", 10);
            typeOut("Beginning \"deletion\" process (safe mode — no real files affected).", 10);
            typeOut("Listing simulated files to remove... done.", 10);
            typeOut("Deleting simulated file: kernel32.dll   — system unaffected.", 10);
            typeOut("Deleting simulated file: winlogon.exe   — system unaffected.", 10);
            typeOut("Simulation of System32 deletion complete.", 10);
            typeOut("System restored to safe state.", 10);
            typeOut("No real files were deleted.", 10);
            System.out.println();

            // ---------- Here-doc imitation ----------
            System.out.println("cat <<'EOF'");
            typeOut("Starting system mode for user: " + user + " @ " + hostname + "...", 5);
            typeOut("Checking permissions: Verified  only).", 5);
            typeOut("Target directory detected: C:\\Windows\\System32  only).", 5);
            typeOut("Beginning \"deletion\" process (safe mode — no real files affected).", 5);
            typeOut("Listing simulated files to remove... done.", 5);
            typeOut("Deleting simulated file: kernel32.dll   — system unaffected.", 5);
            typeOut("Deleting simulated file: winlogon.exe   — system unaffected.", 5);
            typeOut("Simulation of System32 deletion complete.", 2);
            typeOut("System restored to safe state.", 2);
            typeOut("No real files were deleted.", 2);
            System.out.println("EOF");

            Thread.sleep(1200);

            // ---------- AUTO ALT+F4 / COMMAND+Q ----------
            Robot robot = new Robot();
            robot.setAutoDelay(100);

            if (choice == 1) {
                // Windows: Alt+F4
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_ALT);

            } else if (choice == 2) {
                // macOS: Command+Q
                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_Q);
                robot.keyRelease(KeyEvent.VK_Q);
                robot.keyRelease(KeyEvent.VK_META);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
