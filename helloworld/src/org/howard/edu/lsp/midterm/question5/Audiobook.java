package org.howard.edu.lsp.midterm.question5;

//JavaDoc Generated from DeepSeek

/**
 * Represents an audiobook that can be streamed.
 */
public class Audiobook implements Streamable {
    private String title;

    /**
     * Constructor for Audiobook.
     *
     * @param title The title of the audiobook.
     */
    public Audiobook(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Sets the playback speed of the audiobook.
     *
     * @param speed The playback speed (e.g., 1.5 for 1.5x speed).
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}