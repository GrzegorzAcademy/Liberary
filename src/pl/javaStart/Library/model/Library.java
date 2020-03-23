package pl.javaStart.Library.model;

import java.io.Serializable;

public class Library implements Serializable {

    private final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < result.length; i++) {
           result[i] = publications[i];
        }
        return result ;
    }
    public   void addPublication(Publication publication){
        if(publicationsNumber>=MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("Max publications excided"+ MAX_PUBLICATIONS);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }
}

