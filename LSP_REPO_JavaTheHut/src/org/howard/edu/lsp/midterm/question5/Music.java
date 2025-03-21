package org.howard.edu.lsp.midterm.question5;

public class Music extends Streamable{
    private String title;

    Music(String title){
        this.title = title;
    }

    /**
     * Plays the Music
     * @return a string represeting the status of the Music that it is playing
     */
    public String play(){
        String status = String.format("Playing Music: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Pauses the Music
     * @return a string represeting the status of the Music that it is paused
     */
    public String pause(){
        String status = String.format("Paused Music: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Stops the Music
     * @return a string represeting the status of the Music that it is stopped
     */
    public String stop(){
        String status = String.format("Stopped Music: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Adds the music to a playlist
     * @param playlistName the playlist name in which the music will be added to
     * @return a string represeting the status of the Music that is being added to a playlist
     */
    public String addToPlaylist(String playlistName){ 
        String status = String.format("Added %s to %s playlist", title, playlistName);
        System.out.println(status);
        return status;
    }
    
}

