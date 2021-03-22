package guide1.exc5;

public class Hour {
    //private properties
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Hour(int hour, int minute, int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
    public Hour(){}

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 24 || hour >= 0)
            this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 60 || minute >= 0)
            this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 60 || second >= 0)
            this.second = second;
    }

    //Methods

    public String printTime(){

        String hour ;
        if(this.hour < 10)
         hour= "0" + this.hour;
          else
           hour= String.valueOf(this.hour);

        String minute ;
        if(this.minute < 10)
         minute= "0" + this.minute ;
         else
         minute= String.valueOf(this.minute);

        String second ;
        if(this.second < 10)
         second= "0" + this.second ;
         else
          second= String.valueOf(this.second);

        return String.format("%s:%s:%s", hour, minute, second);
    }

    public void addSecond(){// had to use getter and setter only
        if (getSecond() + 1 == 60) {
            setSecond(0);
            setMinute(getMinute()+1);
        }else
                setSecond(getSecond()+1);

        if(getMinute() == 60 ){
            setHour(getHour()+1);
            setMinute(0);
            if(getHour() == 24){
                setHour(0);
            }
        }
    }
    public void takeOutSecond(){
        if(getSecond()-1 < 0) {
            setSecond(59);
            setMinute(getMinute()-1);
        }else
            setSecond(getSecond()-1);
        if (getMinute() < 0){
            setHour(getHour()-1);
            setMinute(59);
            if(getHour()<0){
                setHour(23);
            }
        }
    }

}
