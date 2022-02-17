import java.io.*;
import java.util.*;

public class Article {
    private String paperid;
    private String name;
    private String publisherName;
    private String publishYear;

    public Article() {
        this.paperid = "";
        this.name = "";
        this.publisherName = "";
        this.publishYear = "";
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String toString(){
        return (this.paperid + "\t" + this.name + " " + this.publisherName + " " + this.publishYear);
    }

    public static ArrayList article(String articlefromcommand) throws IOException {

        ArrayList<String> lineList = new ArrayList();
        ArrayList wordList = new ArrayList();
        ArrayList<ArrayList> articleList = new ArrayList<ArrayList>();

        File articletxt = new File(articlefromcommand);
        if (articletxt.exists()) {
            articletxt.createNewFile();
        }
        FileReader fReader = new FileReader(articletxt);
        String line;
        BufferedReader bReader = new BufferedReader(fReader);
        while ((line = bReader.readLine()) != null) {
            lineList.add(line);
        }
        bReader.close();
        int counter = 0;
        for (String i : lineList) {
            String[] a = i.split(" ");
            for (int j = 0; j < a.length; j++) {
                wordList.add(a[j]);
            }
            ArrayList wordlistc = new ArrayList();
            wordlistc = (ArrayList) wordList.clone();
            articleList.add(new ArrayList<Integer>());
            articleList.set(counter, wordlistc);
            wordList.clear();
            counter++;
        }
        ArrayList articles = new ArrayList();
        for (int i = 0; i < articleList.size(); i++) {
            Article newArticle = new Article();
            newArticle.setPaperid((String) articleList.get(i).get(1));
            newArticle.setName((String) articleList.get(i).get(2));
            newArticle.setPublisherName((String) articleList.get(i).get(3));
            newArticle.setPublishYear((String) articleList.get(i).get(4));
            articles.add(newArticle);
        }
        return articles;
    }
}
