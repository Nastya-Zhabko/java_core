package com.nastyazhabko.javacore.collections.collectionsProject;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Contact> contactsList = new ArrayList<> ();
    private static Set<Contact> contactsSet = new HashSet<> ();
    private static Map<String, ArrayList <Contact>> contactsMap = new HashMap<>();
    private static Set<String> allNames = new TreeSet<> ();

    public static void main(String[] args) {
        int operation;
        boolean quit = false;


        while (!quit) {

            operation = getIntValue("Введите код операции, которую хотите выполнить:\n" +
                    "«1»: Добавить контакт\n" +
                    "«2»: Удалить контакт\n" +
                    "«3»: Посмотреть все контакты\n" +
                    "«4»: Найти контакт\n" +
                    "«5»: Посмотреть контакты по группе\n" +
                    "«0»: Выход");
            sc.nextLine();

            switch (operation) {
                //выход из программы
                case 0:
                    sc.close();
                    System.out.println("Программа завершена");
                    quit = true;
                    break;
                // Добавление нового контакта
                case 1:
                    String contact = getStringValue("Введите имя, телефон, email и группу контакта через запятую в одну строку.");
                    String[] contactData = contact.split(", ");
                    // Проверка, что в строке указаны мя, телефон, email и группа через разделитель ", "
                    if (contactData.length != 4) {
                        System.out.println("Введите корректные данные в указанном формате!");
                    } else {
                        Contact newContact = new Contact();
                        newContact.setName(contactData[0].trim());
                        newContact.setEmail(contactData[1].trim());
                        newContact.setPhone(contactData[2].trim());
                        newContact.setGroup(contactData[3].trim());

                        contactsSet.add(newContact);

                        //проверка на дубликаты через set
                        if (!contactsList.isEmpty() && contactsSet.size() == contactsList.size()) {
                            System.out.println("Данный контакт уже есть в списке контактов. Добавьте новый контакт.");
                        }
                        //добавление нового контакта в коллекции
                        else {
                            contactsList.add(newContact);
                            allNames.add(newContact.getName());
                            if (contactsMap.isEmpty() || !contactsMap.containsKey(newContact.getGroup())) {
                                contactsMap.put(newContact.getGroup(), new ArrayList<Contact>());
                            }
                            contactsMap.get(newContact.getGroup()).add(newContact);
                            System.out.println("Новый контакт добавлен в список контактов!");
                        }

                    }
                    break;
                case 2:
                    String contactForDelete = getStringValue("Введите имя контакта, который вы хотите удалить");
                    //проверка есть ли имя контакта в списке имен всех контактов
                    if (allNames.contains(contactForDelete)) {
                        //удаление имени контакта из списка имен всех контактов
                        allNames.remove(contactForDelete);

                        //удаление контакта из set
                        Iterator<Contact> iterator = contactsSet.iterator();
                        String group;
                        while (iterator.hasNext()) {
                            if (iterator.next().getName().equals(contactForDelete)) {
                                iterator.remove();
                            }
                        }

                        //удаление контакта из list
                        iterator = contactsList.iterator();
                        while (iterator.hasNext()) {
                            if (iterator.next().getName().equals(contactForDelete)) {
                                iterator.remove();
                            }
                        }

                        //удаление контакта из map
                        Iterator<ArrayList<Contact>> arrayIterator = contactsMap.values().iterator();
                        while (arrayIterator.hasNext()) {
                            iterator = arrayIterator.next().iterator();
                            while (iterator.hasNext()) {
                                if (iterator.next().getName().equals(contactForDelete)){
                                    iterator.remove();
                                }
                            }
                        }
                        System.out.println("Контакт удален из списка контактов!");
                    }
                    else {
                        System.out.println("Контакта с данным именем нет в списке контактов!");
                    }
                    break;
                case 3:
                    //вывод всех контактов в порядке добавления
                    if(!contactsList.isEmpty()) {
                    Iterator<Contact> iterator = contactsList.iterator();
                    while(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    }
                    else {
                        System.out.println("В списке пока нет контактов");
                    }
                    break;
                case 4:
                    System.out.println("Введите имя контакта");
                    String name = sc.nextLine();

                    //проверка есть ли имя в списке имен всех контактов
                    if (allNames.contains(name)) {
                        Iterator<Contact> iteratorForNameSearch = contactsList.iterator();
                        while (iteratorForNameSearch.hasNext()) {
                            Contact currentContact = iteratorForNameSearch.next();
                            if (currentContact.getName().equals(name)) {
                                System.out.println(currentContact);

                            }
                        }
                    }
                    else {
                        System.out.println("Контакта с указанным именем нет в списке");
                    }
                    break;
                case 5:
                    System.out.println("Введите название группы контактов");
                    String group = sc.nextLine();

                    //вывод контактов из указанной группы
                    if (contactsMap.containsKey(group)) {
                        ArrayList<Contact> contacts = contactsMap.get(group);
                        for (Contact c : contacts) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Указанная группа контактов не найдена");
                    }
                    break;
            }
        }

    }

    //считывание строки с клавиатуры
    public static String getStringValue(String text) {
        System.out.println(text);
        String result;

        try{
            result = sc.nextLine();
            return result;
        }
        catch (InputMismatchException e) {
            System.out.println("Введите корректную строку!");
            return "error";
        }
    }

    //считывание числа с клавиатуры
    public static int getIntValue(String text) {
        System.out.println(text);
        int result;

        try{
            result = sc.nextInt();
            return result;
        }
        catch (InputMismatchException e) {
            System.out.println("Введите код одной из указанных команд!");
            return 404;
        }
    }

}
