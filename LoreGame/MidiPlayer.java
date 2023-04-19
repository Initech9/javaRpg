import javax.sound.midi.*;

public class MidiPlayer implements Runnable {
    private String midiFilePath;
    
    public MidiPlayer(String midiFilePath) {
        this.midiFilePath = midiFilePath;
    }
    
    public void run() {
        try {
            // Get a Sequencer instance and open it
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            
            // Create a Sequence from the MIDI file
            Sequence sequence = MidiSystem.getSequence(getClass().getResourceAsStream(midiFilePath));
            
            // Set the Sequence to the Sequencer and start playing
            sequencer.setSequence(sequence);
            sequencer.start();
            
            // Wait for the Sequencer to finish playing
            while (sequencer.isRunning()) {
                Thread.sleep(1000);
            }
            
            // Close the Sequencer
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
