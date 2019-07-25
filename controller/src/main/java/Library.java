import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

final class Library {
    @NotNull
    @NonNull
    String name = "";
    @NotNull
    @NonNull
    ArrayList<Book> books = new ArrayList<>();
}
