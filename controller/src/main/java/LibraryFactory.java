import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

final class LibraryFactory {

    @NotNull
    private static ArrayList<Library> libraries = new ArrayList<>();
    @NotNull
    private static Library createLibrary(@NotNull String nameLibrary) throws IOException {
        Reader reader = new Reader();
        Library lib = new Library();
        lib.name = nameLibrary;
        lib.books = reader.getBooks(nameLibrary);
        return lib;
    }

    static void AddLibrary(@NotNull String nameLibrary) throws IOException {
        Library library = createLibrary(nameLibrary);
        libraries.add(library);
    }

    @NotNull
    static ArrayList<Library> GetLibraries() {
        return libraries;
    }
}
