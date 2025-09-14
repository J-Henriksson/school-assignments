// Imports classes
import java.util.Timer;
import java.util.TimerTask;

public class Clock {


    // Fields
    private int hours;
    private int minutes;
    private int seconds;
    
    // Constructor 1
    public Clock() {
        hours = 12;
        minutes = 0;
        seconds = 0;
    }

    // Constructor 2
    public Clock(int hours, int minutes, int seconds) {
        /* Assigns values to hours, minutes and seconds so that the validClock method can work for each parameter. 
        Could be an innefective solution */
        this.hours = 12;
        this.minutes = 0;
        this.seconds = 0;

        setHours(hours);
        
        setMinutes(minutes);

        setSeconds(seconds);
    }

    // Getters and setters for each field

    public void setHours(int hours) {
        if (validClock(hours, minutes, seconds)) {
            this.hours = hours;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setMinutes(int minutes) {
        if (validClock(hours, minutes, seconds)) {
            this.minutes = minutes;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setSeconds(int seconds) {
        if (validClock(hours, minutes, seconds)) {
            this.seconds = seconds;
        }
    }
    
    public int getSeconds() {
        return seconds;
    }
    
    // Method that checks if inputed fields are of a valid format
    private boolean validClock(int hours, int minutes, int seconds) {
        return (1 <= hours && hours <= 12 && 0 <= minutes && minutes <= 60 && 0 <= seconds && seconds <= 60);
    }
    
    // Method that formats the current time into a String
    public String ToString() {
        String hours = String.format("%02d", getHours());
        String minutes = String.format("%02d", getMinutes());
        String seconds = String.format("%02d", getSeconds());
        
        return (hours + ":" + minutes + ":" + seconds);
    }

    /* Method that adds one second to the total time and evaluates whether a minute, an hour or 13 hours have passed 
       When 13 hours have passed the hour vaule resets and skips ahead one hour.
       this is done to avoid representing the same time twice with 12:xx:xx and 00:xx:xx
    */
    public void tick() {
        setSeconds((getSeconds() + 1) % 60);
        if (getSeconds() == 0) {
            setMinutes((getMinutes() + 1) % 60);
            if (getMinutes() == 0) {
                setHours((getHours() + 1) % 13);
                if ((getHours() + 1) % 13 == 0) {
                    setHours(1);
                }
            }
        };
    }

    // Method that calls the previous tick method and adds x amount of seconds to the total time based on the parameter
    public void tick(int seconds) {
        for(int i = 0; i <= seconds; i++) {
            tick();
            System.out.println(ToString());
        }
    }

    // Method that creates a new timer and timertask object and calls the tick method once every second
    public void runClock() {
        Timer timer = new Timer();

        TimerTask clockTick = new TimerTask() {
            public void run() {
                tick();
                System.out.println(ToString());
            }
        };

            timer.schedule(clockTick, 0, 1000);
    }

    // Main method
    public static void main(String[] args) {
        Clock clock = new Clock(12, 59, 50);
        clock.tick(2);
        System.out.println("Starting Clock");
        clock.runClock();
    }
}
