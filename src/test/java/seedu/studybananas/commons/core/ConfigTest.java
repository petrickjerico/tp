package seedu.studybananas.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.logging.Level;

import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void toString_defaultObject_stringReturned() {
        String defaultConfigAsString = "Current log level : INFO\n"
                + "Preference file Location : preferences.json";

        assertEquals(defaultConfigAsString, new Config().toString());
    }

    @Test
    public void equalsMethod() {
        Config defaultConfig = new Config();
        assertNotNull(defaultConfig);
        assertTrue(defaultConfig.equals(defaultConfig));
    }

    @Test
    public void defaultLogLevel_infoLevel() {
        Config defaultConfig = new Config();
        assertEquals(defaultConfig.getLogLevel(), Level.INFO);
    }

    @Test
    public void defaultUserPrefFile_preference() {
        Config defaultConfig = new Config();
        assertEquals(defaultConfig.getUserPrefsFilePath(), Paths.get("preferences.json"));
    }


}
