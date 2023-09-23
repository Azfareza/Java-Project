import java.util.ArrayList;

// membuat class freelancer dengan mewariskan method dan atribut dari class user
public class freelancer extends user {   
    // atribut freelancer (database project yang diambil oleh masing-masing freelancer)
    private ArrayList<project> myproject = new ArrayList<project>();

    // constructor freelancer
    public freelancer(String name, String username, String password) {
        super(name, username, password);
    }

    // method getter untuk mengambil data dari list atribut myproject
    public ArrayList<project> getMyproject() {
        return myproject;
    }
    // method setter untuk mengubah data atribut myproject
    public void setMyproject(ArrayList<project> myproject) {
        this.myproject = myproject;
    }

    // method untuk menambahkan project baru ke list atribut myproject
    public void take_project(project project) {
        this.myproject.add(project);
    }    

    // method untuk menampilkan seluruh project yang diambil oleh freelancer
    public void show_project(){
        if(myproject.size() == 0) System.out.println("You haven't take any project");
        else{
            for (int i = 0; i < myproject.size(); i++) {
                System.out.println("\nproject " + (i + 1));
                System.out.println("------------------------");
                System.out.println("Name\t\t: " + myproject.get(i).getName()); //mengambil nama dari object list MyPosted_project yang dipilih
                System.out.println("Description\t: " + myproject.get(i).getDescription()); //mengambil description dari object list MyPosted_project yang dipilih
                System.out.println("Deadline\t: " + myproject.get(i).getDeadline()); //mengambil deadline dari object list MyPosted_project yang dipilih
                System.out.println("Payment Method\t: " + myproject.get(i).getPayment_method()); //mengambil payment_method dari object list MyPosted_project yang dipilih
                System.out.println("project Fee\t: " + myproject.get(i).getFee()); //mengambil fee dari object list MyPosted_project yang dipilih
            } 
        }        
    }        
}
