import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;

final class Reader {

    @NotNull
    private FileReader getFileFromResources(@NotNull String fileName) throws FileNotFoundException {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new FileReader(resource.getFile());
        }

    }
    @NotNull
    ArrayList<Book> getBooks(@NotNull String fileName) throws IOException {
        FileReader fileReader = this.getFileFromResources(fileName);
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = (JsonArray) parser.parse(fileReader);
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Book>>(){}.getType();
        return gson.fromJson(jsonArray, collectionType);
    }
}

