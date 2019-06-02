import org.testcontainers.containers.RecordingFileFactory;

import java.io.File;

public class CustomRecordingFileFactory implements RecordingFileFactory {

    @Override
    public File recordingFileForTest(File file, String s, boolean b) {
        //custom save file if needed
        //https://circleci.com/docs/2.0/browser-testing/
        return null;
    }
}
