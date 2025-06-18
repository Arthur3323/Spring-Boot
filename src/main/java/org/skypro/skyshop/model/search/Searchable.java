package org.skypro.skyshop.model.search;


import java.util.UUID;

public interface Searchable {

    UUID getId();
    String getSearchTerm();
    String getSearchType();
    String getSearchName();

    default String getStringRepresentation() {
        return "`" + getSearchName() + "` - name of Searchable-object "
                + "`" + getSearchType() + "` - type of Searchable-object";
    }


}
