import java.util.ArrayList;

// membuat class project
public class project {
    // atribut project
    private String name;
    private String description;
    private String deadline;
    private String payment_method;
    private int fee;

    // constructor project
    public project(String name, String description, String deadline, String payment_method, int fee) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.payment_method = payment_method;
        this.fee = fee;
    }

    // metode getter untuk mengambil data atribut name
    public String getName() {
        return name;
    }

     // metode setter untuk mengubah data atribut name
    public void setName(String name) {
        this.name = name;
    }
     // metode getter untuk mengambil data atribut description
    public String getDescription() {
        return description;
    }
     // metode setter untuk mengubah data atribut description
    public void setDescription(String description) {
        this.description = description;
    }
     // metode getter untuk mengambil data atribut deadline
    public String getDeadline() {
        return deadline;
    }
     // metode setter untuk mengubah data atribut deadline
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
     // metode getter untuk mengambil data atribut payment_method
    public String getPayment_method() {
        return payment_method;
    }

     // metode setter untuk mengubah data atribut payment_method
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
     // metode getter untuk mengambil data atribut fee
    public int getFee() {
        return fee;
    }
     // metode setter untuk mengubah data atribut fee
    public void setFee(int fee) {
        this.fee = fee;
    }

    // metode untuk menampilkan seluruh project yang sudah di post oleh sekuruh client
    public static void view_project(ArrayList<project> project){
        if(project.size() == 0) System.out.println("You haven't post any project");
        else{
            for (int i = 0; i < project.size(); i++) {
                System.out.println("\nproject " + (i + 1));
                System.out.println("------------------------");
                System.out.println("Name\t\t: " + project.get(i).getName());
                System.out.println("Description\t: " + project.get(i).getDescription());
                System.out.println("Deadline\t: " + project.get(i).getDeadline());
                System.out.println("Payment Method\t: " + project.get(i).getPayment_method());
                System.out.println("project Fee\t: " + project.get(i).getFee());
            } 
        }                  
    }  
}
