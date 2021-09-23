import java.util.LinkedList;
import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDepthPair
{

    public static final String URL_PREFIX =  "http://";
    public String URL;
    private int depth;
    URL host_path;

    //Проверяет ссылку на формат заданный при помощи регулярного выражения URL_PREFIX
    public static boolean isUrlValid(String url)
    {
        if (url == null)
            return false;
        Pattern urlValidationPattern = Pattern.compile(URL_PREFIX);
        return urlValidationPattern.matcher(url).find();
    }

    //Принимает на вход пару для хранения
    public URLDepthPair (String URL, int depth) throws MalformedURLException
    {
        if (!isUrlValid(URL))
        {
            throw new MalformedURLException();
        }
        this.URL=URL;
        this.depth=depth;
        try
        {
            this.host_path= new URL(URL);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    //Возвращает имя хоста на сервере
    public String getHost()
    {
        return host_path.getHost();
    }

    //Возвращает имя ресурса у хоста
    public String getPath()
    {
        return host_path.getPath();
    }

    //Возвращает глубину сайта, относительно сайта введёного пользователем
    public int getDepth()
    {
        return depth;
    }

    //Возвращает полный путь до сайта
    public String getURL()
    {
        return URL;
    }

    //Возвращает результат проверки ссылки, была ли уже парсинг или нет
    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair)
    {
        boolean isAlready = true;
        for (URLDepthPair c : resultLink)
        {
            if (c.getURL().equals(pair.getURL()))
            {
                isAlready=false;
            }
        }
        return isAlready;
    }
}