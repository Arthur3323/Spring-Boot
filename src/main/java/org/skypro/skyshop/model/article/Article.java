package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;
import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
private final UUID id;
    private final String articleName;
    private final String articleText;


    public Article( UUID id , String articleName, String articleText) {
        this.id = id;
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String toString() {
        return "ARTICLE{" +
                "articleName='" + articleName + '\'' +
                ", articleText='" + articleText + '\'' +
                '}';
    }
    @Override @JsonIgnore
    public String getSearchTerm() {
        return articleName;
    }
    @Override @JsonIgnore
    public String getSearchType() {
        return "ARTICLE";
    }


    public String getName() {
        return articleName;
    }


    public String getText() {
        return articleText;
    }

    @Override @JsonIgnore
    public String getSearchName() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}