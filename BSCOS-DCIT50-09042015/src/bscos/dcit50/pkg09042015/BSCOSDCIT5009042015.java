package bscos.dcit50.pkg09042015;

public class BSCOSDCIT5009042015 {
        /* VARIABLE DECLARATION */
        private String name;
        private String idNum;
        private int age;
        private String gender;
        private String addr;
        private String bday;
        private String status;
        private String college;
        private String highschool;
        private String elemschool;
        private String skills;
        
        /* GET */
        public String getName() {
            return name;
        }
        
        public String getID() {
            return idNum;
        }
        
        public int getAge() {
            return age;
        }
        
        public String getGender() {
            return gender;
        }
        
        public String getAddr() {
            return addr;
        }
        
        public String getBirthday() {
            return bday;
        }
        
        public String getStatus() {
            return status;
        }
        
        public String getCollege() {
            return college;
        }
        
        public String getHigh() {
            return highschool;
        }
        
        public String getElem() {
            return elemschool;
        }
        
        public String getSkills() {
            return skills;
        }
        
        /* SET */
        public void setName(String newName) {
            name = newName;
        }
        
        public void setID(String newID) {
            idNum = newID;
        }

        public void setAge(int newAge) {
            age = newAge;
        }

        public void setGender(String newGender) {
            gender = newGender;
        }

        public void setAddr(String newAddr) {
            addr = newAddr;
        }

        public void setBday(String newBday) {
            bday = newBday;
        }

        public void setStatus(String newStatus) {
            status = newStatus;
        }

        public void setCollege(String newCollege) {
            college = newCollege;
        }

        public void setHSchool(String newHS) {
            highschool = newHS;
        }

        public void setElem(String newElem) {
            elemschool = newElem;
        }

        public void setSkills(String newSkills) {
            skills = newSkills;
        }
        
        public static void main(String[] args) {
            BSCOSDCIT5009042015 target = new BSCOSDCIT5009042015();
            
            target.setName("Mark Nolledo");
            target.setID("201411404");
            target.setAge(23);
            target.setGender("Male USB Port");
            target.setAddr("3630 Lilycove Street, Littleroot Town, Hoenn Region, Japan");
            target.setBday("April 23, 1992");
            target.setStatus("ONLINE");
            target.setCollege("Manila Doctors College, Adamson University, Cavite State University");
            target.setHSchool("Maranatha Christian Academy");
            target.setElem("Jesus Good Shepherd School");
            target.setSkills("BEAST MODE ALWAYS OFF");
            
            System.out.println(
                    "Name: " + target.getName() +
                    "\nID Number: " + target.getID() +
                    "\nAge: " + target.getAge() +
                    "\nGender: " + target.getGender() +
                    "\nAddress: " + target.getAddr() +
                    "\nBirthday: " + target.getBirthday() +
                    "\nStatus: " + target.getStatus() +
                    "\nCollege: " + target.getCollege() +
                    "\nHigh School: " + target.getHigh() +
                    "\nElementary School: " + target.getElem() +
                    "\nSkills: " + target.getSkills()
            );
        }
}
