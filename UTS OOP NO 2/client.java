import java.util.ArrayList;


public class client extends user {
    ArrayList<project> MyPosted_project = new ArrayList<project>();

    public client(String name, String username, String password) {
        super(name, username, password);
    }

    public ArrayList<project> getPosted_project() {
        return MyPosted_project;
    }

    public void setPosted_project(ArrayList<project> posted_project) {
        MyPosted_project = posted_project;
    }

    public void post_project(project project) {
        this.MyPosted_project.add(project);
    }    

    public void show_project() {
        if (MyPosted_project.size() == 0)
            System.out.println("You haven't post any project");
        else {
            for (int i = 0; i < MyPosted_project.size(); i++) {
                System.out.println("\nYour Posted project " + (i + 1));
                System.out.println("------------------------");
                System.out.println("Nama\t\t: " + MyPosted_project.get(i).getName()); 
                System.out.println("Deskripsi\t: " + MyPosted_project.get(i).getDescription());
                System.out.println("Deadline\t: " + MyPosted_project.get(i).getDeadline()); 
                System.out.println("metode pembayaran\t: " + MyPosted_project.get(i).getPayment_method()); 
                System.out.println("biaya\t: " + MyPosted_project.get(i).getFee());
            }
        }
    }    
}
