package algorithms.arrays.find_duplicate_and_missing;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FoundDuplicateAndMissingResult {

    private Integer missing;
    private Integer duplicate;

    public boolean bothFound() {
        return (missing != null && duplicate != null);
    }
}
