import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Robot {

    public static void main(String[] args) {
        // Start the camera stream
        CameraServer.getInstance().startAutomaticCapture();

        // Set Limelight LED mode to default (0)
        setLimelightLEDMode(0);

        // Your robot code here

        // Example: Get Limelight target information
        double tx = getLimelightX();
        double ty = getLimelightY();
        double ta = getLimelightArea();

        // Process the target information as needed
    }

    // Helper method to set Limelight LED mode
    private static void setLimelightLEDMode(int mode) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(mode);
    }

    // Helper method to get Limelight X coordinate
    private static double getLimelightX() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    }

    // Helper method to get Limelight Y coordinate
    private static double getLimelightY() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    }

    // Helper method to get Limelight target area
    private static double getLimelightArea() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    }
}