package seedu.address;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Version;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.ConfigUtil;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.systemlevelmodel.AddressBook;
import seedu.address.model.systemlevelmodel.FlashcardBank;
import seedu.address.model.systemlevelmodel.QuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlyAddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.ReadOnlyUserPrefs;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.systemlevelmodel.UserPrefs;
import seedu.address.model.util.SampleDataUtil;
import seedu.address.storage.AddressBookStorage;
import seedu.address.storage.JsonAddressBookStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.Storage;
import seedu.address.storage.StorageManager;
import seedu.address.storage.UserPrefsStorage;
import seedu.address.storage.flashcardstorage.FlashcardBankStorage;
import seedu.address.storage.flashcardstorage.JsonFlashcardBankStorage;
import seedu.address.storage.quizstorage.JsonQuizRecordsStorage;
import seedu.address.storage.quizstorage.QuizRecordsStorage;
import seedu.address.storage.schedulestorage.JsonScheduleStorage;
import seedu.address.storage.schedulestorage.ScheduleStorage;
import seedu.address.ui.Ui;
import seedu.address.ui.UiManager;

/**
 * Runs the application.
 */
public class MainApp extends Application {

    public static final Version VERSION = new Version(0, 6, 0, true);

    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    protected Ui ui;
    protected Logic logic;
    protected Storage storage;
    protected Model model;
    protected Config config;

