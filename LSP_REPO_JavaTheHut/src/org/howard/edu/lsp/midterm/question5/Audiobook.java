package org.howard.edu.lsp.midterm.question5;

public class Audiobook extends Streamable{
    private String title;

    Audiobook(String title){
        this.title = title;
    }

    /**
     * Plays the Audiobook
     * @return a string represeting the status of the Audiobook that it is playing
     */
    public String play(){
        String status = String.format("Playing Audiobook: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Pauses the Audiobook
     * @return a string represeting the status of the Audiobook that it is paused
     */
    public String pause(){
        String status = String.format("Paused Audiobook: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Stops the Audiobook
     * @return a string represeting the status of the Audiobook that it is stopped
     */
    public String stop(){
        String status = String.format("Stopped Audiobook: %s", title);
        System.out.println(status);
        return status;
    }

    /**
     * Sets the playback speed of the Audiobook
     * @param speed the speed in which the audiobook will be played back in
     * @return a string represeting the status of the Audiobook that is being played at a different speed
     */
    public String setPlaybackSpeed(double speed){ 
        String status = String.format("Setting playback speed of Audiobook: %s by %sx", title, Double.toString(speed));
        System.out.println(status);
        return status;
    }
    
}
