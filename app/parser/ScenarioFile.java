package app.parser;

import app.parser.dto.ScenarioData;

import java.nio.file.Path;

public class ScenarioFile {
    private final ScenarioData data;

    public ScenarioFile(String path) {
        this.data = new ScenarioDataReader().read(Path.of(path));
    }

    public ScenarioData data() {
        return data;
    }

    public int simulations() {
        return data.simulations();
    }
}