    @Override
    public void init() throws Exception {
        logger.info("=============================[ Initializing AddressBook ]===========================");
        super.init();

        AppParameters appParameters = AppParameters.parse(getParameters());
        config = initConfig(appParameters.getConfigPath());

        UserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(config.getUserPrefsFilePath());
        UserPrefs userPrefs = initPrefs(userPrefsStorage);
        AddressBookStorage addressBookStorage = new JsonAddressBookStorage(userPrefs.getAddressBookFilePath());
        ScheduleStorage scheduleStorage = new JsonScheduleStorage(userPrefs.getScheduleFilePath());
        FlashcardBankStorage flashcardBankStorage = new JsonFlashcardBankStorage(userPrefs.getFlashcardBankFilePath());
        QuizRecordsStorage quizRecordsStorage = new JsonQuizRecordsStorage(userPrefs.getQuizRecordsFilePath());

        storage = new StorageManager(scheduleStorage, flashcardBankStorage,
                quizRecordsStorage, addressBookStorage, userPrefsStorage);

        initLogging(config);

        model = initModelManager(storage, userPrefs);

        logic = new LogicManager(model, storage);

        ui = new UiManager(logic);
    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    private Model initModelManager(Storage storage, ReadOnlyUserPrefs userPrefs) {

        Optional<ReadOnlyAddressBook> addressBookOptional;
        Optional<ReadOnlySchedule> scheduleOptional;
        Optional<ReadOnlyFlashcardBank> flashcardBankOptional;
        Optional<ReadOnlyQuizRecords> quizRecordsOptional;

        ReadOnlyAddressBook initialAddressBookData;
        ReadOnlySchedule initialScheduleData;
        ReadOnlyFlashcardBank initialFlashcardBankData;
        ReadOnlyQuizRecords initialQuizRecordsData;

        try {
            addressBookOptional = storage.readAddressBook();

            if (addressBookOptional.isEmpty()) {
                logger.info("AddressBook data file not found. Will be starting with a sample AddressBook");
            }

            initialAddressBookData = addressBookOptional.orElseGet(SampleDataUtil::getSampleAddressBook);
        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty AddressBook");
            initialAddressBookData = new AddressBook();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
            initialAddressBookData = new AddressBook();
        }

        try {
            scheduleOptional = storage.readSchedule();

            if (scheduleOptional.isEmpty()) {
                logger.info("Schedule data file not found. Will be starting with a sample Schedule");
            }

            initialScheduleData = scheduleOptional.orElseGet(SampleDataUtil::getSampleSchedule);
        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty Schedule");
            initialScheduleData = new Schedule();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty Schedule");
            initialScheduleData = new Schedule();
        }

        try {
            flashcardBankOptional = storage.readFlashcardBank();

            if (flashcardBankOptional.isEmpty()) {
                logger.info("FlashcardBank data file not found. Will be starting with a sample FlashcardBank");
            }

            initialFlashcardBankData = flashcardBankOptional.orElseGet(SampleDataUtil::getSampleFlashcardBank);
        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty FlashcardBank");
            initialFlashcardBankData = new FlashcardBank();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty FlashcardBank");
            initialFlashcardBankData = new FlashcardBank();
        }

        try {
            quizRecordsOptional = storage.readQuizRecords();

            if (quizRecordsOptional.isEmpty()) {
                logger.info("Quiz Records data file not found. Will be starting with a sample FlashcardBank");
            }

            initialQuizRecordsData = quizRecordsOptional.orElseGet(SampleDataUtil::getSampleQuizRecords);
        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty Quiz Record");
            initialQuizRecordsData = new QuizRecords();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty Quiz Record");
            initialQuizRecordsData = new QuizRecords();
        }

        return new ModelManager(initialAddressBookData, userPrefs, initialScheduleData,
                initialFlashcardBankData, initialQuizRecordsData);
    }

    private void initLogging(Config config) {
        LogsCenter.init(config);
    }

    /**
     * Returns a {@code Config} using the file at {@code configFilePath}. <br>
     * The default file path {@code Config#DEFAULT_CONFIG_FILE} will be used instead
     * if {@code configFilePath} is null.
     */
    protected Config initConfig(Path configFilePath) {
        Config initializedConfig;
        Path configFilePathUsed;

        configFilePathUsed = Config.DEFAULT_CONFIG_FILE;

        if (configFilePath != null) {
            logger.info("Custom Config file specified " + configFilePath);
            configFilePathUsed = configFilePath;
        }

        logger.info("Using config file : " + configFilePathUsed);

        try {
            Optional<Config> configOptional = ConfigUtil.readConfig(configFilePathUsed);
            initializedConfig = configOptional.orElse(new Config());
        } catch (DataConversionException e) {
            logger.warning("Config file at " + configFilePathUsed + " is not in the correct format. "
                    + "Using default config properties");
            initializedConfig = new Config();
        }

        //Update config file in case it was missing to begin with or there are new/unused fields
        try {
            ConfigUtil.saveConfig(initializedConfig, configFilePathUsed);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }
        return initializedConfig;
    }

    /**
     * Returns a {@code UserPrefs} using the file at {@code storage}'s user prefs file path,
     * or a new {@code UserPrefs} with default configuration if errors occur when
     * reading from the file.
     */
    protected UserPrefs initPrefs(UserPrefsStorage storage) {
        Path prefsFilePath = storage.getUserPrefsFilePath();
        logger.info("Using prefs file : " + prefsFilePath);

        UserPrefs initializedPrefs;
        try {
            Optional<UserPrefs> prefsOptional = storage.readUserPrefs();
            initializedPrefs = prefsOptional.orElse(new UserPrefs());
        } catch (DataConversionException e) {
            logger.warning("UserPrefs file at " + prefsFilePath + " is not in the correct format. "
                    + "Using default user prefs");
            initializedPrefs = new UserPrefs();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
            initializedPrefs = new UserPrefs();
        }

        //Update prefs file in case it was missing to begin with or there are new/unused fields
        try {
            storage.saveUserPrefs(initializedPrefs);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }

        return initializedPrefs;
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting Study Bananas " + MainApp.VERSION);
        ui.start(primaryStage);
    }

    @Override
    public void stop() {
        logger.info("============================ [ Stopping Study Bananas ] =============================");
        try {
            storage.saveUserPrefs(model.getUserPrefs());
        } catch (IOException e) {
            logger.severe("Failed to save preferences " + StringUtil.getDetails(e));
        }
    }
}
