import java.io.*;
import java.util.*;


public class Command {

    public static ArrayList<ArrayList<Article>> articleArrays(String authorFile) throws IOException {

        ArrayList<ArrayList<Article>> articles = new ArrayList<>();

        for(Object authorNumber : Author.author(authorFile)) {

            ArrayList<Article> temp = new ArrayList<>();
            articles.add(temp);
        }
        return articles;
    }


    public static void command(String commandfromuser) throws IOException {
        ArrayList<String> lineList = new ArrayList();
        ArrayList wordList = new ArrayList();
        ArrayList<ArrayList> commandList = new ArrayList<ArrayList>();

        File commandtxt = new File(commandfromuser);
        if (commandtxt.exists()) {
            commandtxt.createNewFile();
        }
        FileReader fReader = new FileReader(commandtxt);
        String line;
        BufferedReader bReader = new BufferedReader(fReader);
        while ((line = bReader.readLine()) != null) {
            lineList.add(line);
        }
        bReader.close();

        File outputFile = new File("output.txt");
        FileWriter fWriter = new FileWriter(outputFile,false);
        BufferedWriter bWriter = new BufferedWriter(fWriter);

        ArrayList<Author> authorList = new ArrayList<>();
        ArrayList<Article> articleList = new ArrayList<>();
        ArrayList<ArrayList<Article>> articleList2 = new ArrayList<>();

        authorList = Author.author(Main.authorFile);
        articleList2 = articleArrays(Main.authorFile);



        for (String i : lineList) {
            String[] wordlist = i.split(" ");
            for (int j = 0; j < wordlist.length; j++) {

                if (wordlist[j].equals("read")){

                    articleList = Article.article(wordlist[j+1]);

                    int timerRead = 0;

                    for(Author author : authorList) {

                        for(Article article : articleList) {
                            if(author.getArticle1().equals(article.getPaperid()))
                                articleList2.get(timerRead).add(article);
                        }
                        for(Article article : articleList) {
                            if(author.getArticle2().equals(article.getPaperid()))
                                articleList2.get(timerRead).add(article);
                        }
                        for(Article article : articleList) {
                            if(author.getArticle3().equals(article.getPaperid()))
                                articleList2.get(timerRead).add(article);
                        }
                        for(Article article : articleList) {
                            if(author.getArticle4().equals(article.getPaperid()))
                                articleList2.get(timerRead).add(article);
                        }
                        for(Article article : articleList) {
                            if(author.getArticle5().equals(article.getPaperid()))
                                articleList2.get(timerRead).add(article);
                        }

                        timerRead++;
                    }

                }
                if (wordlist[j].equals("completeAll")){
                    for(Author author : authorList) {

                        for(Article article : articleList) {

                            if((author.getArticle1().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){

                                int counter = authorList.indexOf(author);
                                articleList2.get(counter).add(article);
                                author.setArticle1(article.getPaperid());
                                continue;
                            }
                            if((author.getArticle2().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){

                                int counter = authorList.indexOf(author);
                                articleList2.get(counter).add(article);
                                author.setArticle2(article.getPaperid());
                                continue;
                            }
                            if((author.getArticle3().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){

                                int counter = authorList.indexOf(author);
                                articleList2.get(counter).add(article);
                                author.setArticle3(article.getPaperid());
                                continue;
                            }
                            if((author.getArticle4().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){

                                int counter = authorList.indexOf(author);
                                articleList2.get(counter).add(article);
                                author.setArticle4(article.getPaperid());
                                continue;
                            }
                            if((author.getArticle5().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){

                                int counter = authorList.indexOf(author);
                                articleList2.get(counter).add(article);
                                author.setArticle5(article.getPaperid());
                                continue;
                            }
                        }
                    }
                    bWriter.write("**************************CompleteAll Successful*******************\n");
                }
                if (wordlist[j].equals("sortedAll")){

                    for(ArrayList<Article> article : articleList2){
                        Collections.sort(article, Comparator.comparing(Article::getPaperid));
                    }
                    bWriter.write("*****************************SortedAll Successful*********************\n");
                }
                if (wordlist[j].equals("del")){

                    int toBeDeleted = 0;
                    for(Author author : authorList) {
                        toBeDeleted = authorList.indexOf(author);
                        if(wordlist[j+1].equals(author.getId())) {
                            authorList.remove(author);
                            articleList2.remove(toBeDeleted);
                            break;
                        }
                    }
                    bWriter.write("*************************del Successful************************************\n");
                }
                if (wordlist[j].equals("list")){
                    bWriter.write("-----------------------------List-------------------------------------\n");
                    int timerList =0;
                    for(Author author : authorList) {

                        bWriter.write("Author:" + author.getId() + "\t" + author.getName() + "\t" + author.getUniversity() + "\t" + author.getDepartment() + "\t" + author.getEmail() + "\n");
                        for(Article article : articleList2.get(timerList)) {

                            bWriter.write("+" + String.valueOf(article).replace(" ","\t") + "\n");
                        }
                        bWriter.write("\n");
                        timerList++;
                    }
                    bWriter.write("------------------------------End-------------------------------------\n");
                }
            }
        }
        bWriter.close();
    }
}
