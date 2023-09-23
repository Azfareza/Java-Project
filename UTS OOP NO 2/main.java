import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    Scanner sc = new Scanner(System.in);

    admin admin1 = new admin("hanif", "hanifadmin1", "hanif!");
    

    ArrayList<client> clientList = new ArrayList<client>();
    ArrayList<freelancer> freelancerList = new ArrayList<freelancer>();
    ArrayList<project> projectList = new ArrayList<project>();    
    int project_count = 0;

    void menu() {
        System.out.println("\n\n        --------------");
        System.out.println("        | LOG IN ACC |");
        System.out.println("        |  Wake Up!  |");
        System.out.println("        --------------\n\n");
    }


    void delete_client(admin admin) {
        System.out.println("\n\n      ----------------");
        System.out.println("      | HAPUS CLIENT |");
        System.out.println("      ----------------");


        if (clientList.size() == 0) System.out.println("Tidak ada"); 
        else {
            for (int i = 0; i < clientList.size(); i++) {
                System.out.println((i+1) + " " + admin.view_client(clientList, i));
            }

            System.out.print("Pilih clien yang ingin dihapus (1, 2, 3):");
            int delete_client = sc.nextInt();
            admin.delete_client(clientList, delete_client - 1);
            System.out.println("\nBerhasil");                      
        }
        System.out.print("selesai!, tekan enter");  
        sc.nextLine();
        sc.nextLine();
    }


    void delete_freelancer(admin admin) {
        System.out.println("\n\n      --------------------");
        System.out.println("      | HAPUS FREELANCER |");
        System.out.println("      --------------------");


        if (freelancerList.size() == 0)
            System.out.println("Tidak ada");
        else {
            for (int i = 0; i < freelancerList.size(); i++) {
                System.out.println((i+1) + " " + admin.view_freelancer(freelancerList, i));
            }

            System.out.print("Pilih freelancer yang ingin dihapus:");
            int delete_freelancer = sc.nextInt();
            admin.delete_freelancer(freelancerList, delete_freelancer - 1);            
            System.out.println("\nBerhasil");                       
        }
        System.out.print("selesai!, tekan enter"); 
        sc.nextLine();
        sc.nextLine();
    }

    void delete_project(admin admin) {
        System.out.println("\n\n      -----------------");
        System.out.println("      | HAPUS PROJECT |");
        System.out.println("      -----------------");


        if (projectList.size() == 0)
            System.out.println("Tidak ada");
        else {
            for (int i = 0; i < projectList.size(); i++) {
                System.out.println((i+1) + " " + admin.view_project(projectList, i));
            }

            System.out.print("Pilih project yang ingin dihapus:");
            int delete_Project = sc.nextInt();
            admin.delete_project(projectList, delete_Project - 1);

            project_count--;
            System.out.println("\nBerhasil");                       
        }
        System.out.print("selesai!, tekan enter"); 
        sc.nextLine();
        sc.nextLine();
    }


    void menu_admin(admin admin) {
        int menu_admin;
        do {
            System.out.println("\n\n      --------------------");
            System.out.println("      |  Wake Up! ADMIN  |");
            System.out.println("      --------------------\n\n");
            System.out.println("1. Hapus client");
            System.out.println("2. Hapus freelancer");
            System.out.println("3. Hapus Project");
            System.out.println("0. Kembali");
            System.out.print("pilih: ");
            menu_admin = sc.nextInt();

            switch (menu_admin) {
                case 1: {
                    delete_client(admin);
                    break;
                }
                case 2: {
                    delete_freelancer(admin);
                    break;
                }
                case 3: {
                    delete_project(admin);
                    break;
                }
                case 0: {
                    break;
                }
            }
        } while (menu_admin != 0);

    }

    int check_date(String deadline) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        String today = localDate.format(formatter);
        LocalDate max = localDate.plusDays(90); 
        LocalDate min = localDate.plusDays(60);
        String deadline_max = max.format(formatter);
        String deadline_min = min.format(formatter);
        if (deadline.compareTo(deadline_min) > 0) {
            if (deadline.compareTo(deadline_max) < 0) {
                return 1;
            }
        }
        return -1;
    }


    void create_project(client client) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        String project_name;
        String project_description;
        String project_deadline;
        String project_payment_method;
        int project_fee;
        int deadline_valid = 0;


        System.out.println("\n\n      ----------------");
        System.out.println("      | BUAT PROJECT |");
        System.out.println("      ----------------");
        System.out.print("Tentukan nama project anda!: ");
        project_name = sc.next(); 
        System.out.print("Alasan anda mengapa membuat project tersebut: ");
        project_description = scan.next(); 
        sc.nextLine();
        do {
            System.out.print("Deadline 2 - 3 bulan YYYY-MM-DD: ");
            project_deadline = sc.next();
            deadline_valid = check_date(project_deadline);
        } 
        
        while (deadline_valid != 1);
        System.out.print("Masukkan metode pembayaran: ");
        project_payment_method = sc.next();
        System.out.print("Masukkan biaya project anda: ");
        project_fee = sc.nextInt(); 


        project project = new project(project_name, project_description, project_deadline, project_payment_method, project_fee); 

        projectList.add(project);

        client.post_project(project);        
        project_count++;
        System.out.println("\nproject kamu berhasil di post!");
        System.out.print("selesai!, tekan enter ");
        sc.nextLine();
        sc.nextLine();
    }


    void view_project(client client) {
        if(projectList.size() == 0) System.out.println("Tidak ada");
        else{
            System.out.println("      ------------------");
            System.out.println("      | DAFTAR PROJECT |");
            System.out.println("      ------------------");  
            project.view_project(projectList);
            
            System.out.println("      ----------------");
            System.out.println("      | PROJECT SAYA |");  
            System.out.println("      ----------------");
            if(client.getPosted_project().size() == 0){
                System.out.println("TIDAK ADA");
            } 
            else{
                client.show_project();
            }                                            
        }  
        System.out.print("selesai!, tekan enter ");   
        sc.nextLine();
        sc.nextLine();    
    }

    void menu_client(client client) {
        int menu_client;
        do {
            System.out.println("\n\n      ------------");
            System.out.println("      | Wake Up! |" + client.getName());
            System.out.println("      ------------");
            System.out.println("1. Buat project");
            System.out.println("2. Lihat project");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            menu_client = sc.nextInt();

            switch (menu_client) {
                case 1: {
                    create_project(client);
                    break;
                }
                case 2: {
                    view_project(client);
                    break;
                }

                case 0: {
                    break;
                }
            }
        } while (menu_client != 0);

    }

    void get_project(freelancer freelancer){
        int project_option;
        System.out.println("      ------------------");
        System.out.println("      | DAFTAR PROJECT |");
        System.out.println("      ------------------");

        if(project_count == 0) System.out.println("Tidak ada");
        else{
            project.view_project(projectList); 
            System.out.println("\n\n");
            System.out.print("pilih: ");
            project_option = sc.nextInt(); 
            
            freelancer.take_project(projectList.get(project_option-1));
            projectList.remove(project_option-1);    
            project_count--; 
        }  
        System.out.print("selesai!, tekan enter ");
        sc.nextLine();
        sc.nextLine();               
    }


    void view_myproject(freelancer freelancer){
        System.out.println("      ----------------");        
        System.out.println("      | PROJECT SAYA |");
        System.out.println("      ----------------");
        freelancer.show_project();
        System.out.print("selesai!, tekan enter ");
        sc.nextLine();    
        sc.nextLine();  
    }

    void menu_freelance(freelancer freelancer) {
        int menu_freelancer;
        do {
            System.out.println("        ");
            System.out.println("      | Wake Up! |" + freelancer.getName());
            System.out.println("        ");
            System.out.println("1. Ambil project");
            System.out.println("2. Lihat project saya");
            System.out.println("0. kembali");
            System.out.print("pilih: ");
            menu_freelancer = sc.nextInt();

            switch (menu_freelancer) {
                case 1: {
                    get_project(freelancer);
                    break;
                }
                case 2: {
                    view_myproject(freelancer);
                    break;
                }

                case 0: {
                    break;
                }
            }
        } while (menu_freelancer != 0);
    }

    void check_credentials(String user_username, String user_password) {
        int count = 0;
        if (user_username.equals(this.admin1.getUsername()) && user_password.equals(this.admin1.getPassword())) {
            count = 1;
            menu_admin(admin1);
        }

        if (clientList.size() != 0) {
            for (int i = 0; i < clientList.size(); i++) {
                if (user_username.equals(clientList.get(i).getUsername())
                        && user_password.equals(clientList.get(i).getPassword())) {
                    count = 1;
                    menu_client(clientList.get(i));
                }
            }
        }

        if (freelancerList.size() != 0) {
            for (int i = 0; i < freelancerList.size(); i++) {
                if (user_username.equals(freelancerList.get(i).getUsername())
                        && user_password.equals(freelancerList.get(i).getPassword())) {
                    count = 1;
                    menu_freelance(freelancerList.get(i));
                }
            }
        }
        if (count == 0) {
            System.out.print("Tidak ada");
            sc.nextLine();sc.nextLine();
            
        }
    }

    public main() {
        client client1 = new client("azfareza", "azfareza", "1234");
        client client2 = new client("damara", "damara", "1234");
        client client3 = new client("immanuel", "immanuel", "1234");
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        freelancer freelancer1 = new freelancer("putra", "putra", "1234");
        freelancer freelancer2 = new freelancer("affan", "affan", "1234");        
        freelancer freelancer3 = new freelancer("salwa", "salwa", "1234");    
        freelancerList.add(freelancer1);
        freelancerList.add(freelancer2);
        freelancerList.add(freelancer3);
        project project1 = new project("CTos", "Pengen kayak di game WatchDogs", "2023-03-03", "american express", 1000000); 
        projectList.add(project1);
        project_count++;
          
        
        
        String user_username;
        String user_password;
        do {
            menu();
            System.out.print("username: ");
            user_username = sc.next(); 
            if(user_username.equals("0")) System.exit(0);         
            System.out.print("Password: ");
            user_password = sc.next();  
            if(user_password.equals("0")) System.exit(0);             
            check_credentials(user_username, user_password);
        } while (!user_username.equals("0") || !user_password.equals("0"));
    }

    public static void main(String[] args) {
        new main();
    }
}
