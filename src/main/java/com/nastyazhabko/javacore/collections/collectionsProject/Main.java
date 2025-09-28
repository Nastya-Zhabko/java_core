package com.nastyazhabko.javacore.collections.collectionsProject;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Contact> contactsList = new ArrayList<> ();
    private static final Set<Contact> contactsSet = new HashSet<> ();
    private static final Map<String, ArrayList <Contact>> contactsMap = new HashMap<>();
    private static final Set<String> allNames = new HashSet<> ();

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
                    addNewContact();
                    break;
                case 2:
                    deleteContact();
                    break;
                case 3:
                    showAllContacts();
                    break;
                case 4:
                    showContactByName();
                    break;
                case 5:
                    showAllContactsByGroup();
                    break;
            }
        }

    }

    //считывание строки с клавиатуры
    private static String getStringValue(String text) {
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
    private static int getIntValue(String text) {
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

    private static void addNewContact(){
        String contact = getStringValue("Введите имя, телефон, email и группу контакта через запятую в одну строку.");
        String[] contactData = contact.split(", ");
        // Проверка, что в строке указаны мя, телефон, email и группа через разделитель ", "
        if (contactData.length != 4) {
            System.out.println("Введите корректные данные в указанном формате!");
        }
        else if(contactData[0].trim().isEmpty() || contactData[1].trim().isEmpty() || contactData[2].trim().isEmpty() || contactData[3].trim().isEmpty())
        {
            System.out.println("Все данные контакта должны быть указаны!");
        }
        else {
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
                    contactsMap.put(newContact.getGroup(), new ArrayList<>());
                }
                contactsMap.get(newContact.getGroup()).add(newContact);
                System.out.println("Новый контакт добавлен в список контактов!");
            }

        }
    }

    private static void deleteContact(){
        String contactForDelete = getStringValue("Введите имя контакта, который вы хотите удалить");
        //проверка есть ли имя контакта в списке имен всех контактов
        if (allNames.contains(contactForDelete)) {
            //удаление имени контакта из списка имен всех контактов
            allNames.remove(contactForDelete);

            //удаление контакта из set
            Iterator<Contact> iterator = contactsSet.iterator();
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
    }

    private static void showAllContacts(){
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
    }

    private static void showContactByName(){
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
    }

    private static void showAllContactsByGroup(){
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
    }

}
