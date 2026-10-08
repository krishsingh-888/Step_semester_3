package main.java.oop_week7.class_problems;

interface Playable {
    String play();
    String play(int fromSecond);
    String pause();
}

abstract class MediaFile {
    private static int counter = 1001;
    private final String fileId;
    
    public MediaFile() {
        this.fileId = "MF-" + (counter++);
    }
    
    public abstract String getFormatInfo();
    public String getFileId() { return fileId; }
}

class AudioFile extends MediaFile implements Playable {
    private String title;
    
    public AudioFile(String title) { this.title = title; }
    
    @Override
    public String play() { 
        return "Playing audio: " + title; 
    }
    
    @Override
    public String play(int fromSecond) { 
        return "Playing audio: " + title + " from 0:" + fromSecond; 
    }
    
    @Override
    public String pause() { 
        return "Audio paused"; 
    }
    
    @Override
    public String getFormatInfo() { 
        return "Audio file, ID: " + getFileId(); 
    }
}

class Podcast implements Playable {
    private String showName;
    private int episodeNumber;
    
    public Podcast(String showName, int episodeNumber) {
        this.showName = showName;
        this.episodeNumber = episodeNumber;
    }
    
    @Override
    public String play() { 
        return "Streaming episode " + episodeNumber + " of " + showName; 
    }
    
    @Override
    public String play(int fromSecond) { 
        return play() + " from " + fromSecond + "s"; 
    }
    
    @Override
    public String pause() { 
        return "Podcast paused"; 
    }
}

public class UniversalMediaLauncher {
    // Justification: 
    // AudioFile IS-A MediaFile because it represents a physical, stored file that requires an ID and format properties.
    // Podcast CAN-DO Playable because it acts like media from the outside (can be played/paused), but since it is streamed live, it does not fit the mold of a stored MediaFile.
    
    public static void launchAll(Playable[] items) {
        for (Playable p : items) {
            if (p != null) {
                System.out.println(p.play());
            }
        }
    }
}