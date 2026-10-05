package framework.utils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestDataReader {

        public static String read(String fileName) {

            String filePath = "testdata/" + fileName;

            try (InputStream inputStream =
                         TestDataReader.class
                                 .getClassLoader()
                                 .getResourceAsStream(filePath)) {

                if (inputStream == null) {
                    throw new RuntimeException(
                            "Test data file not found: " + filePath
                    );
                }

                return new String(
                        inputStream.readAllBytes(),
                        StandardCharsets.UTF_8
                );

            } catch (Exception e) {

                throw new RuntimeException(
                        "Failed to read test data file: " + filePath,
                        e
                );
            }
        }
}
