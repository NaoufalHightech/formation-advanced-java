package jour3.ex3;

public class Book {
    private long id;

    public Book(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void lireInfoLivre() {

            System.out.println("Lecture des information sur le livre !" + this.getId());
        }


    // Exclusivité en Écriture
    public void emprunter(){

            System.out.println("Le livre emprunte est : " + this.getId());

    }

    // Exclusivité en Écriture
    public void retourner(){
            System.out.println("Le livre retourne est : " + this.getId());
    }
}
