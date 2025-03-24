package at.technikum.javafx.entity;

import java.time.LocalDateTime;

public class SearchTerm {

    private String id;

    private String term;

    private LocalDateTime firstSearched;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public LocalDateTime getFirstSearched() {
        return firstSearched;
    }

    public void setFirstSearched(LocalDateTime firstSearched) {
        this.firstSearched = firstSearched;
    }
}
