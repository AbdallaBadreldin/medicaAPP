package eg.iti.pillsmanager.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import eg.iti.pillsmanager.model.Dose;
import eg.iti.pillsmanager.model.User;
public class Converters {
   /* @TypeConverter
    public static String fromUsertoString(User user){
        return  new Gson().toJson(user);
    }
    @TypeConverter
    public  static User fromStringtoUser(String stringUser){
        return new Gson().fromJson(stringUser,User.class);

    }
*/   /* @TypeConverter
  public static String fromDosetoString(Dose dose){
        return  new Gson().toJson(dose);
    }
    @TypeConverter
    public static Dose fromStringtoDose(String stringDose){
        return new Gson().fromJson(stringDose,Dose.class);

    }*/
    @TypeConverter
    public static String fromArrayListToString(ArrayList<String> days_of_week){
        return new Gson().toJson(days_of_week);
    }
    @TypeConverter
    public static ArrayList<String> fromStringToArrayList(String strDay){
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(strDay,listType);
    }

}
