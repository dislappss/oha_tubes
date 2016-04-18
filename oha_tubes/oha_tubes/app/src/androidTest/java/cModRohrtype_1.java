/**
 * Created by disl on 14.04.2016.
 */


    public class cModRohrtype_1
    {
        public int id;
        public String description;

        public cModRohrtype_1() {}

        public cModRohrtype_1(int Sysid, String Name)
        {
            this.id = Sysid;
            this.description = Name;
        }

        // getting ID
        public int getID(){
            return this.id;
        }

        // setting id
        public void setID(int id){
            this.id = id;
        }

        // getting name
        public String getDescription(){
            return this.description;
        }

        // setting name
        public void setDescription(String name){
            this.description = name;
        }
    }




