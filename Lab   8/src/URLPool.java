import java.util.LinkedList;
public class URLPool
{

    LinkedList<URLDepthPair> findLink;
    LinkedList<URLDepthPair> viewedLink;

    //Максимальная глубина сканирования
    int maxDepth;

    //Число потоков ждущих ссылку для обработки
    int cWait;

    //Конструктор класса принимающий значение максимальной глубины
    public URLPool(int maxDepth)
    {
        this.maxDepth = maxDepth;
        findLink = new LinkedList<URLDepthPair>();
        viewedLink = new LinkedList<URLDepthPair>();
        cWait = 0;
    }

    //Метод для получения пары для обработки из потока
    public synchronized URLDepthPair getPair()
    {
        while (findLink.size() == 0)
        {
            cWait++;
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("Ignoring InterruptedException");
            }
            cWait--;
        }
        URLDepthPair nextPair = findLink.removeFirst();
        return nextPair;
    }

    //Метод для добавления пары из потока в список просмотренных или найденных ссылок
    public synchronized void addPair(URLDepthPair pair)
    {
        if (URLDepthPair.check(viewedLink,pair))
        {
            viewedLink.add(pair);
            if (pair.getDepth() < maxDepth)
            {
                findLink.add(pair);
                notify();
            }
        }
    }

    //Метод для получения числа потоков, сидящих без работы (для проверки, что все потоки  завершили работу)
    public synchronized int getWait()
    {
        return cWait;
    }

    //Метод возвращает результирующий списов пар (для вывода списка в консоль)
    public LinkedList<URLDepthPair> getResult()
    {
        return viewedLink;
    }
}