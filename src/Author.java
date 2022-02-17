import java.io.*;
import java.util.*;

public class Author {
    private String id;
    private String name;
    private String university;
    private String department;
    private String email;
    private String article1;
    private String article2;
    private String article3;
    private String article4;
    private String article5;

    public Author() {
        this.id = "null";
        this.name = "null";
        this.university = "null";
        this.department = "null";
        this.email = "null";
        this.article1 = "null";
        this.article2 = "null";
        this.article3 = "null";
        this.article4 = "null";
        this.article5 = "null";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArticle1() {
        return article1;
    }

    public void setArticle1(String article1) {
        this.article1 = article1;
    }

    public String getArticle2() {
        return article2;
    }

    public void setArticle2(String article2) {
        this.article2 = article2;
    }

    public String getArticle3() {
        return article3;
    }

    public void setArticle3(String article3) {
        this.article3 = article3;
    }

    public String getArticle4() {
        return article4;
    }

    public void setArticle4(String article4) {
        this.article4 = article4;
    }

    public String getArticle5() {
        return article5;
    }

    public void setArticle5(String article5) {
        this.article5 = article5;
    }

    public String toString(){
        return (this.id + " " + this.name + " " + this.university + " " + this.department + " " + this.email + " " + this.article1 + " " + this.article2 + " " + this.article3 + " " + this.article4 + " " + this.article5);
    }

    public static ArrayList author(String authorfromuser) throws IOException {
        ArrayList<String> lineList = new ArrayList();
        ArrayList wordList = new ArrayList();
        ArrayList<ArrayList> authorList = new ArrayList<ArrayList>();

        File authortxt = new File(authorfromuser);
        if (authortxt.exists()) {
            authortxt.createNewFile();
        }
        FileReader fReader = new FileReader(authortxt);
        String line;
        BufferedReader bReader = new BufferedReader(fReader);
        while ((line = bReader.readLine()) != null) {
            lineList.add(line);
        }
        int counter = 0;
        for (String i : lineList) {
            String[] a = i.split(" ");
            ArrayList b = new ArrayList();
            b.addAll(Arrays.asList(a));
            for (int j = 0; j < 11; j++) {
                if (b.size() <= j){
                    b.add(j-1," ");
                    wordList.add(b.get(j-1));
                }
                else {
                    wordList.add(b.get(j));
                }
            }
            ArrayList wordlistc = new ArrayList();
            wordlistc = (ArrayList) wordList.clone();
            authorList.add(new ArrayList<Integer>());
            authorList.set(counter, wordlistc);
            wordList.clear();
            counter++;
        }

        ArrayList authors = new ArrayList();
        for (int i = 0; i< authorList.size(); i++){
            Author newAuthor = new Author();
            newAuthor.setId((String) authorList.get(i).get(1));
            newAuthor.setName((String) authorList.get(i).get(2));
            newAuthor.setUniversity((String) authorList.get(i).get(3));
            newAuthor.setDepartment((String) authorList.get(i).get(4));
            newAuthor.setEmail((String) authorList.get(i).get(5));
            newAuthor.setArticle1((String) authorList.get(i).get(6));
            newAuthor.setArticle2((String) authorList.get(i).get(7));
            newAuthor.setArticle3((String) authorList.get(i).get(8));
            newAuthor.setArticle4((String) authorList.get(i).get(9));
            newAuthor.setArticle5((String) authorList.get(i).get(10));
            authors.add(newAuthor);

        }
        bReader.close();
        return authors;
    }
}
