package frc.vision;

import java.util.concurrent.atomic.AtomicBoolean;

import edu.wpi.cscore.CvSource;
import edu.wpi.first.cameraserver.CameraServer;

public class pixyCameraServer implements Runnable {
    static {
        System.loadLibrary("pixy2_usb");
    }

    private native int pixy2USBInit();

    private native void pixy2USBGetVersion();

    private native void pixy2USBInitCameraServer(int source);

    private void pixy2USBInitCameraServer(CvSource source) {
        pixy2USBInitCameraServer(source.getHandle());
    }

    // Return value is status of PutFrame
    private native int pixy2USBLoopCameraServer();

    private static final int PIXY2_RAW_FRAME_WIDTH = 316;
    private static final int PIXY2_RAW_FRAME_HEIGHT = 208;

    private pixyCameraServer pixy2USBJNI;

    public AtomicBoolean toggleLamp = new AtomicBoolean(false);

    @Override
    public void run() {
        // Uncomment these if you want extra, "regular" USB cameras
        // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        // camera.setResolution(640, 480);
        // UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(1);
        // camera1.setResolution(640, 480);

        pixy2USBJNI = new pixyCameraServer();
        int init_result = pixy2USBJNI.pixy2USBInit();
        if (init_result == 0) {
            
            pixy2USBJNI.pixy2USBGetVersion();
            
            CvSource outputStream = CameraServer.getInstance().putVideo("Target Reticle", PIXY2_RAW_FRAME_WIDTH, PIXY2_RAW_FRAME_HEIGHT);
            pixy2USBJNI.pixy2USBInitCameraServer(outputStream);

        }
    }
}