import java.util.ArrayList;

public class DotComBust {
    // Обявляем и инициализируем переменные, которые нам понадобяться
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList= new ArrayList<DotCom>();
    private int numOfGuess=0;

    private void setUpGame(){
        // Создадим несколько сайтов и присвоим им имена
        //Создаем три объекта DotCom
        //даем им имена и помещаем в ArrayList
        DotCom one = new DotCom();
        one.setName("pets.com");

        DotCom two = new DotCom();
        one.setName("eToys.com");

        DotCom three = new DotCom();
        one.setName("Go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        //Выводим краткие инструкции для пользователя
        System.out.println("Ваша цель потопить три сайта");
        System.out.println("pets, eToys, Go2");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        //Повторяем с каждым объектом dotcom в списке
        for(DotCom dotComToSet: dotComList){
            //запрашиваем у вспомогательного объекта адрес сайта
            ArrayList<String> newLocation = helper.placeDotCom(3);
            //Вызываем сеттер из объекта DotCom
            //Передаем местоположение, полученное из вспомогательного объекта
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        //пока список не пустой выполняем
        while (!dotComList.isEmpty()){
            //Получаем пользовательский ввод
            String userGuess=helper.getUserInput("Сделай ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        //инкерементируем количество попыток пользователя
        numOfGuess++;
        //Подразумаваем промах пока не выясним обратного
        String result ="Мимо";

        //Повторяем для всех объектов сайта дотком в списке
        for (DotCom dotComToTest:dotComList){
            //Просим дотком проверить ход пользователя, ищем попадаение или потопление корабля
            result=dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")){
                //Выходим из цикла раньще времени, нет смысла проверять другие объекты
                break;
            }
            if (result.equals("Потопил")){
                //Корабль нашли, удаляем его из списка и выходим из цикла раньше врмени
                dotComList.remove(dotComToTest);
                break;
            }

        }
        //Выводим для пользователя результат
        System.out.println(result);
    }

    //Выводим пользователю сообщение о том, что пользователь прошел игру
    private  void finishGame(){
        System.out.println("все сайты ушли ко дну");
        if (numOfGuess<=18){
            System.out.println("это заняло у вас " + numOfGuess +" попыток");
        }
        else {
            System.out.println("это заняло у вас много времени "+ numOfGuess+" попыток");
        }
    }

    public static void main (String[] args){
        //Создаем игровой объект
        DotComBust game = new DotComBust();
        //Подготовка игры
        game.setUpGame();
        //Гачало главного игрового цикла
        game.startPlaying();
    }
}
