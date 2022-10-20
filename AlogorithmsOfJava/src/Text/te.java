package Text;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class te {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Schedule s1= new Schedule();
            if (i==0){
                s1.Planer = "jav1";
            }else
            {
                s1.Planer = "@";
            }
            for (int j = 0; j < 2; j++) {

                if (j==0){
                    s1.Fronter = "jav2";
                }else
                {
                    s1.Fronter = "@";
                }
                for (int a = 0; a < 2; a++) {
                    if (a==0){
                        s1.Backer = "jav3";
                    }else
                    {
                        s1.Backer = "@";
                    }
                    for (int b = 0; b < 2; b++) {
                        if (b==0){
                            s1.Tester = "jav4";
                        }else
                        {
                            s1.Tester = "@";
                        }
                        contact(s1);

                    }
                }
            }
        }
//        Schedule s1= new Schedule();
//        s1.id =1;
//        s1.Planer="jav";
//        s1.Fronter="jav1";
//        s1.Backer="jav2";
//        s1.Tester="jav3";
//        contact(s1);
//        Schedule s2= new Schedule();
//        s2.id =2;
//        s1.Planer="jav";
//        s1.Fronter=" ";
//        s1.Backer=" ";
//        s1.Tester="jav3";
//        contact(s1);
//        s1.id =3;
//        s1.Planer="jav";
//        s1.Fronter=" ";
//        s1.Backer=" ";
//        s1.Tester=" ";
//        contact(s1);
//        s1.id =4;
//        s1.Planer="jav";
//        s1.Fronter=" ";
//        s1.Backer="jav3";
//        s1.Tester=" ";
//        contact(s1);
//        s1.id =5;
//        s1.Planer="jav";
//        s1.Fronter="jav2";
//        s1.Backer=" ";
//        s1.Tester=" ";
//        contact(s1);
//        s1.id =6;
//        s1.Planer=" ";
//        s1.Fronter=" ";
//        s1.Backer="jav3";
//        s1.Tester="jav4";
//        contact(s1);
//        s1.id =6;
//        s1.Planer=" ";
//        s1.Fronter="jav2";
//        s1.Backer="jav3";
//        s1.Tester=" ";
//        contact(s1);
//        s1.id =6;
//        s1.Planer="";
//        s1.Fronter="jav2";
//        s1.Backer="";
//        s1.Tester="jav4";
//        contact(s1);

    }

    private static void contact(Schedule s1) {
        s1.Person=null;
        List<String> person = new LinkedList<>();
        if (!s1.Planer.equals("@")){
            person.add(s1.Planer);
        }
        if (!s1.Fronter.equals("@")){
            person.add(s1.Fronter);
        }
        if (!s1.Backer.equals("@")){
            person.add(s1.Backer);
        }
        if (!s1.Tester.equals("@")){
            person.add(s1.Tester);
        }
        if (person.size()==0){
            s1.Person = null;
        }else{
            for (String ja :
                    person) {
                if (s1.Person == null)
                {
                    s1.Person = ja;
                    continue;
                }
                s1.Person += "/"+ja;
            }
        }
//        s1.Person = s1.Planer+"/"
//                + s1.Fronter+"/"
//                + s1.Backer+"/"
//                + s1.Tester;
//        if (s1.Person.equals("@/@/@/"))
//        {
//            s1.Person = "";
//        }else if (s1.Person.contains("/@/@/")){
//            s1.Person.replace("/","/@/@/");
//        }else if (s1.Person.contains("/@/")){
//            s1.Person.replace("/@/","/");
//        }else if (s1.Person.startsWith("@/")){
//            s1.Person = s1.Person.substring(2);
//        }else if (s1.Person.endsWith("/@")){
//            s1.Person = s1.Person.substring(0,s1.Person.length()-2);
//        }
        System.out.println("id: "+s1.id+"s person = "+s1.Person);
    }


}

class Schedule{
    public int id;
    public String Planer;
    public String Fronter;
    public String Backer;
    public String Tester;
    public String Person;
}
