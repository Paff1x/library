import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class Application {
    public static void main(@NotNull String[] args) throws IOException {
        LibraryFactory.AddLibrary("Library1");
        LibraryFactory.AddLibrary("Library2");
        LibraryFactory.AddLibrary("Library3");
        System.out.println("Input an author name: ");
        Scanner in = new Scanner(System.in);
        String author = in.nextLine();
        Gson gson = new Gson();
        ArrayList<Book> authorBooks = new ArrayList<>();
        for (Library lib:
            LibraryFactory.GetLibraries()){
            for (Book book :
                    lib.books) {
                if (author.equals(book.authorName)) {
                    authorBooks.add(book);
                }
            }
        }
        String jsonData = gson.toJson(authorBooks);
        System.out.println(jsonData);
    }
}


