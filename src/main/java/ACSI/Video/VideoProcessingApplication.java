package ACSI.Video;

import org.opencv.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoProcessingApplication {

    public static void main(String[] args) {
        // Load OpenCV native libraries
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        SpringApplication.run(VideoProcessingApplication.class, args);
    }
}
