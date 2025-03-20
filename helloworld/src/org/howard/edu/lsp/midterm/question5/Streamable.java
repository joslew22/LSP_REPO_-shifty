package org.howard.edu.lsp.midterm.question5;

/**
 * Represents streamable content that supports common behaviors like play, pause, and stop.
 */
public interface Streamable {
    /**
     * Plays the content.
     */
    void play();

    /**
     * Pauses the content.
     */
    void pause();

    /**
     * Stops the content.
     */
    void stop();
}
