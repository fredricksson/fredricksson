
package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.control.Label;
import javax.swing.JLabel;

/**
 *
 * @author Albertino Augusto */

public class DateTime 
{
    
    private int day;
    private int year;
    private int month;
    
    private int hour;
    private int mins;
    private int secs;
    private int am_pm;
    
    private final Calendar calendar;
    
    public DateTime() 
    {
        calendar = new GregorianCalendar();
        
        this.hour = calendar.get(Calendar.HOUR);
        this.mins = calendar.get(Calendar.MINUTE);
        this.secs = calendar.get(Calendar.SECOND);
        this.am_pm = calendar.get(Calendar.AM_PM);
        
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);
        
    }
    
    public String getTime()
    {
        String day_night;
                        
        if(am_pm == 0)
        {
            day_night = "AM"; 
        }
        else
        {
            day_night = "PM"; 
        }

        if(hour == 0)
        {
            hour = 12;
        }
            
        return hour + ":"+ mins + ":" + secs + " " + day_night;
    }
    
    
    
    
    public int getHour()
    {
        return hour;
    }
    
    
    public String getDay()
    {
        String d;
        if (day < 10)
        {
            d = "0" + day;
        }
        else
        {
            d = day + "";
        }
        
        return d;
    }
    
    
    public String getMonth()
    {
        
        String m;
        if (month < 10)
        {
            m = "0" + month;
        }
        else
        {
            m = month + "";
        }
        
        return m;
    }
    
    
    public String getYear()
    {
        return year + "";
    }
    
    
    public String getDate()
    {
        String d;
        if (day < 10)
        {
            d = "0" + day;
        }
        else
        {
            d = day + "";
        }
        
        String m;
        if (month < 10)
        {
            m = "0" + month;
        }
        else
        {
            m = month + "";
        }
        
        return d + "-" + m + "-" + year;
    }
    
    
    
    public String getToDay()
    {
        String m = "";
        
        if(month == 0)
        {
            m = "Jan"; 
        }
        else if(month == 1)
        {
            m = "Fev";
        }
        else if(month == 2)
        {
            m = "Mar";
        }
        else if(month == 3)
        {
            m = "Abr";
        }
        else if(month == 4)
        {
            m = "Mai";
        }
        else if(month == 5)
        {
            m = "Jun";
        }
        else if(month == 6)
        {
            m = "Jul";
        }
        else if(month == 7)
        {
            m = "Ago";
        }
        else if(month == 8)
        {
            m = "Set";
        }
        else if(month == 9)
        {
            m = "Out";
        }
        else if(month == 10)
        {
            m = "Nov";
        }
        else if(month == 11)
        {
            m = "Dez";
        }
        
        return day + "-" + m + "-" + year;
    }
    
     int timeRun = 0;
    public void setTimeToThis(Label label)
    {
      
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    
                    while(timeRun == 0) 
                    {   
                       // timeRun++;
                        Calendar calendar = new GregorianCalendar();
                        int hour = calendar.get(Calendar.HOUR);
                        int min = calendar.get(Calendar.MINUTE);
                        int sec = calendar.get(Calendar.SECOND);
                        int am_pn = calendar.get(Calendar.AM_PM);

                        String day_night;

                        if(am_pn == 0)
                        {
                            day_night = "AM"; 
                        }
                        else
                        {
                            day_night = "PM"; 
                        }

                        if(hour == 0)
                        {
                            hour = 12;
                        }
                        
                        String time;
                        
                        String H;
                        String M;
                        String S;
                        
                        if (hour <= 9)
                        {
                           H = "0" + hour + "";
                        }
                        else
                        {
                            H = hour + "";
                        }
                           
                        
                        if (min <= 9)
                        {
                           M = "0" + min + "";
                        }
                        else
                        {
                            M = min + "";
                        }
                           
                        
                        
                        if (sec <= 9)
                        {
                            S = "0" + sec + "";
                        }
                        else
                        {
                            S = sec + "";
                        }
                        
                        
                        
                        time = H + ":" + M + ":" + S + " " +  day_night;
                        
                     label.setText(time);
                        
                    }
                }
                catch(Exception e) 
                {
                
                }
            }

           

        }.start();
       
    }

   
    
     
    
   
    
}
