package org.howard.edu.lsp.midterm.question5;

public class Movie extends Streamable {
    private String title;

    Movie(String title){
        this.title = title;
    }

    /**
     * Plays the Movie
     * @return a string represeting the status of the movie that it is playing
     */
    public String play(){
        String status = String.format("Playing movie: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Pauses the Movie
     * @return a string represeting the status of the movie that it is paused
     */
    public String pause(){
        String status = String.format("Paused movie: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Stops the Movie
     * @return a string represeting the status of the movie that it is stopped
     */
    public String stop(){
        String status = String.format("Stopped movie: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Rewinds the Movie
     * @param seconds how many seconds the movie will be rewinded
     * @return a string represeting the status of the movie that is being rewinded
     */
    public String rewind(int seconds){
        String status = String.format("Rewinding movie: %s by %d seconds", title, seconds);
        System.out.println(status);
        return status;
    }



}
