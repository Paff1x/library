import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public final class Book extends Author{
    @NotNull
    @NonNull
    String title = "";
    @NonNull
    int countPage;
}
