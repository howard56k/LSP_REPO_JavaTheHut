package org.howard.edu.lsp.midterm.question2;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int releaseYear;
    /**
     * Creates the Book object with its Title, Author, IBSN, Release Date
     *
     * @param title     the title of the Book
     * @param author    the author of the Book
     * @param isbn      the IBSN of the Book
     * @param releaseYear   The Release Year of the Book
     */
    public Book(String title, String author, String isbn, int releaseYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.releaseYear = releaseYear;
    }

    /**
     * Overrides the equals method to compare two Book objects.
     * 
     * @param obj The Book Object to compare to the current Book.
     * @return true if author and ibsn is the the same else false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            // Checks if the object is being compared against itself
            return true;
        if (obj == null || getClass() != obj.getClass())
            // Checks if Obj is even comparable / is a Book
            return false;

        Book otherBook = (Book) obj;
        return (this.isbn.equals(otherBook.isbn) && this.author.equals(otherBook.author));
    }

    /**
     * Returns a meaningful string representation of a Book object.
     * 
     * @return String representation of a Book object
     */
    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, ISBN: %s, Year: %d",
                title, author, isbn, releaseYear);
    }
    
}
    